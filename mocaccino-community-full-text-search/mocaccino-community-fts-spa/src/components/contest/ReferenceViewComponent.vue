<template>
  <section>
    <!-- todo -->
  </section>
</template>

<script>
import ContestRestService from '../../services/ContestRestService'

export default {
  name: 'ReferenceViewComponent',
  props: {
    uri: String
  },
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
    participants: []
  }),
  methods: {
    isAcceptable() {
      return false;
    },
    showModalDetail() {
      this.$refs['view-reference-participants'].show();
    },
    hideModalDetail() {
      this.$refs['view-reference-participants'].hide();
    },
    retrieveListOfParticipants() {
      ContestRestService.readListOfEmployee(this.uri)
        .then(response => {
          this.participants = response.data._embedded.employees;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.retrieveListOfParticipants();
  }
}
</script>
