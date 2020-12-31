<template>
    <section>
      <b-dropdown-item 
        @click="showModalDetail">delete reference to contest</b-dropdown-item>
      <b-modal 
        size="xl" 
        ref="modal-edit-reference" 
        hide-footer 
        :title="uri">
        <div class="d-block text-center">
          <h3>select a contest to be dereferenced</h3>
          <b-form  @submit.stop.prevent>
          <!-- contest reference to remove -->
          <b-form-group>
            <label for="reference-contest">contest</label>
            <b-form-select 
              v-model="contest" 
              :options="contests" 
              value-field="_links.self.href" 
              text-field="name"
              class="mb-3" 
              id="reference-contest"></b-form-select>
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
          @click="deleteConfirm">delete</b-button>
      </b-modal>
    </section>
</template>

<script>
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'

export default {
    name: 'EmployeeDelRefToContestComponent',
  data: () => ({
    contest: '',
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
      EmployeeVerbsRestfulService.readContestParticipation(this.uri)
        .then(response => {
          this.contests = response.data._embedded.contests;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    ruleOutContestParticipation() {
      this.hideModalDetail();
      // TODO
    },
    deleteConfirm() {
      this.messageBoxToConfirmDeletion = '';
      this.$bvModal.msgBoxConfirm('are you sure you want to delete this reference', {
        title: 'please confirm',
        size: 'md',
        buttonSize: 'md',
        okVariant: 'danger',
        okTitle: 'yes',
        cancelTitle: 'no',
        footerClass: 'p-2',
        hideHeaderClose: false,
        centered: true
      }).then(value => {
        if(value) {
          this.ruleOutContestParticipation();
        }
      });
    }
  },
  mounted() {
    this.retrieveContests();
  }
}
</script>
