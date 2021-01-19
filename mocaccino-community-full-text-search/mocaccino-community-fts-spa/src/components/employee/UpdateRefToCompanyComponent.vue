<template>
  <section>
    <!-- todo -->
  </section>
</template>

<script>
import EmployeeRestService from '../../services/EmployeeRestService'
import CompanyRestService from '../../services/CompanyRestService'

export default {
  name: 'UpdateRefToCompanyComponent',
  props: {
    uri: String
  },
  data: () => ({
    company: '',
    companies: []
  }),
  computed: {
    isRefSelected() {
      return (this.company != '') ? false : true;
    }
  },
  methods: {
    showModalDetail() {
      this.$refs['modal-edit-reference'].show();
    },
    hideModalDetail() {
      this.$refs['modal-edit-reference'].hide();
    },
    retrieveCompanies() {
      CompanyRestService.readAll()
        .then(response => {
          this.companies = response.data._embedded.companies;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    settingUpCompanyMembership() {
      this.hideModalDetail();
      var data = {
        company: this.company
      };
      EmployeeRestService.updateReferenceToCompany(this.uri, data);
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
          this.settingUpCompanyMembership();
        }
      });
    }
  },
  mounted() {
    this.retrieveCompanies();
  }
}
</script>
