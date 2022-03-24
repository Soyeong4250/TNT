<template>
    <div id="header">
        <img id="logo" src="@/assets/logo.png" alt="로고 로딩 오류"/>

        <span id=header_btn>
            <span class="header_text">공지사항</span>   
            <span class="header_text">로그인</span>
            <span class="header_text">로그아웃</span>
        </span>
    </div>
        <div id="header_title">Today News Talk</div>
</template>

<script>
export default {

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
.header_text{
    color: aquamarine;
    cursor: pointer;    
    position: relative;
    margin-right: 20px;
    font-weight: normal;
    font-size: 20px;
}
#header_btn{
    float: right;
}
.header_text:hover{
    color: black;
}
#header_title{
    margin-top: 20px;
    font-size: 30px;
    font-weight: bold;
    margin-left: 500px;
}
</style>