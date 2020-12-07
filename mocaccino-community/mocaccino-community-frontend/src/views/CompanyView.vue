<template>
  <main>
    <welcomeComponent msg="company view"/>
    <companyComponent/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import CompanyComponent from '@/components/CompanyComponent.vue'

export default {
  name: 'CompanyView',
  components: {
    welcomeComponent: WelcomeComponent,
    companyComponent: CompanyComponent
  },
  mounted () {
    this.$store.state.placeholderSearch = 'type a name to search for',
    this.$store.state.disabledSearchAvailability = false
  },
  destroyed () {
    this.$store.state.textToSearch = '',
    this.$store.state.placeholderSearch = '',
    this.$store.state.disabledSearchAvailability = true
  }
}
</script>
