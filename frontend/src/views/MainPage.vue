<template>
    <div>
      <category-btn></category-btn>
      <dailykeyword/>
      <div></div>
      <!--공지사항 및 로그인-->
      <div></div>
    </div>
</template>

<script>
import categoryBtn from "@/components/category-btn.vue";
import dailykeyword from "@/components/daily-keyword.vue";

export default {
  name: "App",
  components: {
    categoryBtn,
    dailykeyword,
  },
};
</script>

<style>

</style>