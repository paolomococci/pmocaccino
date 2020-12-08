<template>
  <section>
    <b-jumbotron>
      <template #header>in this web application</template>
      <hr class="my-4">
      <p v-text="msg"></p>
      <b-row>
        <b-col><b-button size="lg" variant="outline-secondary" href="#/company">company</b-button></b-col>
        <b-col><b-button size="lg" variant="outline-secondary" href="#/contest">contest</b-button></b-col>
        <b-col><b-button size="lg" variant="outline-secondary" href="#/employee">employee</b-button></b-col>
      </b-row>
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
