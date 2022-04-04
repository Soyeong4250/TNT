<template>
  <div>
    <div class="container-fluid">
      <div id="searchBar" class="search-box">
          <!-- <select class="category-select" v-model="state.searchCategory">
              <option selected disabled>전체</option>
              <option class="option-category">제목</option>
              <option class="option-category">내용</option>
          </select> -->
          <input type="text" class="search-text" placeholder="검색" v-model="state.searchWord" @keyup.enter="clickSearchBtn" @click="clickSearchBar"/>
          <a class="search-btn" @click="clickSearchBtn">
              <i class="bi bi-search"></i>
          </a>
      </div>
  </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>