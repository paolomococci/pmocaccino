<template>
  <section class="home">
    <hello msg="home page"/>
  </section>
</template>

<script>
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    hello: HelloWorld
  }
}
</script>
