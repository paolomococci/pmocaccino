<template>
  <main>
    <welcomeComponent msg="employee view"/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'EmployeeView',
  components: {
    welcomeComponent: WelcomeComponent
  },
  mounted () {
    this.$store.state.disabledSearchAvailability = false
  },
  destroyed () {
    this.$store.state.disabledSearchAvailability = true
  }
}
</script>
