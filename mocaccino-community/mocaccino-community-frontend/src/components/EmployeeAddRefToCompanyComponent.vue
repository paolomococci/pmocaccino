<template>
    <section>
      <b-dropdown-item 
        @click="showModalDetail">add reference to company</b-dropdown-item>
      <b-modal 
        size="xl" 
        ref="modal-edit-reference" 
        hide-footer 
        :title="uri">
        <div class="d-block text-center">
          <h3>add the company reference</h3>
          <b-form  @submit.stop.prevent>
          <!-- company reference to add -->
          <b-form-group>
            <label for="reference-company">company</label>
            <b-form-select 
              v-model="company" 
              :options="options" 
              id="reference-company"></b-form-select>
            <!-- todo verify -->
            <div class="mt-3">selected: <output v-text="company"></output></div>
          </b-form-group>
          </b-form>
          <h3>companies</h3>
          <b-table 
            :items="companies" 
            striped 
            responsive="sm"></b-table>
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
          @click="addConfirm">update</b-button>
      </b-modal>
    </section>
</template>

<script>
import CompanyVerbsRestfulService from '../services/CompanyVerbsRestfulService'

export default {
    name: 'EmployeeAddRefToCompanyComponent',
  data: () => ({
    company: null,
    companies: [],
    options: []
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
          this.companies = response.data._embedded.companies;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    settingOptions() {
      // TODO
    },
    settingUpCompanyMembership() {
      this.hideModalDetail();
      // TODO
    },
    addConfirm() {
      this.messageBoxToConfirmDeletion = '';
      this.$bvModal.msgBoxConfirm('are you sure you want to add this reference', {
        title: 'please confirm',
        size: 'md',
        buttonSize: 'md',
        okVariant: 'warning',
        okTitle: 'yes',
        cancelTitle: 'no',
        footerClass: 'p-2',
        hideHeaderClose: false,
        centered: true
      }).then(value => {
        if(value) {
          this.settingUpCompanyMembership();
        }
      });
    }
  },
  mounted() {
    this.retrieveCompanies();
  }
}
</script>
