<template>
  <section>
    <!-- todo -->
  </section>
</template>

<script>
import EmployeeRestService from '../../services/EmployeeRestService'

export default {
  name: 'ReferenceViewComponent',
  props: {
    uri: String
  },
  data: () => ({
    company: {"name":"","_links":{"self":{"href":""},"company":{"href":""},"employees":{"href":""}}},
    contests: [],
    fields: [
      {
        key: 'date',
        sortable: true
      },
      {
        key: 'name'
      },
      {
        key: 'title'
      },
      {
        key: 'description'
      },
      {
        key: '_links.self.href',
        label: 'URI'
      }
    ]
  }),
  methods: {
    showModalDetail() {
      this.$refs['modal-view-reference'].show();
    },
    hideModalDetail() {
      this.$refs['modal-view-reference'].hide();
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
  },
  mounted() {
    this.retrieveCompany();
    this.retrieveContests();
  }
}
</script>
