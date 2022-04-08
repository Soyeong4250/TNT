<template>
  <div></div>
</template>

<script>
import axios from "axios";
import { mapState } from 'vuex';
import { useStore } from "vuex";
export default {
    setup(){
        const store = useStore();
        var naverLogin = new window.naver.LoginWithNaverId(
            {
                clientId: process.env.VUE_APP_NAVER_KEY,
                callbackUrl: process.env.VUE_APP_NAVER_CALLBACK2_URL,
                isPopup: false,
                callbackHandle: true
            }
        );
        mapState(['userInfo']);
        naverLogin.init();
        window.addEventListener('load', ()=>{
            naverLogin.getLoginStatus(function (status) {
                if (status) {
                var email = naverLogin.user.getEmail(); // 필수로 설정할것을 받아와 아래처럼 조건문을 줍니다.
                //console.log(naverLogin.user); 
                if( email == undefined || email == null) {
                    alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
                    naverLogin.reprompt();
                    return;
                }
                } else {
                    //console.log("callback 처리에 실패하였습니다.");
                }
            });
            naverLogin.getLoginStatus(function (status) {
                if (status) {
                var email = naverLogin.user.getEmail(); // 필수로 설정할것을 받아와 아래처럼 조건문을 줍니다.
               // console.log(naverLogin.user); 
                if( email == undefined || email == null) {
                    alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
                    naverLogin.reprompt();
                    return;
                }
                } else {
                    //console.log("callback 처리에 실패하였습니다.");
                }
                axios.post(process.env.VUE_APP_API_URL + "/auth/login", {
                    user_id: naverLogin.user.email,
                    user_pwd: naverLogin.user.email+"ssafy6",
                })
                .then(()=>{                    
                    const payload = {
                        user_id: naverLogin.user.email,
                        user_pwd: naverLogin.user.email+"ssafy6",
                    };
                    store.dispatch("accountStore/getToken", payload);                    
                })
                .catch(()=>{                                        
                    // 회원가입 진행
                    //let days = naverLogin.user.getBirthday().toString();
                    //let birthday = new Date(naverLogin.user.birthyear+'-'+days);
                    //console.log(birthday);
                    //
                    let values = {
                        user_name: naverLogin.user.name,
                        user_id: naverLogin.user.email,
                        user_email: naverLogin.user.email,
                        user_pwd : naverLogin.user.email+"ssafy6",
                        user_birth: naverLogin.user.birthyear+"-"+naverLogin.user.birthday
                    }
                    axios.post(process.env.VUE_APP_API_URL + "/users/register/", values)
                    .then(()=>{ // 다시 로그인
                        axios.post(process.env.VUE_APP_API_URL + "/auth/login", {
                        user_id: naverLogin.user.email,
                        user_pwd: naverLogin.user.email+"ssafy6",
                        })
                        .then(()=>{
                            const payload = {
                                user_id: naverLogin.user.email,
                                user_pwd: naverLogin.user.email+"ssafy6",
                            };
                            store.dispatch("accountStore/getToken", payload);
                        })
                    })
                    .catch(()=>{
                    });
                })
            });
        });
    },                
}
</script>

<style>

</style>
