<template>
  <main>
    <welcomeComponent msg="contest view"/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'ContestView',
  components: {
    welcomeComponent: WelcomeComponent
  }
}
</script>
