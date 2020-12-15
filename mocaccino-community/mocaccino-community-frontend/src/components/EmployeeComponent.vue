<template>
  <section>
    <aside>
      <add-employee/>
    </aside>
    <!-- sub-section to show the employee list -->
    <section>
      <b-table 
        :items="employees" 
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
              <b-col sm="3" class="text-sm-right"><b>name:</b></b-col>
              <b-col><output v-text="row.item.name"></output></b-col>
            </b-row>
            <b-row class="mb-2">
              <b-col sm="3" class="text-sm-right"><b>surname:</b></b-col>
              <b-col><output v-text="row.item.surname"></output></b-col>
            </b-row>
            <b-row class="mb-2">
              <b-col sm="3" class="text-sm-right"><b>email:</b></b-col>
              <b-col><output v-text="row.item.email"></output></b-col>
            </b-row>
            <b-row class="mb-2">
              <b-col sm="3" class="text-sm-right"><b>profession:</b></b-col>
              <b-col><output v-text="row.item.profession"></output></b-col>
            </b-row>
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
import EmployeeAddComponent from '@/components/EmployeeAddComponent.vue'

export default {
  name: 'EmployeeComponent',
  components: {
    'add-employee': EmployeeAddComponent
  },
  data: () => ({
    url: 'http://localhost:8090/rest/employees',
    fields: [
      {
        key: 'username',
        label: 'usernames',
        sortable: true
      },
      {
        key: 'showDetails',
        label: 'details'
      }
    ],
    employees: [],
    employee: {name: '', surname: '', email: '', profession:  '', username:  '', _links: {self: {href: ''}}},
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
    searchByUsername() {
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
