import { createRouter, createWebHistory } from "vue-router";
import Main from "@/views/MainPage.vue";
import Search from "@/views/SearchPage.vue";
import Login from "@/views/users/UserLogin.vue";
import Register from "@/views/users/UserRegister.vue"
import FindId from "@/views/users/FindId.vue";
import FindPwd from "@/views/users/FindPwd.vue";
const routes = [
  {
    path: "/",
    name: "Main",
    component: Main,
  },
  {
    path: "/search",
    name: "Search",
    component: Search,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/register",
    name: "Register",
    component: Register,
  },
  {
    path: "/find/id",
    name: "FindId",
    component: FindId,
  },
  {
    path: "/find/pwd",
    name: "FindPwd",
    component: FindPwd,
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
