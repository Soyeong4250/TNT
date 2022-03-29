<template>
  <div id="app">
    <form @submit="onSubmit">
        <div>
        <input name="user_id" v-model="user_id" />
        <span>{{ userIdError }}</span>
        </div>
        <div>
        <input name="name" v-model="name" />
        <span>{{ nameError }}</span>
        </div>
        <div>
        <input name="password" v-model="password" type="password" />
        <span>{{ passwordError }}</span>
        </div>
        <div>
        <input name="confirmPassword" v-model="confirmPassword" type="password" />
        <span>{{ confirmPasswordError }}</span>
        </div>
        <div>
        <input name="user_birth" v-model="user_birth" type="date" />
        <span>{{ birthError }}</span>
        </div>
    </form>
  </div>
</template>

<script>
import { useForm, useField } from 'vee-validate';
import * as yup from 'yup';
export default {
    name:"UserRegister",
    setup(){
      const schema = yup.object({
      user_id: yup.string().required("아이디는 필수 기입사항 입니다."),
        name: yup.string().required("이름은 필수 기입사항 입니다."),
      email: yup.string()
        .required("Email 은 필수 기입사항 입니다.")
        .email("Email 이 유효하지 않습니다."),
      password: yup.string()
        .min(6, "비밀번호는 적어도 6자리 이상이어야 합니다.")
        .required("비밀번호는 필수 기입사항 입니다."),
      confirmPassword: yup.string()
        .oneOf([yup.ref("password"), null], "비밀번호와 같지 않습니다.")
        .required("비밀번호 확인은 필수 기입사항 입니다."),
    });
       useForm({
      validationSchema: schema,
    });
    const { handleSubmit } = useForm();
    const onSubmit = handleSubmit(values => {
      alert(JSON.stringify(values, null, 2));
    });
    // No need to define rules for fields
    const { value: user_id, errorMessage: userIdError } = useField('user_id');
    const { value: password, errorMessage: passwordError } = useField('password');
    const { value: confirmPassword, errorMessage: confirmPasswordError } = useField('confirmPassword');
    const { value: name, errorMessage: nameError } = useField('name');
    const { value: user_birth, errorMessage: birthError } = useField('user_birth');


    return {
      onSubmit,
      user_id,
      userIdError,
      password,
      passwordError,
      confirmPassword,
      confirmPasswordError,
      name,
      nameError,
      user_birth,
      birthError,
    };
    }
}
</script>

<style>

</style>