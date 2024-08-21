<template>
  <view class="messages">
    <view v-if="isNull">
      <scroll-view class="message-list" scroll-y="true">
        <ListItem v-for="(stick, index) in posts" :key="index" :post="stick" @delete="deleteStick" @view-details="mainStick" />
      </scroll-view>
    </view>
    <view v-if="!isNull" class="m_tip">
      <text>目前好像没有帖子呢...</text>
    </view>
  </view>
</template>

<script>
import ListItem from '/components/ListItem.vue';

export default {
  components: {
    ListItem
  },
  data() {
    return {
      posts: [], // 存储帖子信息
      isNull: false
    }
  },
  onPullDownRefresh() {
    console.log("下拉刷新");
    this.posts = [];
    this.getUserPosts();
  },
  onShow() {
    this.getUserPosts();
  },
  methods: {
    getUserPosts() {
      const that = this;
      var uID = uni.getStorageSync("id");
      uni.request({
        url: "http://localhost/stick/getUserSticks/" + uID,
        method: 'GET',
        success: (data) => {
          uni.stopPullDownRefresh();
          let userPosts = data.data.data;
          console.log(userPosts);
          if (userPosts.length > 0) {
            that.posts = userPosts;
            that.isNull = true;
          } else {
            that.isNull = false;
          }
        },
        fail: (err) => {
          console.error(err);
          that.isNull = false;
        }
      })
    },
    deleteStick(mid) {
      console.log("删除帖子，mid:", mid);
      uni.request({
        url: "http://localhost/stick/delStickBymID/?mID=" + mid,
        method: 'POST',
        success: (res) => {
          console.log("帖子删除成功", res);
          this.getUserPosts();
        },
        fail: (err) => {
          console.error("帖子删除失败", err);
        }
      })
    },
    mainStick(mid) {
      console.log(mid);
      uni.navigateTo({
        url: '/pages/stick/mainStick?info=' + mid,
        success: (data) => {
          console.log("跳转到指定帖子");
        }
      })
    }
  }
}
</script>

<style>
.messages {
  background-color: #f5f5f5;
}
.message-list {
  height: 100%;
}
.m_tip {
  margin: auto;
  color: #818181;
  text-align: center;
}
</style>
