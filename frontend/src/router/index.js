import { createRouter, createWebHistory } from "vue-router";
import Main from "@/views/MainPage.vue";
import Search from "@/views/SearchPage.vue";

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
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
