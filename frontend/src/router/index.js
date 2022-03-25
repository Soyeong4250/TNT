import { createRouter, createWebHistory } from 'vue-router'
import Main from "@/views/MainPage.vue"
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
      path: '/notice',
      name: 'NoticeLPage',
      component: NoticePage,
      redirect: "/notice/list",
      children: [
        {
          path: "list",
          name: "NoticeList",
          component: NoticeList,
        },
        {
          path: "write",
          name: "NoticeWrite",
          component: NoticeWrite,
        },
        {
          path: "detail/:noticeno",
          name: "NoticeView",
          component: NoticeView,
        },
        {
          path: "modify/:noticeno",
          name: "NoticeModify",
          component: NoticeModify,
        }
      ],
    },
]
  
  const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
  })
  
  export default router
  