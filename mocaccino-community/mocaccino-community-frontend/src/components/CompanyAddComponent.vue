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
        <b-form  @submit.stop.prevent="onSubmitForm">
          <!-- name field -->
          <b-form-group id="input-name-group" label="name" label-for="input-name">
            <b-form-input 
              id="input-name"
              name="input-name"
              v-model="$v.form.companyName.$model" 
              :state="onValidateForm('companyName')" 
              aria-describedby="input-name-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-name-feedback-invalid">
              must be 8 to 30 characters long, moreover the symbols and white space are prohibited
            </b-form-invalid-feedback>
            <b-form-valid-feedback>
              all right
            </b-form-valid-feedback>
          </b-form-group>
        <b-button 
          class="mt-3" 
          variant="outline-secondary" 
          block 
          @click="hideModalDetail">cancel</b-button>
        <b-button 
          class="mt-3" 
          variant="outline-warning" 
          block 
          @click="onResetForm()">reset</b-button>
        <b-button 
          class="mt-3" 
          variant="outline-primary" 
          block 
          type="submit">save</b-button>
        </b-form>
      </div>
    </b-modal>
  </section>
</template>

<script>
import { validationMixin } from 'vuelidate'
import { required, minLength, maxLength, helpers } from 'vuelidate/lib/validators'
import CompanyVerbsRestfulService from '../services/CompanyVerbsRestfulService'

const charactersAcceptedAsValid = helpers.regex('charactersAcceptedAsValid', /^[a-zA-Z0-9-_]*$/);

export default {
  name: 'CompanyAddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      companyName: ''
    },
    companyName: ''
  }),
  validations: {
    form: {
      companyName: {
        required,
        minLength: minLength(8),
        maxLength: maxLength(30),
        charactersAcceptedAsValid
      }
    }
  },
  methods: {
    onValidateForm(companyName) {
      const { $dirty, $error } = this.$v.form[companyName];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        companyName: ''
      };
      this.$nextTick(() => {
        this.$v.$reset();
      });
    },
    onSubmitForm() {
      this.$v.form.$touch();
      if (this.$v.form.$anyError) {
        this.onResetForm();
        return;
      }
      this.onConfirm();
    },
    onConfirm() {
      this.messageBoxToConfirmDeletion = '';
      this.$bvModal.msgBoxConfirm('are you sure you want to add this item', {
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
          this.addCompany();
        }
      });
    },
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide();
    },
    addCompany() {
      var data = {
        name: this.form.companyName
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
