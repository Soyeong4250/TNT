<template>
	<div class="page">
		<b-form @submit="onSubmit" @reset="onReset">
      <b-container class="ml-5 inputBox">
        <table class="view-table">
          <colgroup>
            <col style="width: 20%" />
            <col style="width: 80%" />
          </colgroup>
          <tr class="view-table-content">
            <th>제목</th>
            <td>
              <b-form-input ref="title" v-model="title" placeholder="제목 입력">{{ title }}</b-form-input>
            </td>
          </tr>
          <tr class="view-table-content">
            <th>내용</th>
            <td>
              <b-form-textarea
                class="view-table-textarea"
                :value="content"
                v-model="content"
                placeholder="내용 입력..."
                rows="18"
                max-rows="15"
              >{{ content }}</b-form-textarea
            ></td>
          </tr>
        </table>
      </b-container>
      <div class="hr"/>
      <b-container style="padding-top: 15px" class="view-btn-group">
        <b-button type="submit" class="p-1" variant="primary" v-if="this.type=='write'">
          글작성
        </b-button>
        <b-button type="submit" class="p-1" variant="primary" v-else-if="this.type=='modify'">글수정</b-button>
        <b-button type="reset" class="p-1" variant="danger">목록</b-button>
      </b-container>
    </b-form>
	</div>
</template>

<script>
import http from "@/util/http-common";
import { mapGetters } from "vuex";

export default {
	data() {
		return {
      notice : {},
      no : "",
      writer : "",
      title : "",
      content : "",
		}
	},
	props: {
    type: String,
  },
  computed: {
    ...mapGetters({userinfo: "accountStore/GET_USER_INFO"}),
  },
  created() {
    if (this.userinfo.role != 'A') {
      alert("관리자만 접근할 수 있습니다.");
      this.$router.push({ name: "NoticeList" });
    }

    if (this.type == "modify") {
      // this.getNotice(`/notice/${this.$route.params.no}`);
      http.get(`/notice/${this.$route.params.no}`).then(({data}) => {
				console.log(data);
        // this.notice = data;
        this.no = data.no;
        this.writer = data.writer;
				this.title = data.title;
        this.content = data.content;
			})
			.catch((error) => {
				console.log(error);
			});
    }
  },
  methods: {
    // getNotice(no) {
		// 	http.get(no).then(({data}) => {
		// 		console.log(data);
		// 		this.title = data.title;
    //     this.content = data.content;
		// 	})
		// 	.catch((error) => {
		// 		console.log(error);
		// 	});
		// },
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      err &&
        !this.title &&
        ((msg = "제목 입력해주세요"),
        (err = false),
        this.$refs.title.focus());
      err &&
        !this.content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else this.type === "write" ? this.writeNotice() : this.modifyNotice();
    },
    onReset(event) {
      event.preventDefault();
      this.userid = "";
      this.title = "";
      this.content = "";
      this.$router.push({
                name : "NoticeList",
                params: {page: 1}
        });
    },
    writeNotice() {
      console.log(this.userinfo);
        http.post(`/notice/`, {
          title : this.title,
          writer : this.userinfo.id,
          content : this.content,
        }).then((data) => {
          let msg = "글 등록 처리시 문제가 발생했습니다.";
          if(data.status == 200) {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        }).catch(({error}) => {
          console.log(error);
        });
    },
    modifyNotice() {
      http
        .put(`/notice/${this.$route.params.no}`, {
          no : this.no,
          writer : this.writer,
          title: this.title,
          content: this.content,
        })
        .then((data) => {
          console.log(this.$route.params.no);
          console.log(data);
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data.status == 200) {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        });
    },
    moveList() {
      this.$router.push({
                name : "NoticeList",
                params: {page: 1}
        });
    },
  },
};
</script>

<style>
.inputBox {
  height: 35em;
}
.view-table {
  width: 90%;
  height: 100%;
  margin: 1em;
  border-spacing: 10px;
}
.view-table-content {
  padding: 10px;
}
.view-table td {
  border: none;
  padding: 0.5em;
}
.view-table th {
  border-right: 1px solid #0f4c82;
}
.view-table-textarea {
  min-height: 200px;
}
.hr {
  border: 0;
  height: 0.1em;
  background-color: #0f4c82;
  margin-top: 1em;
}
.view-btn-group {
  padding: 1em;
  margin: 0;
  text-align: right;
}
.btn {
  width: 5em;
  height: 2em;
  color: white;
  border: 0;
  border-radius: 4px;
  margin: 0.5em;
}
</style>