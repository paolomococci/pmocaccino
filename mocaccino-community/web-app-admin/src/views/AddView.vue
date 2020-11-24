<template>
  <section>
    <add message="on this page you can add an employee to the database"/>
  </section>
</template>

<script>
import AddEmployeeComponent from '@/components/AddEmployeeComponent'

export default {
  name: 'AddView',
  components: {
    add: AddEmployeeComponent
  }
}
</script>
