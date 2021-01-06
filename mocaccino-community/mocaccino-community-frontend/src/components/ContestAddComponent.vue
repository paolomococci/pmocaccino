<template>
  <section>
    <b-button 
      variant="outline-primary" 
      @click="showModalDetail">add contest</b-button>
    <b-button 
      variant="outline-secondary" 
      @click="updateView">update view</b-button>
    <b-modal ref="modal-add" hide-footer title="enter the details of a new contest">
      <div class="d-block text-center">
        <h3>fields</h3>
        <b-form  @submit.stop.prevent="onSubmitForm">
          <!-- name field -->
          <b-form-group id="input-name-group" label="name" label-for="input-name">
            <b-form-input 
              id="input-name" 
              name="input-name" 
              v-model="$v.form.contestName.$model" 
              :state="onValidateFormContestName('contestName')" 
              aria-describedby="input-name-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-name-feedback-invalid">
              must be 10 to 20 characters long, moreover the symbols and white space are prohibited
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-name-feedback-valid">
              all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- title field -->
          <b-form-group id="input-title-group" label="title" label-for="input-title">
            <b-form-input 
              id="input-title" 
              name="input-title" 
              v-model="$v.form.contestTitle.$model" 
              :state="onValidateFormContestTitle('contestTitle')" 
              aria-describedby="input-title-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-title-feedback-invalid">
              must be 8 to 30 characters long, moreover the symbols are prohibited
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-title-feedback-valid">
              all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- description field -->
          <b-form-group id="input-description-group" label="description" label-for="input-description">
            <b-form-input 
              id="input-description" 
              name="input-description" 
              v-model="$v.form.contestDescription.$model" 
              :state="onValidateFormContestDescription('contestDescription')" 
              aria-describedby="input-description-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-description-feedback-invalid">
              must be 20 to 50 characters long, moreover the symbols are prohibited
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-description-feedback-valid">
              all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- date field -->
          <b-form-group id="input-date-group" label="choose a date" label-for="contest-date-picker">
            <b-form-datepicker 
              id="contest-date-picker" 
              name="contest-date-picker" 
              min="minDate" 
              v-model="$v.form.contestDate.$model" 
              :state="onValidateFormContestDate('contestDate')" 
              aria-describedby="input-description-feedback-invalid"
              menu-class="w-100" 
              calendar-width="100%" 
              class="mb-2"
              locale="en-US" 
              v-b-popover.hover.top="'only today\'s or future date are accepted'"></b-form-datepicker>
            <b-form-invalid-feedback id="input-description-feedback-invalid">
              today or future date are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-description-feedback-valid">
              all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- buttons -->
          <b-button 
            class="mt-3" 
            variant="outline-secondary" 
            block 
            @click="hideModalDetail">cancel</b-button>
          <b-button 
            class="mt-3" 
            variant="outline-warning" 
            block 
            @click="onResetForm()">reset</b-button>
          <b-button 
            class="mt-3" 
            variant="outline-primary" 
            block 
            type="submit">save</b-button>
        </b-form>
      </div>
    </b-modal>
  </section>
</template>

<script>
import moment from 'moment'
import { validationMixin } from 'vuelidate'
import { required, minLength, maxLength, helpers } from 'vuelidate/lib/validators'
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'

const contestNameRegex = helpers.regex('contestNameRegex', /^[a-zA-Z0-9-_]*$/);
const contestTitleAndDescriptionRegex = helpers.regex('contestTitleAndDescriptionRegex', /^[a-zA-Z0-9-_\s]*$/);

export default {
  name: 'ContestAddComponent',
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
          this.addContest();
        }
      });
    },
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide();
    },
    addContest() {
      var data = {
        name: this.form.contestName,
        title: this.form.contestTitle,
        description: this.form.contestDescription,
        date: this.form.contestDate
      };
      ContestVerbsRestfulService.create(data)
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
