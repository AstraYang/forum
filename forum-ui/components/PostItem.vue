<template>
	<view class="comm" @click="navigateToPost(post.mid)">
		
		<view class="c-top">
			<image :src="httpPath + post.uavatar" style="width: 100rpx;height: 100rpx;border-radius: 50%;"></image>
			<text>{{post.uname}}</text>
		</view>
		<view class="c-center">
			<view class="text_box">
				<text class="mtitle">{{post.mtitle}}</text>
			</view>
		</view>
		<view class="c-botton flex">
			<view @click="toggleStar(post.mid)">
				<image src="../static/img/收藏.png"></image>
			</view>
			<view>
				<image src="../static/icon/留言.png"></image>
				<text>{{post.mreplies}}</text>
			</view>
			<view @click="toggleLike(post.mlike, post.mid)">
				<image :src="getLikeIcon(post.mlike)"></image>
				<text>{{post.mlike}}</text>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		props: {
			
			post: Object,
			httpPath: String,
		},

		methods: {
		
			navigateToPost(mID) {
				this.$emit('navigateToPost', mID);
			},
			toggleStar(mID) {
				this.$emit('toggleStar', mID);
			},
			toggleLike(mLike, mID) {
				this.$emit('toggleLike', mLike, mID);
			},
			getLikeIcon(mLike) {
				return mLike > 0 ? '../../static/icon/点赞.png' : '../../static/icon/like(1).png';
			}
		}
	}
</script>

<style scoped>
	.comm {
		width: 95%;
		min-height: 190rpx;
		border-radius: 20rpx;
		padding: 10rpx 0;
		margin: 15rpx auto;
		background-color: #fff;
	}

	.c-top {
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
		width: 90%;
		margin: 10rpx auto;
		display: flex;
		flex-direction: column;
	}

	.c-center .text_box .mtitle{
		line-height: 60rpx;
		font-size: 35rpx;
		margin-left: 5rpx;
		white-space: nowrap;
		text-overflow: ellipsis;
		overflow: hidden;
	}

	.c-center image {
		width: 100%;
		margin-top: 10rpx;
		border-radius: 20rpx;
	}

	.c-botton {
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
</style>
