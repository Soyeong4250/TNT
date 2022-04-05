<template>
<div class="main-size">
  <main-header></main-header>
  <router-view></router-view>
  <main-footer> </main-footer>
</div>
</template>

<script>
import MainHeader from "@/components/main-header.vue";
import MainFooter from "@/components/main-footer.vue";
export default {
  name: "MainPage",
  components: {
    MainHeader,
    MainFooter,  
    },
};
</script>

<style>
.main-size{
  margin-left: 15%;
  margin-right: 15%;
}
</style>