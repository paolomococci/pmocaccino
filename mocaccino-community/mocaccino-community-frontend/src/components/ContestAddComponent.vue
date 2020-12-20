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
          <label for="feedback-name">name</label>
          <b-form-input 
            v-model="contestName" 
            :state="acceptable" 
            id="feedback-name"></b-form-input>
          <b-form-invalid-feedback :state="acceptable">
            name of new contest must be 8 to 30 characters long
          </b-form-invalid-feedback>
          <b-form-valid-feedback :state="acceptable">
            all right
          </b-form-valid-feedback>
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
        :disabled="!isAcceptable()"
        @click="addContest">save</b-button>
    </b-modal>
  </section>
</template>

<script>
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'

export default {
  name: 'ContestAddComponent',
  data: () => ({
    contestName: ''
  }),
  computed: {
    acceptable() {
      return this.isAcceptable();
    }
  },
  methods: {
    isAcceptable() {
      return this.contestName.length > 7 && this.contestName.length < 31;
    },
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide();
    },
    addContest() {
      var data = {
        name: this.contestName
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
