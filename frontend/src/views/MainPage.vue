<template>
<div class="main-size">
  <main-header></main-header>
  <router-view :key="$route.fullPath"></router-view>
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
  margin-left: 8%;
  margin-right: 8%;
  font-family: 'NanumBarunGothic', sans-serif;
}
</style>