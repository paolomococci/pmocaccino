<template>
  <section>
    <h1><span v-text="msg"></span></h1>
  </section>
</template>

<script>
export default {
  name: 'WelcomeComponent',
  props: {
    msg: String
  }
}
</script>

<style scoped lang="scss">
h1 {
  margin: 40px;
}
</style>
