<template>
  <section>
    <b-button variant="outline-primary" @click="showModalDetail">add employee</b-button>
    <b-modal ref="modal-add" hide-footer title="enter the details of a new employee">
      <div class="d-block text-center">
        <h3>fields</h3>
      </div>
      <b-button class="mt-3" variant="outline-info" block @click="hideModalDetail">cancel</b-button>
    </b-modal>
  </section>
</template>

<script>
export default {
  name: 'EmployeeAddComponent',
  methods: {
    showModalDetail() {
      this.$refs['modal-add'].show()
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide()
    }
  }
}
</script>
