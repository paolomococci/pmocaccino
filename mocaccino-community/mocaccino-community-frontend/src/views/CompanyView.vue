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
  },
  mounted () {
    this.$store.state.placeholderSearch = 'type a name to search',
    this.$store.state.disabledSearchAvailability = false
  },
  destroyed () {
    this.$store.state.placeholderSearch = '',
    this.$store.state.disabledSearchAvailability = true
  }
}
</script>
