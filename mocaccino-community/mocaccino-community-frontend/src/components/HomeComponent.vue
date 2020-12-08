<template>
  <section>
    <b-jumbotron>
      <template #header>on this web application</template>
      <template #lead><span v-text="msg"></span></template>
      <hr class="my-4">
      <p>you can view and edit this type of entity:</p>
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
