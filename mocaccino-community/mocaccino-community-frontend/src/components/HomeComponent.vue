<template>
  <section>
    <b-jumbotron>
      <template #header>in this web application</template>
      <hr class="my-4">
      <p><span v-text="msg"></p>
      <b-button variant="primary" href="#/company">company</b-button>
      <span> &#173; </span>
      <b-button variant="primary" href="#/contest">contest</b-button>
      <span> &#173; </span>
      <b-button variant="primary" href="#/employee">employee</b-button>
      <span> &#173; </span>
    </b-jumbotron>
  </section>
</template>

<script>
export default {
  name: 'HomeComponent',
  props: {
    msg: String
  }
}
</script>
