<template>
  <section>
    <listArticle/>
  </section>
</template>

<script>
import ListArticleComponent from '@/components/ListArticleComponent.vue'

export default {
  name: 'ListArticleView',
  components: {
    listArticle: ListArticleComponent
  }
}
</script>
