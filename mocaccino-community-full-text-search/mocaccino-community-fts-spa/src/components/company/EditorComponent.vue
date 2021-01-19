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
  name: 'EditorComponent',
  mixins: [validationMixin],
  props: {
    uri: String,
    nameField: String
  },
  data: () => ({
    form: {
      companyName: ''
    }
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
          this.updateCompany();
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
      CompanyRestService.partialUpdate(this.uri, data)
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
    this.form.companyName = this.nameField;
  }
}
</script>
