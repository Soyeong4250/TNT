import axios from "axios";
import router from "../../router";
export const accountStore={
    namespaced : true,
    state:()=>({
        accessToken : "",
        userinfo: {},
        userId: "",
    }),
    getters:{
      GET_TOKEN (state) {
        return state.accessToken;
      },
      GET_USER_INFO(state) {
        return state.userinfo;
      }
    },
    mutations:{
        setToken(state, newAccessToken) {
            state.accessToken = newAccessToken;
          },
          // 로그아웃 시 vuex-persistance 데이터도 삭제
          logout(state) {
            state.accessToken = "";
            state.userinfo = {};
            window.localStorage.clear();
            router.push({ name: "Login" });
          },
          setAccounts(state, newAccounts) {
            state.accounts = newAccounts;
            // console.log(state.accounts)
          },
          setUser(state, userinfo) {
            state.userinfo = userinfo;
            router.push({ name: "Main" });
            // console.log(state.accounts)
          },
          setUserId(state, userId){
              state.userId=userId;
              router.push({})
          }
    },
    actions:{
        getToken({ commit }, { user_id, user_pwd }) {
            axios
              .post(process.env.VUE_APP_API_URL + "/auth/login", {
                user_id,
                user_pwd,
              })
              .then((response) => {
                localStorage.setItem("accessToken", response.data.accessToken);
                commit("setToken", response.data.accessToken);
                axios
                  .get(process.env.VUE_APP_API_URL + `/users/${user_id}`, {
                    headers: {
                      Authorization: `Bearer ${response.data.accessToken}`,
                    },
                  })
                  .then((response) => {
                    commit("setUser", response.data);
                  });
              })
              .catch((err) => {
                console.log("에러", err.response);
                alert("존재하지 않는 아이디 혹은 맞지 않는 비밀번호 입니다.");
              });
          },
          getFindUserId({commit},{user_name, user_email}){
            axios.post(process.env.VUE_APP_API_URL+ "/users/find/id",{
                user_name,
                user_email
            }).then((response)=>{
                commit("setUserId",response.data.userId);
                console.log(response.data.userId);
            }).catch((err) => {
                console.log("에러", err.response);
                alert("이름과 이메일이 맞지 않습니다.");
            });
          },
          getFindUserPwd({user_id, user_email}){
            axios.post(process.env.VUE_APP_API_URL+ "/users/find/pwd",{
                user_id,
                user_email
            }).then(alert("이메일 전송 성공!")
            ).catch((err) => {
                console.log("에러", err.response);
                alert("이름과 이메일이 맞지 않습니다.");
            });
          },
          getUserinfo({ commit }, accessToken) {
            axios
              .get(process.env.VUE_APP_API_URL + "/users/userInfo/", {
                headers: {
                  Authorization: `Bearer ${accessToken}`,
                },
              })
              .then((response) => {
                console.log(response);
                commit("setUser", response.data);
              })
              .catch((err) => {
                console.log("에러", err.response);
              });
            }
    },
}