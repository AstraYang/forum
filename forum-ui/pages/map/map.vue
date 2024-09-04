<script setup>
import { onMounted, onUnmounted } from "vue";
import AMapLoader from "@amap/amap-jsapi-loader";

let map = null;

onMounted(() => {
  AMapLoader.load({
    key: "2b22b00de5eeac33ac154369a8ab3b62",
    version: "2.0",
  })
    .then((AMap) => {
      const center = [119.16864499999997, 26.065248999999998];
      const zoom = 16; // 根据需要调整缩放级别

      map = new AMap.Map("container", {
        viewMode: "3D", // 3D地图模式
        center: center,
        zoom: zoom,
      });

      // 添加标记（可选）
      const marker = new AMap.Marker({
        position: center,
        title: "闽江学院",
      });
      map.add(marker);
    })
    .catch((e) => {
      console.error(e);
    });
});

onUnmounted(() => {
  map?.destroy(); // 在组件卸载时销毁地图实例
});
</script>

<template>
  <div id="container"></div>
</template>

<style scoped>
#container {
  width: 100%;
  height: 800px;
}
</style>
