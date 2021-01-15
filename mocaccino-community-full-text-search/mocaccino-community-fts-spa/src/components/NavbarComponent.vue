<template>
  <section class="centerx">
    <vs-navbar>
      <div slot="title">
        <vs-navbar-title>
          mocaccino community
        </vs-navbar-title>
      </div>
      <vs-navbar-item index="0"><router-link to="/">home</router-link></vs-navbar-item>
      <vs-navbar-item index="1"><router-link to="/about">about</router-link></vs-navbar-item>
      <vs-navbar-item index="2"><router-link to="/company">company</router-link></vs-navbar-item>
      <vs-navbar-item index="3"><router-link to="/contest">contest</router-link></vs-navbar-item>
      <vs-navbar-item index="4"><router-link to="/employee">employee</router-link></vs-navbar-item>
    </vs-navbar>
    <h1 v-text="msg"></h1>
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
