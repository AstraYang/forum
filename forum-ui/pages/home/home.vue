<template>
	<view class="content">
		<view class="h-user">
			<view class="h-user-left">
				<image :src="uAvatarPath" @click="updateUImg"></image>
				<text>{{userData.uname}}</text>
			</view>
			<view class="h-user-right" @click="isLogin"><text>{{asUsertext}}</text></view>
		</view>
		<view class="h-list" @click="myStick(userData.uid)">
			<image src="../../static/img/我的帖子.png"></image><text>我的帖子</text>
		</view>
		
		<view class="h-list" >
			<image src="../../static/img/收藏.png"></image><text>我的收藏</text>
		</view>
		
		<view class="h-list" @click="addStick">
			<image src="../../static/img/发布.png"></image><text>发布帖子</text>
		</view>
		
		<view class="h-list" @click="update">
			<image src="../../static/img/个人信息-my.png"></image><text>更改个人信息</text>
		</view>
		
		<view class="h-list">
			<image src="../../static/img/更多.png"></image><text>更多</text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				userData: [],
				imgPaths: [],
				asUsertext: "点我登录",
				httpPath:"http://localhost",
				uAvatarPath: ""
			}
		},
		onPullDownRefresh() {
			console.log("下拉刷新");
			this.userData = [];
			this.getUser();
		},
		onShow() {
			console.warn("进入onShow");
			this.getUser();
		},
		methods: {
			//按id获取用户数据
			getUser(){
				let id = uni.getStorageSync('id');
				if (id != null) {
					this.asUsertext = "切换用户"
				}
				uni.request({
					url: 'http://localhost/user/getUser/' + id,
					method: 'GET',
					success: data => {
						uni.stopPullDownRefresh();//停止页面刷新
						this.userData = data.data.data;
						this.uAvatarPath=this.httpPath+this.userData.uavatar;
						console.log(this.uAvatarPath);
						console.log(this.userData)
						//存放到Storage
						uni.setStorage({
							key: 'userData',
							data: this.userData,
							success: function() {
								console.log('异步Storage成功');
							}
						});
					},
					fail: (res) => {
						console.log('get失败');
						console.log(res.data);
					}
				});
			},
			//跳转到用户信息更改界面
			update() {
				uni.navigateTo({
					url: "/pages/home/update"
				})
			},
			//跳转到登录界面
			isLogin() {
				uni.navigateTo({
					url: "/pages/user/login",
				})
			},
			//跳转到我的主贴
			myStick(uID) {
				uni.navigateTo({
					url: "/pages/user/userSticks?uid="+uID
				})
			},
			//更新用户图片
			updateUImg() {	
				uni.showToast({	//提示弹窗
					title: "正在进入更改头像",
					icon: 'none',
					duration: 1000
				});
				uni.chooseImage({ //获取文件以及文件名
					count: 1,
					sourceType: ['album'], //从相册选择
					success: (img) => {
						console.log('这是img:');
						console.log(img);
						var that = this;//解决this指向问题
						that.userData.uAvater = img.tempFiles[0].name;//数据同步图片名称
						console.log('这是图片名称:'+img.tempFiles[0].name);
						that.imgPaths = img.tempFilePaths;//获取图片临时路径
						uni.uploadFile({ //图片数据上传
							url: "http://localhost/user/updateAvatar", // 请求地址
							filePath: that.imgPaths[0], // 临时文件路径
							name: "uAvatarImg", // 文件对应的key值
							formData: { // 额外的请求数据
								uID:that.userData.uid
							},
							success: (res) => { // 成功后的回调
								console.log("修改成功");
								var path = JSON.parse(res.data).data;
								that.uAvatarPath=that.httpPath+path;
								console.log('这是图片路径:'+that.uAvatarPath);
							}
						})
					}
				})
			},
			//发布帖子
			addStick(){
				uni.navigateTo({
					url: "/pages/stick/addStick"
				})
			}
		}
	}
</script>

<style lang="scss">
	.content {
		width: 100%;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.uni-flex {
		display: flex;
	}

	.h-user {
		width: 100%;
		height: 4.5rem;
		background-color: #55aaff;
		color: #333333;
	}

	.h-user-left {
		float: left;
		width: 70%;
	}

	.h-user-left image {
		border-radius: 50%;
		width: 130rpx;
		height: 130rpx;
		vertical-align: middle; //图片旁的文字自动居中
		margin: 25rpx;
		border: 5px #fff solid;
	}

	.h-user-left text {
		font-size: 40rpx;
	}

	.h-user-right {
		float: right;
		margin-right: 30rpx;
		line-height: 200rpx;
	}
	.h-list {
		width: 100%;
		height: 100rpx;
		background-color: #fff;
		margin-left: 30rpx;
		margin-top: 30rpx;
		border-bottom: 1px solid #905997;
		display: flex;
		flex-direction: row;
		align-items: center;
		padding-bottom: 20rpx;
	}

	.h-list image {
		width: 75rpx;
		height: 75rpx;
		margin: 0 10px;
	}

	.h-list:active {
		background-color: #979891;
	}
</style>