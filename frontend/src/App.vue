<template>
  <main-page></main-page>
</template>

<script>
import MainPage from "./views/MainPage.vue";
export default {
  name: "App",
  components: {
    MainPage
  },
};
</script>

<style>
main-footer{
  position: relative;
  transform: translateY(-100%);
}

</style>