<template>
  <section>
    <!-- todo -->
  </section>
</template>

<script>
import EmployeeRestService from '../../services/EmployeeRestService'

export default {
  name: 'DelRefToContestComponent',
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
      EmployeeRestService.readContestParticipation(this.uri)
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
      var data = {
        employeeUri: this.uri,
        contestUri: this.contest
      };
      EmployeeRestService.deleteContestParticipation(data);
    },
    deleteConfirm() {
      this.messageBoxToConfirmDeletion = '';
      this.$bvModal.msgBoxConfirm('are you sure you want to remove this reference', {
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
