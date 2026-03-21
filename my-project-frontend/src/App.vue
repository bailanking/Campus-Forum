<script setup>
import { useDark, useToggle } from '@vueuse/core'

// 根据 html 的 class 标记维护明暗主题状态。
useDark({
  selector: 'html',
  attribute: 'class',
  valueDark: 'dark',
  valueLight: 'light'
})

// 主题变化时触发切换，确保状态同步。
useDark({
  onChanged(dark) { useToggle(dark) }
})

</script>

<template>
  <header>
    <div class="wrapper">
      <router-view/>
    </div>
  </header>
</template>

<style scoped>
header {
  line-height: 1.5;
}
</style>
