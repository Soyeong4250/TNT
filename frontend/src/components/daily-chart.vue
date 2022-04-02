<template>
    <div>
        <canvas id="chart" width="200" height="200"></canvas>
    </div>
</template>
<script>
import { Chart, BarElement, BarController, LinearScale, CategoryScale } from 'chart.js';
Chart.register(BarElement, BarController, LinearScale, CategoryScale);
export default {
    methods: {
        fillData() {
            const ctx = document.getElementById('chart').getContext('2d');
            this.myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ['조선일보', '중앙일보', '동아일보', '한겨레', '경향신문', '오마이신문'],
                    datasets: [
                        {
                            label: '기사 수',
                            data: [15, 10, 8, 5, 12, 3],
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
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
        this.fillData();
    },
    data() {
        return {
            myChart: null
        };
    }
};
</script>

<style scoped>
#chart{
    width : 200px;
}
</style>