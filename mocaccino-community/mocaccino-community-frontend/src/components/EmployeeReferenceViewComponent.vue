<template>
    <section>
      <b-button 
        variant="outline-secondary" 
        @click="showModalDetail">references</b-button>
      <b-modal 
        size="xl"
        ref="modal-view-reference" 
        hide-footer 
        :title="uri">
        <div class="d-block text-center">
          <h3>references</h3>
          <b-form  @submit.stop.prevent>
          <!-- company name -->
          <b-form-group>
            <label for="reference-company-name">company name</label>
            <b-form-input 
              v-model="company.name" 
              id="reference-company-name"
              readonly></b-form-input>
          </b-form-group>
          <!-- company URI -->
          <b-form-group>
            <label for="reference-company-uri">company URI</label>
            <b-form-input 
              v-model="company._links.self.href" 
              id="reference-company-uri"
              readonly></b-form-input>
          </b-form-group>
          </b-form>
          <h3>contests</h3>
          <b-table 
            :items="contests" 
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
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'

export default {
    name: 'EmployeeReferenceViewComponent',
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
  props: {
    uri: String
  },
  methods: {
    showModalDetail() {
      this.$refs['modal-view-reference'].show();
    },
    hideModalDetail() {
      this.$refs['modal-view-reference'].hide();
    },
    retrieveCompany() {
      EmployeeVerbsRestfulService.readCompanyMembership(this.uri)
        .then(response => {
          this.company = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    retrieveContests() {
      EmployeeVerbsRestfulService.readContestParticipation(this.uri)
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
