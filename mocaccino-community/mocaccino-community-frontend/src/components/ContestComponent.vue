<template>
  <section>
    <b-table 
      striped hover 
      :items="contests" 
      :fields="fields">
      <template>
        <template>
          <span aria-hidden="true">&#10007;</span>
        </template>
        <template>
          <span aria-hidden="true">&#160;</span>
        </template>
      </template>
    </b-table>
    <aside>
      <detail/>
    </aside>
  </section>
</template>

<script>
import axios from 'axios'
import ContestDetailComponent from '@/components/ContestDetailComponent.vue'

export default {
  name: 'ContestComponent',
  components: {
    detail: ContestDetailComponent
  },
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
