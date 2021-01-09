<template>
    <section>
        <!-- TODO-->
    </section>
</template>

<script>
import ContestVerbsRestfulService from '../services/ContestVerbsRestfulService'
import ContestEditorComponent from '@/components/ContestEditorComponent.vue'
import ContestReferenceViewComponent from '@/components/ContestReferenceViewComponent.vue'

export default {
    name: 'ContestViewTableComponent',
  components: {
    'edit-contest': ContestEditorComponent,
    'view-reference-participants': ContestReferenceViewComponent
  },
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
    messageBoxToConfirmDeletion: ''
  }),
  methods: {
    retrieveContests() {
      ContestVerbsRestfulService.readAll()
        .then(response => {
          this.contests = response.data._embedded.contests;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    async updateView() {
      this.$bvToast.toast('data of contests being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.contests = null;
          this.retrieveContests();
        }, 1000);
    },
    deleteItem(uri) {
      ContestVerbsRestfulService.delete(uri)
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
    this.retrieveContests();
  }
}
</script>
