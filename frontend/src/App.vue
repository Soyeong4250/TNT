<template>
  <div>
      <header>
        <!--공지사항 및 로그인-->
        <div>
          <router-link to="/notice">공지사항</router-link>
        </div>
        <div></div> 
        <main-header></main-header>
      </header>
      
      <router-view></router-view>
      
      바닥
      <main-footer>

      </main-footer>
  </div>
</template>

<script>
import mainHeader from "@/components/main-header.vue"
import mainFooter from "@/components/main-footer.vue"

export default {
  name: 'App',
  components: {
    mainHeader,
    mainFooter
  }
}
</script>

<style>

</style>
