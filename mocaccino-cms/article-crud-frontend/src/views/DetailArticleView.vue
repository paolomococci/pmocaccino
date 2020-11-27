<template>
  <section>
    <detailArticle/>
  </section>
</template>

<script>
import DetailArticleComponent from '@/components/DetailArticleComponent.vue'

export default {
  name: 'DetailArticleView',
  components: {
    detailArticle: DetailArticleComponent
  }
}
</script>
