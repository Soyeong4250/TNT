<template>
    <div id="header-title" class = "">
        <span @click="clickMain" id="header-title-text">Today News Talk</span>
    </div>
    <main-search></main-search>
      
    <div class="category">
      <nav>
      <div class="nav nav-tabs nav-fill nav-tabs-category" id="nav-category-tab" role="tablist">
        <button class="nav-link active category-button" id="politics" data-bs-toggle="tab" data-bs-target="#nav-best" type="button" role="tab" aria-controls="nav-best" aria-selected="true">정치</button>
        <button class="nav-link category-button" id="economy" data-bs-toggle="tab" data-bs-target="#nav-weather" type="button" role="tab" aria-controls="nav-weather" aria-selected="false">경제</button>
        <button class="nav-link category-button" id="social" data-bs-toggle="tab" data-bs-target="#nav-digital" type="button" role="tab" aria-controls="nav-digital" aria-selected="false">사회</button>
        <button class="nav-link category-button" id="life-culture" data-bs-toggle="tab" data-bs-target="#nav-life" type="button" role="tab" aria-controls="nav-life" aria-selected="false">생활/문화</button>
        <button class="nav-link category-button" id="it" data-bs-toggle="tab" data-bs-target="#nav-kitchen" type="button" role="tab" aria-controls="nav-kitchen" aria-selected="false">IT</button>
        <button class="nav-link category-button" id="opinion" data-bs-toggle="tab" data-bs-target="#nav-kitchen" type="button" role="tab" aria-controls="nav-kitchen" aria-selected="false">오피니언</button>
      </div>
    </nav>
    </div>
    <dailykeyword/>
    <article-number/>
    <daily-chart/>
</template>

<script>
import MainSearch from "@/components/main-search.vue";
import dailykeyword from "@/components/daily-keyword.vue";
import ArticleNumber from "@/components/article-number.vue";
import DailyChart from "@/components/daily-chart.vue";
export default {
    name: "MainContent",
    components:{
    MainSearch,
    dailykeyword,
    ArticleNumber,
    DailyChart,},
}
</script>

<style>

</style>