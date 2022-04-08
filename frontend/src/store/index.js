import { createStore } from "vuex";
import { accountStore } from "./modules/accountStore";
import { searchStore } from "./modules/searchStore";
import { keywordStore } from "./modules/keywordStore";
import {newsStore} from "./modules/newsStore";
import createPersistedState from "vuex-persistedstate";


export default createStore({
	modules: {
		accountStore : accountStore,
		searchStore : searchStore,
		keywordStore : keywordStore,
		newsStore : newsStore,
	},
	plugins: [createPersistedState()],
});