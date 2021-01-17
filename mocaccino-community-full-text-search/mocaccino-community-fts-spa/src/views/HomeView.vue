<template>
  <main>
    <home msg="home view"/>
  </main>
</template>

<script>
import HomeComponent from '@/components/HomeComponent.vue'

export default {
  name: 'HomeView',
  components: {
    home: HomeComponent
  }
}
</script>
