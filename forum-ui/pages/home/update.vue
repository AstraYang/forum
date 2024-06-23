<template>
	<view class="page">
		<view class="title">更改信息</view>
		
		<view class="input_box">
			<input type="text" v-model.trim="userData.uname" placeholder="请输入昵称" maxlength="11" />
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
			<input type="text" v-model="userData.uemail" placeholder="请输入邮箱" />
		</view>
		<view class="input_box">
			<input password type="safe-password" v-model="pwd" placeholder="请输入密码" />
		</view>
		<view class="input_box">
			<input password type="safe-password" v-model="pwdV" placeholder="请再次确认密码"/>
			<!-- <text :style="isRed">*密码不一致！</text> -->
		</view>
		<view class="btn_box"><button @click="submit()">更改</button></view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				userData:{},
				pwd: '',
				pwdV: ''
			}
		},
		onLoad() {
			//获取userData
			uni.getStorage({
				key: 'userData',
				success: res=>{
					this.userData=res.data;
					console.log(this.userData);
				}
			});
		},
		methods: {
			//radio-group通过onChange自动获取velue的信息
			radioChange(evt) {
				this.userData.usex = evt.detail.value;
			},
			submit(){
				uni.showModal({
					title: '提示',
					content: '确定更改？',
					cancelText: "取消", // 取消按钮的文字  
					confirmText: "确认", // 确认按钮的文字  
					showCancel: true, // 是否显示取消按钮，默认为 true
					confirmColor: '#f55850',
					cancelColor: '#39B54A',
					success: (res) => {
					if(res.confirm) {  
						//点击确定之后执行的代码
						if(this.pwd!=""){ //判断密码是否可以保存
							this.userData.upwd=this.pwd;
						}
						var userData = this.userData;
						uni.request({
							url:"http://localhost/user/updateUser",
							data:{userData},
							method:'POST',
							success: data =>{
								console.log(data.data)
							}
						})
						uni.showToast({
							title: '更改成功',
							duration: 1500
						})
					} else {  
						console.log('cancel') //点击取消之后执行的代码
						}  
					} 
				})

				
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

	.title {
		padding: 60rpx 0 40rpx 0;
		font-size: 60rpx;
		color: #333333;
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
</style>