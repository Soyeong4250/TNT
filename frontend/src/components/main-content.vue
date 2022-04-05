<template>
    <div id="header-title" class = "">
        <span @click="clickMain" id="header-title-text">Today News Talk</span>
    </div>

    <main-search></main-search>
  
    <div class="category">
      <nav>
      <div class="nav nav-tabs nav-fill nav-tabs-category" id="nav-category-tab" role="tablist">
        <button class="nav-link active category-button" id="politics" data-bs-toggle="tab" data-bs-target="#nav-politics" type="button" role="tab" aria-controls="nav-politics" aria-selected="true">정치</button>
        <button class="nav-link category-button" id="economy" data-bs-toggle="tab" data-bs-target="#nav-economy" type="button" role="tab" aria-controls="nav-economy" aria-selected="false">경제</button>
        <button class="nav-link category-button" id="social" data-bs-toggle="tab" data-bs-target="#nav-social" type="button" role="tab" aria-controls="nav-social" aria-selected="false">사회</button>
        <button class="nav-link category-button" id="life-culture" data-bs-toggle="tab" data-bs-target="#nav-life-culture" type="button" role="tab" aria-controls="nav-life-culture" aria-selected="false">생활/문화</button>
        <button class="nav-link category-button" id="it" data-bs-toggle="tab" data-bs-target="#nav-it" type="button" role="tab" aria-controls="nav-it" aria-selected="false">IT</button>
        <button class="nav-link category-button" id="opinion" data-bs-toggle="tab" data-bs-target="#nav-opinion" type="button" role="tab" aria-controls="nav-opinion" aria-selected="false">오피니언</button>
      </div>
    </nav>
        <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="politics" role="tabpanel" aria-labelledby="nav-politics-tab">...</div>
        <div class="tab-pane fade" id="economy" role="tabpanel" aria-labelledby="nav-economy-tab">...</div>
        <div class="tab-pane fade" id="social" role="tabpanel" aria-labelledby="nav-social-tab">...</div>
        <div class="tab-pane fade" id="life-culture" role="tabpanel" aria-labelledby="nav-life-culture-tab">...</div>
        <div class="tab-pane fade" id="it" role="tabpanel" aria-labelledby="nav-it-tab">...</div>
        <div class="tab-pane fade" id="opinion" role="tabpanel" aria-labelledby="nav-opinion-tab">...</div>
        </div>
    <div class="mainPage">
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
    </div>

</template>

<script>
import MainSearch from "@/components/main-search.vue";
//import MainTab from "@/components/main/main-tab.vue";
import dailykeyword from "@/components/main/daily-keyword.vue";
import DailyChart from "@/components/main/daily-chart.vue";
export default {
    name: "MainContent",
    components:{
    MainSearch,
    dailykeyword,
    DailyChart,
    //MainTab,
    },
}
</script>

<style scoped>
button{
    border: none;
    background: none;
}

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

.category{
    padding-top: 30px;
    border-bottom: 1px solid rgb(blue, blue, blue);
    margin-left:auto;
    margin-right: auto;
    font-size: 15px;
}

.nav-link.active{
    color : rgb(26, 112, 211);
    font-weight: bold;
    background-color: #fff;
    border-color: #fff #fff #1f57f1;
    border-width: 3px;
}

.nav-link{
    color : grey;
}

.category-button:hover{
    border-color:white;
}

.tab-content{
    height: 20%;
}
</style>