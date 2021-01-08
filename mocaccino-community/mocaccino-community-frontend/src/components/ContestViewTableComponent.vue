<template>
    <section>
        <!-- TODO-->
    </section>
</template>

<script>
export default {
    name: 'ContestViewTableComponent',
  data: () => ({
    fields: [
      {
        key: 'date',
        label: 'dates',
        sortable: true
      },
      {
        key: 'name',
        label: 'names'
      },
      {
        key: 'showDetails',
        label: 'details'
      }
    ],
    contests: [],
    messageBoxToConfirmDeletion: '',
    textToSearchFor: ''
  }),
  methods: {},
  computed: {},
  mounted() {}
}
</script>
