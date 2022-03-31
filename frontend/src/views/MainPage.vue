<template>
    <b-container>
      <category-btn></category-btn>
      <dailykeyword/>
      <article-number/>
      <daily-chart/>
      <div></div>
      <!--공지사항 및 로그인-->
      <div></div>
    </b-container>
</template>

<script>
import categoryBtn from "@/components/category-btn.vue";
import dailykeyword from "@/components/daily-keyword.vue";
import DailyChart from '@/components/daily-chart.vue';
import ArticleNumber from '@/components/article-number.vue';

export default {
  name: "App",
  components: {
    categoryBtn,
    dailykeyword,
    DailyChart,
    ArticleNumber,
  },
};
</script>

<style>

</style>