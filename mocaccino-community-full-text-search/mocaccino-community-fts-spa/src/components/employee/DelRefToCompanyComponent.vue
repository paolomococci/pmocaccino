<template>
  <section>
    <!-- todo -->
  </section>
</template>

<script>
import EmployeeRestService from '../../services/EmployeeRestService'

export default {
  name: 'DelRefToCompanyComponent',
  props: {
    uri: String
  },
  data: () => ({
    company: ''
  }),
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
    retrieveCompany() {
      EmployeeRestService.readCompanyMembership(this.uri)
        .then(response => {
          this.company = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    ruleOutCompanyMembership() {
      this.hideModalDetail();
      EmployeeRestService.deleteCompanyMembership(this.uri);
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
          this.ruleOutCompanyMembership();
        }
      });
    }
  },
  mounted() {
    this.retrieveCompany();
  }
}
</script>
