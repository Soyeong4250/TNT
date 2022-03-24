<template>
      <main-header></main-header>
  <div>
      
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
