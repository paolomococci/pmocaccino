<template>
  <section class="about">
    <welcome message="this is about page"/>
  </section>
</template>

<script>
import Welcome from '@/components/Welcome'

export default {
  name: 'AboutView',
  components: {
    welcome: Welcome
  }
}
</script>
