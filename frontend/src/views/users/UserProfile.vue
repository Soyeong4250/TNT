<template>
  <section class="vh-50" style="background-color: #fff;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-12 col-xl-4">

        <div class="card" style="border-radius: 15px;">
          <div class="card-body text-center">
            <div class="mt-3 mb-4">
              <img
                src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2-bg.webp"
                class="rounded-circle img-fluid" style="width: 100px;"
              />
            </div>
            <h4 class="mb-2">{{state.userInfo.name}}</h4>
            <p class="text-muted mb-4">{{state.userInfo.userId}} <span class="mx-2">|</span> {{state.userInfo.email}}</p>
            <button type="button" class="btn btn-primary btn-rounded btn-lg">
              정보수정
            </button>
            <button type="button"  @click="userDelete" class="btn btn-primary btn-rounded btn-lg">
              회원탈퇴
            </button>
          </div>
        </div>

      </div>
    </div>
  </div>
</section>
</template>

<script>
import { computed, reactive} from "vue";
import {useStore} from "vuex";
export default {
    setup(){
        const store=useStore();
        const state=reactive({
            userInfo: computed(()=>{
                return store.state.accountStore.userinfo;
            })
        })
        
        const userDelete=(()=>{
            return store.dispatch("accountStore/deleteUser",state.userInfo.userId);
        });
        return{
            userDelete,
            state,
        }
    }
}
</script>

<style>

</style>