<template>
        <!-- 내용 -->
        <div id = "keyword-box">
            <p>오늘의 키워드</p>
            <div class="cateBtn">
                <b-button class = "button" pill variant="outline-primary" :key="key.num" v-for="key in categories">
                    {{key.category}}
                </b-button>
            </div>
            <div id="keyword-inbox">
                <div class = "rank-box" v-for = "rank in ranks5" :key = "rank.rank" >
                    <!-- 순위 가져오기-->
                    <b-button class="ranking" pill variant = "secondary"> 
                    {{ rank.rank }}   {{rank.content}} {{rank.change}}
                    <!-- 순위 변화는 나중에 함수 구현 -->
                    </b-button>

                </div>
                <div class ="rank-box" v-for = "rank in ranks10" :key = "rank.rank" >
                    <!-- 순위 가져오기-->
                    <b-button class="ranking" pill variant = "secondary"> 
                    {{ rank.rank }}   {{rank.content}} {{rank.change}}
                    <!-- 순위 변화는 나중에 함수 구현 -->
                    </b-button>
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
export default {

data() {
    return {
        articles : [
                {name: "조선일보",
                num:100},
                {name : "동아일보",
                num:70},
                {name: "중앙일보",
                num:60},
                {name: "한겨레",
                num:30},
                {name: "경향신문",
                num:10},
                
                ],
                keywords : [
                {name: "삼성전자",
                num:100},
                {name : "삼성SDI",
                num:70},
                {name: "코로나19",
                num:60},
                {name: "싸피",
                num:30},
                {name: "삼성증권",
                num:10},
                
                ]
         
    }
},
    setup() {
        const categories =[
                { category : "전체",
                  num : 1},
                  { category : "정치",
                  num : 2},
                  { category : "경제",
                  num : 3},
                  { category : "사회",
                  num : 4},
                  { category : "생활/문화",
                  num : 5},
                  { category : "IT/과학",
                  num : 6},
                  { category : "오피니언",
                  num : 7},
                  
            ];
        const ranks5 = [{rank:1,
                    content : "삼성전자",
                    change : 0},
                    {rank:2,
                    content : "삼성전자",
                    change : 0},
                    {rank:3,
                    content : "삼성전자",
                    change : 0},
                    {rank:4,
                    content : "삼성전자",
                    change : 0},
                    {rank:5,
                    content : "삼성전자",
                    change : 0},
                    ];
        const ranks10 = [ {rank:6,
                    content : "삼성전자",
                    change : 0},
                    {rank:7,
                    content : "삼성전자",
                    change : 0},
                    {rank:8,
                    content : "삼성전자",
                    change : 0},
                    {rank:9,
                    content : "삼성전자",
                    change : 0},
                    {rank:10,
                    content : "삼성전자",
                    change : 0},
        ];
        return{
            categories,
            ranks5,
            ranks10
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
/* #keyword-inbox::after {
    content: '';
    display: block;
    clear: both;
} */
.rank-box{
    width : 50%;
    display: inline-block;
    text-align: center;
}
.ranking {
    width: 70%;
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