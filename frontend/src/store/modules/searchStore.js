import http from "@/util/http-common.js";
import router from "../../router";

export const searchStore={
	namespaced : true,
	state:() => ({
		selected : "",
		searchWord: "",
		news: [],
	}),
	getters:{
		selected: (state) => state.selected,
		searchWord: (state) => state.searchWord,
		news: (state) => state.news,
	},
	mutations: {
		// SET_SEARCH_TITLE(state, searchData) {
		// 	console.log(searchData);
		// 	state.searchWord = searchData.searchWord;
		// 	state.news = searchData;
		// 	console.log(state.news);
		// 	router.push({name: "Search"});
		// },
		// SET_SEARCH_CONTENT(state, searchData) {
		// 	// state.n = news;
		// 	// console.log(state.news);
		// 	state.searchWord = searchData.searchWord;
		// 	console.log(state.news);
		// 	router.push({name: "Search"});
		// },
		// SET_SEARCH_COMPANY(state, result) {
		// 	console.log(result);
		// 	state.news = result.content;
		// 	router.push({name: "Search"});
		// },
		SET_SEARCH_NEWS(state, result) {
			//console.log(result);
			state.searchWord = "";
			state.news = [];
			state.news = result.content;
			state.searchWord = result.searchWord;
			router.push({name: "Search"});
		},
	},
	actions: {
		GET_SEARCH_TITLE({ commit }, searchData) {
			
			http.get(`/news/find/title`, {params : {title: searchData.searchWord, page: searchData.page}})
      .then((response) => {
        //console.log("제목 검색 결과");
				//console.log(response.data.content);
        //let msg = "제목 검색시 문제가 발생했습니다.";
        if(response.status == 200) {
         // msg = "제목 검색이 완료되었습니다.";
          // this.news = data;
					// commit("SET_SEARCH_TITLE", {content : response.data.content, searchWord: searchData.searchWord});
					commit("SET_SEARCH_NEWS", {content : response.data.content, searchWord: searchData.searchWord});
        }
        //console.log(msg);
        });
		},
		GET_SEARCH_CONTENT({ commit }, searchData) {
			
			http.get(`/news/find/content`, {params : {content: searchData.searchWord, page: searchData.page}})
      .then((response) => {
				//console.log("내용 검색 결과")
        //console.log(response.data.content);
        //let msg = "내용 검색시 문제가 발생했습니다.";
        if(response.status == 200) {
          //msg = "내용 검색이 완료되었습니다.";
          // this.news = data;
					// commit("SET_SEARCH_CONTENT", {content : response.data.content, searchWord: searchData.searchWord});
					commit("SET_SEARCH_NEWS", {content : response.data.content, searchWord: searchData.searchWord});
        }
        //console.log(msg);
        });
		},
		GET_SEARCH_COMPANY({ commit }, searchData) {
			//console.log(searchData.page);
			//console.log(searchData);
			http.get(`/news/find/company`, {params : {company: searchData.searchWord, page: searchData.page}})
			.then((response) => {
				//console.log("언론사 검색 결과")
				//console.log(response.data.content);
				//let msg = "언론사 검색시 문제가 발생했습니다.";
				if(response.status == 200) {
					//msg = "언론사 검색이 완료되었습니다.";
					// this.news = data;
					// commit("SET_SEARCH_COMPANY", {content : response.data.content, searchWord: searchData.searchWord});
					commit("SET_SEARCH_NEWS", {content : response.data.content, searchWord: searchData.searchWord});
				}
				//console.log(msg);
				});
		}
	},
}