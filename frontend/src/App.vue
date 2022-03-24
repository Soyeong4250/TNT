<template>
  <div>
    <header>
      <main-header></main-header>
      <category-btn></category-btn>
      <div></div>
      <!--공지사항 및 로그인-->
      <div></div>
    </header>

    <router-view></router-view>

    바닥
    <main-footer> </main-footer>
  </div>
</template>

<script>
import mainHeader from "@/components/main-header.vue";
import mainFooter from "@/components/main-footer.vue";
import categoryBtn from "@/components/category-btn.vue";

export default {
  name: "App",
  components: {
    mainHeader,
    mainFooter,
    categoryBtn,
  },
};
</script>

<style></style>
