<template>
  <div class="d-flex justify-content-center">
    <form @submit="onSubmit">
    <input name="user_name" v-model="user_name" />
    <span>{{ userNameError }}</span>
    <input name="user_email" v-model="user_email" />
    <span>{{ userEmailError }}</span>
    <button type="submit" class="login-btn d-block">아이디 찾기</button>
    </form>
  </div>
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

</style>