<template>
	<view>
		<view class="head-nav">
			<view :class="navIndex==0?'activite':''" @click="checkIndex(0)">全部</view>
			<view :class="navIndex==1?'activite':''" @click="checkIndex(1)">待就诊</view>
			<view :class="navIndex==2?'activite':''" @click="checkIndex(2)">待反馈</view>
			<view :class="navIndex==3?'activite':''" @click="checkIndex(3)">已反馈</view>
			<view :class="navIndex==4?'activite':''" @click="checkIndex(4)">已取消</view>
		</view>
		<u-line></u-line>
		<!-- 内容切换 -->
		<view class="content" v-if="navIndex==0">
			<view>
			<uni-card>
				<uni-list>
						<view class="uni-list-cell" hover-class="uni-list-cell-hover" v-for="(value, key) in listData" :key="key" @click="goDetail(value)">
						<view class="uni-media-list">
							<view>
								<image class="uni-media-list-logo" :src="value.cover"></image>
							</view>
							<view class="uni-media-list-body">
							    <view class="uni-media-list-text-top">{{ value.doctor_name }}</view>
								<view class="uni-media-list-text-middle">{{ value.title }}</view>
								<view class="uni-media-list-text-bottom">{{ value.hospital }}</view>
							</view>
							<u-line direction="col"></u-line>
							
						</view>
						<text>{{ value.author_name }}</text>
						<text style="margin-left: 30rpx;margin-top: 6rpx;">{{ value.published_at }}</text>
					</view>
				</uni-list>
				</uni-card>
			</view>
		</view>
		<view class="content" v-if="navIndex==1">
			我是选项2
		</view>
		<view class="content" v-if="navIndex==2">
			我是选项3
		</view>
		<view class="content" v-if="navIndex==3">
			我是选项4
		</view>
		<view class="content" v-if="navIndex==4">
			我是选项5
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
						doctor_name: "接诊人：吴先正",
						title: "急诊科",
						hospital: "同济大学附属医院",
						author_name: "徐子",
						cover: "https://img.36krcdn.com/20191230/v2_37635ef22df24e96aa7f26e192036c2b_img_png",
						published_at: "2019-12-30 15:20:00"
					},
					{
						id: "109121",                       
						doctor_name: "接诊人：吴先正",
						title: "急诊科",
						hospital: "同济大学附属医院",
						author_name: "半佛仙人",
						cover: "https://img.36krcdn.com/20191230/v2_02c342a62f91498b99c7f2b5aa22ff1c_img_png",
						published_at: "2019-12-30 15:22:00"
					},
					{
						id: "109121",
						doctor_name: "接诊人：吴先正",
						title: "急诊科",
						hospital: "同济大学附属医院",
						author_name: "燃财经",
						cover: "https://img.36krcdn.com/20191230/v2_43cbd298bed24a18bd023802258f20c8_img_png",
						published_at: "2019-12-30 15:26:00"
					},
					{
						id: "109121",
						doctor_name: "接诊人：吴先正",
						title: "急诊科",
						hospital: "同济大学附属医院",
						author_name: "36氪的朋友们",
						cover: "https://img.36krcdn.com/20191230/v2_037f7f799f504a60a848b52fa913ab65_img_png",
						published_at: "2019-12-30 15:29:00"
					}
				],
			}
		},
		methods: {
			checkIndex(index) {
				console.log(index)
				this.navIndex = index;
			},
			goDetail: function(e) {
			                
			},
		}
	}
</script>

<style lang="scss" scoped>
	.head-nav {
		margin: 35rpx 35rpx 35rpx 35rpx;
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
			border-radius: 50%
		}
		
		.uni-media-list-body {
			flex-direction: row;
			height: auto;
			margin-left: 32rpx;
			margin-right: 32rpx;
			justify-content: space-around;
		}
		 
		.uni-media-list-text-top {
			height: 74rpx;
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
	}
</style>
