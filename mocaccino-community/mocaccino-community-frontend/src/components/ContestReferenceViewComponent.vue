<template>
    <section>
      <b-button 
        variant="outline-secondary" 
        size="sm" 
        @click="showModalDetail">view participants</b-button>
      <b-modal size="xl" scrollable ref="view-reference-participants" hide-footer :title="uri">
        <div class="d-block text-center">
          <h3>participants</h3>
          <b-table 
            :items="participants" 
            :fields="fields" 
            striped 
            responsive="sm"></b-table>
        </div>
        <b-button 
          class="mt-3" 
          variant="outline-secondary" 
          block 
          @click="hideModalDetail">toggle</b-button>
      </b-modal>
    </section>
</template>

<script>
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'

export default {
    name: 'ContestReferenceViewComponent',
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
  props: {
    uri: String
  },
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
      ContestVerbsRestfulService.readListOfEmployee(this.uri)
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
