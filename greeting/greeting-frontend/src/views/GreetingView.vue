<template>
  <article>
    <greeting msg="greeting view"/>
  </article>
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
