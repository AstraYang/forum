<template>
	<view class="page">
		<view class="group">
			<text>头像：</text>
			<image class="imgSize" src="../../static/img/right-outlined.png"></image>
		</view>
		<view class="group">
			<text>昵称：</text>
			<input class="inputStyle" type="text" :placeholder="userInfo.uName" maxlength="20" v-model="userInfo.uName">
		</view>
		<view class="group">
			性别：
			<image class="imgSize" src="../../static/img/right-outlined.png"></image>
		</view>
		<view class="group">
			签名：
			<image class="imgSize" src="../../static/img/right-outlined.png"></image>
		</view>
		<view class="group">
			电话：
			<input class="inputStyle" type="number" :placeholder="userInfo.uName" maxlength="11"
				v-model="userInfo.uName">
		</view>
		<view class="group">
			密码：
			<image class="imgSize" src="../../static/img/right-outlined.png"></image>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				userInfo: []
			}
		},
		methods: {

		}
	}
</script>

<style>
	.grow1 {
		flex-grow: 1;
	}

	.grow2 {
		flex-grow: 2;
	}

	.grow3 {
		flex-grow: 2;
	}

	.group {
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		width: 85%;
		height: 100rpx;
		background-color: #e1b7ec;
		color: white;
		font-size: 35rpx;
		margin: 20rpx auto;
		padding: 0 20rpx;
		border-radius: 10rpx;
		line-height: 100rpx;
	}
	.imgSize {
		width: 90rpx;
		height: 90rpx;
		margin: auto 0;
	}
	.inputStyle {
		width: 82%;
		margin: auto;
	}
</style>