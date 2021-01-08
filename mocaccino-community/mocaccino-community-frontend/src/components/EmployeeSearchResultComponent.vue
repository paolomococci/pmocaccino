<template>
    <section>
        <!-- TODO-->
    </section>
</template>

<script>
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'

export default {
    name: 'EmployeeSearchResultComponent',
  data: () => ({}),
  methods: {
    searchByUsername() {
      EmployeeVerbsRestfulService.searchByUsername(this.textToSearchFor)
        .then(response => {
          this.employees = response.data._embedded.employees;
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
