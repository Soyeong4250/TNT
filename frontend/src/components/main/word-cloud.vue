<template>
  <div class="d-flex" id="word-cloud"></div>
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
            this.words.push({text:keyword.value,size:keyword.count/170*100, color:this.randomRGB()});
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
        .size([1000, 500])
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
      const width = 800;
      const height = 460;
      d3.select("#word-cloud")
        .append("svg")
        .attr("width", width)
        .attr("height", height)
        .style("background", "white")        
        .style("border","1px solid black")
        .attr("class","mx-auto")
        .append("g")
        .attr("style", "width:50em;height:50em")
        .attr("transform", "translate(" + width/2 + "," + height/2 + ")") // g를 중심에서 단어들을 그리기 때문에 g를 svg 중심으로 이동
        .selectAll("text")
        .data(words)
        .enter()
        .append("text")
        .style("font-size", (d) => {
          return d.size +2 + "px";
        })
        .style("font-family", "Bold")
        .style("fill", (d)=>{return d.color;})
        .attr("text-anchor", "middle")
        .attr("transform", (d) => {
          return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
        })
        .text((d) => d.text);
    },
    randomRGB() {
      const r = parseInt(Math.random() * 255);
      const g = parseInt(Math.random() * 255);
      const b = parseInt(Math.random() * 255);
      return `rgb(${r}, ${g}, ${b})`;
    }
  }
}
  
</script>

<style>
</style>