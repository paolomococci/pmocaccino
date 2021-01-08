<template>
    <section>
        <!-- TODO-->
    </section>
</template>

<script>
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'

export default {
    name: 'ContestSearchResultComponent',
  data: () => ({}),
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
