import http from "@/util/http-common.js";
// import router from "../../router";

export const keywordStore={
	namespaced : true,
	state:() => ({
		preKeywords: [{ value: null, count: 0 }],
		nowKeywords: [{ value: null, count: 0 }],
	}),
	getters:{
		keywordRank (state){
			return state.nowKeywords.filter(nowKeyword=>nowKeyword.value)
			// return state.nowKeywords.filter((nowKeyword) => {
			// 	console.log(nowKeyword.value);
			// 	return nowKeyword.value;
			// });
		},
		// keywordWord: state => {
		// 	return state.nowKeywords.filter(nowKeyword => nowKeyword.keyword);
		// },

	},
	mutations: {
		SET_UPDATE_KEYWORD(state, results) {
			state.preKeywords = state.nowKeywords;
			state.nowKeywords= [];
			console.log(results);			
			Object.keys(results).forEach((k)=>{
				state.nowKeywords.push({
					value: k,
					count:  results[k],
				})
			})
			console.log("키워드 결과");
			console.log(state.nowKeywords);	
		},
	},
	actions: {
		GET_UPDATE_KEYWORD({ commit }) {
			http.get(`/keyword`)
			.then((response) => {
					console.log("가져온 키워드 결과");
					console.log(response);
					let msg = "키워드를 가져오지 못했습니다.";
					if(response.status == 200) {
							msg = "키워드를 가져왔습니다.";
							commit("SET_UPDATE_KEYWORD", response.data);
					}
					console.log(msg);
			});
			
		}
	},
}