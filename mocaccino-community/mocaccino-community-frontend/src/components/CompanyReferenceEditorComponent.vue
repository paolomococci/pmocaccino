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
    employee: null,
    contests: []
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
    retrieveEmployee() {
      CompanyVerbsRestfulService.read(this.uri)
        .then(response => {
          this.employee = response.data._embedded.employee;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    retrieveContests() {
      CompanyVerbsRestfulService.read(this.uri)
        .then(response => {
          this.contests = response.data._embedded.contests;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.retrieveEmployee();
    this.retrieveContests();
  }
}
</script>
