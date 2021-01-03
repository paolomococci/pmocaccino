<template>
  <section>
    <b-button 
      variant="outline-primary" 
      @click="showModalDetail">edit</b-button>
    <b-modal ref="modal-edit" hide-footer :title="uri">
      <div class="d-block text-center">
        <h3>fields</h3>
        <b-form  @submit.stop.prevent>
          <!-- name field -->
          <label for="feedback-name">name</label>
          <b-form-input 
            placeholder="must be 10 to 20 characters long"
            required
            v-model="contestName" 
            :state="acceptableName" 
            id="feedback-name"></b-form-input>
          <!-- title field -->
          <label for="feedback-title">title</label>
          <b-form-input 
            placeholder="must be 8 to 30 characters long"
            required
            v-model="contestTitle" 
            :state="acceptableTitle" 
            id="feedback-title"></b-form-input>
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
        type="submit">update</b-button>
    </b-modal>
  </section>
</template>

<script>
import { validationMixin } from "vuelidate";
import { required, minLength, maxLength, helpers } from "vuelidate/lib/validators";
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'

export default {
  name: 'ContestEditorComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      contestName: '',
      contestTitle: '',
      contestDescription: '',
      contestDate: ''
    }
  }),
  props: {
    uri: String,
    nameField: String,
    titleField: String,
    descriptionField: String,
    dateField: String
  },
  validations: {
  },
  methods: {
    onValidateForm(companyName) {
      // TODO
    },
    onResetForm() {
      // TODO
    },
    onSubmitForm() {
      // TODO
    },
    onConfirm() {
      // TODO
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
      ContestVerbsRestfulService.partialUpdate(this.uri, data)
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
    this.contestName = this.nameField;
    this.contestTitle = this.titleField;
    this.contestDescription = this.descriptionField;
    this.contestDate = this.dateField;
  }
}
</script>
