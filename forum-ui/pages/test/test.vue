<template>
	<view class="content">
		<view class="button">
			<button @click="choose" value="请选择文件">请选择文件</button>
		</view>
		<view class="img" v-for="imgPath in imgPaths">
			<image class="img_img" :src="imgPath"></image>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello',
				imgPaths:[]
			}
		},
		onLoad() {

		},
		methods: {
			choose(e){
				var me = this;
				uni.chooseImage({
				    count: 6, //默认9
				    sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
				    sourceType: ['album'], //从相册选择
				    success: function (res) {
						me.imgPaths = res.tempFilePaths;
						console.log(me.imgPaths);
						uni.uploadFile({
						            url: 'http://192.168.1.106:8080/uploadImg', //仅为示例，非真实的接口地址
						            filePath: me.imgPaths[0],
						            name: 'uploadFile',
						            formData: {
						                'user': 'test'
						            },
						            success: (uploadFileRes) => {
						                console.log(uploadFileRes);
						            }
						        });
				    }
				});
			}
		}
	}
</script>



