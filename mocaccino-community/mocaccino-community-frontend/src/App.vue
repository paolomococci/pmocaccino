<template>
  <div id="app">
    <nav id="nav">
      <headerComponent/>
    </nav>
    <router-view/>
  </div>
</template>

<script>
import HeaderComponent from '@/components/HeaderComponent'

export default {
  components: {
    headerComponent: HeaderComponent
  }
}
</script>
