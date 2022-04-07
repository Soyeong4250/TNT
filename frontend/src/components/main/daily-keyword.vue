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
                    <table class="mx-auto">
                        <thead>
                            <th colspan="2">언론사별 기사 수</th>
                        </thead>
                        <tbody id="article-number">
                            <tr :key="article" v-for="article in articles">
                                <td>{{article.name}}</td>
                                <td>{{article.num}}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="keynum">
                    <table class="mx-auto">
                        <thead>
                            <th colspan="2">키워드 개수</th>
                        </thead>
                        <tbody id="article-number">
                            <tr :key="keyword" v-for="keyword in keywords">
                                <td>{{keyword.name}}</td>
                                <td>{{keyword.num}}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>





</template>

<script>
import { mapGetters } from 'vuex';
export default {
    setup() {
        const ranks5 = [];
        const ranks10 = [];
        return{
            ranks5,
            ranks10
        }
    },

    data() {
        return{
            categoriess: [
                { category : "전체", num : 1},
                { category : "정치", num : 2},
                { category : "경제", num : 3},
                { category : "사회", num : 4},
                { category : "생활/문화", num : 5},
                { category : "IT/과학", num : 6},
                { category : "오피니언", num : 7},
            ],
            rank0: [],
            rank5: [],
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