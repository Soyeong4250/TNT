<template>
	<b-tr>
		<!-- <b-td>{{ cnt }}</b-td> -->
		<b-td class="text-left">
			{{ title }}
		</b-td>
		<b-td>{{ company }}</b-td>
		<!-- <b-td>{{ changeDateFormat }}</b-td> -->
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
		category: String,
		company: String,
		date: String,
		url: String,
		reporter: String,
		title: String,
		tumbnailUrl: String,
	},
	computed: {
		// changeDateFormat() {
		// 	// return moment(new Date(this.date)).format("YY.MM.DD");
		// 	return dayjs(this.date).format("YYYY.MM.DD");
		// },
	},
	
}
</script>

<style>
.title, .title:hover {
  text-decoration: none;
  color: black
}
</style>