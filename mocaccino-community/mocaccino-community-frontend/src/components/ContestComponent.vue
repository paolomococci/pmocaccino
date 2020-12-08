<template>
  <section>
    <b-table striped hover :items="contests" :fields="fields"></b-table>
    <footer>
      <b-card-group deck>
      <b-card header="element that displays the text to search for" title="text to search for:">
        <b-card-text><mark v-text="textToSearch"></mark></b-card-text>
      </b-card>
    </b-card-group>
    </footer>
  </section>
</template>

<script>
import axios from 'axios'

export default {
  name: 'ContestComponent',
  data: () => ({
    url: 'http://localhost:8090/rest/contests',
    fields: [
      {
        key: 'name',
        label: 'names'
      },
      {
        key: 'title',
        label: 'titles'
      },
      {
        key: 'description',
        label: 'descriptions'
      },
      {
        key: 'date',
        label: 'dates',
        sortable: true
      },
      {
        key: '_links.self.href',
        label: 'URIs'
      }
    ],
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
