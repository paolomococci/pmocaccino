<template>
  <section>
    <b-button 
      variant="outline-primary" 
      @click="showModalDetail">edit</b-button>
    <b-modal ref="modal-edit" hide-footer :title="uri">
      <div class="d-block text-center">
        <h3>fields</h3>
        <b-form  @submit.stop.prevent>
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
          <b-form-group>
            <label for="feedback-name">name</label>
            <b-form-input 
              v-model="employeeName" 
              :state="acceptableName" 
              id="feedback-name"></b-form-input>
            <b-form-invalid-feedback :state="acceptableName">
              name of new employee must be 3 to 14 characters long
            </b-form-invalid-feedback>
            <b-form-valid-feedback :state="acceptableName">
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
        :disabled="!validateForm"
        @click="updateEmployee">update</b-button>
    </b-modal>
  </section>
</template>

<script>
import { validationMixin } from "vuelidate";
import { required, minLength, maxLength, helpers } from "vuelidate/lib/validators";
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'

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
  },
  methods: {
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
