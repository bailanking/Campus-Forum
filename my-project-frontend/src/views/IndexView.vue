<template>
  <div>
    <el-button @click="userLogout">退出登录</el-button>
  </div>
</template>

<script setup>
import { logout } from '@/net'
import router from "@/router";

// 退出登录后回到欢迎页。
function userLogout() {
  logout(() => router.push("/"))
}
</script>

<style scoped>

</style>
