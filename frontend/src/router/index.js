import { createRouter, createWebHistory } from "vue-router";
import Main from "@/views/MainPage.vue";
import Search from "@/views/SearchPage.vue";
import Login from "@/views/users/UserLogin.vue";
import Register from "@/views/users/UserRegister.vue"
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
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
