<template>
  <section>
    <detail message="on this page you can view the registered data of an employee"/>
  </section>
</template>

<script>
import EmployeeDetailsComponent from '@/components/EmployeeDetailsComponent'

export default {
  name: 'EmployeeDetailsView',
  components: {
    detail: EmployeeDetailsComponent
  }
}
</script>
