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
              <edit-company 
                :nameField="row.item.name" 
                :uri="row.item._links.self.href" 
                @updateView="updateView"/>
              <b-button 
                variant="outline-danger" 
                size="sm" 
                @click="deleteItem(row.item._links.self.href)">delete</b-button>
              <b-button 
                variant="outline-secondary" 
                size="sm" 
                @click="row.toggleDetails">toggle details</b-button>
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

export default {
  name: 'CompanyComponent',
  components: {
    'add-company': CompanyAddComponent,
    'edit-company': CompanyEditorComponent
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
    updateView() {
      this.companies = null;
      this.retrieveCompanies();
    },
    deleteItem(uri) {
      CompanyVerbsRestfulService.delete(uri)
        .catch(e => {
          console.log(e);
        });
      this.updateView();
    },
    retrieveURI(uri) {
      return uri;
    },
    searchByName() {
      CompanyVerbsRestfulService.searchByName(this.textToSearchFor)
        .then(response => {
          this.companies = response.data._embedded.companies;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
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
    margin: 3px;
  }
</style>
