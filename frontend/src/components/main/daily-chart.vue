<template>
    <span class="chart-name"><i class="fas fa-chart-bar"></i>&nbsp;기사 개수 차트</span>
    <div class="chartPage">
        <canvas id="chart" height="100%"></canvas>
    </div>
</template>
<script>
import http from "@/util/http-common.js";
import { Chart, BarElement, BarController, LinearScale, CategoryScale } from 'chart.js';
Chart.register(BarElement, BarController, LinearScale, CategoryScale);
export default {
     data() {
        return {
            myChart: null,
            // dataCnt : [{category: null, cnt: 0}],
            dataCnt : [],
        };
    },
    created(){
        this.getChartData();
    },
    methods: {
        getChartData() {
            http.get(`/news/find/category/count`)
            .then((response) => {
                //console.log(response.data);
                // Object.keys(response.data).forEach((d)=>{
                //   this.dataCnt.push({
				// 	category: d,
				// 	cnt: response.data[d],
				// })
                this.dataCnt = response.data;
                //console.log("전체 출력 : "+ this.dataCnt.전체);
                //console.log(typeof(this.dataCnt.전체));
            })
            .catch(() => {
                //console.log(error);
            })
        },
        fillData() {
            const ctx = document.getElementById('chart').getContext('2d');
            //console.log("나오나요"+this.dataCnt['전체']);
            //console.log("전달 ; "+chartData);
            this.myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ['정치', '경제', '사회', '생활/문화', 'IT/과학', '오피니언'],
                    datasets: [
                        {
                            label: '기사 수',
                            data: [this.$data.dataCnt['정치'], this.$data.dataCnt['경제'], this.$data.dataCnt['사회'],this.$data.dataCnt['생활'] , this.$data.dataCnt['IT'], this.$data.dataCnt['오피니언']],
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                // 'rgba(255, 159, 64, 0.2)',
                                'rgba(215, 139, 214, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                // 'rgba(255, 159, 64, 1)',
                                'rgba(215, 139, 214, 1)'
                            ],
                            borderWidth: 3
                        }
                    ]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        }
    },
    
    mounted() {
        setTimeout(()=>{
            this.fillData(this.dataCnt);
        },200);
    },
};
</script>

<style scoped>
.chartPage {
    margin-left: 10%;
    margin-right: 10%;
    width: 70%;
    height: 500px;
    padding: 2em 1em 1em 1em;
}

.chart-name{
    margin-top: 30px;
    margin-left: 10%;
    font-family: 'NanumBarunGothicBold',sans-serif;
    font-size : 18px;
    margin-bottom: 20px;
}
.fa-chart-bar{
    color:blue
}
</style>