<template>
	<div>
		<main-search></main-search>
		<div v-if="this.news.length!=0">
			<div id="newsPage" class="topNews">
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
									<div v-if="this.news[0].tumbnailUrl!=null" class="col-md-4">
										<img :src="this.news[0].tumbnailUrl" class="newsImg" alt="..." data-bs-toggle="modal" :data-bs-target="'#newsModal'+0">
									</div>
									<div class="col-md-8">
										<div class="card-body">
											<h5 class="card-title" data-bs-toggle="modal" :data-bs-target="'#newsModal'+0">{{ this.news[0].title }}</h5>
											<p class="card-text" data-bs-toggle="modal" :data-bs-target="'#newsModal'+0">
												{{ this.newsContent[0] }}
											</p>
											<p class="card-text">
												<small class="text-muted">{{ changeDateFormat1 }}</small>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Modal -->
						<div class="modal fade" :id="'newsModal'+0" tabindex="-1" aria-labelledby="newsModalLabel" aria-hidden="true">
							<div class="modal-dialog modal-lg modal-dialog-scrollable">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="newsModalLabel">{{ this.news[0].title }}</h5>
										<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
											<p>{{	 this.news[0].company	}}</p>
											<img class="modal-image mx-auto" :src=" this.news[0].tumbnailUrl" alt="tumbnail" style="width: 100%; height: 100%;">
											<div>{{	this.news[0].content	}}</div>
											<div style="text-align:right; padding-left: 1em; padding-top: 1em">{{	this.news[0].reporter }}</div>
											<div style="text-align:right; padding-left: 1em; padding-top: 1em">{{	this.news[0].company	}}</div>
									</div>
									<div class="modal-footer">
										<a :href="this.news[0].newsUrl" class="btn btn-primary btn-md">원문보러가기</a>
										<!-- <span>기사 원문 : <a :href=" this.news[0].newsUrl">{{ this.news[0].newsUrl }}</a></span> -->
											
									</div>
								</div>
							</div>
						</div>
						<div class="carousel-item">
							<div class="card mb-3 newsCard">
								<div class="row g-0">
									<div v-if="this.news[1].tumbnailUrl!=null" class="col-md-4">
										<img :src="this.news[1].tumbnailUrl" class="newsImg" alt="..." data-bs-toggle="modal" :data-bs-target="'#newsModal'+1">
									</div>
									<div class="col-md-8">
										<div class="card-body">
											<h5 class="card-title" data-bs-toggle="modal" :data-bs-target="'#newsModal'+1">{{ this.news[1].title }}</h5>
											<p class="card-text" data-bs-toggle="modal" :data-bs-target="'#newsModal'+1">
												{{ this.newsContent[1] }}
											</p>
											<p class="card-text">
												<small class="text-muted">{{ changeDateFormat2 }}</small>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Modal -->
						<div class="modal fade" :id="'newsModal'+1" tabindex="-1" aria-labelledby="newsModalLabel" aria-hidden="true">
							<div class="modal-dialog modal-lg modal-dialog-scrollable">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="newsModalLabel">{{ this.news[1].title }}</h5>
										<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
											<p>{{	 this.news[1].company	}}</p>
											<img class="modal-image mx-auto" :src=" this.news[1].tumbnailUrl" alt="tumbnail" style="width: 100%; height: 100%;">
											<div>{{	this.news[1].content	}}</div>
											<div style="text-align:right; padding-left: 1em; padding-top: 1em">{{	this.news[1].reporter }}</div>
											<div style="text-align:right; padding-left: 1em; padding-top: 1em">{{	this.news[1].company	}}</div>
									</div>
									<div class="modal-footer">
										<a :href="this.news[1].newsUrl" class="btn btn-primary btn-md">원문보러가기</a>
									</div>
								</div>
							</div>
						</div>
						<div class="carousel-item">
							<div class="card mb-3 newsCard">
								<div class="row g-0">
									<div v-if="this.news[2].tumbnailUrl!=null" class="col-md-4">
										<img :src="this.news[2].tumbnailUrl" class="newsImg" alt="..." data-bs-toggle="modal" :data-bs-target="'#newsModal'+2">
									</div>
									<div class="col-md-8">
										<div class="card-body">
											<h5 class="card-title" data-bs-toggle="modal" :data-bs-target="'#newsModal'+2">{{ this.news[2].title }}</h5>
											<p class="card-text" data-bs-toggle="modal" :data-bs-target="'#newsModal'+2">
												{{ this.newsContent[2] }}
											</p>
											<p class="card-text">
												<small class="text-muted">{{ changeDateFormat3 }}</small>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					<!-- Modal -->
						<div class="modal fade" :id="'newsModal'+2" tabindex="-1" aria-labelledby="newsModalLabel" aria-hidden="true">
							<div class="modal-dialog modal-lg modal-dialog-scrollable">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="newsModalLabel">{{ this.news[2].title }}</h5>
										<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
											<p>{{	 this.news[2].company	}}</p>
											<img class="modal-image mx-auto" :src=" this.news[2].tumbnailUrl" alt="tumbnail" style="width: 100%; height: 100%;">
											<div>{{	this.news[2].content	}}</div>
											<div style="text-align:right; padding-left: 1em; padding-top: 1em">{{	this.news[2].reporter }}</div>
											<div style="text-align:right; padding-left: 1em; padding-top: 1em">{{	this.news[2].company	}}</div>
									</div>
									<div class="modal-footer">
											<a :href="this.news[2].newsUrl" class="btn btn-primary btn-md">원문보러가기</a>
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
			<div id="newsPage" v-if="this.news!==[]">
				<b-row>
				<b-col v-if="this.newsArr.length">
				<b-table-simple hover responsive outlined>
				<b-thead head-variant="light">
				<colgroup>
				<col style="width: 85%"/>
				<col style="width: 15%"/>
				</colgroup>
				</b-thead>
				<b-tbody>
				<news-list-item v-for="(n, index) in newsArr" 
					:key="index"
					:index="index+3"
					:category="n.category" 
					:company="n.company" 
					:date="n.date" 
					:url="n.newsUrl" 
					:reporter="n.reporter" 
					:title="n.title" 
					:tumbnailUrl="n.tumbnailUrl" 
					:content="n.content"/>
				</b-tbody>
				</b-table-simple>
				</b-col>
				</b-row>
			</div>
			<!-- pagenation -->
			<div class="overflow-auto">
					<b-pagination
						v-model= "this.currentPage"
						:total-rows="this.rows"
						:per-page="this.perPage"
						aria-controls="newsPage"
						class="justify-content-center"
						@page-click="pageClick"
					></b-pagination>
			</div>
		</div>
		<!-- <news-modal class="modal fade bd-example-modal-lg" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" /> -->
		<div v-else>
			<b-table-simple hover responsive outlined>
				<b-tbody>
					<b-td class="text-center" colspan="4" style="padding: 3em;">
						<img src="@/assets/caution.png" alt="caution.png">
						<b>등록된 기사가 없습니다.</b>
					</b-td>
				</b-tbody>
			</b-table-simple>
		</div>
	</div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex';
