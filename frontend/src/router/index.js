import { createRouter, createWebHistory } from 'vue-router'
import Main from "@/views/MainPage.vue";
import Search from "@/views/SearchPage.vue";
import User from "@/views/user/UserPage.vue";

import NoticePage from "@/views/NoticePage.vue";
import NoticeList from "@/components/notice/NoticeList.vue";
import NoticeWrite from "@/components/notice/NoticeWrite.vue";
import NoticeView from "@/components/notice/NoticeView.vue";
import NoticeModify from "@/components/notice/NoticeModify.vue";

const routes = [
    {
      path: '/',
      name: 'Main',
      component: Main
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
    {
      path: '/notice',
      name: 'NoticePage',
      component: NoticePage,
      redirect: "/notice/list",
      children: [
        {
          path: "list",
          name: "NoticeList",
          component: NoticeList,
        },
        {
          path: "regist",
          name: "NoticeWrite",
          component: NoticeWrite,
        },
        {
          path: "detail/:no",
          name: "NoticeView",
          component: NoticeView,
        },
        {
          path: "modify/:no",
          name: "NoticeModify",
          component: NoticeModify,
        }],
    },
];
  
  const router = createRouter({
    history: createWebHistory(),
    routes
  })
  
  export default router
  