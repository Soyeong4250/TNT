<template>
	<b-tr>
		<b-td>{{ cnt }}</b-td>
		<b-td class="text-left">
			<router-link 
			id="title"
			:to="{name:`NoticeView`, params: { no: no}}">
			{{ title }}
			</router-link>
			<!-- <router-link 
			id="title"
			:to="{name: 'NoticeView', 
			params: { no: no}}">
			{{ title }}
			</router-link> -->
		</b-td>
		<b-td>{{ writer }}</b-td>
		<b-td>{{ changeDateFormat }}</b-td>
	</b-tr>
</template>

<script>
// import moment from "moment";
import dayjs from "dayjs";

export default {
	component: {
		dayjs,
	},
	data() {
		return {
			
		};
	},
	props: {
		no: Number,
		cnt: String,
		title: String,
		writer: String,
		date: String,
	},
	computed: {
		changeDateFormat() {
			// return moment(new Date(this.date)).format("YY.MM.DD");
			return dayjs(this.date).format("YYYY.MM.DD");
		},
	},
	// filters : {
	// 	changeDateFormat:function(value) {
	// 		if(value == '') return '';

	// 		// 현재 Date 혹은 DateTime 데이터를 javaScript date 타입화
	// 		var js_date = new Date(value);

	// 		// 연도, 월, 일 추출
	// 		var year = js_date.getFullYear();
	// 		var month = js_date.getMonth() + 1;
	// 		var day = js_date.getDate();

	// 		// 월, 일의 경우 한자리 수 값이 있기 때문에 공백에 0 처리
	// 		if(month < 10){
	// 			month = '0' + month;
	// 		}

	// 		if(day < 10){
	// 			day = '0' + day;
	// 		}

	// 		// 최종 포맷 (ex - '2021-10-08')
	// 		return year + '.' + month + '.' + day;
	// 	}
	// }
}
</script>

<style>

</style>