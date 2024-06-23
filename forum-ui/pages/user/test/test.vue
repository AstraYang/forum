<template>
	<view>
		<input type="text" v-model.trim="test00"/>
		{{test00}}
	</view>
</template>

<script>
	export default {
		data() {
			test00:''
		},
		methods: {
			
			// //如果判断Input输入框是否为空，不为空时再提交，可以用
			// If(this.inputData.trim().length !==0){
			// //此处写请求接口的代码
			// }
		}
	}
</script>

<style>

</style>
