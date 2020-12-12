<template>
  <section>
    <b-table 
      striped hover 
      selectable 
      select-mode="single" 
      ref="selectableTable"
      :items="employees" 
      :fields="fields" 
      @row-selected="onRowSelected" 
      responsive="sm">
      <template #cell(employee)="{rowSelected}">
        <template v-if="rowSelected">
          <span aria-hidden="true">&#10007;</span>
        </template>
        <template v-else>
          <span aria-hidden="true">&#160;</span>
        </template>
      </template>
    </b-table>
    <aside>
      <b-button 
        class="mt-3" 
        variant="outline-secondary" 
        @click="deselect">deselect</b-button>
      <br><br>
      <p v-text="employee"></p>
      <br>
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
        key: '_links.employee.href',
        label: 'URIs'
      },
      {
        key: 'employee',
        label: 'edit'
      }
    ],
    employees: [],
    employee: '',
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
    },
    onRowSelected(item) {
      this.employee = item
    },
    deselect() {
      this.$refs.selectableTable.clearSelected()
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
