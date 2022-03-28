import { createRouter, createWebHistory } from "vue-router";
import Main from "@/views/MainPage.vue";
import Search from "@/views/SearchPage.vue";
import User from "@/views/user/UserPage.vue"

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
    path: "/user",
    name: "User",
    component: User,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
