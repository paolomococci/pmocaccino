<template>
  <section>
    <b-table striped hover :items="employees" :fields="fields"></b-table>
    <aside>
      <detail/>
    </aside>
  </section>
</template>

<script>
import axios from 'axios'
import EmployeeDetailComponent from '@/components/EmployeeDetailComponent.vue'

export default {
  name: 'EmployeeComponent',
  components: {
    detail: EmployeeDetailComponent
  },
  data: () => ({
    url: 'http://localhost:8090/rest/employees',
    fields: [
      {
        key: 'name',
        label: 'names'
      },
      {
        key: 'surname',
        label: 'surnames'
      },
      {
        key: 'email',
        label: 'emails'
      },
      {
        key: 'profession',
        label: 'professions'
      },
      {
        key: 'username',
        label: 'usernames',
        sortable: true
      },
      {
        key: '_links.self.href',
        label: 'URIs'
      }
    ],
    employees: [],
    employee: {name: '', surname: '', email: '', profession: '', username: '', _links: {self: {href: ''}}},
    index: 0,
    textToSearchFor: ''
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
      axios.get(`http://localhost:8090/rest/employees/search/likeByUsername?username=${this.textToSearchFor}`)
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
