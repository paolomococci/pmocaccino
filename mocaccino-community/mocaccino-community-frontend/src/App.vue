<template>
  <div id="app">
    <nav id="nav">
      <header-component/>
    </nav>
    <router-view/>
  </div>
</template>

<script>
import HeaderComponent from '@/components/HeaderComponent'

export default {
  components: {
    'header-component': HeaderComponent
  }
}
</script>
