<template>
  <section>
    <listArticle msg="list of articles"/>
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
