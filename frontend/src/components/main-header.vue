<template>
    <div id="header">
        <img @click="clickMain" id="logo" src="@/assets/logo.png" alt="로고 로딩 오류"/>

        <span id=header-btn>
            <div class="btn-group" role="group" aria-label="Basic outlined example">
                <router-link to="/notice">
                    <button type="button" class="btn btn-outline-dark header-text">공지사항</button>
                </router-link>

                <router-link to="/user">
                    <button type="button" class="btn btn-outline-dark header-text">로그인</button>                
                </router-link>

                <router-link to="/user">
                    <button type="button" class="btn btn-outline-dark header-text">로그아웃</button>
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
    margin-top: 7px;
}
#logo{
    margin-left: 10px;
    width: 20px;
    height: 20px;
}
#header-btn{
    float: right;
}
#header-title{
    margin-top: 20px;
    font-size: 30px;
    text-align: center;
    font-weight: bold;    
}
#header-title-text{
    cursor: pointer;
}
.header-text{
    margin-right: 20px;   
}
</style>