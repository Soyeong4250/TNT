import { createStore } from "vuex";
import http from "@/util/http-common.js";

export default createStore({
	state: {
		notices: [],
		notice: {},

	},
	getters : {
		notices: state => state.notices,
		notice: state => state.notice,
	},
	mutations: {
		SET_NOTICE_LIST(state, notices) {
			state.notices = notices;
		},
		SET_NOTICE(state, notice) {
			state.notice = notice;
		}
	},
	actions: {
		getNoticeList({ commit }) {
			http.get('/notice')
			.then((response) => {
				console.log(response.data);
				commit("SET_NOTICE_LIST", response.data);
			})
			.catch((error) => {
				console.log(error);
			});
		},
		getNotice(context, noticeno) {
			http.get(noticeno).then(({ data }) => {
				context.commit("SET_NOTICE", data);
			});
		},
	},
	modules: {},
});