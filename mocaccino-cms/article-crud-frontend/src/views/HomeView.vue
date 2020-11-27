<template>
  <section class="home">
    <welcome msg="home page"/>
  </section>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'HomeView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
