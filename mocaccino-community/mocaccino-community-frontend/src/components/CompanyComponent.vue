<template>
  <section>
    <aside>
      <add-company @updateView="updateView"/>
    </aside>
    <!-- sub-section to show the company list -->
    <section>
      <b-table 
        :items="companies" 
        :fields="fields" 
        striped 
        responsive="sm">
        <template #cell(showDetails)="row">
          <b-form-checkbox v-model="row.detailsShowing" @change="row.toggleDetails">
            details
          </b-form-checkbox>
        </template>
        <template #row-details="row">
          <b-card>
            <b-row class="mb-2">
              <b-col sm="3" class="text-sm-right"><b>URI:</b></b-col>
              <b-col><output v-text="row.item._links.self.href"></output></b-col>
            </b-row>
            <b-row>
              <b-button-group>
                <edit-company 
                  :nameField="row.item.name" 
                  :uri="row.item._links.self.href" 
                  @updateView="updateView"/>
                <view-reference-staff 
                  :uri="row.item._links.self.href"/>
                <b-dropdown right text="more actions">
                  <b-dropdown-item 
                    @click="row.toggleDetails">toggle details</b-dropdown-item>
                  <b-dropdown-divider/>
                  <b-dropdown-item 
                    @click="deleteItemConfirm(row.item._links.self.href)"
                    >delete item</b-dropdown-item>
                </b-dropdown>
              </b-button-group>
            </b-row>
          </b-card>
        </template>
      </b-table>
    </section>
  </section>
</template>

<script>
import CompanyVerbsRestfulService from '../services/CompanyVerbsRestfulService'
import CompanyAddComponent from '@/components/CompanyAddComponent.vue'
import CompanyEditorComponent from '@/components/CompanyEditorComponent.vue'
import CompanyReferenceViewComponent from '@/components/CompanyReferenceViewComponent.vue'

export default {
  name: 'CompanyComponent',
  components: {
    'add-company': CompanyAddComponent,
    'edit-company': CompanyEditorComponent,
    'view-reference-staff': CompanyReferenceViewComponent
  },
  data: () => ({
    fields: [
      {
        key: 'name',
        label: 'names',
        sortable: true
      },
      {
        key: 'showDetails',
        label: 'details'
      }
    ],
    companies: [],
    messageBoxToConfirmDeletion: '',
    textToSearchFor: ''
  }),
  methods: {
    retrieveCompanies() {
      CompanyVerbsRestfulService.readAll()
        .then(response => {
          this.companies = response.data._embedded.companies;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    async updateView() {
      this.$bvToast.toast('data of companies being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 2000
      });
      await setTimeout(() => {
          this.companies = null;
          this.retrieveCompanies();
        }, 2000);
    },
    deleteItem(uri) {
      CompanyVerbsRestfulService.delete(uri)
        .catch(e => {
          console.log(e);
        });
      this.updateView();
    },
    deleteItemConfirm(uri) {
      this.messageBoxToConfirmDeletion = '';
      this.$bvModal.msgBoxConfirm('are you sure you want to delete this item', {
        title: 'please confirm',
        size: 'md',
        buttonSize: 'md',
        okVariant: 'danger',
        okTitle: 'yes',
        cancelTitle: 'no',
        footerClass: 'p-2',
        hideHeaderClose: false,
        centered: true
      }).then(value => {
        if(value) {
          this.deleteItem(uri);
        }
      });
    }
  },
  computed: {
    textToSearch() {
      return this.$store.state.textToSearch;
    }
  },
  mounted() {
    this.retrieveCompanies();
  }
}
</script>

<style>
  button {
    margin: 2px;
  }
</style>
