<template>
    <section>
        <!-- TODO-->
    </section>
</template>

<script>
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'
import EmployeeEditorComponent from '@/components/EmployeeEditorComponent.vue'
import EmployeeReferenceViewComponent from '@/components/EmployeeReferenceViewComponent.vue'
import EmployeeUpdateRefToCompanyComponent from '@/components/EmployeeUpdateRefToCompanyComponent.vue'
import EmployeeDelRefToCompanyComponent from '@/components/EmployeeDelRefToCompanyComponent.vue'
import EmployeeAddRefToContestComponent from '@/components/EmployeeAddRefToContestComponent.vue'
import EmployeeDelRefToContestComponent from '@/components/EmployeeDelRefToContestComponent.vue'

export default {
    name: 'EmployeeViewTableComponent',
  components: {
    'edit-employee': EmployeeEditorComponent,
    'view-reference-employee': EmployeeReferenceViewComponent,
    'update-ref-to-company': EmployeeUpdateRefToCompanyComponent,
    'del-ref-to-company': EmployeeDelRefToCompanyComponent,
    'add-ref-to-contest': EmployeeAddRefToContestComponent,
    'del-ref-to-contest': EmployeeDelRefToContestComponent
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
    messageBoxToConfirmDeletion: ''
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
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.employees = null;
          this.retrieveEmployees();
        }, 1000);
    },
    deleteItem(uri) {
      EmployeeVerbsRestfulService.delete(uri)
        .catch(e => {
          console.log(e);
        });
      this.updateView();
    },
    deleteItemConfirm(uri) {
      this.messageBoxToConfirmDeletion = '';
      this.$bvModal.msgBoxConfirm('are you sure you want to delete this item', {
        title: 'please confirm',
        size: 'md',
        buttonSize: 'md',
        okVariant: 'danger',
        okTitle: 'yes',
        cancelTitle: 'no',
        footerClass: 'p-2',
        hideHeaderClose: false,
        centered: true
      }).then(value => {
        if(value) {
          this.deleteItem(uri);
        }
      });
    }
  },
  computed: {},
  mounted() {
    this.retrieveEmployees();
  }
}
</script>
