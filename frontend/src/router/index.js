import { createRouter, createWebHistory } from "vue-router";
import Main from "@/components/main-content.vue";
import Search from "@/views/SearchPage.vue";
import UserPage from "@/views/UserPage.vue";
import UserLogin from "@/views/users/UserLogin.vue";
import UserRegister from "@/views/users/UserRegister.vue"
import Profile from "@/views/users/UserProfile.vue"
import FindId from "@/views/users/find/FindId.vue";
import FindPwd from "@/views/users/find/FindPwd.vue";
import FindIdResult from "@/views/users/find/FindIdResult.vue";
import FindPwdResult from "@/views/users/find/FindPwdResult.vue";

import NoticePage from "@/views/NoticePage.vue";
import NoticeList from "@/components/notice/NoticeList.vue";
import NoticeWrite from "@/components/notice/NoticeWrite.vue";
import NoticeView from "@/components/notice/NoticeView.vue";
import NoticeModify from "@/components/notice/NoticeModify.vue";

import NaverLogin from "@/views/social/NaverLogin.vue";

const routes = [
  {
    path: "/",
    name: "Main",
    component: Main,
  },
  {
    path: "/search/:selected/:searchWord/:page",
    name: "Search",
    component: Search,
  },
  {
    path:"/profile",
    name:"Profile",
    component: Profile,
  },
  {
    path: '/users',
    name : 'UserPage',
    component: UserPage,
    redirect: "/users/login",
    children:[
      {
        path:"login",
        name: "UserLogin",
        component: UserLogin,
      },
      {
        path:"register",
        name:"UserRegister",
        component: UserRegister,
      },
      {
        path: "find/id",
        name: "FindId",
        component: FindId,
      },
      {
        path: "find/pwd",
        name: "FindPwd",
        component: FindPwd,
      },
      {
        path: "find/idResult",
        name: "FindIdResult",
        component: FindIdResult,
      },
      {
        path: "find/pwdResult",
        name: "FindPwdResult",
        component: FindPwdResult,
      },
    ]
  },
  {
    path: '/notice',
    name: 'NoticePage',
    component: NoticePage,
    redirect: "/notice/list/1",
    children: [
      {
        path: "list/:page",
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
  {
    path: '/social/naver',
    name: 'NaverLogin',
    component: NaverLogin,
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
  
