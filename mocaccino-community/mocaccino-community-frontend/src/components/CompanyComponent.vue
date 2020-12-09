<template>
  <section>
    <b-table striped hover :items="companies" :fields="fields"></b-table>
    <aside>
      <detail/>
    </aside>
  </section>
</template>

<script>
import axios from 'axios'
import CompanyDetailComponent from '@/components/CompanyDetailComponent.vue'

export default {
  name: 'CompanyComponent',
  components: {
    detail: CompanyDetailComponent
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
        key: '_links.self.href',
        label: 'URIs'
      }
    ],
    companies: [],
    company: {name: '', _links: {self: {href: ''}}},
    index: 0,
    toSearchFor: ''
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
      axios.get(`http://localhost:8090/rest/articles/search/likeByName?name=${this.toSearchFor}`)
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
