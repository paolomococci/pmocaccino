<template>
  <aside>
    <b-button v-b-toggle.header-sidebar>show help</b-button>
    <b-sidebar id="header-sidebar" title="help" shadow>
      <div class="px-3 py-2">
        <p>example of help text into sidebar</p>
      </div>
    </b-sidebar>
  </aside>
</template>

<script>
export default {
  name: 'AsideComponent'
}
</script>

<style>
  aside {
    margin: 1rem;
  }
</style>
