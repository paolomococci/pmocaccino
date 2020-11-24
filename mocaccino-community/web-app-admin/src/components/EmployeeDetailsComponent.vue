<template>
  <section>
    <h1>{{message}}</h1>
    <!-- TODO -->
  </section>
</template>

<script>

export default {
  name: 'EmployeeDetailsComponent',
  props: {
    message: String
  }
}
</script>

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
