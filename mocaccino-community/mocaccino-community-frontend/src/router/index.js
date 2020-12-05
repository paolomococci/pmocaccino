import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/about',
    name: 'AboutView',
    component: () => import('../views/AboutView.vue')
  },
  {
    path: '/company',
    name: 'CompanyView',
    component: () => import('../views/CompanyView.vue')
  },
  {
    path: '/contest',
    name: 'ContestView',
    component: () => import('../views/ContestView.vue')
  },
  {
    path: '/employee',
    name: 'EmployeeView',
    component: () => import('../views/EmployeeView.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
