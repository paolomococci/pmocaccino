<template>
  <section>
    <h1>{{msg}}</h1>
    <aside>
      <input type="text" placeholder="search by title" v-model="title"/>
      <button type="button" @click="searchByTitle">search</button>
    </aside>
    <hr/>
    <section>
      <h4>articles list:</h4>
        <p :class="{ active: index == currentIndex }"
          v-for="(article, index) in articles"
          :key="index"
          @click="setActiveArticle(article, index)">
          {{article.title}}
        </p>
    </section>
    <hr/>
    <section>
      <footer v-if="currentIndex">
        <h4>details to edit:</h4>
          <label for="title">title</label><br/>
          <samp id="title">{{currentArticle.title}}</samp><br/><br/>
          <label for="description">description</label><br/>
          <samp id="description">{{currentArticle.description}}</samp><br/><br/>
          <label for="published">published</label><br/>
          <samp id="published">{{currentArticle.published ? "yes" : "no"}}</samp><br/><br/>
          <label for="selfLink">URI</label><br/>
          <samp id="selfLink">{{currentArticle._links.self.href}}</samp><br/><br/>
        <!-- TODO -->
        <a :href="'/#/detail?uri='+currentArticle._links.self.href">edit this article</a>
      </footer>
      <footer v-else>
        <p>please, click for edit an article</p>
      </footer>
    </section>
  </section>
</template>

<style scoped lang="scss">
  label, input, button {
    margin: 5px;
  }
  h1 {
    font-size: 20px;
    font-weight: lighter;
    margin: 40px;
  }
  h4 {
    font-size: 18px;
    font-weight: lighter;
  }
</style>

<script>
import axios from 'axios'

export default {
  name: 'ListArticleComponent',
  props: {
    msg: String
  },
  data: () => ({
    url: 'http://localhost:8090/rest/articles',
    articles: [],
    currentArticle: {title: '', description: '', published: false, _links: {article: {href: ''}, self: {href: ''}}},
    currentIndex: 0,
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
      this.currentIndex = index+1;
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
