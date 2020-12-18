<template>
  <section>
    <b-button variant="outline-primary" size="sm" @click="showModalDetail">edit</b-button>
    <b-modal ref="modal-add" hide-footer :title="uri">
      <div class="d-block text-center">
        <h3>fields</h3>
        <b-form  @submit.stop.prevent>
          <label for="feedback-name">name</label>
          <b-form-input 
            v-model="companyName" 
            :state="acceptable" 
            id="feedback-name"></b-form-input>
          <b-form-invalid-feedback :state="acceptable">
            name of new company must be 8 to 30 characters long
          </b-form-invalid-feedback>
          <b-form-valid-feedback :state="acceptable">
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
        :disabled="!isAcceptable()" 
        @click="updateCompany">save</b-button>
    </b-modal>
  </section>
</template>

<script>
import CompanyVerbsRestfulService from '../services/CompanyVerbsRestfulService'

export default {
  name: 'CompanyEditorComponent',
  data: () => ({
    companyName: ''
  }),
  props: {
    uri: String,
    nameField: String
  },
  methods: {
    isAcceptable() {
      return this.companyName.length > 7 && this.companyName.length < 31;
    },
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide();
    },
    updateCompany() {
      var data = {
        name: this.companyName
      };
      CompanyVerbsRestfulService.partialUpdate(this.uri, data)
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
  },
  computed: {
    acceptable() {
      return this.isAcceptable();
    }
  },
  mounted() {
    this.companyName = this.nameField;
  }
}
</script>
