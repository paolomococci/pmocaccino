<template>
    <section>
        <!-- TODO-->
    </section>
</template>

<script>
import CompanyVerbsRestfulService from '../services/CompanyVerbsRestfulService'

export default {
    name: 'CompanySearchResultComponent',
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
  methods: {
    searchByName() {
      CompanyVerbsRestfulService.searchByName(this.textToSearchFor)
        .then(response => {
          this.companies = response.data._embedded.companies;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    async updateView() {
      this.$bvToast.toast('data of companies being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.companies = null;
          this.searchByName();
        }, 1000);
    }
  },
  computed: {},
  mounted() {}
}
</script>
