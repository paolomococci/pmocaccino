<template>
  <header>
    <nav>
      <navbarComponent/>
    </nav>
    <asideComponent/>
  </header>
</template>

<script>
import NavbarComponent from '@/components/NavbarComponent'
import AsideComponent from '@/components/AsideComponent'

export default {
  name: 'HeaderComponent',
  components: {
    navbarComponent: NavbarComponent,
    asideComponent: AsideComponent
  }
}
</script>
