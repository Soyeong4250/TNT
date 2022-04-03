<template>
  <div>
      찾으시는 아이디는 {{state.userId}}입니다.
  </div>
</template>

<script>
import { computed, reactive} from "vue";
import {useStore} from "vuex";
export default {    
    setup(){
        const store=useStore();
        const state=reactive({
            userId: computed(() => store.state.accountStore.userId),
            userName: computed(()=> store.state.accountStore.userinfo.name)
        })
        return{
            state,
        }
    }
}
</script>

<style>

</style>