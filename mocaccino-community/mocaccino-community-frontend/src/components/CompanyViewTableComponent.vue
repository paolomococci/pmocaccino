<template>
    <section>
        <!-- TODO-->
    </section>
</template>

<script>
import CompanyVerbsRestfulService from '../services/CompanyVerbsRestfulService'

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
    messageBoxToConfirmDeletion: ''
  }),
  methods: {
    retrieveCompanies() {
      CompanyVerbsRestfulService.readAll()
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
        autoHideDelay: 2000
      });
      await setTimeout(() => {
          this.companies = null;
          this.retrieveCompanies();
        }, 2000);
    },
    deleteItem(uri) {
      CompanyVerbsRestfulService.delete(uri)
        .catch(e => {
          console.log(e);
        });
      this.updateView();
    },
    deleteItemConfirm(uri) {
      this.messageBoxToConfirmDeletion = '';
      this.$bvModal.msgBoxConfirm('are you sure you want to delete this item', {
        title: 'please confirm',
        size: 'md',
        buttonSize: 'md',
        okVariant: 'danger',
        okTitle: 'yes',
        cancelTitle: 'no',
        footerClass: 'p-2',
        hideHeaderClose: false,
        centered: true
      }).then(value => {
        if(value) {
          this.deleteItem(uri);
        }
      });
    }
  },
  computed: {},
  mounted() {
    this.retrieveCompanies();
  }
}
</script>
