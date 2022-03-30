<template>
	<div class="formpage">
		<b-form @submit="onSubmit" @reset="onReset">
      <b-container>
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
                v-model="login_id"
                readonly
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
                rows="10"
                max-rows="15"
              ></b-form-textarea
            ></b-td>
          </b-tr>
        </table>
      </b-container>
      <div style="padding-top: 15px" class="view-btn-group">
        <button type="submit" class="btn" v-if="this.type === 'register'">
          글작성
        </button>
        <button type="submit" class="btn" v-else>글수정</button>
        <button type="reset" class="btn">취소</button>
      </div>
    </b-form>
	</div>
</template>

<script>
import http from "@/util/http-common";
import {mapState} from "vuex";

export default {
	date() {
		return {
			noticeno: 1,
			login_id: "",
			title: "",
			content: "",

			isLoginid: false,
		}
	},
	props: {
    type: { type: String },
  },
  computed: {
    ...mapState(["userInfo"]),
  },
  created() {
    // if (this.userInfo === null) {
    //   alert("로그인을 해주세요.");
    //   this.$router.push({ name: "Login" });
    // }

    if (this.type === "modify") {
      http.get(`/notice/${this.$route.params.articleno}`).then(({ data }) => {
        this.login_id = data.login_id;
        this.notice = data.notice;
        this.content = data.content;
      });
      this.isLoginid = true;
    } else {
      this.login_id = this.userInfo.login_id;
    }
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      !this.login_id &&
        ((msg = "작성자 입력해주세요"),
        (err = false),
        this.$refs.login_id.focus());
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
      else this.type === "register" ? this.registNotice() : this.modifyNotice();
    },
    onReset(event) {
      event.preventDefault();
      this.noticeno = 0;
      this.title = "";
      this.content = "";
      this.$router.push({ name: "NoticeList" });
    },
    registNotice() {
      http
        .post(`/notice/`, {
          login_id: this.login_id,
          title: this.title,
          content: this.content,
        })
        .then(({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        })
        .catch(({ error }) => {
          console.log(error);
        });
    },
    modifyNotice() {
      http
        .put(`/notice/${this.$route.params.noticeno}`, {
          noticeNo: this.$route.params.noticeno,
          title: this.title,
          content: this.content,
        })
        .then(({ data }) => {
          console.log(this.$route.params.noticeno);
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

</style>