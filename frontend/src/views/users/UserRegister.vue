<template>
  <div id="app">
    <form @submit="onSubmit">
        <div>
        <input name="user_id" v-model="idCk" @keyup="memberCheck"/>
        <span>{{ userIdError }}</span>
        <p v-if="bool" id="check-id">중복된 아이디입니다.</p>
        </div>
        <div>
        <input name="user_name" v-model="user_name" />
        <span>{{ user_nameError }}</span>
        </div>
         <div>
        <input name="user_email" v-model="user_email" />
        <span>{{ user_emailError }}</span>
        </div>
        <div>
        <input name="user_pwd" v-model="user_pwd" type="password" />
        <span>{{ user_pwdError }}</span>
        </div>
        <div>
        <input name="confirmPassword" v-model="confirmPassword" type="password" />
        <span>{{ confirmPasswordError }}</span>
        </div>
        <div>
        <input user_name="user_birth" v-model="user_birth" type="date" />
        <span>{{ birthError }}</span>
        </div>
        <button
                type="submit"
                class="login-btn d-block btn-width"
              >
                회원가입
        </button>
    </form>
  </div>
</template>

<script>
import { useForm, useField } from 'vee-validate';
import axios from "axios";
import * as yup from 'yup';
import { ref } from "vue";
export default {
    name:"UserRegister",
    setup(){
      const schema = yup.object({
      user_id: yup.string().required("아이디는 필수 기입사항 입니다."),
        user_name: yup.string().required("이름은 필수 기입사항 입니다."),
      user_email: yup.string()
        .required("Email 은 필수 기입사항 입니다.")
        .email("Email 이 유효하지 않습니다."),
      user_pwd: yup.string()
        .min(6, "비밀번호는 적어도 6자리 이상이어야 합니다.")
        .required("비밀번호는 필수 기입사항 입니다."),
      confirmPassword: yup.string()
        .oneOf([yup.ref("user_pwd"), null], "비밀번호와 같지 않습니다.")
        .required("비밀번호 확인은 필수 기입사항 입니다."),
    });
    const { handleSubmit } = useForm({
      validationSchema: schema,
    });
   
    let bool = ref(false);
    const idCk = ref("");
    // No need to define rules for fields
    const { value: user_id, errorMessage: userIdError } = useField('user_id');
    const { value: user_pwd, errorMessage: user_pwdError } = useField('user_pwd');
    const { value: user_email, errorMessage: user_emailError } = useField('user_email');
    const { value: confirmPassword, errorMessage: confirmPasswordError } = useField('confirmPassword');
    const { value: user_name, errorMessage: user_nameError } = useField('user_name');
    const { value: user_birth, errorMessage: birthError } = useField('user_birth');

    const onSubmit = handleSubmit(values=>{

      if (bool.value) {
        alert("중복된 아이디입니다.");
      } else {
        axios
          .post(process.env.VUE_APP_API_URL + "/users/register/", values)
          .then((response) => {

            if(response.data.message==="success") alert("회원 등록 성공!");
          }).catch(alert("회원 등록 실패!"));
          
      }
    });

    const memberCheck = () => {
        if(idCk.value.length<1) return;
      axios
        .get(process.env.VUE_APP_API_URL + "/users/IdCheck/" + idCk.value)
        .then((response) => {

          let cnt = response.data;
          if (cnt) bool.value = true;
          else bool.value = false;
        })
        
    };

    return {
      onSubmit,
      memberCheck,
      idCk,
      bool,
      user_id,
      userIdError,
      user_pwd,
      user_pwdError,
      user_email,
      user_emailError,
      confirmPassword,
      confirmPasswordError,
      user_name,
      user_nameError,
      user_birth,
      birthError,
    };
    }
}
</script>

<style>

</style>