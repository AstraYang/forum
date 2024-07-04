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
  onPullDownRefresh(){
    console.log("下拉刷新");
    this.posts = [];
    this.getUserPosts();
  },
  onShow(){
    this.getUserPosts();
  },
  methods:{
    // 获取用户的帖子信息
    getUserPosts(){
      const that = this;
      // 获取用户id
      var uID = uni.getStorageSync("id");
      // 发送请求
      uni.request({
        url: "http://localhost/stick/getStarSticks/" + uID,
        method: 'GET',
        success: (data) => {
          uni.stopPullDownRefresh(); // 停止页面刷新
          let userPosts = data.data.data;
          console.log(userPosts);
          if (userPosts.length > 0) {
            that.posts = userPosts;
            console.log("显示开启");
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
    // 跳转到指定帖子
    mainStick(mid){	
      console.log(mid); // 输出 mid 进行调试
      uni.navigateTo({
        url: '/pages/stick/mainStick?info=' + mid,
        success: (data) => {
          console.log("跳转到指定帖子");
        }
      })
    },
	}
};  
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
