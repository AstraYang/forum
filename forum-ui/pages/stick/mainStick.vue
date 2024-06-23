<template>
	<!-- 主贴部分 -->
	<view class="mainStick" v-if="isShow" >
		<!-- 头部图片 -->
		<view class="m_img" v-if="isImg" >
			<image :src="'http://localhost'+pictures[0].pname" 
					@click="previewImg('http://localhost'+pictures[0].pname)"
				    mode="aspectFit"></image>
		</view>
		<!-- 标题 -->
		<view class="m_title">
			<text>{{stickInfo.mtitle}}</text>
		</view>
		<!-- 内容 -->
		<view class="m_content">
			<!-- 用户信息 -->
			<uni-card :thumbnail="'http://localhost'+stickInfo.uavatar" 
					  :title="stickInfo.uname" :isFull="true" 
					  shadow="0px 0px 0px 0px rgba(0, 0, 0, 0.08)">
				<!-- 主贴文本内容 -->
				<view class="m_text">
					{{stickInfo.mcontent}}
					<!-- 图片内容 -->
					<view v-for="(p,index) in pictures">
						<image v-if="index!=0" :src="'http://localhost'+p.pname" 
							   @click="previewImg('http://localhost'+p.pname)" 
							   mode="aspectFit"></image>
					</view>
				</view>
			</uni-card>
		</view>
	</view>
	<!-- 回复贴部分 -->
	<view class="reply">
		<!-- 顶部部分 -->
		<view class="reply_top">
			<text>评论</text>
			<text></text>
		</view>
		<!-- 用户回复部分 -->
		<view class="reply_content">
			<view v-if="isReplies==false" class="r_tip">好像还没有人留言呢OwO</view>
			<view v-for="(r,index) in replies">
				<view class="r_user">
					<view class="r_user_left">
						<image class="r_uAvatar" :src="'http://localhost'+r.uavatar"></image>
						<text>{{r.uname}}</text>
					</view>
					<view class="r_user_right">
						<image src="../../static/icon/like(1).png"></image>
						<text>{{r.rlike}}</text>
					</view>
				</view>
				<!-- 文本内容 -->
				<view class="r_text">
					<view>
						<text>{{r.rcontent}}</text>
					</view>
					<view>
						<text>{{r.rcreateTime}}</text>
					</view>
				</view>
			</view>
		</view>
	</view>
	<!-- 文本框部分 -->
	<view class="reply_box">
		<view class="input_box">
			<input type="text" placeholder="说点什么吧 ~" v-model="replyText"/>
		</view>
<!-- 		<view class="img_box">
			<image src="../../static/icon/Grey_likes.png"></image>
		</view> -->
		<view class="img_box" @click="addReply()">
			<image src="../../static/icon/my1.png"></image>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				info:{},//从隔壁页面获取主贴的信息，包含该用户信息
				stickInfo:{},
				pictures:{},
				replies:{},
				replyText:"",
				isShow:false,
				isImg:false,
				isReplies:false
			}
		},
		onLoad(info) {
			console.log("onLoad");
			console.log(info.info);
			var mID=info.info;
			// //接收info
			// this.info = JSON.parse(info.info);
			// console.log(this.info);
			//主贴和回复贴信息
			this.getStick(mID);
			this.getReplies(mID);
		},
		onBackPress(){
			console.log("onBackPress");
		},
		methods: {
			//获取主贴信息
			getStick(mid){
				uni.request({ //根据mid获取
					url:"http://localhost/stick/getStick/"+mid,
					method:'GET',
					success: (data) => {
						let d = data.data.data;
						this.stickInfo = d.stickVo;
						this.pictures = d.pictures;
						if(this.pictures!=""){
							//开启显示图片
							this.isImg=true;
						}
						if(this.stickInfo!=""){
							//开启显示
							this.isShow=true;
						}
						console.log("主贴信息")
						console.log(this.stickInfo);
						console.log("图片信息")
						console.log(this.pictures);
					}
				})
			},
			//获取回复贴信息
			getReplies(mid){
				uni.request({ //根据mid获取
					url:"http://localhost/reply/getReplies/"+mid,
					method:'GET',
					success: (data) => {
						this.replies={};
						let d = data.data.data;
						this.replies = d.replies;
						if(this.replies!=""){
							//显示回复贴
							this.isReplies=true;
						}
						console.log("回复贴信息")
						console.log(this.replies);
					}
				})
			},
			//添加回复贴
			addReply(){
				//获取本用户ID
				var uID = uni.getStorageSync("id");
				//获取本主贴ID
				var mID = this.stickInfo.mid;
				//获取回复内容
				var rContent = this.replyText;
				//获取评论数 加1
				var mReplies = this.stickInfo.mreplies+1;
				//发送请求
				uni.request({
					url:'http://localhost/reply/addReply',
					method:'POST',
					data:{
						uID:uID,
						mID:mID,
						rContent:rContent,
						mReplies:mReplies
					},
					header:{
						"Content-Type": "application/x-www-form-urlencoded"
					},
					success: data =>{
						console.log(data);
						//刷新数据
						this.getReplies(mID);
					}
				})
			},
			//简单点赞
			addLike(mLike,mID) {
				mLike++;
				uni.request({
					url: 'http://localhost/stick/addMLike/'+mLike+"/"+mID,
					method: 'GET',
					success:(result)=>{
						console.log(result);
						if(result.statusCode==200){
							this.getSticks();//直接全部刷新 2333
							// this.iconImg.like=this.iconImg.like2;
						}
					}
				})
			},
			//图片预览
			previewImg(url){
				uni.previewImage({
					current:0,
					urls:[url]
				})
			}
		}
	}
