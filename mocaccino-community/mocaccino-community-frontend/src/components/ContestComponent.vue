<template>
  <section>
    <aside>
      <add-contest/>
    </aside>
    <!-- sub-section to show the contest list -->
    <section>
      <b-table 
        :items="contests" 
        :fields="fields" 
        striped 
        responsive="sm">
        <template #cell(showDetails)="row">
          <b-form-checkbox v-model="row.detailsShowing" @change="row.toggleDetails">
            details
          </b-form-checkbox>
        </template>
        <template #row-details="row">
          <b-card>
            <b-row class="mb-2">
              <b-col sm="3" class="text-sm-right"><b>title:</b></b-col>
              <b-col><output v-text="row.item.title"></output></b-col>
            </b-row>
            <b-row class="mb-2">
              <b-col sm="3" class="text-sm-right"><b>description:</b></b-col>
              <b-col><output v-text="row.item.description"></output></b-col>
            </b-row>
            <b-row class="mb-2">
              <b-col sm="3" class="text-sm-right"><b>URI:</b></b-col>
              <b-col><output v-text="row.item._links.self.href"></output></b-col>
            </b-row>
            <b-button size="sm" @click="row.toggleDetails">toggle details</b-button>
          </b-card>
        </template>
      </b-table>
    </section>
  </section>
</template>

<script>
import axios from 'axios'
import ContestAddComponent from '@/components/ContestAddComponent.vue'

export default {
  name: 'ContestComponent',
  components: {
    'add-contest': ContestAddComponent
  },
  data: () => ({
    url: 'http://localhost:8090/rest/contests',
    fields: [
      {
        key: 'date',
        label: 'dates',
        sortable: true
      },
      {
        key: 'name',
        label: 'names'
      },
      {
        key: 'showDetails',
        label: 'details'
      }
    ],
    contests: [],
    textToSearchFor: ''
  }),
  methods: {
    retrieveContests() {
      axios.get(this.url)
        .then(response => {
          this.contests = response.data._embedded.contests;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    searchByTitle() {
      axios.get(`http://localhost:8090/rest/articles/search/likeByTitle?title=${this.textToSearchFor}`)
        .then(response => {
          this.contests = response.data._embedded.contests;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  computed: {
    textToSearch() {
      return this.$store.state.textToSearch;
    }
  },
  mounted() {
    this.retrieveContests();
  }
}
</script>
