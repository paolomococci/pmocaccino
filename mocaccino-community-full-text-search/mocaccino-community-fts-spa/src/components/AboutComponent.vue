<template>
  <section>
    <div class="card">
      <div class="card-content">
        <div class="media">
          <div class="media-content">
            <p class="title is-4" v-text="msg"></p>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>

export default {
  name: 'AboutComponent',
  props: {
    msg: String
  },
  data: () => ({
    // TODO
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
