<template>
  <div class="d-flex justify-content-center">
    <form @submit="onSubmit">
    <input name="userId" v-model="userId" />
    <span>{{ userIdError }}</span>
    <input name="password" v-model="password" type="password" />
    <span>{{ passwordError }}</span>
    <button type="submit" class="login-btn d-block">로그인</button>
    </form>
  </div>
</template>

<script>
import { useForm, useField } from 'vee-validate';
import * as yup from 'yup';
export default {
    name : 'UserLogin',
    setup(){
      const schema = yup.object({
      userId: yup.string().required(),
      password: yup.string().required().min(4),
    });
       useForm({
      validationSchema: schema,
    });
    const { handleSubmit } = useForm();
    const onSubmit = handleSubmit(values => {
      alert(JSON.stringify(values, null, 2));
    });
    // No need to define rules for fields
    const { value: userId, errorMessage: userIdError } = useField('userId');
    const { value: password, errorMessage: passwordError } = useField('password');
    return {
      onSubmit,
      userId,
      userIdError,
      password,
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