<template>
  <main>
    <welcome-component msg="contest view"/>
    <contest-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ContestComponent from '@/components/ContestComponent.vue'

export default {
  name: 'ContestView',
  components: {
    'welcome-component': WelcomeComponent,
    'contest-component': ContestComponent
  },
  mounted () {
    this.$store.state.placeholderSearch = 'type a title to search for',
    this.$store.state.disabledSearchAvailability = false
  },
  destroyed () {
    this.$store.state.textToSearch = '',
    this.$store.state.placeholderSearch = '',
    this.$store.state.disabledSearchAvailability = true
  }
}
</script>
