<template>
	<b-tr>
		<b-td>{{ cnt }}</b-td>
		<b-td class="text-left">
			<router-link 
			class="title"
			:to="{name:`NoticeView`, params: { no: no}}">
			{{ title }}
			</router-link>
		</b-td>
		<b-td>{{ writer }}</b-td>
		<b-td>{{ changeDateFormat }}</b-td>
	</b-tr>
</template>

<script>
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
			return dayjs(this.date).format("YYYY.MM.DD");
		},
	},
}
</script>

<style>
.title, .title:hover {
  text-decoration: none;
  color: black
}
</style>