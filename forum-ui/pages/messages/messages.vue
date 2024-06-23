<template>
	<view class="messages">  
		<view v-if="isNull">
			<scroll-view class="message-list" scroll-y="true">
			  <view v-for="(m,index) in messages" :key="index" class="message-item">  
			    <uni-card :title="m.uname" sub-title="@评论了你" extra="评论消息" 
						  :thumbnail="'http://localhost'+m.uavatar"
						  @click="mainStick(m.mid)">
			    	<text>{{m.rcontent}}</text>
			    </uni-card>
			  </view>  
			</scroll-view> 
		</view>
		<view v-if="isNull==false" class="m_tip">
			<text>目前好像没有人回复呢OwO...</text>
		</view>
	  </view>  
</template>

<script>
	export default {  
	  data() {  
	    return {  
	      messages:{},
		  isNull:false
	    }
	  },
	  onPullDownRefresh(){
		  console.log("下拉刷新");
		  this.messages={};
		  this.getReplies();
	  },
	  onShow(){
	  	this.getReplies();
	  },
	  methods:{
		  //获取该用户帖子的回复贴
		  getReplies(){
			const that = this;
			//获取用户id
			var uID = uni.getStorageSync("id");
			//发送请求
			uni.request({
				url:"http://localhost/reply/getUMReplies/"+uID,
				method:'GET',
				success: (data) => {
					uni.stopPullDownRefresh();//停止页面刷新
					let uReplies=data.data.data.uReplies;
					console.log(uReplies);
					if(uReplies!=""){
						that.messages=data.data.data.uReplies;
						console.log("显示开启");
						that.isNull=true;
					}
				}
			})
		  },
		  //跳转到指定帖子 在index有相同方法，空余弄下全局方法
		  mainStick(mID){	
			  // let mData={
			  // 	uid:info.uid,
			  // 	mid:info.mid,
			  // 	uname:info.uname,
			  // 	uavatar:info.uavatar
			  // };
			  // console.log(mData);
			  uni.navigateTo({
			  	url: '/pages/stick/mainStick?info='+mID,
			  	success: (data) => {
			  		console.log("跳转到指定帖子");
			  	}
			  })
		  }
	  }
	};  
</script>

<style>
	.messages{
		background-color: #f5f5f5;
	}
	.message-list {  
	  height: 100%;  
	}  
	.message-item {  
	}  
	.m_tip{
		margin: auto;
		color:#818181;
		text-align: center;
	}
</style>