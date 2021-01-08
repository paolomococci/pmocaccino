<template>
    <section>
        <!-- TODO-->
    </section>
</template>

<script>
export default {
    name: 'CompanyViewTableComponent',
  data: () => ({
    fields: [
      {
        key: 'name',
        label: 'names',
        sortable: true
      },
      {
        key: 'showDetails',
        label: 'details'
      }
    ],
    companies: [],
    messageBoxToConfirmDeletion: '',
    textToSearchFor: ''
  }),
  methods: {},
  computed: {},
  mounted() {}
}
</script>
