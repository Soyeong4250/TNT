<template>
    <div class="chartPage">
        <canvas id="chart" height="100%"></canvas>
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
                    labels: ['전체', '정치', '경제', '사회', '생활/문화', 'IT/과학', '오피니언'],
                    datasets: [
                        {
                            label: '기사 수',
                            data: [15, 10, 8, 5, 12, 3, 4],
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)',
                                'rgba(215, 139, 214, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)',
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
.chartPage {
    width: 100%;
    height: 720px;
    padding: 2em 1em 5.5em 1em;
}
</style>