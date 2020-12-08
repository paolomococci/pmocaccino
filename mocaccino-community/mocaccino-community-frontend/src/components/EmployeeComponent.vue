<template>
  <section>
    <b-table striped hover :items="employees" :fields="fields"></b-table>
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

export default {
  name: 'EmployeeComponent',
  data: () => ({
    url: 'http://localhost:8090/rest/employees',
    fields: ['name', 'surname', 'email', 'profession', 'username', '_links.self.href'],
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
  computed: {
    textToSearch() {
      return this.$store.state.textToSearch;
    }
  },
  mounted() {
    this.retrieveEmployees();
  }
}
</script>
