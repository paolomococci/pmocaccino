<template>
    <section>
      <b-dropdown-item 
        variant="outline-warning" 
        @click="showModalDetail">add reference to contest</b-dropdown-item>
      <b-modal ref="modal-edit-reference" hide-footer :title="uri">
        <div class="d-block text-center">
          <h3>references</h3>
          <b-form  @submit.stop.prevent>
          <!-- contest reference -->
          <b-form-group>
            <label>contest name</label>
            <!-- TODO -->
          </b-form-group>
          </b-form>
        </div>
        <b-button 
          class="mt-3" 
          variant="outline-secondary" 
          block 
          @click="hideModalDetail">toggle</b-button>
        <b-button 
          class="mt-3" 
          variant="outline-primary" 
          block 
          @click="settingUpContestParticipation">update</b-button>
      </b-modal>
    </section>
</template>

<script>
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'

export default {
    name: 'EmployeeAddRefToContestComponent',
  data: () => ({
    contests: []
  }),
  props: {
    uri: String
  },
  methods: {
    isAcceptable() {
      return false;
    },
    showModalDetail() {
      this.$refs['modal-edit-reference'].show();
    },
    hideModalDetail() {
      this.$refs['modal-edit-reference'].hide();
    },
    retrieveContests() {
      ContestVerbsRestfulService.readAll()
        .then(response => {
          this.contests = response.data._embedded.contests;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    settingUpContestParticipation() {
      // TODO
      this.hideModalDetail();
    }
  },
  mounted() {
    this.retrieveContests();
  }
}
</script>
