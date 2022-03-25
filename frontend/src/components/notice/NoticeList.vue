<template>
	<b-container>
		<b-row class="mb-1">
			<b-col class = "text-right">
				<button class="btn" @click="moveWrite()"> 글쓰기 </button>
			</b-col>
		</b-row>
		<b-row>
			<b-col v-if="notices.length">
				<b-table-simple hover responsive outlined>
					<b-thead head-variant="light">
						<colgroup>
							<col style="width: 10%" />
							<col style="width: 50%" />
							<col style="width: 20%" />
							<col style="width: 20%" />
						</colgroup>
						<b-tr>
							<b-th>글번호</b-th>
							<b-th>제목</b-th>
							<b-th>작성자</b-th>
							<b-th>등록일</b-th>
						</b-tr>
					</b-thead>
					<b-tbody>
						<notice-list-item
							v-for="(notice, index) in notices"
							:key="index"
							:noticeno="notice.noticeNo"
							:noticetitle="notice.noticeTitle"
							:login_id="notice.login_id"
							:noticeDate="notice.noticeDate"
							/>
					</b-tbody>
				</b-table-simple>
			</b-col>
			<b-col v-else>
				<b-table-simple hover responsive outlined>
					<b-thead head-variant="light">
						<colgroup>
							<col style="width: 10%" />
							<col style="width: 50%" />
							<col style="width: 20%" />
							<col style="width: 20%" />
						</colgroup>
						<b-tr>
							<b-th>글번호</b-th>
							<b-th>제목</b-th>
							<b-th>작성자</b-th>
							<b-th>등록일</b-th>
						</b-tr>
					</b-thead>
					<b-tbody>
						<b-td class="text-center">등록된 글이 없습니다.</b-td>
					</b-tbody>
				</b-table-simple>
			</b-col>
		</b-row>
	</b-container>
</template>

<script>
import NoticeListItem from "@/components/notice/child/NoticeListItem.vue";
import { mapGetters } from "vuex";


export default {
	components: {
		NoticeListItem,
	},
	data(){
		return{};
	},
	computed: {
		...mapGetters(["notices"]),
	},
	created() {
		this.$store.dispatch("getNoticeList");
	},
	methods: {
		moveWrite() {
			this.$router.push({ name:"NoticeWrite" });
		},
	},
};
</script>

<style>

</style>