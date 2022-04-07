<template>
    <main-search></main-search>
    <span class="today-issue"><i class="fas fa-bell"></i> 오늘의 이슈</span>
    <div class="category">
      <nav>
      <div class="nav nav-tabs nav-fill nav-tabs-category" id="nav-category-tab" role="tablist">
        <button class="nav-link active category-button" id="nav-politics-tab" data-bs-toggle="tab" data-bs-target="#nav-politics" type="button" role="tab" aria-controls="nav-politics" aria-selected="true">정치</button>
        <button class="nav-link category-button" id="nav-economy-tab" data-bs-toggle="tab" data-bs-target="#nav-economy" type="button" role="tab" aria-controls="nav-economy" aria-selected="false">경제</button>
        <button class="nav-link category-button" id="nav-social-tab" data-bs-toggle="tab" data-bs-target="#nav-social" type="button" role="tab" aria-controls="nav-social" aria-selected="false">사회</button>
        <button class="nav-link category-button" id="nav-life-culture-tab" data-bs-toggle="tab" data-bs-target="#nav-life-culture" type="button" role="tab" aria-controls="nav-life-culture" aria-selected="false">생활/문화</button>
        <button class="nav-link category-button" id="nav-it-tab" data-bs-toggle="tab" data-bs-target="#nav-it" type="button" role="tab" aria-controls="nav-it" aria-selected="false">IT</button>
        <button class="nav-link category-button" id="nav-opinion-tab" data-bs-toggle="tab" data-bs-target="#nav-opinion" type="button" role="tab" aria-controls="nav-opinion" aria-selected="false">오피니언</button>
      </div>
    </nav>
    </div>
        <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-politics" role="tabpanel" aria-labelledby="nav-politics-tab">
            <main-tab :category="`정치`"></main-tab>
        </div>
        <div class="tab-pane fade" id="nav-economy" role="tabpanel" aria-labelledby="nav-economy-tab">
            <main-tab :category="`경제`"></main-tab>
        </div>
        <div class="tab-pane fade" id="nav-social" role="tabpanel" aria-labelledby="nav-social-tab">
            <main-tab :category="`사회`"></main-tab>
        </div>
        <div class="tab-pane fade" id="nav-life-culture" role="tabpanel" aria-labelledby="nav-life-culture-tab">
            <main-tab :category="`생활`"></main-tab>
        </div>
        <div class="tab-pane fade" id="nav-it" role="tabpanel" aria-labelledby="nav-it-tab">
            <main-tab :category="`IT`"></main-tab>
        </div>
        <div class="tab-pane fade" id="nav-opinion" role="tabpanel" aria-labelledby="nav-opinion-tab">
            <main-tab :category="`오피니언`"></main-tab>
        </div>
        </div>
    <div class="mainPage">
      <div class="flexbox d-flex">
        <div class="mainBox mx-auto">
          <dailykeyword/>
          <!-- <article-number/> -->
        </div>
        <div class="mainBox mx-auto">
          <h3 style="width: 95%; padding-left: 1.5em; color:#1f57f1; font-weight:bold">WordCloud</h3>
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
import MainTab from "@/components/main/main-tab.vue";
import dailykeyword from "@/components/main/daily-keyword.vue";
import DailyChart from "@/components/main/daily-chart.vue";
import WordCloud from "@/components/main/word-cloud.vue";
export default {
    name: "MainContent",
    components:{
      MainSearch,
      MainTab,
      dailykeyword,
      DailyChart,
      WordCloud,
    },
}
</script>

<style scoped>

.nav-tab-category button{
    border: none;
    background: none;
}
.nav-tab-category button:focus{
    outline: none;
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
    border-bottom: 1px solid rgb(227, 227, 227);
    margin-left:10%;
    margin-right: 10%;
    font-size: 15px;
}

#nav-category-tab .nav-link.active{
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

.today-issue{
    margin-left:10%;
    margin-right: 10%;
    font-family: 'NanumBarunGothicBold',sans-serif;
    font-size : 18px;
}

.tab-content{
    margin-left:10%;
    margin-right: 10%;
    border-bottom: 0.5px solid rgb(227, 227, 227);
    border-left: 0.5px solid rgb(227, 227, 227);
    border-right: 0.5px solid rgb(227, 227, 227);
    height: 400px;
}

.fa-bell{
    color: rgb(46, 72, 221);
}
</style>