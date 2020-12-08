<template>
  <main>
    <welcomeComponent msg="about view"/>
    <about msg="some text"/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import AboutComponent from '@/components/AboutComponent.vue'

export default {
  name: 'AboutView',
  components: {
    welcomeComponent: WelcomeComponent,
    about: AboutComponent
  }
}
</script>
