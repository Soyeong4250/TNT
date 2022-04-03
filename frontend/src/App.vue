<template>
  <main-header></main-header>
  <router-view></router-view>
  <main-footer> </main-footer>
</template>

<script>
import mainHeader from "@/components/main-header.vue";
import mainFooter from "@/components/main-footer.vue";

export default {
  name: "App",
  components: {
    mainHeader,
    mainFooter,
  },
};
</script>

<style>
main-footer{
  position: relative;
  transform: translateY(-100%);
}

</style>