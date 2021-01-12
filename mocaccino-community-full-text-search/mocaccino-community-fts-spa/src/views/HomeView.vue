<template>
  <section>
    <welcome msg="home view"/>
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
