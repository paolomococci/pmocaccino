<template>
  <section>
    <adding message="this is adding page"/>
  </section>
</template>

<script>
import AddEmployeeComponent from '@/components/AddEmployeeComponent'

export default {
  name: 'AddView',
  components: {
    adding: AddEmployeeComponent
  }
}
</script>
