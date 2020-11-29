<template>
  <article class="hello">
    <h1>{{msg}}</h1>
  </article>
</template>

<style scoped lang="scss">
h1 {
  font-size: 30px;
  margin: 50px 0 0;
}
</style>

<script>
export default {
  name: 'WelcomeComponent',
  props: {
    msg: String
  }
}
</script>
