<template>
	<view class="contact">
		<image class="img" src="http://www.itcast.cn/2018czydz/images/gywmban.jpg" mode=""></image>
		<view class="info">
			<view @click="phone">
				联系电话：021-69589712（点击拨打）
			</view>
			<view>地址：上海市嘉定区曹安公路4800号济事楼</view>
		</view>
		<map
			class="map"
			:longitude="longtitude"
			:latitude="latitude"
			:markers="marker"
			:scale="scale">
		</map>
		<view class="copyright">
			<text class="cr">{{cr}}</text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				cr: '-- JIYI --',
				longtitude: 121.220163,
				latitude: 31.288384,
				marker: [
					{
						longtitude: 121.220163,
						latitude: 31.288384,
						iconPath: '/static/logo.png',
						width: 30,
						height: 30
					}
				],
				scale: 13
			}
		},
		methods: {
			phone() {
				uni.makePhoneCall({
					phoneNumber: '13935033108'
				})
			}
		}
	}
</script>

<style lang="scss">
.contact {
	.img {
		width: 750rpx;
		height: 350rpx;
	}
	.info {
		padding: 10rpx 20rpx;
		font-size: 30rpx;
		view {
			line-height: 80rpx;
			border-bottom: 1px solid #eee;
		}
	}
	.map {
		width: 750rpx;
		height: 950rpx;
	}
	.copyright {
		display: flex;
		justify-content: center;
		margin-top: 20px;
		font-size: 30rpx;
		/* font-weight: 500; */
		color: #c0c0c0;
	}
}
</style>
