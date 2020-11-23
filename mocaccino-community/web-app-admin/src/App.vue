<template>
  <section id="app">
    <section id="nav">
      <navbar/>
    </section>
    <router-view/>
  </section>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #235;
}

#nav {
  padding: 0px;

  a {
    font-weight: bold;
    color: #235;

    &.router-link-exact-active {
      color: #4b8;
    }
  }
}
</style>

<script>
import NavbarComponent from '@/components/NavbarComponent'

export default {
  components: {
    navbar: NavbarComponent
  }
}
</script>
