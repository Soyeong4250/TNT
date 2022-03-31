<template>
  <MDBNavbar class="navbar-nav" light bg="light" position="top" container>
    <MDBNavbarBrand href="#">Fixed Top</MDBNavbarBrand>
  </MDBNavbar>
</template>

<script>
import { MDBNavbar, MDBNavbarBrand } from 'mdb-vue-ui-kit';
  export default {
    components: {
      MDBNavbar,
      MDBNavbarBrand,
    },
  };
</script>

<style>
.navbar-nav { padding: 260px 25px }
</style>