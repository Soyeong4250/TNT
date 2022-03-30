import { createStore } from "vuex";
import { accountStore } from "./modules/accountStore";
export default createStore({
	modules: {accountStore},
});