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

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #235;
}
#nav {
  padding: 30px;
  a {
    font-weight: bold;
    color: #235;
    &.router-link-exact-active {
      color: #4b8;
    }
  }
}
</style>
