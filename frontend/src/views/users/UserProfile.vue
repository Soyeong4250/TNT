<template>
  <section class="vh-50" style="background-color: #fff;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-12 col-xl-4">

        <div class="card" style="border-radius: 15px;">
          <div class="card-body text-center">
            <div class="mt-3 mb-4">
              <i class="fas fa-id-badge fa-4x"></i>
            </div>
            <h4 class="mb-2">{{state.userInfo.name}}</h4>
            <p class="text-muted mb-4">{{state.userInfo.userId}} <span class="mx-2">|</span> {{state.userInfo.email}}</p>
            <button type="button" @click="userUpdate" class="custom-button">
              정보수정
            </button>
            <button type="button"  @click="userDelete" class="custom-button">
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
import { useRouter } from 'vue-router';
export default {
    setup(){
        const store=useStore();
        const router=useRouter();
        const state=reactive({
            userInfo: computed(()=>{
                return store.state.accountStore.userinfo;
            })
        })
        
        const userUpdate=(()=>{
            router.push({name:"UserUpdate"})
        })

        const userDelete=(()=>{
            return store.dispatch("accountStore/deleteUser",state.userInfo.userId);
        });
        return{
            userUpdate,
            userDelete,
            state,
        }
    }
}
</script>

<style>
.custom-button{
    display: inline-block;
  line-height: 1.5;
  color: #67748e;
  text-align: center;
  vertical-align: middle;
  cursor: pointer;
  margin: 10px;
   width:20%;
  user-select: none;
  border: 1px solid transparent;
  padding: 0.625rem 1.25rem;
  transition: all 0.15s ease-in;
  /* font-weight: 500; */
  /* font-size: 0.875rem; */
  /* background-color: transparent; */
  border-radius: 0.3rem;
  background-image: linear-gradient(310deg, #04e4a1 0%, #5ffce7 100%);
}
</style>