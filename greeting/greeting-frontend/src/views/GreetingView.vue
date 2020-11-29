<template>
  <section>
    <greeting msg="greeting page"/>
  </section>
</template>

<script>
import GreetingComponent from '@/components/GreetingComponent.vue'

export default {
  name: 'GreetingView',
  components: {
    greeting: GreetingComponent
  }
}
</script>
