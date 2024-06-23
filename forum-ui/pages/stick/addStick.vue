<template>
	<view class="s_main">
		<view class="s_img grow3">
			<view class="example-body">
				<uni-file-picker limit="9" title="最多选择9张图片" 
					:source-type="sourceType" @select="select" @delete="del">
				</uni-file-picker>
			</view>
		</view>
		<view class="s_title grow1">
			<input adjust-position="true" type="text" placeholder="标题" maxlength="30" v-model="title"/>
		</view>
		<view class="s_line"></view>
		<view class="s_content grow3">
			<textarea maxlength="-1" auto-height placeholder="请输入内容" v-model="content"/>
		</view>
	</view>
	<view class="s_submit">
		<button @click="addStick">发布</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title:"",
				content:"",
				sourceType:['album','camera'],
				filePaths: []
			}
		},
		methods: {
			//添加文件路径
			select(e){
				console.log('select'+e.tempFilePaths);
				this.filePaths.push(e.tempFilePaths);
				console.log(this.filePaths);
			},
			//删除文件路径
			del(e){
			 	let path = e.tempFilePath;
				console.log('del:'+path);
				this.filePaths = this.filePaths.filter(item => item!=path);
				console.log(this.filePaths);
			},
			//添加帖子
			addStick(){
				let that = this;//解决this指向
				let filePaths=this.filePaths;
				var id = uni.getStorageSync("id");//获取uID
				console.log(id);
				console.log(that.title);
				console.log(that.content);
				//添加帖子内容
				uni.request({
					url:"http://localhost/stick/addStickContent",
					method:'POST',
					header: {
					    "Content-Type": "application/x-www-form-urlencoded"
					},
					data:{
						uID:id,
						mTitle:that.title,
						mContent:that.content
					},
					success: (data) => {
						console.log(data);
						//上传图片文件
						var mID=data.data.data.mID;
						console.log(mID);
						if(data.statusCode==200){
							that.filePaths.forEach((val,index,filePaths)=>{
								console.log(filePaths[index]);
								uni.uploadFile({
									url:"http://localhost/stick/addStickPicture",
									filePath:that.filePaths[index]+"",
									name:"stickImg",
									formData:{
										mID:data.data.data.mID,
										uID:id
									},
									success: (data) => {
										console.log("成功时data值");
										console.log(data);
										uni.showToast({
											title: '添加成功',
											duration: 1500
										});
										uni.switchTab({
											url:'/pages/index/index'
										})
									}
								})
							})
						}
					}
				})
				
			}
		}
	}
</script>

<style lang="scss">
	page{
		width:100%;
		background-color:#ffffff;
	}
	.s_main{
		width: 95%;
		min-height: 500rpx;
		margin: 10rpx auto;
		padding-bottom: 500rpx;
		display: flex;
		flex-direction: column;
	}
	.grow1{
		flex-grow: 1;
	}
	.grow2{
		flex-grow: 2;
	}
	.grow3{
		flex-grow: 3;
	}
	.s_title{
		height: 80rpx;
		margin: 10rpx 0;
	}
	.s_title input {
		width: 100%;
		height: 90rpx;
		font-size: 80rpx;
	}
	.s_line{
		width: 98%;
		height:2rpx;
		background-color: #f5f5f5;
		margin: 15rpx auto;
	}
	.s_content{
		width: 100%;
	}
	.s_content textarea{
		width: 100%;
		height: 500rpx;
		
	}
	.s_submit{
		width: 100%;
		position: fixed;
		bottom: var(--window-bottow,0);
	}
	.s_submit button{
		background-color:#55aaff;
	}
</style>
