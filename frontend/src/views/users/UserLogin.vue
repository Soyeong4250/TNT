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

    
    return {
      onSubmit,
      user_id,
      userIdError,
      user_pwd,
      passwordError,
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

@media (min-width: 1025px) {
.h-custom-2 {
height: 100%;
}
}
</style>