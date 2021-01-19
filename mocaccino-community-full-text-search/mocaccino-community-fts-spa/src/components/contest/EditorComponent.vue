<template>
  <section>
    <!-- todo -->
  </section>
</template>

<script>
import moment from 'moment'
import { validationMixin } from 'vuelidate'
import {
  required,
  minLength,
  maxLength,
  helpers
} from 'vuelidate/lib/validators'
import ContestRestService from '../services/ContestRestService'

const contestNameRegex = helpers.regex('contestNameRegex', /^[a-zA-Z0-9-_]*$/);
const contestTitleAndDescriptionRegex = helpers.regex('contestTitleAndDescriptionRegex', /^[a-zA-Z0-9-_\s]*$/);

export default {
  name: 'EditorComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      contestName: '',
      contestTitle: '',
      contestDescription: '',
      contestDate: ''
    },
    minDate: moment()
  }),
  props: {
    uri: String,
    nameField: String,
    titleField: String,
    descriptionField: String,
    dateField: String
  },
  validations: {
    form: {
      contestName: {
        required,
        minLength: minLength(10),
        maxLength: maxLength(20),
        contestNameRegex
        },
      contestTitle: {
        required,
        minLength: minLength(8),
        maxLength: maxLength(30),
        contestTitleAndDescriptionRegex
        },
      contestDescription: {
        required,
        minLength: minLength(20),
        maxLength: maxLength(50),
        contestTitleAndDescriptionRegex
      },
      contestDate: {
        required
      }
    }
  },
  methods: {
    onValidateFormContestName(contestName) {
      const { $dirty, $error } = this.$v.form[contestName];
      return $dirty ? !$error : null;
    },
    onValidateFormContestTitle(contestTitle) {
      const { $dirty, $error } = this.$v.form[contestTitle];
      return $dirty ? !$error : null;
    },
    onValidateFormContestDescription(contestDescription) {
      const { $dirty, $error } = this.$v.form[contestDescription];
      return $dirty ? !$error : null;
    },
    onValidateFormContestDate(contestDate) {
      const { $dirty, $error } = this.$v.form[contestDate];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        contestName: '',
        contestTitle: '',
        contestDescription: ''
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
          this.updateContest();
        }
      });
    },
    showModalDetail() {
      this.$refs['modal-edit'].show();
    },
    hideModalDetail() {
      this.$refs['modal-edit'].hide();
    },
    updateContest() {
      var data = {
        name: this.form.contestName,
        title: this.form.contestTitle,
        description: this.form.contestDescription,
        date: this.form.contestDate
      };
      ContestRestService.partialUpdate(this.uri, data)
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
    this.form.contestName = this.nameField;
    this.form.contestTitle = this.titleField;
    this.form.contestDescription = this.descriptionField;
    this.form.contestDate = this.dateField;
  }
}
</script>
