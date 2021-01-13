<template>
  <div id="app">
    <nav id="nav">
      <router-link to="/">home</router-link> 
      <router-link to="/about">about</router-link>
    </nav>
    <router-view/>
  </div>
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
