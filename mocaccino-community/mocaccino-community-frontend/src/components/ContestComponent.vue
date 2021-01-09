<template>
  <section>
    <aside>
      <add-contest @updateView="updateView"/>
    </aside>
    <!-- sub-section to show the contest list -->
    <contest-view-table/>
  </section>
</template>

<script>
import ContestViewTableComponent from '@/components/ContestViewTableComponent.vue'

export default {
  name: 'ContestComponent',
  components: {
    'contest-view-table': ContestViewTableComponent
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
