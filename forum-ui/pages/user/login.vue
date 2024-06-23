<template>
	<view class="login_centen">
		<view class="login_nav">
			<image src="../../static/img/小猫灰灰.png"></image>
		</view>
		<view class="login_box">
			<view class="input_box">
				<input type="text" placeholder="请输入您的电话或邮箱" v-model="text" />
			</view>
			<view class="input_box">
				<input password type="safe-password" placeholder="请输入您的密码" maxlength="20" v-model="pwd" />
			</view>
			<view class="password_register">
				<text @click="onPageJump('/pages/user/register')">注册账号</text><!-- navigator -->
				<text>忘记密码</text>
			</view>
			<view class="btn_box">
				<button @click="goData(text,pwd)" class="active">登录</button>
			</view>
		</view>
		
	</view>
</template>

<script>
	export default {
		data(){
			return {
				text:"",
				pwd:"",
				userList:[]
			}
		},
		methods:{
			goData:function(text,pwd){
				//验证
				if (!this.text) {
					uni.showToast({
						title: '请输入电话或邮箱',
						icon: 'none',
					})
					return;
				};
				if (!this.pwd) {
					uni.showToast({
						title: '请输入密码',
						icon: 'none',
					})
					return;
				};
				//提交
				uni.request({
					url:'http://localhost/user/getLogin',
					data:{text,pwd},
					method:'POST',
					success:data =>{
						var id=data.data.data;
						console.log("返回的值：");
						console.log(id);
						if(id!=null){
							uni.setStorageSync("id", id);
							uni.switchTab({
								url:"/pages/home/home"
							})
						}else{
							uni.showToast({
								title: '密码或账号错误，请重新输入',
								icon: 'none',
								duration:3000
							})
							return;
						}
					},
					fail:(res)=>{
						console.log('失败');
						console.log(res.data);
					}
				})
			},
			//转发注册
			onPageJump:function(url){
				uni.navigateTo({
					url:url
				})
			}
			
		}
	}
</script>

<style lang="scss">
	.login_nav{
		width: 100%;
		height: 300rpx;
		background-color: $uni-color-warning;
	}
	.login_nav image{
		width: 100%;
		height: 100%;
	}
	.login_box{
		width: 75%;
		margin: 0 auto;
	}
	.input_box{
		height: 100rpx;
		background-color: #e6e6e6;
		margin: 20rpx auto;
		padding: 0rpx 40rpx;
		border-radius: 10rpx;
		input{
			height: 100%;
		}
	}
	.btn_box{
		height: 100rpx;
		margin: 20rpx auto;
	}
	.password_register{
		margin: auto ;
		display: flex;
		justify-content: space-between;
	}
</style>