</script>

<style lang="scss">
	.mainStick {
		display: flex;
		flex-direction: column;
	}
	.m_img {
		background-color: #fff;
		position: relative;
	}
	.m_img image {
		width: 100%;
	}
	.m_text{
		padding-bottom: 90rpx;
	}
	.m_text view{
		text-align: center;
	}
	.m_title{
		font-size: 70rpx;
		padding-left: 30rpx;
		background-color: #fff;
	}
	.r_tip{
		margin: auto;
		color:#818181;
		text-align: center;
	}
	.reply{
		width: 100%;
		min-height: 500rpx;
		margin-top: 10rpx;
		padding-bottom: 100rpx;
		background-color: #fff;
	}
	.reply_top{
		line-height: 100rpx;
		padding: 0 20rpx;
		// background-color: #f08874;
		font-size: 35rpx;
		border-bottom: 3rpx solid #f5f5f5;
	}
	.reply_content{
		min-height: 100rpx;
		// background-color: #00e36e;
		padding-top: 40rpx;
		padding-bottom: 30rpx;
		border-bottom: 3rpx solid #f5f5f5;
	}
	.r_user{
		width: 97%;
		margin: 0 auto;
		height: 100rpx;
	}
	.r_user_left{
		float: left;
	}
	.r_user_right{
		float: right;
		margin-right: 20rpx;
	}
	.r_user_right image{
		width: 60rpx;
		height: 60rpx;
		margin-right: 10rpx;
	}
	.r_user_right text{
		line-height: 20rpx;
	}
	.r_uAvatar{
		width: 95rpx;
		height: 95rpx;
		border-radius: 50%;
		margin: 0 10rpx;
		vertical-align: middle;
	}
	.r_text{
		width: 95%;
		margin: 20rpx auto;
		padding-top: 10rpx;
	}
	.reply_box{
		width: 100%;
		height: 100rpx;
		background-color: #ffffff;
		box-shadow: 2rpx 2rpx 5rpx 2rpx rgba(48, 48, 48, 0.2);
		position: fixed;
		bottom: 0;
		display: flex;
	}
	.input_box{
		height: 75rpx;
		background-color: #f5f5f5;
		border-radius: 10rpx;
		margin: auto 10rpx;
	}
	.input_box{
		width: 85%;
		margin-left: 18rpx;
	}
	.input_box input{
		width: 95%;
		padding: 15rpx 10rpx;
		color: #b2b2b2;
	}
	.img_box image{
		margin: 15rpx;
		width: 65rpx;
		height: 65rpx;
	}
</style>