<template>
  <main id="app">
    <nav id="nav">
      <router-link class="routerLink" to="/">home</router-link>
      <router-link class="routerLink" to="/about">about</router-link>
      <router-link class="routerLink" to="/greeting">greeting</router-link>
    </nav>
    <router-view/>
  </main>
</template>

<style lang="scss">
.routerLink {
  margin: 5px;
}
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
