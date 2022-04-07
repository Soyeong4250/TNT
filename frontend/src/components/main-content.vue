<template>
    <div id="header-title" class = "">
        <span @click="clickMain" id="header-title-text">Today News Talk</span>
    </div>

    <main-search></main-search>
  
    <div class="category">
      <nav>
        <div class="nav nav-tabs nav-fill nav-tabs-category" id="nav-category-tab" role="tablist">
          <button class="nav-link active category-button" id="all" data-bs-toggle="tab" data-bs-target="#nav-best" type="button" role="tab" aria-controls="nav-best" aria-selected="true">전체</button>
          <button class="nav-link category-button" id="politics" data-bs-toggle="tab" data-bs-target="#nav-best" type="button" role="tab" aria-controls="nav-best" aria-selected="false">정치</button>
          <button class="nav-link category-button" id="economy" data-bs-toggle="tab" data-bs-target="#nav-weather" type="button" role="tab" aria-controls="nav-weather" aria-selected="false">경제</button>
          <button class="nav-link category-button" id="social" data-bs-toggle="tab" data-bs-target="#nav-digital" type="button" role="tab" aria-controls="nav-digital" aria-selected="false">사회</button>
          <button class="nav-link category-button" id="life-culture" data-bs-toggle="tab" data-bs-target="#nav-life" type="button" role="tab" aria-controls="nav-life" aria-selected="false">생활/문화</button>
          <button class="nav-link category-button" id="it" data-bs-toggle="tab" data-bs-target="#nav-kitchen" type="button" role="tab" aria-controls="nav-kitchen" aria-selected="false">IT</button>
          <button class="nav-link category-button" id="opinion" data-bs-toggle="tab" data-bs-target="#nav-kitchen" type="button" role="tab" aria-controls="nav-kitchen" aria-selected="false">오피니언</button>
        </div>
      </nav>
    </div>
    <div class="mainPage">
      <div class="flexbox d-flex">
        <div class="mainBox mx-auto">
          <dailykeyword/>
          <!-- <article-number/> -->
        </div>
        <div class="mainBox mx-auto">
          <word-cloud></word-cloud>
        </div>
        <div class="mainBox mx-auto">
          <daily-chart/>
        </div>
      </div>
    </div>


</template>

<script>
import MainSearch from "@/components/main-search.vue";
import dailykeyword from "@/components/main/daily-keyword.vue";
import DailyChart from "@/components/main/daily-chart.vue";
import WordCloud from "@/components/main/word-cloud.vue";
export default {
    name: "MainContent",
    components:{
      MainSearch,
      dailykeyword,
      WordCloud,
      DailyChart,
    },
}
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