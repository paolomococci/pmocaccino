<template>
  <section>
    <aside>
      <add-contest @updateView="updateView"/>
    </aside>
    <!-- sub-section to show the contest list -->
    <section>
      <b-table 
        :items="contests" 
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
              <b-col sm="3" class="text-sm-right"><b>title:</b></b-col>
              <b-col><output v-text="row.item.title"></output></b-col>
            </b-row>
            <b-row class="mb-2">
              <b-col sm="3" class="text-sm-right"><b>description:</b></b-col>
              <b-col><output v-text="row.item.description"></output></b-col>
            </b-row>
            <b-row class="mb-2">
              <b-col sm="3" class="text-sm-right"><b>URI:</b></b-col>
              <b-col><output v-text="row.item._links.self.href"></output></b-col>
            </b-row>
            <b-row>
              <b-button-group>
                <edit-contest 
                  :nameField="row.item.name" 
                  :titleField="row.item.title" 
                  :descriptionField="row.item.description" 
                  :dateField="row.item.date"
                  :uri="row.item._links.self.href" 
                  @updateView="updateView"/>
                <view-reference-participants 
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
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'
import ContestAddComponent from '@/components/ContestAddComponent.vue'
import ContestEditorComponent from '@/components/ContestEditorComponent.vue'
import ContestReferenceViewComponent from '@/components/ContestReferenceViewComponent.vue'

export default {
  name: 'ContestComponent',
  components: {
    'add-contest': ContestAddComponent,
    'edit-contest': ContestEditorComponent,
    'view-reference-participants': ContestReferenceViewComponent
  },
  data: () => ({
    fields: [
      {
        key: 'date',
        label: 'dates',
        sortable: true
      },
      {
        key: 'name',
        label: 'names'
      },
      {
        key: 'showDetails',
        label: 'details'
      }
    ],
    contests: [],
    messageBoxToConfirmDeletion: '',
    textToSearchFor: ''
  }),
  methods: {
    retrieveContests() {
      ContestVerbsRestfulService.readAll()
        .then(response => {
          this.contests = response.data._embedded.contests;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    async updateView() {
      this.$bvToast.toast('data of contests being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 2000
      });
      await setTimeout(() => {
          this.contests = null;
          this.retrieveContests();
        }, 2000);
    },
    deleteItem(uri) {
      ContestVerbsRestfulService.delete(uri)
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
    this.retrieveContests();
  }
}
</script>

<style>
  button {
    margin: 2px;
  }
</style>
