<template>
  <section>
    <b-button 
      variant="outline-primary" 
      @click="showModalDetail">edit</b-button>
    <b-modal ref="modal-edit" hide-footer :title="uri">
      <div class="d-block text-center">
        <h3>fields</h3>
        <b-form  @submit.stop.prevent="onSubmitForm">
          <!-- username field -->
          <b-form-group>
            <label for="feedback-username">username</label>
            <b-form-input 
              v-model="employeeUsername" 
              :state="acceptableUsername" 
              id="feedback-username"></b-form-input>
            <b-form-invalid-feedback :state="acceptableUsername">
              username of new employee must be 6 to 20 characters long
            </b-form-invalid-feedback>
            <b-form-valid-feedback :state="acceptableUsername">
              all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- name field -->
          <b-form-group id="input-name-group" label="name" label-for="input-name">
            <b-form-input 
              id="input-name" 
              name="input-name" 
              v-model="$v.form.employeeName.$model" 
              :state="onValidateFormEmployeeName('employeeName')" 
              aria-describedby="input-name-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-name-feedback-invalid">
              must be 3 to 14 characters long; moreover only alphabetic characters are accepted, both uppercase and lowercase
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-name-feedback-valid">
              all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- surname field -->
          <b-form-group>
            <label for="feedback-surname">surname</label>
            <b-form-input 
              v-model="employeeSurname" 
              :state="acceptableSurname" 
              id="feedback-surname"></b-form-input>
            <b-form-invalid-feedback :state="acceptableSurname">
              surname of new employee must be 3 to 20 characters long
            </b-form-invalid-feedback>
            <b-form-valid-feedback :state="acceptableSurname">
              all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- email field -->
          <b-form-group>
            <label for="feedback-email">email</label>
            <b-form-input 
              v-model="employeeEmail" 
              :state="acceptableEmail" 
              id="feedback-email"></b-form-input>
            <b-form-invalid-feedback :state="acceptableEmail">
              email of new employee must be 8 to 40 characters long
            </b-form-invalid-feedback>
            <b-form-valid-feedback :state="acceptableEmail">
              all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- profession field -->
          <b-form-group>
            <label for="feedback-profession">profession</label>
            <b-form-input 
              v-model="employeeProfession" 
              :state="acceptableProfession" 
              id="feedback-profession"></b-form-input>
            <b-form-invalid-feedback :state="acceptableProfession">
              profession of new employee must be 5 to 30 characters long
            </b-form-invalid-feedback>
            <b-form-valid-feedback :state="acceptableProfession">
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
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'

const templateCharactersAcceptedAsValid = helpers.regex('templateCharactersAcceptedAsValid', /^[a-z]*$/);

export default {
  name: 'EmployeeEditorComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      employeeUsername: '',
      employeeName: '',
      employeeSurname: '',
      employeeEmail: '',
      employeeProfession: ''
    }
  }),
  props: {
    uri: String,
    usernameField: String,
    nameField: String,
    surnameField: String,
    emailField: String,
    professionField: String
  },
  validations: {
    form: {
      employeeUsername: {
        required,
        minLength: minLength(6),
        maxLength: maxLength(20)
      },
      employeeName: {
        required,
        minLength: minLength(3),
        maxLength: maxLength(14)
      },
      employeeSurname: {
        required,
        minLength: minLength(3),
        maxLength: maxLength(20)
      },
      employeeEmail: {
        required,
        minLength: minLength(8),
        maxLength: maxLength(60)
      },
      employeeProfession: {
        required,
        minLength: minLength(5),
        maxLength: maxLength(30)
      }
    }
  },
  methods: {
    onValidateFormEmployeeUsername(employeeUsername) {
      // TODO
    },
    onValidateFormEmployeeName(employeeName) {
      // TODO
    },
    onValidateFormEmployeeSurname(employeeSurname) {
      // TODO
    },
    onValidateFormEmployeeEmail(employeeEmail) {
      // TODO
    },
    onValidateFormEmployeeProfession(employeeProfession) {
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
    updateEmployee() {
      var data = {
        name: this.form.employeeName,
        surname: this.form.employeeSurname,
        email: this.form.employeeEmail,
        profession: this.employeeProfession,
        username: this.form.employeeUsername
      };
      EmployeeVerbsRestfulService.partialUpdate(this.uri, data)
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
  mounted() {
    this.employeeUsername = this.usernameField;
    this.employeeName = this.nameField;
    this.employeeSurname = this.surnameField;
    this.employeeEmail = this.emailField;
    this.employeeProfession = this.professionField;
  }
}
</script>
