<template>
  <article>
    <welcome msg="about view"/>
  </article>
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
