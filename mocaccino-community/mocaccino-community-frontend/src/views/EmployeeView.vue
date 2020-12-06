<template>
  <main>
    <welcomeComponent msg="employee view"/>
    <employeeComponent/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import EmployeeComponent from '@/components/EmployeeComponent.vue'

export default {
  name: 'EmployeeView',
  components: {
    welcomeComponent: WelcomeComponent,
    employeeComponent: EmployeeComponent
  },
  mounted () {
    this.$store.state.placeholderSearch = 'type a username to search for',
    this.$store.state.disabledSearchAvailability = false
  },
  destroyed () {
    this.$store.state.placeholderSearch = '',
    this.$store.state.disabledSearchAvailability = true
  }
}
</script>
