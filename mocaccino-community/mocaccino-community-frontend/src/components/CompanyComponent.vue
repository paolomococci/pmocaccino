<template>
  <section>
    <!-- TODO -->
  </section>
</template>

<script>
import axios from 'axios'

export default {
  name: 'CompanyComponent',
  data: () => ({
    url: 'http://localhost:8090/rest/companies',
    companies: [],
    company: {name: '', _links: {self: {href: ''}}},
    index: 0,
    name: ''
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
      axios.get(`http://localhost:8090/rest/articles/search/likeByName?name=${this.name}`)
        .then(response => {
          this.companies = response.data._embedded.companies;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    // TODO
  }
}
</script>
