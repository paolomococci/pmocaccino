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
    path: '/add',
    name: 'AddArticleView',
    component: () => import('../views/AddArticleView.vue')
  },
  {
    path: '/list',
    name: 'ListArticleView',
    component: () => import('../views/ListArticleView.vue')
  },
  {
    path: '/detail',
    name: 'DetailArticleView',
    component: () => import('../views/DetailArticleView.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
