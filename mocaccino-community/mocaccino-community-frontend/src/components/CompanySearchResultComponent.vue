<template>
    <section>
        <!-- TODO-->
    </section>
</template>

<script>
import CompanyVerbsRestfulService from '../services/CompanyVerbsRestfulService'

export default {
    name: 'CompanySearchResultComponent',
  data: () => ({}),
  methods: {
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
  computed: {},
  mounted() {}
}
</script>
