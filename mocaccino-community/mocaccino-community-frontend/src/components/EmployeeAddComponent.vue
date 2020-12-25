<template>
  <section>
    <b-button 
      variant="outline-primary" 
      @click="showModalDetail">add employee</b-button>
    <b-button 
      variant="outline-secondary" 
      @click="updateView">update view</b-button>
    <b-modal ref="modal-add" hide-footer title="enter the details of a new employee">
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
              email of new employee must be 8 to 60 characters long
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
        @click="addEmployee">save</b-button>
    </b-modal>
  </section>
</template>

<script>
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'

export default {
  name: 'EmployeeAddComponent',
  data: () => ({
    employeeUsername: '',
    employeeName: '',
    employeeSurname: '',
    employeeEmail: '',
    employeeProfession: ''
  }),
  computed: {
    acceptableUsername() {
      return this.isAcceptableUsername();
    },
    acceptableName() {
      return this.isAcceptableName();
    },
    acceptableSurname() {
      return this.isAcceptableSurname();
    },
    acceptableEmail() {
      return this.isAcceptableEmail();
    },
    acceptableProfession() {
      return this.isAcceptableProfession();
    },
    validateForm() {
      return this.acceptableUsername && 
        this.acceptableName && 
        this.acceptableSurname && 
        this.acceptableEmail && 
        this.acceptableProfession;
    }
  },
  methods: {
    isAcceptableUsername() {
      return this.employeeUsername.length > 5 && this.employeeUsername.length < 21;
    },
    isAcceptableName() {
      return this.employeeName.length > 2 && this.employeeName.length < 15;
    },
    isAcceptableSurname() {
      return this.employeeSurname.length > 2 && this.employeeSurname.length < 21;
    },
    isAcceptableEmail() {
      return this.employeeEmail.length > 7 && this.employeeEmail.length < 61;
    },
    isAcceptableProfession() {
      return this.employeeProfession.length > 4 && this.employeeProfession.length < 31;
    },
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide();
    },
    addEmployee() {
      var data = {
        username: this.employeeUsername,
        name: this.employeeName,
        surname: this.employeeSurname,
        email: this.employeeEmail,
        profession: this.employeeProfession
      };
      EmployeeVerbsRestfulService.create(data)
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
