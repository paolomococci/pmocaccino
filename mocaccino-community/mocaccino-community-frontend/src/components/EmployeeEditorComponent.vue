<template>
  <section>
    <b-button 
      variant="outline-primary" 
      @click="showModalDetail">edit</b-button>
    <b-modal ref="modal-edit" hide-footer :title="uri">
      <div class="d-block text-center">
        <h3>fields</h3>
        <!-- TODO -->
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
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'

export default {
  name: 'EmployeeEditorComponent',
  data: () => ({
    employeeUsername: '',
    employeeName: '',
    employeeSurname: '',
    employeeEmail: '',
    employeeProfession: ''
  }),
  props: {
    uri: String,
    usernameField: String,
    nameField: String,
    surnameField: String,
    emailField: String,
    professionField: String
  },
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
      return this.employeeEmail.length > 7 && this.employeeEmail.length < 41;
    },
    isAcceptableProfession() {
      return this.employeeProfession.length > 4 && this.employeeProfession.length < 31;
    },
    showModalDetail() {
      this.$refs['modal-edit'].show();
    },
    hideModalDetail() {
      this.$refs['modal-edit'].hide();
    },
    updateEmployee() {
      var data = {
        name: this.employeeName,
        surname: this.employeeSurname,
        email: this.employeeEmail,
        profession: this.employeeProfession,
        username: this.employeeUsername
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
