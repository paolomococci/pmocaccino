<template>
  <section>
    <b-button variant="outline-primary" @click="showModalDetail">add company</b-button>
    <b-modal ref="modal-add" hide-footer title="enter the details of a new company">
      <div class="d-block text-center">
        <h3>fields</h3>
        <b-form  @submit.stop.prevent>
          <label for="feedback-name">name</label>
          <b-form-input v-model="companyName" :state="acceptable" id="feedback-name"></b-form-input>
          <b-form-invalid-feedback :state="acceptable">
            name of new company must be 8 to 30 characters long
          </b-form-invalid-feedback>
          <b-form-valid-feedback :state="acceptable">
            all right
          </b-form-valid-feedback>
        </b-form>
      </div>
      <b-button class="mt-3" variant="outline-secondary" block @click="hideModalDetail">cancel</b-button>
      <b-button class="mt-3" variant="outline-primary" block @click="todoModalDetail">save</b-button>
    </b-modal>
  </section>
</template>

<script>
import { alpha, required, minLength, maxLength } from '@vuelidate/validators'

export default {
  name: 'CompanyAddComponent',
  data: () => ({
    companyName: ''
  }),
  validations: {
    companyName: {
      alpha,
      required,
      minLength: minLength(8),
      maxLength: maxLength(30)
    }
  },
  computed: {
    acceptable() {
      return this.companyName.length > 7 && this.companyName.length < 31;
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
