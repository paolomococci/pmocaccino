<template>
  <section>
    <vs-row vs-justify="center">
      <vs-col type="flex" vs-justify="center" vs-align="center" vs-w="6">
        <vs-card>
          <section slot="header">
            <h3>mocaccino</h3>
          </section>
          <section>
            <span v-text="msg"></span>
          </section>
        </vs-card>
      </vs-col>
    </vs-row>
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
