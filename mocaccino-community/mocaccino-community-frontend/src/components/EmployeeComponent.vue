<template>
  <section>
    <aside>
      <add-employee @updateView="updateView"/>
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
            <b-row>
              <b-button-group size="sm">
                <edit-employee 
                  :usernameField="row.item.username" 
                  :nameField="row.item.name" 
                  :surnameField="row.item.surname" 
                  :emailField="row.item.email"
                  :professionField="row.item.profession"
                  :uri="row.item._links.self.href" 
                  @updateView="updateView"/>
                <view-reference-employee 
                  :uri="row.item._links.self.href"/>
                <b-dropdown right text="more actions">
                  <b-dropdown-item 
                    @click="deleteItem(row.item._links.self.href)">delete item</b-dropdown-item>
                  <b-dropdown-divider/>
                  <b-dropdown-item 
                    @click="row.toggleDetails">toggle details</b-dropdown-item>
                </b-dropdown>
              </b-button-group>
            </b-row>
          </b-card>
        </template>
      </b-table>
    </section>
  </section>
</template>

<script>
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'
import EmployeeAddComponent from '@/components/EmployeeAddComponent.vue'
import EmployeeEditorComponent from '@/components/EmployeeEditorComponent.vue'
import EmployeeReferenceViewComponent from '@/components/EmployeeReferenceViewComponent.vue'

export default {
  name: 'EmployeeComponent',
  components: {
    'add-employee': EmployeeAddComponent,
    'edit-employee': EmployeeEditorComponent,
    'view-reference-employee': EmployeeReferenceViewComponent
  },
  data: () => ({
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
    textToSearchFor: ''
  }),
  methods: {
    retrieveEmployees() {
      EmployeeVerbsRestfulService.readAll()
        .then(response => {
          this.employees = response.data._embedded.employees;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    async updateView() {
      this.$bvToast.toast('data of employees being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 6000
      });
      await setTimeout(6000);
      this.employees = null;
      this.retrieveEmployees();
    },
    deleteItem(uri) {
      EmployeeVerbsRestfulService.delete(uri)
        .catch(e => {
          console.log(e);
        });
      this.updateView();
    },
    deleteItemConfirm() {
      // TODO
    },
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

<style>
  button {
    margin: 3px;
  }
</style>
