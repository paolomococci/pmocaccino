<template>
    <section>
        <!-- TODO-->
    </section>
</template>

<script>
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'

export default {
    name: 'ContestSearchResultComponent',
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
    messageBoxToConfirmDeletion: '',
    textToSearchFor: ''
  }),
  methods: {
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
  computed: {},
  mounted() {}
}
</script>
