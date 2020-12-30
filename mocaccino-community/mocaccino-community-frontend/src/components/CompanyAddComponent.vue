<template>
  <section>
    <b-button 
      variant="outline-primary" 
      @click="showModalDetail">add company</b-button>
    <b-button 
      variant="outline-secondary" 
      @click="updateView">update view</b-button>
    <b-modal ref="modal-add" hide-footer title="enter the details of a new company">
      <div class="d-block text-center">
        <h3>fields</h3>
        <b-form  @submit.stop.prevent>
          <!-- name field -->
          <label for="feedback-name">name</label>
          <b-form-input 
            required
            v-model="companyName" 
            :state="acceptableName" 
            id="feedback-name"></b-form-input>
          <b-form-invalid-feedback :state="acceptableName">
            name of new company must be 8 to 30 characters long
          </b-form-invalid-feedback>
          <b-form-valid-feedback :state="acceptableName">
            all right
          </b-form-valid-feedback>
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
        :disabled="!isAcceptableName()" 
        @click="addCompany">save</b-button>
    </b-modal>
  </section>
</template>

<script>
import CompanyVerbsRestfulService from '../services/CompanyVerbsRestfulService'

export default {
  name: 'CompanyAddComponent',
  data: () => ({
    companyName: ''
  }),
  computed: {
    acceptableName() {
      return this.isAcceptableName();
    }
  },
  methods: {
    isAcceptableName() {
      return this.companyName.length > 7 && this.companyName.length < 31;
    },
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide();
    },
    addCompany() {
      var data = {
        name: this.companyName
      };
      CompanyVerbsRestfulService.create(data)
        .then(response => {
          console.log(response.data);
        }).catch(e => {
          console.log(e);
        });
      this.$refs['modal-add'].hide();
      this.updateView();
    },
    updateView() {
      this.$emit('updateView');
    }
  }
}
</script>
