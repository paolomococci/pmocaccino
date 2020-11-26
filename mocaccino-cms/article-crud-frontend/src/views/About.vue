<template>
  <section class="about">
    <hello msg="about page"/>
  </section>
</template>

<script>
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'About',
  components: {
    hello: HelloWorld
  }
}
</script>
