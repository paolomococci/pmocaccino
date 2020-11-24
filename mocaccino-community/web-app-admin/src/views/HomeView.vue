<template>
  <section class="home">
    <welcome message="welcome to this example of Vue.js web application"/>
  </section>
</template>

<script>
import Welcome from '@/components/Welcome'

export default {
  name: 'Home',
  components: {
    welcome: Welcome
  }
}
</script>
