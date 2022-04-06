<template>
  <div>
    <main-search></main-search>
    <div class="topNews">
      <h3>"<b>{{ this.searchWord }}</b>"에 대한 검색결과</h3>
      <!-- 캐러셀을 이용한 topNews -->
      <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="thumbnail" :style="{backgroundImage: 'url('+this.news[0].tumbnailUrl+')'}">
              <!-- <img src="https://mimgnews.pstatic.net/image/origin/014/2022/04/03/4813743.jpg?type=nf264_176&ut=20220403184504" class="thumbnail d-inline w-25 m-3" alt="첫번째 뉴스"> -->
              <!-- <img :src="this.news[0].tumbnailUrl" class="thumbnail d-inline w-25 m-5" alt="첫번째 뉴스" width="500px" height="500px" style="float:left">  -->
            </div>
            <div class="newsDesc" style="">
              <h5>{{ this.news[0].title }}</h5>
              <p class="ellipsis">{{ this.news[0].content }}</p>
            </div>
            <button type="button ml-9" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong">
              뉴스보기
            </button>
            </div>
          </div>
          <div class="carousel-item">
            <img :src="this.news[1].tumbnailUrl" class="thumbnail d-inline w-25 m-3" alt="두번째 뉴스" >
            <div class="" style="display:inline-block;">
              <h5>{{ this.news[1].title }}</h5>
              <p class="ellipsis">{{ this.news[1].content }}</p>
            </div>
          </div>
          <div class="carousel-item">
            <img :src="this.news[2].tumbnailUrl" class="thumbnail d-inline w-25 m-3" alt="세번째 뉴스" >
            <div class="" style="display:inline-block;">
              <h5>{{ this.news[2].title }}</h5>
              <p class="ellipsis">{{ this.news[2].content }}</p>
            </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
          <!-- <span class="carousel-control-prev-icon" aria-hidden="true"></span> -->
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
          <!-- <span class="carousel-control-next-icon" aria-hidden="true"></span> -->
          <span class="visually-hidden">Next</span>
        </button>
      </div>

    <!--뉴스 리스트-->
    <div>
      <b-row>
        <b-col v-if="this.news.length">
          <b-table-simple hover responsive outlined>
            <b-thead head-variant="light">
              <colgroup>
                <col style="width: 85%" />
                <col style="width: 15%" />
              </colgroup>
            </b-thead>
            <b-tbody>
              <news-list-item
                v-for="(n, index) in this.news"
                :key="index"
                :cnt="`${index + 1}`"
                :category="n.category"
                :company="n.company"
                :date="n.date"
                :url="n.newsUrl"
                :reporter="n.reporter"
                :title="n.title"
                :tumbnailUrl="n.tumbnailUrl"
                />
            </b-tbody>
          </b-table-simple>
        </b-col>
      </b-row>
    </div>
    <news-modal class="modal fade bd-example-modal-lg" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" />
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';
import NewsListItem from "@/components/news/NewsListItem.vue";
import MainSearch from "@/components/main-search.vue";

export default {
  components: {
    NewsListItem,
    MainSearch,
  },
  data() {
    return{
      selected : this.$route.params.selected,
      searchWord : this.$route.params.searchWord,
      page : 1,
      content: "",
    }
  },
  created() {
    if(this.selected == '제목'){
      this.$store.dispatch("searchStore/GET_SEARCH_TITLE",{
        searchWord : this.searchWord, 
        page : this.page});
    } else if(this.selected == "내용") {
      this.$store.dispatch("searchStore/GET_SEARCH_CONTENT", {
        searchWord : this.searchWord, 
        page : this.page});
    } else if(this.selected == "언론사") {
      this.$store.dispatch("searchStore/GET_SEARCH_COMPANY", {
        searchWord : this.searchWord, 
        page : this.page});
    }

    // if(this.news.content.length > 30){
    //   this.news.content = this.news.content.substr(0, 31) + '...';
    // }

  },
  computed: {
    ...mapGetters({ 
      // searchWord:"searchStore/searchWord",
      news: "searchStore/news",
    })
  },
  methods : {
    ...mapActions([
      "GET_SEARCH_TITLE",
      "GET_SEARCH_CONTENT",
      "GET_SEARCH_COMPANY",
    ]),
  }
}

</script>

<style>
.carousel-inner {
  height: 25em;
}
.carousel-item {
  min-height: 15em;
  margin: 1em;
  /* border: 1px solid black; */
}
.ellipsis {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}
img{
  width:300px;
  height: 220px;
  object-fit: cover;
}
</style>