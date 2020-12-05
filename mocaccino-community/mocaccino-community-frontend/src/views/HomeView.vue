<template>
  <main>
    <welcomeComponent msg="home view"/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'HomeView',
  components: {
    welcomeComponent: WelcomeComponent
  }
}
</script>
