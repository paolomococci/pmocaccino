import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter);

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
    path: '/add',
    name: 'AddEmployeeView',
    component: () => import('../views/AddEmployeeView.vue')
  },
  {
    path: '/list',
    name: 'ListEmployeesView',
    component: () => import('../views/ListEmployeesView.vue')
  },
  {
    path: '/detail',
    name: 'EmployeeDetailsView',
    component: () => import('../views/EmployeeDetailsView.vue')
  }
];

const router = new VueRouter({
  routes
});

export default router;
