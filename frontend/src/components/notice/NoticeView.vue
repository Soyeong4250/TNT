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
            ><b-form-input v-model="notice.title" readonly style="background-color : white;"> {{ notice.title }}</b-form-input>
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
							style="background-color : white;"
              >{{ notice.content }}</b-form-textarea
            ></td
          >
        </tr>
      </table>
		</div>
		<div class="hr"/>
		<b-container style="padding-top: 15px" class="view-btn-group">
      <div
				style="padding-top: 15px"
				class="view-btn-group"
				v-if="this.userinfo != null && this.notice.writer== userinfo.id"
				>
				<b-button variant="primary" class="p-1" @click="moveModify()"> 수정 </b-button>
				<b-button variant="danger" class="p-1" @click="deleteNotice()"> 삭제 </b-button>
				
				<!-- <router-link to="/notice" class="btn">목록</router-link> -->
			</div>
				<b-button v-else type="submit" class="p-1" variant="primary" @click="moveList()">목록</b-button>
    </b-container>
	</b-container>
</template>

<script>
import { mapGetters } from 'vuex';
import http from "@/util/http-common.js";

export default {
	data() {
		return {
			no : this.$route.params.no,
			notice : {},
		}
	},
	computed: {
		...mapGetters({userinfo: "accountStore/GET_USER_INFO"}),
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
		deleteNotice() {
			http
        .delete(`/notice/${this.$route.params.no}`, {
          no : this.no,
          writer : this.writer,
          title: this.title,
          content: this.content,
        })
        .then((data) => {
          console.log(this.$route.params.no);
          console.log(data);
          let msg = "삭제 처리시 문제가 발생했습니다.";
          if (data.status == 200) {
            msg = "삭제가 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        });
		},
		moveModify() {
			this.$router.push({name:"NoticeModify",params:{no:this.no}});
		},
		moveList() {
			this.$router.push({
                name : "NoticeList",
                params: {page: 1}
        });
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