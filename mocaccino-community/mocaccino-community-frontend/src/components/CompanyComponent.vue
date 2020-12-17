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
            <b-button variant="outline-primary" size="sm">update</b-button>
            <b-button variant="outline-danger" size="sm" @click="deleteItem(row.item._links.self.href)">delete</b-button>
            <b-button variant="outline-secondary" size="sm" @click="row.toggleDetails">cancel</b-button>
          </b-card>
        </template>
      </b-table>
    </section>
  </section>
</template>

<script>
import CompanyVerbsRestfulService from '../services/CompanyVerbsRestfulService'
import CompanyAddComponent from '@/components/CompanyAddComponent.vue'

export default {
  name: 'CompanyComponent',
  components: {
    'add-company': CompanyAddComponent
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
    company: {name: '', _links: {self: {href: ''}}},
    index: 0,
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
      this.companies = null;
      this.retrieveCompanies();
    },
    searchByName() {
      CompanyVerbsRestfulService.get(this.textToSearchFor)
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
