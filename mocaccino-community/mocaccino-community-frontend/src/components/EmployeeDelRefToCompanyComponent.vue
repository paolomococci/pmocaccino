<template>
    <section>
      <b-dropdown-item 
        variant="outline-warning" 
        @click="showModalDetail">delete reference to company</b-dropdown-item>
      <b-modal ref="modal-edit-reference" hide-footer :title="uri">
        <div class="d-block text-center">
          <h3>references</h3>
          <b-form  @submit.stop.prevent>
          <!-- company reference -->
          <b-form-group>
            <label for="reference-company-name">company name</label>
            <b-form-input 
              readonly
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
          @click="deleteConfirm">delete</b-button>
      </b-modal>
    </section>
</template>

<script>
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'

export default {
    name: 'EmployeeDelRefToCompanyComponent',
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
    ruleOutCompanyMembership() {
      this.hideModalDetail();
      EmployeeVerbsRestfulService.deleteCompanyMembership(this.uri);
    },
    deleteConfirm() {
      this.messageBoxToConfirmDeletion = '';
      this.$bvModal.msgBoxConfirm('are you sure you want to delete this reference', {
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
          this.ruleOutCompanyMembership();
        }
      });
    }
  },
  mounted() {
    this.retrieveCompany();
  }
}
</script>
