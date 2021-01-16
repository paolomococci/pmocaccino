<template>
  <section>
    <!-- TODO-->
    <p><span v-text="msg"></span></p>
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
