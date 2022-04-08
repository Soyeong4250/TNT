<template>
<form @submit="onSubmit" style="width: 23rem;">

    <h3 class="fw-normal pb-3" style="letter-spacing: 1px;">회원가입</h3>

    <div class="form-outline mb-4">
        <input type="text" name="user_id" v-on="idCk" v-model="user_id" placeholder="ID 입력" class="form-control form-control-lg"  @keyup="memberCheck"/>
        <span>{{ userIdError }}</span>
        <p v-if="bool" id="check-id">중복된 아이디입니다.</p>
    </div>

    <div class="form-outline mb-4">
                    <input name="user_name" v-model="user_name" placeholder="이름 입력" class="form-control form-control-lg" />
                    <span>{{ user_nameError }}</span>
                </div>

                <div class="form-outline mb-4">
                    <input name="user_email" v-model="user_email" placeholder="이메일 입력" class="form-control form-control-lg" />
                    <span>{{ user_emailError }}</span>
                </div>

                <div class="form-outline mb-4">
                    <input type="password" name="user_pwd" v-model="user_pwd" placeholder="비밀번호 입력" class="form-control form-control-lg" />
                    <span>{{ user_pwdError }}</span>
                </div>

                <div class="form-outline mb-4">
                    <input type="password" name="confirmPassword" v-model="confirmPassword" placeholder="비밀번호 재입력" class="form-control form-control-lg" />
                    <span>{{ confirmPasswordError }}</span>
                </div>

                <div class="form-outline mb-4">
                    <input user_name="user_birth" v-model="user_birth" type="date" class="form-control form-control-lg" />
                    <span>{{ birthError }}</span>
                </div>

    <div class="pt-1 mb-4">
      <button class="register-btn" type="submit">회원가입</button>
    </div>
    
    <p class="text-center text-muted mt-5 mb-0">이미 회원가입 하셨나요? <a class="fw-bold text-body"><u><router-link to="/users/login" class="text-decoration-none link-color">로그인하기</router-link></u></a></p>
  </form>

</template>

<script>
import { useForm, useField } from 'vee-validate';
import {useRouter} from 'vue-router';
import axios from "axios";
import * as yup from 'yup';
import { ref } from "vue";
export default {
    name:"UserRegister",
    setup(){
        const router=useRouter();
    
      const schema = yup.object({
      user_id: yup.string().required("아이디를 입력하세요."),
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
        user_birth: yup.date().required("생년월일은 필수 기입사항 입니다.")
    });
    const { handleSubmit } = useForm({
      validationSchema: schema,
    });
   
    let bool = ref(false);
    let idCk = ref("");
    const memberCheck = () => {
        if(idCk.value.length<1) return;
        else{
        axios
            .get(process.env.VUE_APP_API_URL + "/users/IdCheck/" + idCk.value)
            .then((response) => {

            let cnt = response.data;
            if (cnt) bool.value = true;
            else bool.value = false;
            })
            return;
        }
    };
    // No need to define rules for fields
    const {  errorMessage: userIdError, value: user_id} = useField('user_id');
    const { value: user_pwd, errorMessage: user_pwdError } = useField('user_pwd');
    const { value: user_email, errorMessage: user_emailError } = useField('user_email');
    const { value: confirmPassword, errorMessage: confirmPasswordError } = useField('confirmPassword');
    const { value: user_name, errorMessage: user_nameError } = useField('user_name');
    const { value: user_birth, errorMessage: birthError } = useField('user_birth');

    const onSubmit = handleSubmit(values=>{
        //console.log("작동?")
      if (bool.value) {
        alert("중복된 아이디입니다.");
      } else {
        axios
          .post(process.env.VUE_APP_API_URL + "/users/register/", values)
          .then((response) => {
            //console.log(response);
            if(response.data.message==="Success") alert("회원 등록 성공!");
            router.push({name: "Main"})
          })//.catch(alert("회원 등록 실패!"));
          
      }
    });

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
.register-btn {
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