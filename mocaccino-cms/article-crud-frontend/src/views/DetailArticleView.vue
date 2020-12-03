<template>
  <section>
    <detailArticle msg="detail of article"/>
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
