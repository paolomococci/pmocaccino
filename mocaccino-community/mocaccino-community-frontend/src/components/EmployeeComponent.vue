<template>
  <section>
    <aside>
      <add-employee @updateView="updateView"/>
    </aside>
    <!-- sub-section to show the employee list -->
    <employee-view-table/>
  </section>
</template>

<script>
import EmployeeViewTableComponent from '@/components/EmployeeViewTableComponent.vue'

export default {
  name: 'EmployeeComponent',
  components: {
    'employee-view-table': EmployeeViewTableComponent
  },
  data: () => ({
    textToSearchFor: ''
  }),
  methods: {},
  computed: {
    textToSearch() {
      return this.$store.state.textToSearch;
    }
  },
  mounted() {}
}
</script>

<style>
  button {
    margin: 2px;
  }
</style>
