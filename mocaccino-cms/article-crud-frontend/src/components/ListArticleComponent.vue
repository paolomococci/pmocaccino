<template>
  <section>
    <aside>
      <input type="text" placeholder="search by title" v-model="title"/> &#173;
      <button type="button" @click="searchByTitle">search</button>
    </aside>
    <section>
      <h4>articles list:</h4>
        <p :class="{ active: index == currentIndex }"
          v-for="(article, index) in articles"
          :key="index"
          @click="setActiveArticle(article, index)">
          {{article.title}}
        </p>
    </section>
    <section>
      <footer v-if="currentArticle">
        <h4>details to edit:</h4>
          <p>
            title &#8658; {{currentArticle.title}}
          </p>
          <p>
            description &#8658; {{currentArticle.description}}
          </p>
          <p>
            published &#8658; {{currentArticle.published ? "yes" : "no"}}
          </p>
        <!-- TODO -->
        <!--router-link :to="'/articles/' + currentArticle.id">edit</router-link-->
      </footer>
      <footer v-else>
        <p>please, click for edit an article</p>
      </footer>
    </section>
  </section>
</template>

<style scoped lang="scss">
  h4 {
    font-size: 18px;
    font-weight: lighter;
  }
</style>

<script>
import axios from 'axios'

export default {
  name: 'ListArticleComponent',
  data: () => ({
    url: 'http://localhost:8090/rest/articles',
    articles: [],
    currentArticle: {id: 0, title: '', description: '', published: false},
    currentIndex: -1,
    title: ''
  }),
  methods: {
    retrieveArticleList() {
      axios.get(this.url)
        .then(response => {
          this.articles = response.data._embedded.articles;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    setActiveArticle(article, index) {
      this.currentArticle = article;
      this.currentIndex = index;
    },
    searchByTitle() {
      axios.get(`http://localhost:8090/rest/articles/search/likeByTitle?title=${this.title}`)
        .then(response => {
          this.articles = response.data._embedded.articles;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.retrieveArticleList();
  }
};
</script>
