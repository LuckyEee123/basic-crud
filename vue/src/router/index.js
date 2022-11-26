import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../views/Layout.vue'
import Cookies from 'js-cookie'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect: '/home',
    children : [
      {
        path: 'home',
        name: 'Home',
        component: () => import('@/views/home/HomeView.vue'),
      },
      // ====== User ======
  {
    path: 'user',
    name: 'User',
    component: () => import('@/views/users/User.vue'),
  },
    {
    path: 'addUser',
    name: 'AddUser',
    component: () => import('@/views/users/AddUser.vue'),
  },
  {
    path: 'editUser',
    name: 'EditUser',
    component: () => import('@/views/users/EditUser.vue'),
  },
  // ====== Admin ======
  {
    path: 'admin',
    name: 'Admin',
    component: () => import('@/views/admin/Admin.vue'),
  },
    {
    path: 'addAdmin',
    name: 'AddAdmin',
    component: () => import('@/views/admin/AddAdmin.vue'),
  },
  {
    path: 'editAdmin',
    name: 'EditAdmin',
    component: () => import('@/views/admin/EditAdmin.vue'),
  },
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/login/Login.vue'),
  },
  {
    path: "*",
    component: () => import('@/views/404.vue')
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  if (to.path === '/login') next()
  const admin = Cookies.get("admin")
  if (!admin && to.path !== '/login') return next("/login")  // 强制退回到登录页面
  // 访问 /home 的时候，并且cookie里面存在数据，这个时候我就直接放行
  next()
})

export default router
