<template>
  <header>
    <nav>
      <navbarComponent/>
    </nav>
    <help/>
  </header>
</template>

<script>
import NavbarComponent from '@/components/NavbarComponent'
import HelpComponent from '@/components/HelpComponent'

export default {
  name: 'HeaderComponent',
  components: {
    navbarComponent: NavbarComponent,
    help: HelpComponent
  }
}
</script>
