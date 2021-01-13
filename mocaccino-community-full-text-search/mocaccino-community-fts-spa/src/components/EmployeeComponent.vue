<template>
  <section>
    <h1 v-text="msg"></h1>
  </section>
</template>

<script>
export default {
  name: 'EmployeeComponent',
  props: {
    msg: String
  }
}
</script>
