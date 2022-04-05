<template>
<nav>
  <div class="container-fluid">
      <div id="searchBar" class="search-box">
          <select class="category-select" v-model="state.searchCategory">
              <option selected disabled>선택</option>
              <option class="option-category" value="title">제목</option>
              <option class="option-category" value="content">내용</option>
          </select>
          <input type="text" class="search-text" placeholder="검색" v-model="state.searchTxt" @keyup.enter="clickSearchBtn" @click="clickSearchBar"/>
          <a class="search-btn" @click="clickSearchBtn">
              <i class="fas fa-search"></i>
          </a>
      </div>
  </div>
</nav>
</template>

<script>
import {reactive} from "vue";
import {useStore} from "vuex";
import {useRouter} from "vue-router";
export default {
    setup(){
        const router=useRouter();
        const store=useStore();
        const state=reactive({
            searchTxt: "",
            searchCategory: "선택",
        })
        const clickSearchBtn=()=>{
            if(!state.searchTxt){
                alert("검색어를 입력해주세요!");
                return
            }
            if(state.searchCategory=="선택"){
                alert("제목/내용을 선택해주세요")
                return;
            }
            store.commit("newsStore/setSearchSelect",state.searchCategory)
            store.commit("newsStore/setSearchText",state.searchTxt)

            router.push({name : "Search"});
        }
        return{
            state,
            clickSearchBtn
        }
    }
}
</script>

<style>
.category-select{
    border-radius: 20px;
    border:none;
    outline:none;
    background-color: white;
}

.search-box{
    margin: 10%;
    display: flex;
    padding: auto;
    border:1px solid rgb(62, 62, 253);
    padding-left: 10px;
    height: 40px;
    background-color: white;
    border-radius: 30px;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.search-btn{
    padding-right: 5px;
    text-decoration: none;
    float: right;
    width: 38px;
    height: 35px;
    background-color: white;
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
}

.search-text{
    margin-left: 3px;
    width:80%;
    align-self: center;
    border:none;
    background: none;
    outline:none;
    line-height: 40px;
}
</style>