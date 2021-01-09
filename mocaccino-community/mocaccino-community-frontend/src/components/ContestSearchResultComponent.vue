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
    },
    async updateView() {
      this.$bvToast.toast('data of contests being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 2000
      });
      await setTimeout(() => {
          this.contests = null;
          this.searchByTitle();
        }, 2000);
    }
  },
  computed: {},
  mounted() {}
}
</script>
