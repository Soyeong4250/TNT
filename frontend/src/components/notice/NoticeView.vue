<template>
	<b-container class="page">
		<div>
      <table class="view-table">
        <colgroup>
          <col style="width: 20%" />
          <col style="width: 80%" />
        </colgroup>
        <tr class="view-table-content">
					<th>제목</th>
          <td
            ><b-form-input v-model="notice.title"> {{ notice.title }}</b-form-input>
						</td
          >
        </tr>
        <tr class="view-table-content">
          <th>내용</th>
          <td>
            <b-form-textarea
              class="view-content"
              v-model="notice.content"
              rows="18"
              max-rows="15"
              readonly
              >{{ notice.content }}</b-form-textarea
            ></td
          >
        </tr>
      </table>
		</div>
		<div class="hr"/>
		<b-container style="padding-top: 15px" class="view-btn-group">
      <!-- <div
				style="padding-top: 15px"
				class="view-btn-group"
				v-if="isUpdate === true"
				>
				<router-link
					:to="`/notice/modify/${this.$route.params.no}`"
					class="btn"
					>수정</router-link
				>
				<a href="#" class="btn" @click="deleteNotice">삭제</a>
				<router-link to="/notice" class="btn">목록</router-link>
			</div> -->
				<b-button type="submit" class="p-1" variant="primary" @click="moveList()">목록</b-button>
    </b-container>
	</b-container>
</template>

<script>
// import { mapGetters } from 'vuex';
import http from "@/util/http-common.js";

export default {
	data() {
		return {
			no : this.$route.params.no,
			notice : {},
		}
	},
	computed: {
		
	},
  created() {
		console.log("created")
		this.getNotice(`/notice/${this.no}`);
		// console.log(this.notice.title);
		console.log("createdEnd");
	},
	methods: {
		getNotice(no) {
			http.get(no).then(({data}) => {
				console.log(data);
				this.notice = data;
			})
			.catch((error) => {
				console.log(error);
			});
		},
		moveList() {
			this.$router.push("/notice");
		},
	}
};
</script>
<style>
.page {
	height: 45em;
}

th, td {
	text-align: center;
}

.view-btn-group {
  padding: 1em;
  margin: 0;
  text-align: right;
}

</style>