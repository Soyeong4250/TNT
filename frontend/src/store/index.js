import { createStore } from "vuex";
import { accountStore } from "./modules/accountStore";
import createPersistedState from "vuex-persistedstate";


export default createStore({
	modules: {
		accountStore : accountStore
	},
	plugins: [createPersistedState()],
});