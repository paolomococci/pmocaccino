<template>
  <section>
    <aside>
      <add-contest @updateView="updateView"/>
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
            <b-row>
              <edit-contest 
                :nameField="row.item.name" 
                :titleField="row.item.title" 
                :descriptionField="row.item.description" 
                :dateField="row.item.date"
                :uri="row.item._links.self.href" 
                @updateView="updateView"/>
              <view-reference-participants 
                :uri="row.item._links.self.href"/>
              <b-button 
                variant="outline-danger" 
                size="sm" 
                @click="deleteItem(row.item._links.self.href)">delete</b-button>
              <b-button 
                variant="outline-secondary" 
                size="sm" 
                @click="row.toggleDetails">toggle details</b-button>
            </b-row>
          </b-card>
        </template>
      </b-table>
    </section>
  </section>
</template>

<script>
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'
import ContestAddComponent from '@/components/ContestAddComponent.vue'
import ContestEditorComponent from '@/components/ContestEditorComponent.vue'
import ContestReferenceViewComponent from '@/components/ContestReferenceViewComponent.vue'

export default {
  name: 'ContestComponent',
  components: {
    'add-contest': ContestAddComponent,
    'edit-contest': ContestEditorComponent,
    'view-reference-participants': ContestReferenceViewComponent
  },
  data: () => ({
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
      ContestVerbsRestfulService.readAll()
        .then(response => {
          this.contests = response.data._embedded.contests;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    async updateView() {
      this.$bvToast.toast('data of contests being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 6000
      });
      await setTimeout(6000);
      this.contests = null;
      this.retrieveContests();
    },
    deleteItem(uri) {
      ContestVerbsRestfulService.delete(uri)
        .catch(e => {
          console.log(e);
        });
      this.updateView();
    },
    searchByTitle() {
      ContestVerbsRestfulService.searchByTitle(this.textToSearchFor)
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

<style>
  button {
    margin: 3px;
  }
</style>
