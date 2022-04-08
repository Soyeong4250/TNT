<template>
        <!-- 내용 -->
        <span class="today-keyword"><i class="fas fa-signal"></i> 오늘의 키워드</span>
        <span class="news-count"><i class="fas fa-newspaper"></i> 언론사별 기사수</span>
        <div id = "keyword-box">
            <!-- <h5>this.keywordRank : {{ keywordRank }}</h5> -->
            <!-- <h5>{{ this.rank5 }}</h5> -->
            <div id="keyword-inbox">
                <div class="row">
                    <div class="col-6" >
                        <div class = "rank-box card" v-for="(rank, index) in this.rank0" :key="index">
                            <div class="ranking card-body" pill variant = "secondary"> 
                             <span class="ranking-index">{{ index+1 }}</span>{{ rank.value }}
                            <span class="badge rounded-pill bg-primary">{{rank.count}}</span>
                            </div>
                        </div>
                    </div>
                    <div class ="col-6" >
                        <div class ="rank-box card"  v-for="(rank, index) in this.rank5" :key="index">
                            <div class="ranking card-body" pill variant = "secondary"> 
                                <!-- {{ rank.rank }}   {{rank.content}} {{rank.change}} -->
                            <span class="ranking-index">{{ index+6 }}</span> {{ rank.value }}
                            <span class="badge rounded-pill bg-primary">{{rank.count}}</span>
                        </div>
                            
                        </div>
                    </div>
                </div>
            </div>
            <div class="articleNumber" style="width:40%">
                <div class="artnum">
                    <table class="mx-auto result_table">
                        <tbody id="article-number">
                            <tr class="result_row" v-for="(company, index) in this.companyCnt" :key="index">
                                <td>{{ index+1 }}</td>
                                <td class="result_value">{{ company.news_company }}</td>
                                <td>&nbsp;&nbsp;&nbsp;{{ company.count }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>





</template>

<script>
import http from "@/util/http-common.js";
import { mapGetters } from 'vuex';
export default {
    data() {
        return {
            categories:  [],
            rank0: [],
            rank5: [],
            companyCnt: [],
        }
    },
    computed: {
        ...mapGetters({
           keywordRank: "keywordStore/keywordRank",
        // keywordWord: "keywordStore/keywordWord",
        })
    },
    created() {
        this.$store.dispatch("keywordStore/GET_UPDATE_KEYWORD");
        this.rank0 = this.keywordRank.slice(0, 5);
        this.rank5 = this.keywordRank.slice(5,10);
    },
    mounted() {
        this.getCompanyCnt();
    },
    methods: {
        getCompanyCnt() {
            http.get(`/news/find/company/count`)
            .then((response) => {
                //console.log("언론사별 cnt 결과")
				//console.log(response.data);
				this.companyCnt = response.data.slice(0, 10);
			})
			.catch(() => {
				//console.log(error);
			});
        }
    }
}
</script>

<style scoped>
#keyword-box{
    display: flex;
    margin-left:10%;
    width : 100%;
    height: auto;
    /* box-shadow: 1px 1px 1px 1px gray; */
}
.cateBtn{
    text-align: center;
}
.button {
    margin-bottom: 1.5em;
    width: 6.5em;
}
#keyword-inbox{
    border : 0.5px solid rgb(227, 227, 227);
    height : 20%;
    width: 60%;
    margin :5px;
}

.rank-box{
    width : 100%;
    /* display: inline-block; */
    text-align: center;
}
.ranking {
    width: 100%;
    font-family: 'NanumBarunGothicBold',sans-serif;
    font-size : 18px;
}

.card{
    -webkit-transition: all .9s ease;
    transition: all .9s ease;
}

.card:hover{
    background-color:rgb(86, 125, 252);
    color:white;
    -webkit-transform: scale(1.15);
    transform: scale(1.15);
}

.ranking-index{
    color:blue;
    font-family: 'NanumBarunGothicBold',sans-serif;
    font-size : 18px;
    float:left;
}

.articleNumber {
    width:40%;
    margin-right: 15%;
}
.result_table{
  border-collapse: separate;
  border-spacing: 0 10px;
}
.result_value{
    font-weight: bold;
}
.news-count{
    margin-right: 15%;
    float:right;
    font-family: 'NanumBarunGothicBold',sans-serif;
    font-size : 18px;
    margin-bottom: 20px;
}
.today-keyword{
    margin-left: 10%;
    font-family: 'NanumBarunGothicBold',sans-serif;
    font-size : 18px;
    margin-bottom: 20px;
}

.fa-signal{
    color: blue;
}

.fa-newspaper{
    color:blue;
}

.badge {
    float: right;
    text-align: center;
}
/* #artnum {
    position: relative;
    width: 30%;
    left : 5%;
    float:"left";
}
#keynum {
    position: relative;
    width: 30%;
    left: 30%;
    bottom: 157px;
} */
</style>