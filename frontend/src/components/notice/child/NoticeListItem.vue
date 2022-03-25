<template>
	<b-tr>
		<b-td>{{ noticeno }}</b-td>
		<b-th class="text-left">
			<router-link 
			id="noticeTitle"
			:to="{name: 'NoticeView', 
			params: { noticeno: noticeno}}">
			{{noticeTitle}}
			</router-link>
		</b-th>
		<b-td>{{login_id}}</b-td>
		<b-td>{{ noticeDate }}</b-td>
	</b-tr>
</template>

<script>
import moment from "moment";

export default {
	props: {
		noticeno: Number,
		noticeTitle: String,
		login_id: String,
		noticeDate: String,
	},
	computed: {
		changeDateFormat() {
			return moment(new Date(this.noticeDate)).format("YYYY-MM-DD");
		},
	},
}
</script>

<style>

</style>