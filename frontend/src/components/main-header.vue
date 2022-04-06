<template>
    <div id="header">
        <router-link class="header-router" to="/">
        <img id="logo" src="@/assets/tntLogo.png" alt="로고 로딩 오류"/>
        </router-link>
        <span id=header-btn>
            <div class="btn-group" role="group" aria-label="Basic outlined example">
                <router-link class="header-router" to="/notice">
                    <span class="header-text">공지사항</span>
                </router-link>
                <div v-if="!state.userInfo">
                    <router-link class="header-router" to="/users">
                        <span class="header-text">로그인</span>                    
                    </router-link>

                    <router-link class="header-router" to="/users/register">
                        <span class="header-text">회원가입</span>
                    </router-link>
                </div>
                <div v-else>
                    <router-link class="header-router" to="/users/login">
                        <span class="header-text" v-on:click="logout">로그아웃</span>                    
                    </router-link>

                    <router-link class="header-router" to="/profile">
                        <span class="header-text">내정보</span>
                    </router-link>
                </div>
            </div>
        </span>
    </div>
</template>

<script>
import {computed, reactive} from "vue";
import {useStore} from "vuex";
export default {    
    setup(){
        const store=useStore();
        const state=reactive({
            userInfo: computed(()=>{
                console.log(store.state.accountStore.userinfo)
                return store.state.accountStore.userinfo;
            })
        })
        const logout = () => store.commit("accountStore/logout");
        return{
            logout,
            state,
        }
    }

}
</script>

<style>
#header{
    margin: 1em;
}
#logo{
    margin-left: 1em;
    width: 3em;
    height: 4em;
}
#header-btn{
    float: right;
}
#header-title{
    margin-top: 1em;
    font-size: 2em;
    text-align: center;
    font-weight: bold;    
}
#header-title-text{
    cursor: pointer;
}
.header-text{
}
.header-text:hover{

}
.header-router{
    width: 150px;
    margin-right: 50px;
    text-decoration: none;
    cursor: pointer;
    font-size: 20px;
    color: black;
    font-weight: bold;
    text-align: center;
}
.header-router:hover{
    text-decoration-color: aqua;
    color: firebrick;
    text-decoration: underline;
}
</style>