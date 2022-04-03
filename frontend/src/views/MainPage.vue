<template>
    <div class="mainPage">
      <category-btn></category-btn>
      <div class="flexbox d-flex">
        <div class="mainBox mx-auto">
          <dailykeyword/>
          <!-- <article-number/> -->
        </div>
        <div class="mainBox mx-auto">
          <daily-chart/>
        </div>
      </div>
    </div>
</template>

<script>
import categoryBtn from "@/components/main/category-btn.vue";
import dailykeyword from "@/components/main/daily-keyword.vue";
import DailyChart from '@/components/main/daily-chart.vue';
// import ArticleNumber from '@/components/main/article-number.vue';

export default {
  name: "App",
  components: {
    categoryBtn,
    dailykeyword,
    DailyChart,
    // ArticleNumber,
  },
};
</script>

<style>
.mainPage{
  height: auto;
  min-width: 600px;
}
.mainPage::after {
  content: '';
  display: block;
  clear: both;
}
.flexbox{
  display: flex;
  flex-wrap: wrap;
  gap: 1em;
  align-content: center;
  
}

.mainBox {
  width: 55em;
  height: 100%;
  float: left;
  flex-grow: 0;
}
</style>