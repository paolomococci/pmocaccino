<template>
  <section>
    <b-button 
      variant="outline-primary" 
      @click="showModalDetail">add employee</b-button>
    <b-button 
      variant="outline-secondary" 
      @click="updateView">update view</b-button>
    <b-modal ref="modal-add" hide-footer title="enter the details of a new employee">
      <div class="d-block text-center">
        <h3>fields</h3>
        <b-form  @submit.stop.prevent>
          <!-- username field -->
          <label for="feedback-username">username</label>
          <b-form-input 
            v-model="employeeUsername" 
            :state="acceptable" 
            id="feedback-username"></b-form-input>
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
        :disabled="!isAcceptable()"
        @click="addEmployee">save</b-button>
    </b-modal>
  </section>
</template>

<script>
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'

export default {
  name: 'EmployeeAddComponent',
  data: () => ({
    employeeUsername: ''
  }),
  computed: {
    acceptable() {
      return this.isAcceptable();
    }
  },
  methods: {
    isAcceptable() {
      return this.employeeUsername.length > 5 && this.employeeUsername.length < 15;
    },
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide();
    },
    addEmployee() {
      var data = {
        username: this.employeeUsername
      };
      EmployeeVerbsRestfulService.create(data)
        .then(response => {
          console.log(response.data);
        }).catch(e => {
          console.log(e);
        });
      this.$refs['modal-add'].hide();
      this.updateView();
    },
    updateView() {
      this.$emit('updateView');
    }
  }
}
</script>
