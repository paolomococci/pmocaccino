<template>
  <section>
    <b-button variant="outline-info" @click="showModalDetail">open detail</b-button>
    <b-modal ref="modal-detail" hide-footer title="detail of company">
      <div class="d-block text-center">
        <h3>details</h3>
      </div>
      <b-button class="mt-3" variant="outline-info" block @click="hideModalDetail">close detail modal view</b-button>
    </b-modal>
  </section>
</template>

<script>
export default {
  name: 'CompanyDetailComponent',
  methods: {
    showModalDetail() {
      this.$refs['modal-detail'].show()
    },
    hideModalDetail() {
      this.$refs['modal-detail'].hide()
    }
  }
}
</script>
