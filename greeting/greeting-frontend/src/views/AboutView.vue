<template>
  <section class="about">
    <welcome msg="about page"/>
  </section>
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
