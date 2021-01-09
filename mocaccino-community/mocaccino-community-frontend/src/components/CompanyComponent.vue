<template>
  <section>
    <aside>
      <add-company @updateView="updateView"/>
    </aside>
    <!-- sub-section to show the company list -->
    <company-view-table/>
  </section>
</template>

<script>
import CompanyViewTableComponent from '@/components/CompanyViewTableComponent.vue'

export default {
  name: 'CompanyComponent',
  components: {
    'company-view-table': CompanyViewTableComponent
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
