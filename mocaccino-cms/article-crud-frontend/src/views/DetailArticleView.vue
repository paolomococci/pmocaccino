<template>
  <section>
    <welcome msg="detail page"/>
  </section>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'DetailArticleView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
