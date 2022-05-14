<template>
	<view class="content">
		<image class="logo" src="/static/opening.png"></image>
		<view class="text-area">
			<text class="title">{{title}}</text>
		</view>
		<view class="copyright">
			<text class="cr">{{cr}}</text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Find Your Own Doctor!',
				cr: '-- JIYI --'
			}
		},
		created() {
			this.startTime()
		},
		methods: {
			startTime() {
				setTimeout(() => {
					uni.navigateTo({
						url: '../login/login'	
					});
				}, 3000)
			}
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 400rpx;
		width: 500rpx;
		margin-top: 250rpx;
		margin-left: auto;
		margin-right: auto;
	}

	.text-area {
		display: flex;
		justify-content: center;
		margin-top: 20px;
	}

	.title {
		font-size: 42rpx;
		font-weight: 500;
		color: #1058D1;
	}
	
	.copyright {
		display: flex;
		justify-content: center;
		margin-top: 280px;
		font-size: 30rpx;
		/* font-weight: 500; */
		color: #c0c0c0;
	}
</style>
