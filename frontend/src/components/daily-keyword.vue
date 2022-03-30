<template>
    <div>
        <div>
            <b-button class = "button" pill variant="outline-warning" :key="key.num" v-for="key in keywords"
            @click="functioncall">
                {{key.category}}
            </b-button>
        </div>

        <!-- 내용 -->
        <div id = "keyword-box">
            <p>오늘의 키워드</p>
            <div id="keyword-inbox">
                <div class = "rank-box" v-for = "rank in ranks5" :key = "rank.rank" >
                    <!-- 순위 가져오기-->
                    <b-button class="ranking" pill variant = "secondary"> 
                    {{ rank.rank }}   {{rank.content}} {{rank.change}}
                    <!-- 순위 변화는 나중에 함수 구현 -->
                    </b-button>

                </div>
                <div class ="rank-box2" v-for = "rank in ranks10" :key = "rank.rank" >
                    <!-- 순위 가져오기-->
                    <b-button class="ranking" pill variant = "secondary"> 
                    {{ rank.rank }}   {{rank.content}} {{rank.change}}
                    <!-- 순위 변화는 나중에 함수 구현 -->
                    </b-button>

                </div>
            </div>
        </div>
        
    </div>



</template>

<script>
export default {


    data() {
        return {
            keywords :[
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
                  
            ],

            ranks5 : [{rank:1,
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
                    ],
                ranks10 : [ {rank:6,
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
                ]
        }
    }
}
</script>

<style>
.button {
    margin-right: 30px;
    margin-bottom: 30px;
    width: 100px;
}

#keyword-box{
    width : 35em;
    height: auto;
    box-shadow: 1px 1px 1px 1px gray;
    padding : 10px;
}

#keyword-inbox{
    border : solid 1px black;
    padding : 20px;
    height : 320px;
}

.rank-box{
    width : 230px;
}

.rank-box2{
    position: relative;
    width : 230px;
    left : 230px;
    bottom :  290px;
}
.ranking {
    margin-bottom: 20px;
    margin-left : 30px;
    width:170px;

}

</style>