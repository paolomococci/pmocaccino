<template>
  <main>
    <welcome-component msg="employee view"/>
    <employee-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import EmployeeComponent from '@/components/EmployeeComponent.vue'

export default {
  name: 'EmployeeView',
  components: {
    'welcome-component': WelcomeComponent,
    'employee-component': EmployeeComponent
  },
  mounted () {
    this.$store.state.placeholderSearch = 'type a username to search for',
    this.$store.state.disabledSearchAvailability = false
  },
  destroyed () {
    this.$store.state.textToSearch = '',
    this.$store.state.placeholderSearch = '',
    this.$store.state.disabledSearchAvailability = true
  }
}
</script>
