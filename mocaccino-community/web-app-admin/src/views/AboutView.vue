<template>
  <section class="about">
    <welcome message="this is about page"/>
  </section>
</template>

<script>
import Welcome from '@/components/Welcome'

export default {
  name: 'About',
  components: {
    welcome: Welcome
  }
}
</script>
