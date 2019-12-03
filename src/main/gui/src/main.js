import Vue from 'vue'
import App from './App.vue'
import ElementUI from "element-ui";
import axios from "axios"
import {formatDate} from "./utils/TimeFormater"

Vue.config.productionTip = false;
Vue.use(ElementUI);
Vue.config.productionTip = false;
// let apiUrl = "http://localhost:8080/public/api";
let apiUrl = "/public/api"

axios.defaults.baseURL = apiUrl;
axios.defaults.withCredentials = true;
Vue.prototype.axios = axios;
axios.interceptors.response.use(function (response) {
    return response;
}, function (error) {
    if (error.response.data.status == 500) {
        Vue.prototype.$message({
            message: error.response.data.message,
            type: "error"
        });
    }
    return Promise.reject(error);
});

Vue.filter("formatDate", formatDate);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>'
})
