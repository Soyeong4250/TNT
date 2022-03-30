<template>
  <div class="d-flex justify-content-center">
    <form @submit="onSubmit">
    <input name="user_id" v-model="user_id" />
    <span>{{ userIdError }}</span>
    <input name="user_email" v-model="user_email" />
    <span>{{ userEmailError }}</span>
    <p>이메일로 비밀번호 전송</p>
    <button type="submit" class="login-btn d-block">비밀번호 찾기</button>
    </form>
  </div>
</template>

<script>
import { useForm, useField } from 'vee-validate';
import { useStore } from "vuex";
import * as yup from 'yup';
export default {
    name : 'FindPwd',
    setup(){
      const store = useStore();
      const schema = yup.object({
      user_id: yup.string().required("아이디를 입력하세요"),
      user_email: yup.string().required("이메일을 입력하세요").email("이메일 형식으로 입력해주세요"),
    });
      
    const { handleSubmit } = useForm({validationSchema: schema,});
    const onSubmit = handleSubmit(values => {
      const payload = {
        user_name: values.user_id,
        user_email: values.user_email,
      };
      store.dispatch("accountStore/getFindUserPwd", payload);
    });
    // No need to define rules for fields
    const { value: user_id, errorMessage: userIdError } = useField('user_id');
    const { value: user_email, errorMessage: userEmailError } = useField('user_email');

    
    return {
      onSubmit,
      user_id,
      userIdError,
      user_email,
      userEmailError,
    };
    }
}
</script>

<style>

</style>