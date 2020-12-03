<template>
  <section>
    <addArticle msg="add a new article view"/>
  </section>
</template>

<script>
import AddArticleComponent from '@/components/AddArticleComponent.vue'

export default {
  name: 'AddArticleView',
  components: {
    addArticle: AddArticleComponent
  }
}
</script>
