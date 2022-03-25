import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import BootstrapVue3 from 'bootstrap-vue-3'
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.js";

window.Kakao.init('63b35f75c8e0feae168a685a7e81e0fc');
createApp(App).use(store).use(router).use(BootstrapVue3).mount('#app')