<template>
  <section>
    <!-- TODO-->
    <div class="card">
      <div class="card-content">
        <div class="media">
          <div class="media-content">
            <p class="title is-3" v-text="msg"></p>
            <font-awesome-icon :icon="spinnerIcon" spin/>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faSpinner } from '@fortawesome/free-solid-svg-icons'

export default {
  name: 'WelcomeComponent',
  components: {
    FontAwesomeIcon
  },
  props: {
    msg: String
  },
  data: () => ({
    spinnerIcon: faSpinner
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
