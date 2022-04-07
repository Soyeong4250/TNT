import axios from "axios";
import router from "../../router";
export const accountStore={
    namespaced : true,
    state:()=>({
        accessToken : "",
        userinfo: null,
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
            state.userinfo = null;
            window.localStorage.clear();
            router.push({ name: "UserLogin" });
          },
          setAccounts(state, newAccounts) {
            state.accounts = newAccounts;
            // console.log(state.accounts)
          },
          setUser(state, userinfo) {
            state.userinfo = userinfo;
            console.log(state.userinfo);
            router.push({ name: "Main" });
            // console.log(state.accounts)
          },
          setUserId(state, userId){
              state.userId=userId;
              router.push({name:"FindIdResult"})
          },
          setUpdateUser(state, username){
              state.userinfo.name=username;
              router.push({name:"Profile"});
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
                    console.log(response.data);
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
            }).then(alert("이메일 전송 성공!"),
                router.push("FindPwdResult")
            ).catch((err) => {
                console.log("에러", err.response);
                alert("아이디와 이메일이 맞지 않습니다.");
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
                commit("setUser", response.data.userinfo);
              })
              .catch((err) => {
                console.log("에러", err.response);
              });
            },
        deleteUser({commit}, user_id){
            axios.
                delete(process.env.VUE_APP_API_URL + `/users/${user_id}`)
                .then(()=>{
                    commit("logout")
                    router.push({name:"Main"});
                })
                .catch((err)=>{
                    console.log("에러",err.response);
                    alert("회원 탈퇴 실패")
                })
        },
        updateUser({commit},{user_id,user_name, user_pwd}){
            axios.
                put(process.env.VUE_APP_API_URL + `/users/${user_id}`,{user_name, user_pwd})
                .then(()=>{
                    commit("setUpdateUser", user_name);
                })
                .catch((err)=>{
                    console.log("에러",err.response);
                    alert("회원 수정 실패");
                })
        }
    },
}