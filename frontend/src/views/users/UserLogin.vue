<template>
  <div class="d-flex justify-content-center">
    <form @submit="onSubmit">
    <input name="user_id" v-model="user_id" />
    <span>{{ userIdError }}</span>
    <input name="user_pwd" v-model="user_pwd" type="password" />
    <span>{{ passwordError }}</span>
    <button type="submit" class="login-btn d-block">로그인</button>
    </form>
  </div>
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
  user-select: none;
  border: 1px solid transparent;
  padding: 0.625rem 1.25rem;
  transition: all 0.15s ease-in;
  /* font-weight: 500; */
  /* font-size: 0.875rem; */
  /* background-color: transparent; */
  border-radius: 0.3rem;
  background-image: linear-gradient(310deg, #fad749 0%, #fad749 100%);
  /* 밑에 두개가 내가 한 것 */
  /* background-color: #aae9e5; */
  /* background-image: linear-gradient(310deg, rgb(55, 211, 190) 0%, #aae9e5 100%); */
  /* 원본 색 */
  /* background-image: linear-gradient(310deg, #2dce89 0%, #2dcecc 100%); */
}
</style>