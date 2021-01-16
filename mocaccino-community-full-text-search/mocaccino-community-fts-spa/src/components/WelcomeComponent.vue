<template>
  <section>
    <!-- TODO-->
    <div class="card">
      <div class="card-content">
        <div class="media">
          <div class="media-content">
            <p v-text="msg"></p>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'WelcomeComponent',
  props: {
    msg: String
  }
}
</script>
