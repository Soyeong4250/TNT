import http from "@/util/http-common.js";
// import router from "../../router";

export const keywordStore={
	namespaced : true,
	state:() => ({
		preKeywords: [{ value: null, rank: 0 }],
		nowKeywords: [{ value: null, rank: 0 }],
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
			state.nowKeywords= [{ keyword: null, rank: 0 }];
			console.log(results);
			results.forEach((result) => {
				// console.log(results.indexOf(result));
				state.nowKeywords.push({ value: result, rank: results.indexOf(result)});
			})
	
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