import NewsListItem from "@/components/news/NewsListItem.vue";
import MainSearch from "@/components/main-search.vue";
import dayjs from "dayjs";

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
			rows : 52,
			perPage: 1,
			currentPage: Number(this.$route.params.page),
    }
  },
  created() {
    if(this.selected == '제목'){
      this.$store.dispatch("searchStore/GET_SEARCH_TITLE",{
        searchWord : this.searchWord, 
        page : this.$route.params.page});
    } else if(this.selected == "내용") {
      this.$store.dispatch("searchStore/GET_SEARCH_CONTENT", {
        searchWord : this.searchWord, 
        page : this.$route.params.page});
    } else if(this.selected == "언론사") {
      this.$store.dispatch("searchStore/GET_SEARCH_COMPANY", {
        searchWord : this.searchWord, 
        page : this.$route.params.page});
    }

		if(this.news != null) {			   

			setTimeout(()=>{
				for(let i =0; i<3; i++){
				this.newsContent[i] = this.news[i].content.substr(0, 300)+'...';      
			} 
				for(let i=3; i<this.news.length; i++){
					this.newsArr[i-3] = this.news[i];
				}
			},400);
		}
    console.log(this.newsArr);
    // if(this.news.content != null){
    //   this.news.content = this.news.content.substr(0, 31) + '...';
    // }
  },
	mounted() {
		
	},
  computed: {
    ...mapGetters({ 
      // searchWord:"searchStore/searchWord",
      news: "searchStore/news",
    }),
	changeDateFormat1() {
			return dayjs(this.news[0].date).format("YYYY.MM.DD");
		},
		changeDateFormat2() {
			return dayjs(this.news[1].date).format("YYYY.MM.DD");
		},
		changeDateFormat3() {
			return dayjs(this.news[2].date).format("YYYY.MM.DD");
		},
  },
  methods : {
    ...mapActions([
      "GET_SEARCH_TITLE",
      "GET_SEARCH_CONTENT",
      "GET_SEARCH_COMPANY",
    ]),
	pageClick: function (button, page){
		this.currentPage = page;
		this.changePage(page);
	},
	changePage(page) {
		this.$router.push({
                name : "Search",
                params: {selected : this.selected, searchWord : this.searchWord, page: page}
        });
	},
	
  }
}
</script>
<style scoped>
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
.btn{
	display: block;
	width: 10em;
}
</style>