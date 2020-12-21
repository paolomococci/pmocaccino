<template>
  <section>
      <!-- TODO -->
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
    // TODO
  },
  methods: {
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
