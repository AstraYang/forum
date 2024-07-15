<template>
	<view>
		<view class="index-top">
			<view class="search">
				<input type="text" placeholder="输入帖子名关键字搜索" v-model="keyword" />
			</view>
		</view>
			<view class="content">
				<PostItem 
					v-for="(stick, index) in result" 
					:key="index" 
					:post="stick" 
					:httpPath="httpPath"
					@navigateToPost="mainStick"
					@toggleStar="addStar"
					@toggleLike="addLike"
				/>
			</view>
	</view>
</template>

<script>
	import PostItem from '/components/PostItem.vue';

	export default {
		components: {
			PostItem
		},
		data() {
			return {
				isNull: false,
				keyword: "",
				sticks: [],
				pictures: [],
				httpPath: 'http://localhost',
				iconImg: {
					like: "../../static/icon/点赞.png",
					like1: "../../static/icon/like(1).png",
					like2: "../../static/icon/like(2).png"
				}
			}
		},
		onPullDownRefresh() {
			console.log("下拉刷新");
			this.sticks = [];
			this.getSticks();
		},
		onShow() {
			this.getSticks();
		},
		computed: {
			result: function() {
				return this.sticks.filter(s => {
					if(s.mtitle!=null){
						return s.mtitle.indexOf(this.keyword) > -1;
					}
				});
			}
		},
		methods: {
			getSticks() {
				uni.request({
					url: 'http://localhost/stick/getSticks',
					method: 'POST',
					success: data => {
						uni.stopPullDownRefresh();
						this.sticks = data.data.data.sticks;
						this.pictures = data.data.data.pictures;
						if(this.pictures!=""&&this.sticks!=""){
							this.isNull = true;
						}
					}
				})
			},
			mainStick(mID) {
				uni.navigateTo({
					url: '/pages/stick/mainStick?info='+mID,
					success: (data) => {
						console.log("跳转到指定帖子");
					}
				})
			},
			addLike(mLike, mID) {
				mLike++;
				uni.request({
					url: 'http://localhost/stick/addMLike/'+mLike+"/"+mID,
					method: 'GET',
					success: (result) => {
						if(result.statusCode==200){
							this.getSticks();
						}
					}
				})
			},
			addStar(mID) {
				let uID = uni.getStorageSync('id');
				uni.request({
					url: `http://localhost/stick/checkStarred/${mID}/${uID}`,
					method: 'GET',
					success: (response) => {
						if(response.data.data){
							uni.showToast({
								title: '您已经收藏了该帖子',
								icon: 'none',
								duration: 2000
							});
						}else{
							uni.request({
								url: `http://localhost/stick/addStarStick/${uID}/${mID}`,
								method: 'GET',
								success: (result) => {
									if (result.statusCode === 200) {
										uni.showToast({
											title: '收藏成功',
											icon: 'success',
											duration: 2000
										});
									}
								},
								fail: (error) => {
									console.error('收藏失败', error);
									uni.showToast({
										title: '收藏失败',
										icon: 'none',
										duration: 2000
									});
								}
							});
						}
					}
				});
			}
		}
	}
</script>


<style>
	.search {
		width: 90%;
		height: 60rpx;
		padding: 10rpx;
		margin: 0 auto;
		margin-top: 20rpx;
		border-radius: 50rpx;
		background-color: #ffffff;
	}
	.search input{
		width: 95%;
		margin: 0 auto;
		margin-top: 7rpx;
	}
	.content {
		width: 100%;
		min-height: 1000rpx;
		padding: 10rpx 0;
		background-color: #f5f5f5;
	}
	
	.comm {
		width: 95%;
		/* height: 690rpx; */
		min-height: 190rpx;
		border-radius: 20rpx;
		padding: 10rpx 0;
		margin: 15rpx auto;
		background-color: #fff;
	}
	
	.c-top {
		/* background-color: #ff544e; */
		width: 90%;
		height: 100rpx;
		margin: 15rpx auto;
	}
	
	.c-top image {
		vertical-align: middle;
		margin-right: 15rpx;
	}
	
	.c-top text {
		font-weight: bold;
	}
	
	.c-center {
		/* background-color: #ffc54f; */
		width: 90%;
		/* height: 450rpx; */
		margin: 10rpx auto;
		display: flex;
		flex-direction: column;
	}
	
	.c-center .text_box .mtitle{
		line-height: 60rpx;
		font-size: 35rpx;
		margin-left: 5rpx;
		white-space: nowrap;
		/* 文本强制不换行； */
		text-overflow: ellipsis;
		/* 文本溢出显示省略号； */
		overflow: hidden;
		/* 溢出的部分隐藏 */
	}
	
	.c-center image {
		width: 100%;
		margin-top: 10rpx;
		border-radius: 20rpx;
	}
	
	.c-botton {
		/* background-color: #abff73; */
		width: 90%;
		height: 80rpx;
		margin: 0rpx auto;
		margin-top: 30rpx;
		justify-content: space-between;
	}
	
	.c-botton view {
		width: 25%;
		height: 80rpx;
		text-align: center;
	}
	
	.c-botton image {
		width: 60rpx;
		height: 60rpx;
		text-align: center;
		vertical-align: middle;
	}
	
	.c-botton text {
		font-size: 33rpx;
	}
	
	.flex {
		display: flex;
	}
	
	.grow1 {
		flex-grow: 1;
	}
	
	.grow2 {
		flex-grow: 2;
	}
	
	.grow3 {
		flex-grow: 3;
	}
</style>