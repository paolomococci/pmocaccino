<template>
  <section>
    <h1>{{msg}}</h1>
    <aside v-if="!submitted">
        <label for="title">title</label>
        <input type="text" id="title" required v-model="article.title" name="title"/>
        <label for="description">description</label>
        <input id="description" required v-model="article.description" name="description"/>
      <button @click="createArticle">submit</button>
    </aside>
    <aside v-else>
      <h4>you submitted successfully</h4>
      <button @click="newArticle">Add</button>
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
  name: 'AddArticleComponent',
  props: {
    msg: String
  },
  data: () => ({
    article: {title: '', description: '', published: false},
    submitted: false
  }),
  methods: {
    createArticle() {
      var data = {
        title: this.article.title,
        description: this.article.description,
        published: false
      };
      axios.post("http://localhost:8090/rest/articles", data)
        .then(response => {
          console.log(response.data);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    newArticle() {
      this.submitted = false;
      this.article = {};
    }
  }
};
</script>
