<template>
  <section>
    <aside>
      <add-company/>
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
            <b-button size="sm" @click="row.toggleDetails">hide details</b-button>
          </b-card>
        </template>
      </b-table>
    </section>
  </section>
</template>

<script>
import axios from 'axios'
import CompanyAddComponent from '@/components/CompanyAddComponent.vue'

export default {
  name: 'CompanyComponent',
  components: {
    'add-company': CompanyAddComponent
  },
  data: () => ({
    url: 'http://localhost:8090/rest/companies',
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
      axios.get(this.url)
        .then(response => {
          this.companies = response.data._embedded.companies;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    searchByTitle() {
      axios.get(`http://localhost:8090/rest/articles/search/likeByName?name=${this.textToSearchFor}`)
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
