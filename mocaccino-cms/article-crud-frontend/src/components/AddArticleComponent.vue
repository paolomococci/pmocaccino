<template>
  <section>
    <mark>{{msg}}</mark>
  </section>
</template>

<style scoped lang="scss">
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #4b8;
}
</style>

<script>

export default {
  name: 'AddArticleComponent',
  props: {
    msg: String
  }
}
</script>
