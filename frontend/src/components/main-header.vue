<template>
    <div id="header">
        <img @click="clickMain" id="logo" src="@/assets/logo.png" alt="로고 로딩 오류"/>

        <span id=header-btn>
            <div class="btn-group" role="group" aria-label="Basic outlined example">
                <router-link class="header-router" to="/notice">
                    <span class="header-text">공지사항</span>
                </router-link>

                <router-link class="header-router" to="/login">
                    <span class="header-text">로그인</span>                    
                </router-link>

                <router-link class="header-router" to="/register">
                    <span class="header-text">회원가입</span>
                </router-link>
            </div>
        </span>
    </div>
        <div id="header-title" class = "">
            <span @click="clickMain" id="header-title-text">Today News Talk</span>
        </div>
</template>

<script>
export default {    
    setup(){        
        const clickMain = () =>{
            location.href = "/"
        }
        return{
            clickMain,
        }
    }

}
</script>

<style>
#header{
    margin-top: 1em;    
}
#logo{
    margin-left: 1em;
    width: 1.5em;
    height: 1.5em;
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