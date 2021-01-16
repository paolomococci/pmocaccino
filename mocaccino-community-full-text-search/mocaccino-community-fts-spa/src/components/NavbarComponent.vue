<template>
  <section>
    <!-- TODO-->
    <b-navbar>
      <template #brand>
        <b-navbar-item tag="router-link" :to="{path: '/'}">
          <div class="buttons">
            <a class="button is-primary">
              <strong>mocaccino community</strong>
            </a>
          </div>
        </b-navbar-item>
      </template>
      <template #start>
        <b-navbar-item tag="router-link" :to="{path: '/about'}">
          about
        </b-navbar-item>
      </template>
      <template #end>
      <b-navbar-dropdown label="data">
        <b-navbar-item tag="router-link" :to="{path: '/company'}">
          company
        </b-navbar-item>
        <b-navbar-item tag="router-link" :to="{path: '/contest'}">
          contest
        </b-navbar-item>
        <b-navbar-item tag="router-link" :to="{path: '/employee'}">
          employee
        </b-navbar-item>
      </b-navbar-dropdown>
      </template>
    </b-navbar>
  </section>
</template>

<script>
export default {
  name: 'NavbarComponent',
  props: {
    msg: String
  }
}
</script>
