<template>
  <section>
    <listing message="this page shows the list of employees already registered"/>
  </section>
</template>

<script>
import ListEmployeesComponent from '@/components/ListEmployeesComponent'

export default {
  name: 'ListView',
  components: {
    listing: ListEmployeesComponent
  }
}
</script>
