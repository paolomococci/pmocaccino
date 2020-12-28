<template>
    <section>
      <b-button 
        variant="outline-secondary" 
        size="sm" 
        @click="showModalDetail">view staff</b-button>
      <b-modal size="xl" scrollable ref="modal-view-reference" hide-footer :title="uri">
        <div class="d-block text-center">
          <h3>staff</h3>
          <b-table 
            :items="staff" 
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
import CompanyVerbsRestfulService from '../services/CompanyVerbsRestfulService'

export default {
    name: 'CompanyReferenceViewComponent',
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
      CompanyVerbsRestfulService.readListOfEmployee(this.uri)
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
