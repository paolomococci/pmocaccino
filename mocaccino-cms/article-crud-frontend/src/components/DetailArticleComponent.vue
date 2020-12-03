<template>
  <section>
    <h1>{{msg}}</h1>
    <fieldset v-if="currentArticle">
      <legend> article to edit </legend>
      <form>
          <label for="title">title</label>
          <input type="text" id="title" v-model="currentArticle.title"/>
          <label for="description">description</label>
          <input type="text" class="form-control" id="description" v-model="currentArticle.description"/>
          <label>published:</label>
          <samp>{{currentArticle.published ? "yes" : "no"}}</samp>
      </form>

      <button v-if="currentArticle.published" @click="updatePublished(false)">
        unpublish
      </button>
      <button v-else @click="updatePublished(true)">
        publish
      </button>

      <button @click="deleteArticle">
        delete
      </button>

      <button type="submit" @click="updateArticle">
        update
      </button><br/>
      <samp>{{message}}</samp>
    </fieldset>

    <aside v-else>
      <router-link to="/list">go back to list of articles</router-link>
    </aside>
  </section>
</template>

<style scoped lang="scss">
  h1 {
    font-size: 20px;
    font-weight: lighter;
    margin: 40px;
  }
  label, input, button {
    margin: 5px;
  }
</style>

<script>
import axios from 'axios'

export default {
  name: 'DetailArticleComponent',
  props: {
    msg: String
  },
  data: () => ({
    currentArticle: {title: '', description: '', published: false, _links: {article: {href: ''}, self: {href: ''}}},
    message: ''
  }),
  methods: {
    readArticle(uri) {
      axios.get(uri)
        .then(response => {
          this.currentArticle = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    updatePublished() {
      this.currentArticle.published = !this.currentArticle.published;
      axios.put(this.currentArticle._links.self.href, this.currentArticle)
        .then(response => {
          this.message = 'the published value of this article was updated successfully';
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    updateArticle() {
      axios.put(this.currentArticle._links.self.href, this.currentArticle)
        .then(response => {
        this.message = 'this article was updated successfully';
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteArticle() {
      axios.delete(this.currentArticle._links.self.href)
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: 'ListArticleView' });
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = '';
    this.readArticle(this.$route.query.uri);
  }
};
</script>
