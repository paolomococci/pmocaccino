<template>
  <section>
    <b-button 
      variant="outline-primary" 
      @click="showModalDetail">edit</b-button>
    <b-modal ref="modal-edit" hide-footer :title="uri">
      <div class="d-block text-center">
        <h3>fields</h3>
        <b-form  @submit.stop.prevent="onSubmitForm">
          <!-- name field -->
          <b-form-group id="input-name-group" label="name" label-for="input-name">
            <b-form-input 
              id="input-name" 
              name="input-name" 
              v-model="$v.form.companyName.$model" 
              :state="onValidateFormCompanyName('companyName')" 
              aria-describedby="input-name-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-name-feedback-invalid">
              must be 8 to 30 characters long, moreover the symbols and white space are prohibited
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-name-feedback-valid">
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
            type="submit">update</b-button>
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
  name: 'CompanyEditorComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      companyName: ''
    }
  }),
  props: {
    uri: String,
    nameField: String
  },
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
    onValidateFormCompanyName(companyName) {
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
      this.$bvModal.msgBoxConfirm('are you sure you want to update this item', {
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
          this.updateCompany();
        }
      });
    },
    showModalDetail() {
      this.$refs['modal-edit'].show();
    },
    hideModalDetail() {
      this.$refs['modal-edit'].hide();
    },
    updateCompany() {
      var data = {
        name: this.form.companyName
      };
      CompanyVerbsRestfulService.partialUpdate(this.uri, data)
        .then(response => {
          console.log(response.data);
        }).catch(e => {
          console.log(e);
        });
      this.$refs['modal-edit'].hide();
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
    this.form.companyName = this.nameField;
  }
}
</script>
