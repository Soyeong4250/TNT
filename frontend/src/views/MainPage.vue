<template>
<div class="main-size">
  <main-header></main-header>
  <router-view :key="$route.fullPath"></router-view>
</div>
  <main-footer> </main-footer>
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
  font-family: 'NanumBarunGothic', sans-serif;
}
</style>