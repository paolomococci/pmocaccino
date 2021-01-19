<template>
  <section>
    <!-- todo -->
  </section>
</template>

<script>
import EmployeeRestService from '../../services/EmployeeRestService'
import { validationMixin } from 'vuelidate'
import {
  required,
  minLength,
  maxLength,
  alpha,
  alphaNum,
  email,
  helpers
 } from 'vuelidate/lib/validators'

const employeeProfessionRegex = helpers.regex('employeeProfessionRegex', /^[a-zA-Z-]*$/);

export default {
  name: 'AddComponent',
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
  validations: {
    form: {
      employeeUsername: {
        required,
        minLength: minLength(6),
        maxLength: maxLength(20),
        alphaNum
      },
      employeeName: {
        required,
        minLength: minLength(3),
        maxLength: maxLength(14),
        alpha
      },
      employeeSurname: {
        required,
        minLength: minLength(3),
        maxLength: maxLength(20),
        alpha
      },
      employeeEmail: {
        required,
        minLength: minLength(8),
        maxLength: maxLength(60),
        email
      },
      employeeProfession: {
        required,
        minLength: minLength(5),
        maxLength: maxLength(30),
        employeeProfessionRegex
      }
    }
  },
  methods: {
    onValidateFormEmployeeUsername(employeeUsername) {
      const { $dirty, $error } = this.$v.form[employeeUsername];
      return $dirty ? !$error : null;
    },
    onValidateFormEmployeeName(employeeName) {
      const { $dirty, $error } = this.$v.form[employeeName];
      return $dirty ? !$error : null;
    },
    onValidateFormEmployeeSurname(employeeSurname) {
      const { $dirty, $error } = this.$v.form[employeeSurname];
      return $dirty ? !$error : null;
    },
    onValidateFormEmployeeEmail(employeeEmail) {
      const { $dirty, $error } = this.$v.form[employeeEmail];
      return $dirty ? !$error : null;
    },
    onValidateFormEmployeeProfession(employeeProfession) {
      const { $dirty, $error } = this.$v.form[employeeProfession];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        employeeUsername: '',
        employeeName: '',
        employeeSurname: '',
        employeeEmail: '',
        employeeProfession: ''
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
          this.addEmployee();
        }
      });
    },
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide();
    },
    addEmployee() {
      var data = {
        username: this.form.employeeUsername,
        name: this.form.employeeName,
        surname: this.form.employeeSurname,
        email: this.form.employeeEmail,
        profession: this.form.employeeProfession
      };
      EmployeeRestService.create(data)
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
