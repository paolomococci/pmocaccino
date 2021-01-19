<template>
  <section>
    <!-- todo -->
  </section>
</template>

<script>
import EmployeeRestService from '../services/EmployeeRestService'
import { validationMixin } from 'vuelidate'
import {
  required,
  minLength,
  maxLength,
  alpha,
  alphaNum,
  email,
  helpers
 } from 'vuelidate/lib/validators'

const employeeProfessionRegex = helpers.regex('employeeProfessionRegex', /^[a-zA-Z-]*$/);

export default {
  name: 'EditorComponent',
  props: {
    // TODO
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
