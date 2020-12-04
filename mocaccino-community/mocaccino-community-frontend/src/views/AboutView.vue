<template>
  <main>
    <welcome msg="about view"/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'AboutView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
