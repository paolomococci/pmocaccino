<template>
  <header>
    <nav>
      <navbar/>
    </nav>
    <help/>
  </header>
</template>

<script>
import NavbarComponent from '@/components/NavbarComponent'

export default {
  name: 'HeaderComponent',
  components: {
    navbar: NavbarComponent
  }
}
</script>
