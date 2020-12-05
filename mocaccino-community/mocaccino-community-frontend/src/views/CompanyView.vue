<template>
  <main>
    <welcomeComponent msg="company view"/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'CompanyView',
  components: {
    welcomeComponent: WelcomeComponent
  }
}
</script>
