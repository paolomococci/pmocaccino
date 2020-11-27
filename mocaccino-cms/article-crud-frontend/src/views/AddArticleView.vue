<template>
  <section>
    <welcome msg="add page"/>
  </section>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'AddArticleView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
