<template>
    <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="#">
      <b-avatar size="6em" rounded>mocaccino<br>community</b-avatar>
    </b-navbar-brand>
    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item to="/">home</b-nav-item>
        <b-nav-item to="/about">about</b-nav-item>
      </b-navbar-nav>
      <b-navbar-nav class="ml-auto">
        <b-nav-form>
          <b-form-input 
            size="sm" 
            class="mr-sm-2" 
            :placeholder="placeholderSearch" 
            v-model="textToSearch"></b-form-input>
          <b-button 
            size="sm" 
            class="my-2 my-sm-0" 
            type="submit" 
            @click="search" 
            :disabled="disabledSearchAvailability">search</b-button>
        </b-nav-form>
        <b-nav-item-dropdown right>
          <template #button-content>
            <em>data access</em>
          </template>
          <b-dropdown-item to="/company">company</b-dropdown-item>
          <b-dropdown-item to="/contest">contest</b-dropdown-item>
          <b-dropdown-item to="/employee">employee</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</template>

<script>
export default {
  name: 'NavbarComponent',
  data: () => ({
    textToSearch: ''
  }),
  methods: {
    search() {
      this.$store.state.textToSearch = this.textToSearch,
      this.$bvToast.toast('you have typed a text to search for', {
        title: `search text: ${this.$store.state.textToSearch}`,
        solid: true
      });
      this.textToSearch = '';
    }
  },
  computed: {
    placeholderSearch() {
      return this.$store.state.placeholderSearch;
    },
    disabledSearchAvailability() {
      return this.$store.state.disabledSearchAvailability;
    }
  }
}
</script>
