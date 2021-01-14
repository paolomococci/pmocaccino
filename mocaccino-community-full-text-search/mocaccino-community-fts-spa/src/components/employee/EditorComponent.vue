<template>
  <section>
    <h1>{{msg}}</h1>
  </section>
</template>

<style scoped lang="scss">
h1 {
  font-size: 20px;
  font-weight: lighter;
  margin: 40px;
}
</style>

<script>

export default {
  name: 'EditorComponent',
  props: {
    msg: String
  }
}
</script>
