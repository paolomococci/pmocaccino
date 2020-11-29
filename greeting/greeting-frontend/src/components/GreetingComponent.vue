<template>
  <article class="hello">
    <h1>{{msg}}</h1>
    <h2><em>response from REST web service at url:</em> {{url}}</h2>
    <p><code>{{entities}}</code></p>
  </article>
</template>

<style scoped lang="scss">
h1 {
  font-size: 30px;
  margin: 50px 0 0;
}
h3 {
  font-size: 16px;
  margin: 40px 0 0;
}
p {
  font-size: 14px;
  margin: 30px 0 0;
}
</style>

<script>
import axios from 'axios'

export default {
  name: 'GreetingComponent',
  props: {
    msg: String
  },
  data: () => ({
    url: 'http://localhost:8090/api/greeting?name=John',
    entities: null
  }),
  mounted () {
    axios.get(this.url)
      .then(response => {
        this.entities = response.data
        this.handleResponse(response)
      })
  },
  methods: {
    handleResponse (response) {
      console.log(response)
    }
  }
}
</script>
