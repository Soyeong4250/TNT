<template>
  <main-page></main-page>
</template>

<script>
import MainPage from "./views/MainPage.vue";
export default {
  name: "App",
  components: {
    MainPage
  },
};
</script>

<style>
main-footer{
  position: relative;
  transform: translateY(-100%);
}


@font-face {
  font-family: 'NanumBarunGothic';
  src: url('assets/font/NanumBarunGothic.ttf') format('truetype');
  font-weight: 400;
}

@font-face {
  font-family: 'NanumBarunGothicBold';
  src: url('assets/font/NanumBarunGothicBold.ttf') format('truetype');
  font-weight: 400;
}
/*
@font-face {
  font-family: 'NanumBarunGothic';
  src: url('assets/font/NanumBarunGothicBold.ttf') format('truetype');
  font-weight: 400;
} */
</style>