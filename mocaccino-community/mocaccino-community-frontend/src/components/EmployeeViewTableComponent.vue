<template>
    <section>
        <!-- TODO-->
    </section>
</template>

<script>
export default {
    name: 'EmployeeViewTableComponent',
  data: () => ({
    fields: [
      {
        key: 'username',
        label: 'usernames',
        sortable: true
      },
      {
        key: 'showDetails',
        label: 'details'
      }
    ],
    employees: [],
    messageBoxToConfirmDeletion: '',
    textToSearchFor: ''
  }),
  methods: {},
  computed: {},
  mounted() {}
}
</script>
