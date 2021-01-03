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
        :disabled="!validateForm"
        @click="addContest">save</b-button>
    </b-modal>
  </section>
</template>

<script>
import { validationMixin } from "vuelidate";
import { required, minLength, maxLength, helpers } from "vuelidate/lib/validators";
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'

export default {
  name: 'ContestAddComponent',
  data: () => ({
    contestName: '',
    contestTitle: '',
    contestDescription: '',
    contestDate: ''
  }),
  validations: {
    // TODO
  },
  methods: {
    isAcceptableName() {
      return this.contestName.length > 9 && this.contestName.length < 21;
    },
    isAcceptableTitle() {
      return this.contestTitle.length > 7 && this.contestTitle.length < 31;
    },
    isAcceptableDescription() {
      return this.contestDescription.length > 19 && this.contestDescription.length < 51;
    },
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide();
    },
    addContest() {
      var data = {
        name: this.contestName,
        title: this.contestTitle,
        description: this.contestDescription,
        date: this.contestDate
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
