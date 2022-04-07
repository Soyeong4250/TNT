import { createStore } from "vuex";
import { accountStore } from "./modules/accountStore";
import {newsStore} from "./modules/newsStore";
import createPersistedState from "vuex-persistedstate";


export default createStore({
	modules: {
		accountStore : accountStore,
		newsStore : newsStore,
	},
	plugins: [createPersistedState()],
});