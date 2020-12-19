<template>
  <section>
    <b-button 
      variant="outline-primary" 
      @click="showModalDetail">add employee</b-button>
    <b-modal ref="modal-add" hide-footer title="enter the details of a new employee">
      <div class="d-block text-center">
        <h3>fields</h3>
        <b-form  @submit.stop.prevent>
          <label for="feedback-username">username</label>
          <b-form-input v-model="employeeUsername" :state="acceptable" id="feedback-username"></b-form-input>
          <b-form-invalid-feedback :state="acceptable">
            username of new employee must be 6 to 14 characters long
          </b-form-invalid-feedback>
          <b-form-valid-feedback :state="acceptable">
            all right
          </b-form-valid-feedback>
        </b-form>
      </div>
      <b-button 
        class="mt-3" 
        variant="outline-secondary" 
        block 
        @click="hideModalDetail">cancel</b-button>
      <b-button 
        class="mt-3" 
        variant="outline-primary" 
        block 
        @click="todoModalDetail">save</b-button>
    </b-modal>
  </section>
</template>

<script>

export default {
  name: 'EmployeeAddComponent',
  data: () => ({
    employeeUsername: ''
  }),
  computed: {
    acceptable() {
      return this.employeeUsername.length > 5 && this.employeeUsername.length < 15;
    }
  },
  methods: {
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide();
    },
    todoModalDetail() {
      this.$refs['modal-add'].hide();
    }
  }
}
</script>
