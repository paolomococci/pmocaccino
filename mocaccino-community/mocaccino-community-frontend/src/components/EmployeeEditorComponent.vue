<template>
  <section>
      <!-- TODO -->
  </section>
</template>

<script>
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
    // TODO
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
