<template>
  <section>
    <h3><span v-text="msg"></span></h3>
  </section>
</template>

<script>
export default {
  name: 'HomeComponent',
  data: () => ({
    // TODO
  }),
  props: {
    msg: String
  },
  components: {
    // TODO
  },
  filters: {
    // TODO
  },
  watch: {
    // TODO
  },
  methods: {
    // TODO
  },
  computed: {
    // TODO
  },
  mounted() {
    // TODO
  },
  destroyed () {
    // TODO
  },
  activated () {
    // TODO
  },
  deactivated () {
    // TODO
  }
}
</script>

<style scoped lang="scss">
h3 {
  margin: 30px;
}
</style>
