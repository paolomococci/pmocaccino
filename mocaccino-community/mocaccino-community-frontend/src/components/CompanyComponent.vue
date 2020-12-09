<template>
  <section>
    <b-table striped hover :items="companies" :fields="fields"></b-table>
    <aside>
      <detail/>
    </aside>
    <footer>
      <b-card-group deck>
      <b-card header="element that displays the text to search for" title="text to search for:">
        <b-card-text><mark v-text="textToSearch"></mark></b-card-text>
      </b-card>
    </b-card-group>
    </footer>
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
