<template>
  <section>
    <h1 v-text="msg"></h1>
  </section>
</template>

<script>
export default {
  name: 'SearchResultComponent',
  props: {
    msg: String
  }
}
</script>
