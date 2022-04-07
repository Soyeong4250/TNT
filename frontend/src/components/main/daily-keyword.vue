<template>
        <!-- 내용 -->
        <div id = "keyword-box">
            <!-- <h5>this.keywordRank : {{ keywordRank }}</h5> -->
            <!-- <h5>{{ this.rank5 }}</h5> -->
            <h3 style="width: 95%; padding-left: 1em; color:#1f57f1; font-weight:bold">오늘의 키워드</h3>
            <div id="keyword-inbox" style="display:flex">
                <div class="flex-container column mx-auto my-auto" >
                    <div class = "rank-box" v-for="(rank, index) in this.rank0" :key="index">
                        <b-button class="ranking" pill variant = "secondary"> 
                        {{ index+1 }} {{ rank.value }}
                        </b-button>
                        
                    </div>
                </div>
                <div class="flex-container column mx-auto my-auto" >
                    <div class ="rank-box "  v-for="(rank, index) in this.rank5" :key="index">
                    <b-button class="ranking" pill variant = "secondary"> 
                        <!-- {{ rank.rank }}   {{rank.content}} {{rank.change}} -->
                     {{ index+6 }} {{ rank.value }}
                    </b-button>
                        
                </div>
                </div>
            </div>
            <div class="articleNumber d-flex" style="width:95%; padding:1em;">
                <div class="artnum">
                    <table class="mx-auto result_table">
                        <thead>
                            <th colspan="2">언론사별 기사 수</th>
                        </thead>
                        <tbody id="article-number">
                            <tr class="result_row" v-for="(company, index) in this.companyCnt" :key="index">
                                <td>{{ index+1 }}</td>
                                <td class="result_value">{{ company.news_company }}</td>
                                <td>{{ company.count }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="keynum">
                    <table class="mx-auto result_table">
                        <thead>
                            <th colspan="2">키워드 개수</th>
                        </thead>
                        <tbody id="article-number">
                            <tr class="result_row" v-for="(keyword, index) in rank0" :key="index">
                                <td>{{ index+1 }}</td>
                                <td class="result_value">{{keyword.value}}</td>
                                <td>{{keyword.count}}</td>
                            </tr>
                            <tr v-for="(keyword, index) in rank5" :key="index">
                                <td>{{ index+1 }}</td>
                                <td>{{keyword.value}}</td>
                                <td>{{keyword.count}}</td>
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
                console.log("언론사별 cnt 결과")
				console.log(response.data);
				this.companyCnt = response.data.slice(0, 10);
			})
			.catch((error) => {
				console.log(error);
			});
        }
    }
}
</script>

<style scoped>
#keyword-box{
    width : 100%;
    height: auto;
    /* box-shadow: 1px 1px 1px 1px gray; */
    padding : 1em;
}
.cateBtn{
    text-align: center;
}
.button {
    margin-bottom: 1.5em;
    width: 6.5em;
}
#keyword-inbox{
    border : solid 1px black;
    padding: 1em;
    height : 20em;
    width: 95%;
    margin: 0 auto;
}

.rank-box{
    width : 100%;
    margin-right : 30px;
    margin-bottom : 11px;
    /* display: inline-block; */
    text-align: center;
}
.ranking {
    width: 100%;
}

.artnum, .keynum {
    width: 50%;
}
.result_table{
  border-collapse: separate;
  border-spacing: 0 10px;
}
.result_value{
    font-weight: bold;
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