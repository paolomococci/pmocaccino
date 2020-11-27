<template>
  <section>
    <addArticle/>
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
