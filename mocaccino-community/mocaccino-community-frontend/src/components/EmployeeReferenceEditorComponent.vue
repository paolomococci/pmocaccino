<template>
    <section>
      <b-button 
        variant="outline-warning" 
        @click="showModalDetail">references</b-button>
      <b-modal ref="modal-edit-reference" hide-footer :title="uri">
        <div class="d-block text-center">
          <h3>references</h3>
          <b-form  @submit.stop.prevent>
          <!-- company reference -->
          <b-form-group>
            <label for="reference-company-name">company name</label>
            <b-form-input 
              v-model="company.name" 
              id="reference-company-name"></b-form-input>
          </b-form-group>
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
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'

export default {
    name: 'EmployeeReferenceEditorComponent',
  data: () => ({
    company: '',
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
    retrieveCompany() {
      EmployeeVerbsRestfulService.readCompanyMembership(this.uri)
        .then(response => {
          this.company = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    settingUpCompanyMembership() {
      // TODO
    },
    ruleOutCompanyMembership() {
      // TODO
    },
    retrieveContests() {
      EmployeeVerbsRestfulService.readContestParticipation(this.uri)
        .then(response => {
          this.contests = response.data._embedded.contests;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    settingUpContestParticipation() {
      // TODO
    },
    ruleOutContestParticipation() {
      // TODO
    }
  },
  mounted() {
    this.retrieveCompany();
  }
}
</script>
