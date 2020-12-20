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
          <!-- profession field -->
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
    validateForm() {
      return this.acceptableUsername && this.acceptableName && this.acceptableSurname;
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
