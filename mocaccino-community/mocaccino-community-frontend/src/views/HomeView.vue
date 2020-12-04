<template>
  <main>
    <welcome msg="home view"/>
  </main>
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
