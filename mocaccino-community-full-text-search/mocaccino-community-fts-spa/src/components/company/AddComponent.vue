<template>
  <section>
    <!-- todo -->
  </section>
</template>

<script>
import CompanyRestService from '../../services/CompanyRestService'
import { validationMixin } from 'vuelidate'
import {
  required,
  minLength,
  maxLength,
  helpers
} from 'vuelidate/lib/validators'

const charactersAcceptedAsValid = helpers
  .regex('charactersAcceptedAsValid', /^[a-zA-Z0-9-_]*$/);

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      companyName: ''
    },
    companyName: ''
  }),
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
          this.addCompany();
        }
      });
    },
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide();
    },
    addCompany() {
      var data = {
        name: this.form.companyName
      };
      CompanyRestService.create(data)
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
