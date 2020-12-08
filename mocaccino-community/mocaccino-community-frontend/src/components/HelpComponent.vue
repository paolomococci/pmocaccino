<template>
  <aside>
    <b-button v-b-toggle.header-sidebar>show help</b-button>
    <b-sidebar id="header-sidebar" title="help" shadow>
      <div class="px-3 py-2">
        <b-card header="Edit" 
                title="title text">
          <b-card-text>
            explicative text
          </b-card-text>
        </b-card>
        <b-card header="URI" 
                title="title text">
          <b-card-text>
            explicative text
          </b-card-text>
        </b-card>
      </div>
    </b-sidebar>
  </aside>
</template>

<script>
export default {
  name: 'HelpComponent'
}
</script>

<style>
  aside {
    margin: 1rem;
  }
</style>
