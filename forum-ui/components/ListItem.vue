<template>
  <view class="message-item">
    <uni-card>
      <view class="card-content">
        <text class="mtitle">{{ post.mtitle }}</text>
       <view class="delete-btn" @click="deleteStick(post.mid)">
          <image src="../static/icon/删除.png"></image>
        </view>
        <view class="view-details" @click="mainStick(post.mid)">
          <text>查看详情</text>
        </view>
      </view>
    </uni-card>
  </view>
</template>

<script>
export default {
  props: {
    post: Object
  },
   methods: {
    deleteStick(mid) {
      this.$emit('delete', mid);
    },
    mainStick(mid) {
      this.$emit('view-details', mid);
    }
  }
}
</script>

<style scoped>
.message-item {
  margin-bottom: 10px;
}
.uni-card {
  border-radius: 10px;
  overflow: hidden;
}
.card-content {
  display: flex;
  align-items: center;
  padding: 10px;
}
.delete-btn {
  margin-right: 10px;
  padding: 5px;
  cursor: pointer;
}
.delete-btn image {
  width: 50rpx;
  height: 50rpx;
  margin: 0 10px;
}
.mtitle {
  font-size: 18px;
  color: #333;
  flex: 1;
}
.view-details {
  color: #007aff;
  font-size: 14px;
  cursor: pointer;
}
</style>
