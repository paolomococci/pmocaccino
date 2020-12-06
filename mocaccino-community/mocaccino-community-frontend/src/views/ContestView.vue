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
  },
  mounted () {
    this.$store.state.placeholderSearch = 'type a title to search for',
    this.$store.state.disabledSearchAvailability = false
  },
  destroyed () {
    this.$store.state.placeholderSearch = '',
    this.$store.state.disabledSearchAvailability = true
  }
}
</script>
