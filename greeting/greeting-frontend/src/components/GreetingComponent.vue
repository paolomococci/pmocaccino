<template>
  <article class="hello">
    <h1>{{msg}}</h1>
  </article>
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
  name: 'GreetingComponent',
  props: {
    msg: String
  }
}
</script>
