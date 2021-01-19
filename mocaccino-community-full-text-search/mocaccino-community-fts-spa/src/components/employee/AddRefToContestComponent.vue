<template>
  <section>
    <!-- todo -->
  </section>
</template>

<script>
import EmployeeRestService from '../../services/EmployeeRestService'
import ContestRestService from '../../services/ContestRestService'

export default {
  name: 'AddRefToContestComponent',
  props: {
    uri: String
  },
  data: () => ({
    contest: '',
    contests: []
  }),
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
      ContestRestService.readAll()
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
      EmployeeRestService.updateContestParticipation(data);
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
