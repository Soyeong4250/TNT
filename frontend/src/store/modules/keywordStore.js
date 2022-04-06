import http from "@/util/http-common.js";
// import router from "../../router";

export const keywordStore={
	namespaced : true,
	state:() => ({
		preKeyword: [{ keyword: null, rank: 0 }],
		nowKeyword: [{ keyword: null, rank: 0 }],
	}),
	getters:{
		preKeyword: (state) => state.preKeyword,
		
	},
	mutations: {
		SET_UPDATE_KEYWORD(state, results) {
			state.preKeyword = state.nowKeyword;
			console.log(results);
			// results.forEach((result) => {
			// 	for (let index = 0; index < state.preKeyword.length; index++) {
			// 		if(state.preKeyword[index].keyword == result){

			// 		};
					
			// 	}
			// })
	
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