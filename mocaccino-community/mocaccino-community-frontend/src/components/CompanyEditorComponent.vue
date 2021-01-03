<template>
  <section>
    <b-button 
      variant="outline-primary" 
      @click="showModalDetail">edit</b-button>
    <b-modal ref="modal-edit" hide-footer :title="uri">
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
        variant="outline-warning" 
        block 
        @click="onResetForm()">reset</b-button>
      <b-button 
        class="mt-3" 
        variant="outline-primary" 
        block 
        type="submit">update</b-button>
    </b-modal>
  </section>
</template>

<script>
import { validationMixin } from "vuelidate";
import { required, minLength, maxLength, helpers } from "vuelidate/lib/validators";
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
    onValidateForm(companyName) {
      // TODO
    },
    onResetForm() {
      // TODO
    },
    onSubmitForm() {
      // TODO
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
          // TODO
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
    this.companyName = this.nameField;
  }
}
</script>
