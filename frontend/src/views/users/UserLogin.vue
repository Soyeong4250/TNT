<template>
  <form @submit="onSubmit" style="width: 23rem;">

    <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">로그인</h3>

    <div class="form-outline mb-4">
      <input name="user_id" v-model="user_id" placeholder="ID를 입력하세요" class="form-control form-control-lg" />
      <span>{{ userIdError }}</span>
    </div>

    <div class="form-outline mb-4">
      <input name="user_pwd" v-model="user_pwd" type="password" placeholder="패스워드를 입력하세요" class="form-control form-control-lg" />
      <span>{{ passwordError }}</span>
    </div>

    <div class="pt-1 mb-4">
      <button class="login-btn" type="submit">로그인</button>
    </div>

    <div id="kakao_id_login" class="pt-1 mb-4" @click="kakaoLogin">
    </div>

    <!-- <div id="naverIdLogin" class="pt-1 mb-4" style="display: none;"></div>
    <div id="naver_id_login" class="pt-1 mb-4" @click="naverLogin"></div> -->

    <div class="mb-2 pb-lg-2">
    <span class="small"><router-link to="/users/find/id">아이디 찾기</router-link></span>
    <span class="small"> / </span>
    <span class="small"><router-link to="/users/find/pwd">비밀번호 찾기</router-link></span>
    </div>
    <p>아직 아이디가 없으신가요? <a class="link-info"><router-link to="/users/register" class="text-decoration-none link-color">회원가입</router-link></a></p>
  </form>

</template>

<script>
import { useForm, useField } from 'vee-validate';
import { useStore } from "vuex";
import * as yup from 'yup';
import axios from "axios";
export default {
    name : 'UserLogin',
    setup(){
      const store = useStore();
      const schema = yup.object({
      user_id: yup.string().required("아이디를 입력하세요"),
      user_pwd: yup.string().required("비밀번호를 입력하세요").min(6, "비밀번호는 6자리 이상이어야합니다."),
    });
      
    const { handleSubmit } = useForm({validationSchema: schema,});
    const onSubmit = handleSubmit(values => {
      const payload = {
        user_id: values.user_id,
        user_pwd: values.user_pwd,
      };
      store.dispatch("accountStore/getToken", payload);
    });
    // No need to define rules for fields
    const { value: user_id, errorMessage: userIdError } = useField('user_id');
    const { value: user_pwd, errorMessage: passwordError } = useField('user_pwd');

    // 소셜 로그인 기능

    //kakao
    const kakaoLogout = () => {
        if(window.Kakao.Auth.getAccessToken()){
            //console.log("토큰이 이미 존재합니다.", window.Kakao.Auth.getAccessToken());
        }
        window.Kakao.Auth.logout(()=>{
            //console.log('로그아웃 되었습니다.',window.Kakao.Auth.getAccessToken());
        });
    }    
    const kakaoLogin = () => {
      // console.log(window.Kakao);
      window.Kakao.Auth.login({
        success: GetMe,
      });
    }
    const GetMe = () =>{
      // console.log(authObj);
      window.Kakao.API.request({
        url:'/v2/user/me',
        success : res => {
          const kakao_account = res.kakao_account;
          //console.log(kakao_account);
            //console.log(userInfo);            
            axios.post(process.env.VUE_APP_API_URL + "/auth/login", {
              user_id: kakao_account.email,
              user_pwd: kakao_account.email+"ssafy6"
            })
            .then(()=>{             // 로그인 성공 시       
              const payload = {
                user_id: kakao_account.email,
                user_pwd: kakao_account.email+"ssafy6"
              };
              store.dispatch("accountStore/getToken", payload);
            })
            .catch(()=>{    // 로그인 실패           
              // 회원가입 진행
              let now = new Date();
              let tmpYear = kakao_account.age_range+"";
              let year = tmpYear.substring(0,2);
              year *=1;
              year = now.getFullYear() - year;        
              let tmpDate =kakao_account.birthday+"";
              let month = tmpDate.substring(0,2);
              let day = tmpDate.substring(2,4);
              let values = {
                user_name: kakao_account.profile.nickname,
                user_id: kakao_account.email,
                user_email: kakao_account.email,
                user_pwd : kakao_account.email+"ssafy6",
                user_birth: year+"-"+month+"-"+day
              }
              axios.post(process.env.VUE_APP_API_URL + "/users/register/", values)
              .then(()=>{
                axios.post(process.env.VUE_APP_API_URL + "/auth/login", { // 다시 로그인
                  user_id: kakao_account.email,
                  user_pwd: kakao_account.email+"ssafy6"
                })
                .then(()=>{
                  const payload = {
                    user_id: kakao_account.email,
                    user_pwd: kakao_account.email+"ssafy6"
                  };
                  store.dispatch("accountStore/getToken", payload);
                })
              })
              .catch(()=>{
              });
            })
            // this.$bvModal.hide("bv-modal-example");
        },
        fail : () => {
          this.$router.push("/errorPage");
          //console.log(error);
        }
      })
    }

    return {
      onSubmit,
      user_id,
      userIdError,
      user_pwd,
      passwordError,
      GetMe,
      kakaoLogin,
      kakaoLogout, 
    };
    }
}
</script>

<style>
.login-btn {
  display: inline-block;
  line-height: 1.5;
  color: #67748e;
  text-align: center;
  vertical-align: middle;
  cursor: pointer;
   width:100%;
  user-select: none;
  border: 1px solid transparent;
  padding: 0.625rem 1.25rem;
  transition: all 0.15s ease-in;
  /* font-weight: 500; */
  /* font-size: 0.875rem; */
  /* background-color: transparent; */
  border-radius: 0.3rem;
  background-image: linear-gradient(310deg, #04e4a1 0%, #5ffce7 100%);
}
.link-color {
  color: rgb(49, 180, 242);
}
.card {
  box-shadow: 5px 5px 5px rgba(136, 152, 170, 0.15) !important;
}


.bg-image-vertical {
position: relative;
overflow: hidden;
background-repeat: no-repeat;
background-position: right center;
background-size: auto 100%;
}
#kakao_id_login{
  background-image: url("/src/assets/kakao_login.png");
  background-repeat: no-repeat;
  cursor: pointer;
  height: 48px;
}
#naver_id_login{
  background-image: url("/src/assets/naver_login.png");
  cursor: pointer;
  height: 48px;
  /* max-height: 48px; */
  max-width: 100%;
}

@media (min-width: 1025px) {
.h-custom-2 {
height: 100%;
}
}
</style>
