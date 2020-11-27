<template>
  <section>
    <welcome msg="list page"/>
  </section>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'ListArticleView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
