<template>
  <section>
    <!-- TODO -->
  </section>
</template>

<script>
import axios from 'axios'

export default {
  name: 'ContestComponent',
  data: () => ({
    url: 'http://localhost:8090/rest/contests',
    contests: [],
    contest: {name: '', title: '', description: '', date:  null, _links: {self: {href: ''}}},
    index: 0,
    title: ''
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
      axios.get(`http://localhost:8090/rest/articles/search/likeByTitle?title=${this.title}`)
        .then(response => {
          this.contests = response.data._embedded.contests;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    // TODO
  }
}
</script>
