<template>
	<view class="page">
		<view class="title">注册</view>
		<view class="input_box">
			<input type="text" v-model.trim="newUser.uName" placeholder="请输入昵称" maxlength="11" />
		</view>
		<view class="input_box ">
			<radio-group @change="radioChange">
				<label>
					<radio class="radio_box" value="1" checked="checked">男</radio>
					<radio class="radio_box" value="2">女</radio>
				</label>
				<!-- {{radioVal}} -->
			</radio-group>
		</view>
		<view class="input_box">
			<input type="text" v-model="newUser.uEmail" placeholder="请输入邮箱" />
		</view>
		<view class="input_box">
			<input password type="safe-password" v-model="newUser.uPwd" placeholder="请输入密码" />
		</view>
		<view class="input_box">
			<input password type="safe-password" v-model="pwdV" placeholder="请再次确认密码" @click="clear()" />
			<!-- <text :style="isRed">*密码不一致！</text> -->
		</view>
		<view class="btn_box"><button @click="submit()">注册</button></view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				newUser: {
					uName: '',
					uSex: 1,
					uEmail: '',
					uPwd: ''
				},
				pwdV: '',
				isRed: 'display:none',
				radioVal: 0 // 用于设置默认选中项
			}
		},
		filters: {
			fml(val) {
				return val.replace(/\s/g, "")
			}
		},
		methods: {
			//radio-group通过onChange自动获取velue的信息
			radioChange(evt) {
				this.newUser.uSex = evt.detail.value;
			},
			//清除
			clear() {
				this.isRed = 'display:none';
			},
			//提交
			submit() {
				if (!this.newUser.uName) {
					uni.showToast({
						title: '请输入昵称',
						icon: 'none',
					})
					return;
				};
				if (!this.newUser.uEmail) {
					uni.showToast({
						title: '请输入邮箱',
						icon: 'none',
					});
					return;
				};
				if (!this.newUser.uPwd) {
					uni.showToast({
						title: '请输入密码',
						icon: 'none'
					})
					return;
				};
				if (!this.pwdV) {
					uni.showToast({
						title: '请再次输入密码',
						icon: 'none'
					})
					return;
				};
				if (this.newUser.uPwd!= this.pwdV) {
					uni.showToast({
						title: '密码不一致',
						icon: 'none'
					})
					return;
				} else {
					//开始执行
					var newUser = this.newUser;
					 console.log(newUser);
					uni.request({
						url: 'http://localhost/user/getNewUser',
						data: {
							newUser
						},
						method: 'POST',
						success: data => {
							var id = data.data.data;
							console.log(id);
							//判断id是否为空
							if (id == null) {
								uni.showToast({
									title: '邮箱已被注册',
									icon: 'none',
									duration: 1500
								})
							} else {
								uni.showToast({
									title: '注册成功!',
									duration: 1500, //设置显示时间(毫秒)
									success() {
										//保存id
										uni.setStorageSync("id", id);
										//转到主页
										uni.switchTab({
											url: "/pages/home/home",
										})
									}
								})
							}

						}
					})
				}
			}
		}
	}
</script>

<style>
	.page {
		background-color: #FFF;
		padding: 0 65rpx;
		min-height: 100vh;
	}

	.input_box {

		height: 70rpx;
		border-bottom: 1rpx solid #eeeeee;
		margin: 20rpx 0;
	}

	.input_box input {
		width: 100%;
		flex: 1;
		font-size: 30rpx;
	}

	.input_box text {
		float: right;
	}

	.btn_box {
		margin-top: 40rpx;
	}

	.btn_box button {
		font-size: 32rpx;
		line-height: 100rpx;
		border-radius: 8rpx;
	}

	.radio_box {
		margin-right: 25rpx;
	}

	.title {
		padding: 60rpx 0 40rpx 0;
		font-size: 60rpx;
		color: #333333;
	}
</style>