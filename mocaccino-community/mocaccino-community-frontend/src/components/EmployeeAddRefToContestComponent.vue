<template>
    <section>
      <b-dropdown-item 
        @click="showModalDetail">add reference to contest</b-dropdown-item>
      <b-modal 
        size="xl" 
        ref="modal-edit-reference" 
        hide-footer 
        :title="uri">
        <div class="d-block text-center">
          <h3>select a contest to refer to</h3>
          <b-form  @submit.stop.prevent>
          <!-- contest reference to add -->
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
          :disabled="isRefSelected"
          @click="addConfirm">update</b-button>
      </b-modal>
    </section>
</template>

<script>
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'

export default {
    name: 'EmployeeAddRefToContestComponent',
  data: () => ({
    contest: '',
    contests: []
  }),
  props: {
    uri: String
  },
  computed: {
    isRefSelected() {
      return (this.contest != '') ? false : true;
    }
  },
  methods: {
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
      this.hideModalDetail();
      var data = {
        employeeUri: this.uri,
        contestUri: this.contest
      };
      EmployeeVerbsRestfulService.updateContestParticipation(data);
    },
    addConfirm() {
      this.messageBoxToConfirmDeletion = '';
      this.$bvModal.msgBoxConfirm('are you sure you want to add this reference', {
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
          this.settingUpContestParticipation();
        }
      });
    }
  },
  mounted() {
    this.retrieveContests();
  }
}
</script>
