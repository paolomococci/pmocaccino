<template>
  <main>
    <welcomeComponent msg="employee view"/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'EmployeeView',
  components: {
    welcomeComponent: WelcomeComponent
  }
}
</script>
