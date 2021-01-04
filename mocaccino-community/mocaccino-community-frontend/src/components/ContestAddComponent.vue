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
          <label for="feedback-description">description</label>
          <b-form-input 
            placeholder="must be 20 to 50 characters long"
            required
            v-model="contestDescription" 
            :state="acceptableDescription" 
            id="feedback-description"></b-form-input>
          <!-- date field -->
          <label for="contest-date-picker">choose a date</label>
          <b-form-datepicker 
            id="contest-date-picker" 
            v-model="contestDate" 
            menu-class="w-100" 
            calendar-width="100%" 
            class="mb-2"
            locale="en-US"></b-form-datepicker>
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
import { validationMixin } from 'vuelidate'
import { required, minLength, maxLength, helpers } from 'vuelidate/lib/validators'
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'

const templateCharactersAcceptedAsValid = helpers.regex('templateCharactersAcceptedAsValid', /^[a-z]*$/);

export default {
  name: 'ContestAddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      contestName: '',
      contestTitle: '',
      contestDescription: '',
      contestDate: ''
    }
  }),
  validations: {
    form: {
      contestName: {
        required,
        minLength: minLength(10),
        maxLength: maxLength(20)
        },
      contestTitle: {
        required,
        minLength: minLength(8),
        maxLength: maxLength(30)
        },
      contestDescription: {
        required,
        minLength: minLength(20),
        maxLength: maxLength(50)
      },
      contestDate: {
        required
      }
    }
  },
  methods: {
    onValidateFormContestName(contestName) {
      // TODO
    },
    onValidateFormContestTitle(contestTitle) {
      // TODO
    },
    onValidateFormContestDescription(contestDescription) {
      // TODO
    },
    onValidateFormContestDate(contestDate) {
      // TODO
    },
    onResetForm() {
      // TODO
    },
    onSubmitForm() {
      // TODO
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
          // TODO
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
