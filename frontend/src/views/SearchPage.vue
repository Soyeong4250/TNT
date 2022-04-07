<template>
<div>
	<main-search></main-search>
	<div class="topNews">
		<h3>"<b>{{ this.searchWord }}</b>"에 대한 검색결과</h3>
		<!-- 캐러셀을 이용한 topNews -->
		<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<div class="card mb-3 newsCard">
						<div class="row g-0">
							<div class="col-md-4">
								<img :src="this.news[0].tumbnailUrl" class="newsImg" alt="...">
							</div>
							<!--<div id="img1" class="col-md-4" :style="backgroundimage=url(this.news[0].tumbnailUrl)"> -->
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">{{ this.news[0].title }}</h5>
									<p class="card-text">
										{{ this.newsContent[0] }}
									</p>
									<p class="card-text">
										<small class="text-muted">{{ this.news[0].date}}</small>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<div class="card mb-3 newsCard">
						<div class="row g-0">
							<div class="col-md-4">
								<img :src="this.news[1].tumbnailUrl" class="newsImg" alt="...">
							</div>
							<!--<div id="img1" class="col-md-4" :style="backgroundimage=url(this.news[0].tumbnailUrl)"> -->
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">{{ this.news[1].title }}</h5>
									<p class="card-text">
										{{ this.newsContent[1] }}
									</p>
									<p class="card-text">
										<small class="text-muted">{{ this.news[1].date}}</small>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<div class="card mb-3 newsCard">
						<div class="row g-0">
							<div class="col-md-4">
								<img :src="this.news[2].tumbnailUrl" class="newsImg" alt="...">
							</div>
							<!--<div id="img1" class="col-md-4" :style="backgroundimage=url(this.news[0].tumbnailUrl)"> -->
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">{{ this.news[2].title }}</h5>
									<p class="card-text">
										{{ this.newsContent[2] }}
									</p>
									<p class="card-text">
										<small class="text-muted">{{ this.news[2].date}}</small>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<!-- <span class="carousel-control-prev-icon" aria-hidden="true"></span> -->
			<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<!-- <span class="carousel-control-next-icon" aria-hidden="true"></span> -->
			<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>
	<!--뉴스 리스트-->
	<div>
		<b-row>
		<b-col v-if="this.news.length">
		<b-table-simple hover responsive outlined>
		<b-thead head-variant="light">
		<colgroup>
		<col style="width: 85%"/>
		<col style="width: 15%"/>
		</colgroup>
		</b-thead>
		<b-tbody>
		<news-list-item v-for="(n, index) in newsArr" :key="index" :cnt="`${index + 1}`" :category="n.category" :company="n.company" :date="n.date" :url="n.newsUrl" :reporter="n.reporter" :title="n.title" :tumbnailurl="n.tumbnailUrl"/>
		</b-tbody>
		</b-table-simple>
		</b-col>
		</b-row>
	</div>
	<!-- <news-modal class="modal fade bd-example-modal-lg" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" /> -->
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
      newsContent : [],
      newsArr: [],
      selected : this.$route.params.selected,
      searchWord : this.$route.params.searchWord,
      page : 1,
      // content: "",
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
    for(let i =0; i<3; i++){
      this.newsContent[i] = this.news[i].content.substr(0, 300)+'...';      
    }
    for(let i=3; i<this.news.length; i++){
      this.newsArr[i-3] = this.news[i];
    }
    console.log(this.newsArr);
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
  /* min-height: 15em; */
  margin: 1em;
  margin-bottom: 20px;
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
.newsImg{
  width:100%;
  height:100%;
  max-height: 300px;
  object-fit: contain;
}
.newsCard{
  height: 300px;
}
</style>