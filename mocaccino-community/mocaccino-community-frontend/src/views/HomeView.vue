<template>
  <main>
    <welcomeComponent msg="home view"/>
    <home msg="some text"/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import HomeComponent from '@/components/HomeComponent.vue'

export default {
  name: 'HomeView',
  components: {
    welcomeComponent: WelcomeComponent,
    home: HomeComponent
  }
}
</script>
