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
            <!-- TODO -->
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
          @click="hideModalDetail">toggle</b-button>
        <b-button 
          class="mt-3" 
          variant="outline-primary" 
          block 
          @click="settingUpCompanyMembership">update</b-button>
      </b-modal>
    </section>
</template>

<script>
import CompanyVerbsRestfulService from '../services/CompanyVerbsRestfulService'

export default {
    name: 'EmployeeAddRefToCompanyComponent',
  data: () => ({
    company: ''
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
    retrieveCompanies() {
      CompanyVerbsRestfulService.readAll()
        .then(response => {
          this.company = response.data._embedded.company;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    settingUpCompanyMembership() {
      // TODO
      this.hideModalDetail();
    }
  },
  mounted() {
    this.retrieveCompanies();
  }
}
</script>
