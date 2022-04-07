<template>
<nav>
  <div class="container-fluid">
      <div id="searchBar" class="search-box">
          <select class="category-select" v-model="selected">
              <option class="option-category" disabled>선택</option>
              <option class="option-category">제목</option>
              <option class="option-category">내용</option>
              <option class="option-category">언론사</option>
          </select>
          <input type="text" class="search-text" placeholder="검색" v-model="searchWord" @keyup.enter="clickSearchBtn" @click="clickSearchBar"/>
          <a class="search-btn" @click="clickSearchBtn">
              <i class="fas fa-search"></i>
          </a>
      </div>
  </div>
</nav>
</template>

<script>
export default {
    data() {
        return {
            selected: "선택",
            searchWord: null,
        };
    },
    methods: {
        clickSearchBtn() {
            console.log(this.searchWord + "을(를) 검색했습니다.");
            console.log(document.location.href);
            
            this.$router.push({
                name : "Search",
                params: {selected : this.selected, searchWord : this.searchWord,page: 1}
            });
            
            
            
        }
    }

}
</script>

<style scoped>
.category-select{
    border-radius: 20px;
    border:none;
    outline:none;
    background-color: white;
    width : 5em;
    text-align: center;
}

.search-box{
    margin-left: 20%;
    margin-right: 20%;
    margin-top:10%;
    margin-bottom:10%;
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
    width:88%;
    align-self: center;
    border:none;
    background: none;
    outline:none;
    line-height: 40px;
}
</style>