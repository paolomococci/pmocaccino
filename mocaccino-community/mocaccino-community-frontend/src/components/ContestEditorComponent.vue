<template>
  <section>
    <b-button 
      variant="outline-primary" 
      @click="showModalDetail">edit</b-button>
    <b-modal ref="modal-edit" hide-footer :title="uri">
      <div class="d-block text-center">
        <h3>fields</h3>
        <!-- TODO -->
      </div>
      <b-button 
        class="mt-3" 
        variant="outline-secondary" 
        block 
        @click="hideModalDetail">cancel</b-button>
      <b-button 
        class="mt-3" 
        variant="outline-primary" 
        block 
        :disabled="!validateForm"
        @click="updateContest">save</b-button>
    </b-modal>
  </section>
</template>

<script>
export default {
  name: 'ContestEditorComponent',
  data: () => ({
  }),
  props: {
    uri: String,
    nameField: String,
    titleField: String,
    descriptionField: String,
    dateField: Date
  },
  methods: {
    // TODO
  },
  mounted() {
    // TODO
  }
}
</script>
