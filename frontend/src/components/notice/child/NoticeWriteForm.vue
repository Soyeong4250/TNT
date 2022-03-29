<template>
	<div class="page">
		<b-form @submit="onSubmit" @reset="onReset">
      <b-container class="ml-5 inputBox">
        <table class="view-table">
          <colgroup>
            <col style="width: 20%" />
            <col style="width: 80%" />
          </colgroup>
          <b-tr class="view-table-content">
            <b-th>제목</b-th>
            <b-td
              ><b-form-input ref="subject" v-model="title"></b-form-input
            ></b-td>
          </b-tr>
          <b-tr class="view-table-content">
            <b-th>작성자</b-th>
            <b-td
              ><b-form-input
                ref="login_id"
                v-model="writer"
              ></b-form-input
            ></b-td>
          </b-tr>
          <b-tr class="view-table-content">
            <b-th>내용</b-th>
            <b-td>
              <b-form-textarea
                class="view-table-textarea"
                v-model="content"
                ref="content"
                placeholder="내용 입력..."
                rows="18"
                max-rows="15"
              ></b-form-textarea
            ></b-td>
          </b-tr>
        </table>
      </b-container>
      <div class="hr"/>
      <b-container style="padding-top: 15px" class="view-btn-group">
        <b-button type="submit" class="p-1" variant="primary" v-if="this.type == 'write'">
          글작성
        </b-button>
        <b-button type="submit" class="p-1" variant="primary" v-else>글수정</b-button>
        <b-button type="reset" class="p-1" variant="danger">취소</b-button>
      </b-container>
    </b-form>
	</div>
</template>

<script>
import http from "@/util/http-common";
// import {mapState} from "vuex";

export default {
	date() {
		return {
			no: 0,
			writer: "",
			title: "",
			content: "",

			isLoginid: false,
		}
	},
	props: {
    type: { type: String },
  },
  // computed: {
  //   ...mapState(["userInfo"]),
  // },
  created() {
    // if (this.userInfo === null) {
    //   alert("로그인을 해주세요.");
    //   this.$router.push({ name: "Login" });
    // }

    if (this.type === "modify") {
      http.get(`/notice/api/${this.$route.params.no}`).then(({ data }) => {
        this.writer = data.writer;
        this.title = data.title;
        this.content = data.content;
      });
      this.isLoginid = true;
    }
    // } else {
    //   this.login_id = this.userInfo.login_id;
    // }
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      !this.writer &&
        ((msg = "작성자 입력해주세요"),
        (err = false),
        this.$refs.writer.focus());
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
      this.no = 0;
      this.title = "";
      this.content = "";
      this.$router.push({ name: "NoticeList" });
    },
    writeNotice() {
      http
        .post(`/notice/api/`, {
          title: this.title,
          writer: this.writer,
          content: this.content,
          // date : this.date,
        })
        .then(({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          console.log(msg);
          this.moveList();
        })
        .catch(({ error }) => {
          console.log(error);
        });
    },
    modifyNotice() {
      http
        .put(`/notice/${this.$route.params.no}`, {
          no: this.$route.params.no,
          title: this.title,
          writer: this.writer,
          content: this.content,
        })
        .then(({ data }) => {
          console.log(this.$route.params.no);
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        });
    },
    moveList() {
      this.$router.push({ name: "NoticeList" });
    },
  },
};
</script>

<style>
.inputBox {
  height: 40em;
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