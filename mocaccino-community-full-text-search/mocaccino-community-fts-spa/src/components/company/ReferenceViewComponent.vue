<template>
  <section>
    <!-- todo -->
  </section>
</template>

<script>
import CompanyRestService from '../services/CompanyRestService'

export default {
  name: 'ReferenceViewComponent',
  data: () => ({
    fields: [
      {
        key: 'username',
        sortable: true
      },
      {
        key: 'name'
      },
      {
        key: 'surname'
      },
      {
        key: 'profession'
      },
      {
        key: 'email'
      }
    ],
    staff: []
  }),
  props: {
    uri: String
  },
  methods: {
    isAcceptable() {
      return false;
    },
    showModalDetail() {
      this.$refs['modal-view-reference'].show();
    },
    hideModalDetail() {
      this.$refs['modal-view-reference'].hide();
    },
    retrieveStaffData() {
      CompanyRestService.readListOfEmployee(this.uri)
        .then(response => {
          this.staff = response.data._embedded.employees;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.retrieveStaffData();
  }
}
</script>
