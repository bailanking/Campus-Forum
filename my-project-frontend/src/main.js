import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from "axios";

import 'element-plus/theme-chalk/dark/css-vars.css'

// 统一配置后端 API 根地址，项目内所有 axios 请求都会基于此地址拼接。
axios.defaults.baseURL = 'http://localhost:8080'

// 创建根应用实例并注册路由。
const app = createApp(App)

app.use(router)

// 挂载到 index.html 中的 #app 节点。
app.mount('#app')
