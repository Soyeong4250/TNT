<template>
<form @submit="onSubmit" style="width: 23rem;">

    <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">아이디 찾기</h3>

    <div class="form-outline mb-4">
      <input name="user_name" v-model="user_name" placeholder="이름을 입력하세요" class="form-control form-control-lg" />
      <span>{{ userNameError }}</span>
    </div>

    <div class="form-outline mb-4">
      <input name="user_email" v-model="user_email" placeholder="이메일을 입력하세요" class="form-control form-control-lg" />
      <span>{{ userEmailError }}</span>
    </div>

    <div class="pt-1 mb-4">
      <button class="findid-btn" type="submit">아이디 찾기</button>
    </div>
  </form>
</template>

<script>
import { useForm, useField } from 'vee-validate';
import { useStore } from "vuex";
import * as yup from 'yup';
export default {
    name : 'FindId',
    setup(){
      const store = useStore();
      const schema = yup.object({
      user_name: yup.string().required("이름을 입력하세요"),
      user_email: yup.string().required("이메일을 입력하세요").email(),
    });
      
    const { handleSubmit } = useForm({validationSchema: schema,});
    const onSubmit = handleSubmit(values => {
      const payload = {
        user_name: values.user_name,
        user_email: values.user_email,
      };
      store.dispatch("accountStore/getFindUserId", payload);
    });
    // No need to define rules for fields
    const { value: user_name, errorMessage: userNameError } = useField('user_name');
    const { value: user_email, errorMessage: userEmailError } = useField('user_email');

    
    return {
      onSubmit,
      user_name,
      userNameError,
      user_email,
      userEmailError,
    };
    }
}
    
</script>

<style>
.findid-btn {
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
  /* 밑에 두개가 내가 한 것 */
  /* background-color: #aae9e5; */
  /* background-image: linear-gradient(310deg, rgb(55, 211, 190) 0%, #aae9e5 100%); */
  /* 원본 색 */
  /* background-image: linear-gradient(310deg, #2dce89 0%, #2dcecc 100%); */
}
</style>