
<template>
	<view>
		<uni-card>
				<uni-list>
					<view class="uni-list-cell" hover-class="uni-list-cell-hover" v-for="(value, key) in listData" :key="key" @click="goDetail(value)">
						<view class="uni-media-list">
							<view class="uni-media-list-body">
								<view class="text-title">{{ value.disease }}</view>
								<view class="uni-media-list-text-top">{{ value.doctor_name }}</view>
								<view class="uni-media-list-text-middle">{{ value.title }}</view>
								<view class="uni-media-list-text-bottom">{{ value.hospital }}</view>
							</view>
							<!-- <view>
								<view class="uni-media-list-status">{{ value.status }}</view>
							</view> -->
						</view>
						<text style="margin-left: 32rpx;">{{ value.author_name }}</text>
						<text style="margin-left: 30rpx;margin-top: 6rpx;">{{ value.published_at }}</text>
						<u-button style="margin-top: 10px;" type="primary" :plain="true" text="查看详情"></u-button>
						<u-line style="margin-top: 10px;"></u-line>
					</view>
				</uni-list>
				</uni-card> 
			</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				navIndex: 0,
				listData: [{
						id: "109121",  
						disease:"感冒",					 
						doctor_name: "接诊人：吴先正",
						title: "急诊科",
						hospital: "同济大学附属医院",
						author_name: "就诊人：小徐",
						published_at: "2019-12-30 15:20:00",
						status: "cancel"
					},
					{
						id: "109121", 
						disease:"心悸",	
						doctor_name: "接诊人：吴先正",
						title: "急诊科",
						hospital: "同济大学附属医院",
						author_name: "就诊人：小王",
						published_at: "2019-12-30 15:22:00",
						status: "cancel"
					},
					{
						id: "109121",
						disease:"呼吸道感染",
						doctor_name: "接诊人：吴先正",
						title: "急诊科",
						hospital: "同济大学附属医院",
						author_name: "就诊人：小雷",
						published_at: "2019-12-30 15:26:00",
						status: "cancel"
					},
					{
						id: "109121",
						disease:"失眠",
						doctor_name: "接诊人：吴先正",
						title: "急诊科",
						hospital: "同济大学附属医院",
						author_name: "就诊人：小张",
						published_at: "2019-12-30 15:29:00",
						status: "cancel"
					}
				],
			}
		},
		methods: {
			
		}
	}
</script>

<style lang="scss" scoped>
.head-nav {
		margin: 20rpx 35rpx 35rpx 35rpx;
		display: flex;
		justify-content: space-between;
		align-items: center;
		color: #CCCCCC;
	}

	.activite {
		color: $hospital-color;
	}

	.head-nav>view {
		padding-bottom: 0rpx;
	}

	.content {
		/* background: #008000; */
		height: 100%;
		margin-top: 40rpx;
	}
	
	.uni-media-list{
		display: flex;
		flex-direction: row;
		margin-top: 20px;
		margin-bottom: 10px;
		
		.uni-media-list-logo {
			width: 180rpx;
			height: 180rpx;
			border-radius: 50%;
		}
		
		.uni-media-list-body {
			flex-direction: row;
			height: auto;
			margin-left: 32rpx;
			margin-right: 32rpx;
			justify-content: space-around;
		}
		
		.text-title {
			height: 75rpx;
			font-size: 35rpx;
			font-weight: 600;
			color: #55aaff;
			overflow: hidden;
		}
		 
		.uni-media-list-text-top {
			height: 75rpx;
			font-size: 35rpx;
			font-weight: 500;
			color: #1a1a1a;
			overflow: hidden;
		}
		 
		.uni-media-list-text-middle {
			display: flex;
			flex-direction: row;
			margin-top: 10rpx;
			margin-right: 20rpx;
			font-size: 30rpx;
			color: #999999;
		}
		
		.uni-media-list-text-bottom {
			display: flex;
			flex-direction: row;
			margin-top: 10rpx;
			margin-right: 20rpx;
			font-size: 27rpx;
			color: #999999;
		}
		
		.uni-media-list-status {
			display: flex;
			width: 125rpx;
			height: 125rpx;
			border-radius: 50%;
			margin-top: 10px;
			// font-size: 50rpx;
			// font-weight: 600;
			// color: $hospital-color;
		}
	}
</style>
