<template>
  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="#">
      <b-avatar size="4em" rounded>web<br>app<br>admin</b-avatar>
    </b-navbar-brand>
    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item to="/">home</b-nav-item>
        <b-nav-item to="/about">about</b-nav-item>
      </b-navbar-nav>
      <b-navbar-nav class="ml-auto">
        <b-nav-form>
          <b-form-input size="sm" class="mr-sm-2" placeholder="search"></b-form-input>
          <b-button size="sm" class="my-2 my-sm-0" type="submit">search</b-button>
        </b-nav-form>
        <b-nav-item-dropdown right>
          <template #button-content>
            <em>menu</em>
          </template>
          <b-dropdown-item to="/about">about</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</template>

<style>

</style>

<script>
export default {
  name: 'NavbarComponent'
}
</script>
