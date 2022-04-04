<template>
  <div></div>
</template>

<script>
import { mapState } from 'vuex';
export default {
    setup(){
        var naverLogin = new window.naver.LoginWithNaverId(
            {
                clientId: process.env.VUE_APP_NAVER_KEY,
                callbackUrl: "http://localhost:8080",
                isPopup: true,
                callbackHandle: true
            }
        );
        mapState(['userInfo']);
        naverLogin.init();
        window.addEventListener('load', ()=>{
            naverLogin.getLoginStatus(function (status) {
                if (status) {
                var email = naverLogin.user.getEmail(); // 필수로 설정할것을 받아와 아래처럼 조건문을 줍니다.
                console.log(naverLogin.user); 
                if( email == undefined || email == null) {
                    alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
                    naverLogin.reprompt();
                    return;
                }
                } else {
                    console.log("callback 처리에 실패하였습니다.");
                }
            });
        })
        opener.parent.location="/"
        window.close();
    },                
}
</script>

<style>

</style>