<template>
  <section>
    <!-- TODO-->
    <b-navbar>
      <template #start>
        <b-navbar-item tag="router-link" :to="{path: '/'}">
          <b-tooltip label="mocaccino community" position="is-right">
            <div class="buttons">
              <a class="button is-primary">
                <font-awesome-icon :icon="coffeeIcon" size="lg"/>
              </a>
            </div>
          </b-tooltip>
        </b-navbar-item>
        <b-navbar-item tag="router-link" :to="{path: '/about'}">
          <b-tooltip label="about" position="is-right">
            <div class="buttons">
              <a class="button is-primary">
                <font-awesome-icon :icon="aboutIcon" size="lg"/>
              </a>
            </div>
          </b-tooltip>
        </b-navbar-item>
      </template>
      <template #end>
      <b-navbar-dropdown label="manage">
        <b-navbar-item tag="router-link" :to="{path: '/company'}">
          <b-tooltip label="company" position="is-left">
            <font-awesome-icon :icon="companyIcon"/>
          </b-tooltip>
        </b-navbar-item>
        <b-navbar-item tag="router-link" :to="{path: '/contest'}">
          <b-tooltip label="contest" position="is-left">
            <font-awesome-icon :icon="contestIcon"/>
          </b-tooltip>
        </b-navbar-item>
        <b-navbar-item tag="router-link" :to="{path: '/employee'}">
          <b-tooltip label="employee" position="is-left">
            <font-awesome-icon :icon="employeeIcon"/>
          </b-tooltip>
        </b-navbar-item>
      </b-navbar-dropdown>
      </template>
    </b-navbar>
  </section>
</template>

<script>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import {
  faCoffee,
  faBroadcastTower,
  faBuilding,
  faUsers,
  faUser } from '@fortawesome/free-solid-svg-icons'

export default {
  name: 'NavbarComponent',
  components: {
    FontAwesomeIcon
  },
  props: {
    msg: String
  },
  data: () => ({
    coffeeIcon: faCoffee,
    aboutIcon: faBroadcastTower,
    companyIcon: faBuilding,
    contestIcon: faUsers,
    employeeIcon: faUser
  }),
  methods: {
    // TODO
  },
  computed: {
    // TODO
  },
  mounted() {
    // TODO
  }
}
</script>
