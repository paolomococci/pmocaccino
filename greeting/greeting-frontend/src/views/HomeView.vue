<template>
  <article class="home">
    <welcome msg="home view"/>
  </article>
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
