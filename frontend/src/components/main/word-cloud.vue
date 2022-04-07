<template>
  <div id="word-cloud" ></div>
</template>

<script>

import { mapGetters } from 'vuex';
export default {    
    data() {  
    return {
     words: [
        
      ],
    }
    },
     mounted() {
         console.log(this.keywordRank);
           this.keywordRank.forEach((keyword) => {
            this.words.push({text:keyword.value,size:40});
        }); 
        console.log(this.words);  
    this.genLayout();
  },
  computed: {
        ...mapGetters({
           keywordRank: "keywordStore/keywordRank",
        // keywordWord: "keywordStore/keywordWord",
        })
    },
  methods: {
    genLayout() {
        console.log("!!!!!!!!!");
      const cloud = require("d3-cloud");
      cloud()
        .words(this.words)
        .padding(1)
        .font("Impact")
        .fontSize(function (d) {
          return d.size;
        })
        .on("end", this.end)
        .spiral("archimedean")
        .start()
        .stop();
    },
    end(words) {
      const d3 = require("d3");
      const width = 300;
      const height = 300;
      d3.select("#word-cloud")
        .append("svg")
        .attr("width", width)
        .attr("height", height)
        .style("background", "white")
        .append("g")
        .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")") // g를 중심에서 단어들을 그리기 때문에 g를 svg 중심으로 이동
        .selectAll("text")
        .data(words)
        .enter()
        .append("text")
        .style("font-size", (d) => {
          return d.size + "px";
        })
        .style("font-family", "Impact")
        .attr("text-anchor", "middle")
        .attr("transform", (d) => {
          return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
        })
        .text((d) => d.text);
    },
  }
}
  
</script>

<style>

</style>