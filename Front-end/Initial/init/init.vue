<template>
	<view>
		加载中
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		onLoad() {
			uni.hideTabBar();
			uni.redirectTo({
				url: '../loading/loading'
			})
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
