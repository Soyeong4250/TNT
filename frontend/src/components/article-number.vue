<template>
  <div id="artnum">
    <table>
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

  <div id="keynum">
    <table>
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
    }
}
</script>

<style scoped>
#artnum {
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
}
</style>