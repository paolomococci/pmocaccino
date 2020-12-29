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
        :disabled="!validateForm"
        @click="updateContest">update</b-button>
    </b-modal>
  </section>
</template>

<script>
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'

export default {
  name: 'ContestEditorComponent',
  data: () => ({
    contestName: '',
    contestTitle: '',
    contestDescription: '',
    contestDate: ''
  }),
  props: {
    uri: String,
    nameField: String,
    titleField: String,
    descriptionField: String,
    dateField: String
  },
  computed: {
    acceptableName() {
      return this.isAcceptableName();
    },
    acceptableTitle() {
      return this.isAcceptableTitle();
    },
    acceptableDescription() {
      return this.isAcceptableDescription();
    },
    validateForm() {
      return this.acceptableName && 
        this.acceptableTitle && 
        this.acceptableDescription;
    }
  },
  methods: {
    isAcceptableName() {
      if (this.contestName == null) this.contestName = '';
      return this.contestName.length > 9 && this.contestName.length < 21;
    },
    isAcceptableTitle() {
      if (this.contestTitle == null) this.contestTitle = '';
      return this.contestTitle.length > 7 && this.contestTitle.length < 31;
    },
    isAcceptableDescription() {
      if (this.contestDescription == null) this.contestDescription = '';
      return this.contestDescription.length > 19 && this.contestDescription.length < 51;
    },
    showModalDetail() {
      this.$refs['modal-edit'].show();
    },
    hideModalDetail() {
      this.$refs['modal-edit'].hide();
    },
    updateContest() {
      var data = {
        name: this.contestName,
        title: this.contestTitle,
        description: this.contestDescription,
        date: this.contestDate
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
