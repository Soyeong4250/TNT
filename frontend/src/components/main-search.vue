<template>
  <div class="container-fluid">
      <div id="searchBar" class="search-box">
          <select class="category-select" v-model="state.searchCategory">
              <option selected disabled>전체</option>
              <option class="option-category">정치</option>
              <option class="option-category">경제</option>
              <option class="option-category">사회</option>
              <option class="option-category">생활</option>
              <option class="option-category">IT</option>
              <option class="option-category">오피니언</option>
          </select>
          <input type="text" class="search-text" placeholder="검색" v-model="state.searchWord" @keyup.enter="clickSearchBtn" @click="clickSearchBar"/>
          <a class="search-btn" @click="clickSearchBtn">
              <i class="bi bi-search"></i>
          </a>
      </div>
  </div>
</template>

<script>
import {reactive} from "vue";
export default {
    setup(){
        const state=reactive({
            searchCategory: "카테고리",
        })
        return{
            state,
        }
    }
}
</script>

<style>
.category-select{
    border:none;
    outline:none;
    background-color: white;
}

.search-box{
    margin: 10%;
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
    width:40px;
    height: 40px;
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