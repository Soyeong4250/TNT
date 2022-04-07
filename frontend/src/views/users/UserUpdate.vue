<template>
  <form @submit="onSubmit" style="width: 23rem;">

    <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">정보 수정</h3>

    <div class="form-outline mb-4">
      <input name="user_name" v-model="user_name" placeholder="변경할 이름" class="form-control form-control-lg" />
      <span>{{ userNameError }}</span>
    </div>

    <div class="form-outline mb-4">
      <input name="user_pwd" v-model="user_pwd" type="password" placeholder="변경할 비밀번호" class="form-control form-control-lg" />
      <span>{{ passwordError }}</span>
    </div>

    <div class="form-outline mb-4">
        <input type="password" name="confirmPassword" v-model="confirmPassword" placeholder="비밀번호 재입력" class="form-control form-control-lg" />
        <span>{{ confirmPasswordError }}</span>
    </div>

    <div class="pt-1 mb-4">
      <button class="update-btn" type="submit">정보 변경</button>
    </div>
    </form>

</template>

<script>
import { useForm, useField } from 'vee-validate';
import { useStore } from "vuex";
import {ref} from "vue";
import * as yup from 'yup';
export default {
    name : 'UserUpdate',
    setup(){
      const store = useStore();
      const schema = yup.object({
      user_name: yup.string().required("이름을 입력하세요"),
      user_pwd: yup.string().required("비밀번호를 입력하세요").min(6, "비밀번호는 6자리 이상이어야합니다."),
      confirmPassword: yup.string()
        .oneOf([yup.ref("user_pwd"), null], "비밀번호와 같지 않습니다.")
        .required("비밀번호 확인은 필수 기입사항 입니다."),
    });
    const state=ref({
            userId: store.state.accountStore.userinfo.userId
        })
    const { handleSubmit } = useForm({validationSchema: schema,});
    const onSubmit = handleSubmit(values => {
        console.log(store.state.accountStore.userinfo.userId)
      const payload = {
        user_id: state.value.userId,
        user_name: values.user_name,
        user_pwd: values.user_pwd,
      };
      store.dispatch("accountStore/updateUser", payload);
    });
    // No need to define rules for fields
    const { value: user_name, errorMessage: userNameError } = useField('user_name');
    const { value: user_pwd, errorMessage: passwordError } = useField('user_pwd');
    const { value: confirmPassword, errorMessage: confirmPasswordError } = useField('confirmPassword');
    
    return {
      onSubmit,
      user_name,
      userNameError,
      user_pwd,
      passwordError,
        confirmPassword,
        confirmPasswordError,
        state
    };
    }
}
</script>

<style>
.update-btn {
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

</style>