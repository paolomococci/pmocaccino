<template>
    <section>
      <b-button 
        variant="outline-warning" 
        size="sm" 
        @click="showModalDetail">references</b-button>
      <b-modal ref="modal-edit-reference" hide-footer :title="uri">
        <div class="d-block text-center">
          <h3>references</h3>
          <b-form  @submit.stop.prevent>
            <!-- TODO -->
          </b-form>
        </div>
        <b-button 
          class="mt-3" 
          variant="outline-secondary" 
          block 
          @click="hideModalDetail">cancel</b-button>
        <b-button 
          class="mt-3" 
          variant="outline-primary" 
          block 
          :disabled="!isAcceptable()" 
          @click="hideModalDetail">update</b-button>
      </b-modal>
    </section>
</template>

<script>
import CompanyVerbsRestfulService from '../services/CompanyVerbsRestfulService'

export default {
    name: 'CompanyReferenceEditorComponent',
  data: () => ({
    employees: []
  }),
  props: {
    uri: String
  },
  methods: {
    isAcceptable() {
      return false;
    },
    showModalDetail() {
      this.$refs['modal-edit-reference'].show();
    },
    hideModalDetail() {
      this.$refs['modal-edit-reference'].hide();
    },
    retrieveEmployees() {
      CompanyVerbsRestfulService.readListOfEmployee(this.uri)
        .then(response => {
          this.employees = response.data._embedded.employees;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    addEmployee() {
      // TODO
    },
    removeEmployee() {
      // TODO
    }
  },
  mounted() {
    this.retrieveEmployees();
  }
}
</script>
