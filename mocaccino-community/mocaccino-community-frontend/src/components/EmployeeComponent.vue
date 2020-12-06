<template>
  <section>
    <!-- TODO -->
  </section>
</template>

<script>
import axios from 'axios'

export default {
  name: 'EmployeeComponent',
  data: () => ({
    url: 'http://localhost:8090/rest/employees',
    employees: [],
    employee: {name: '', surname: '', email: '', profession: '', username: '', _links: {self: {href: ''}}},
    index: 0,
    username: ''
  }),
  methods: {
    retrieveEmployees() {
      axios.get(this.url)
        .then(response => {
          this.employees = response.data._embedded.employees;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    searchByEmail() {
      axios.get(`http://localhost:8090/rest/employees/search/likeByUsername?username=${this.username}`)
        .then(response => {
          this.employees = response.data._embedded.employees;
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
