<template>
	<view>
		<view >
			<u-modal :show="show" :title="title" :content='content' @confirm="confirm"></u-modal>
		</view>
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
							<!-- <view>
								<view class="uni-media-list-status">{{ value.status }}</view>
							</view> -->
							<view>
								<image class="uni-media-list-status" :src="`../../../static/zjq/${value.status}.png`"></image>
							</view>
						</view>
						<text>{{ value.author_name }}</text>
						<text style="margin-left: 30rpx;margin-top: 6rpx;">{{ value.published_at }}</text>
						<u-button style="margin-top: 10px;" type="primary" :plain="true" text="删除订单" @click="show = true"></u-button>
						<u-line style="margin-top: 10px;"></u-line>
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
				show:false,
				title:'确认删除',
				content:'确认删除订单记录吗？',
				listData: [{
						id: "1",                       
						doctor_name: "接诊人：王志荣",
						title: "消化内科",
						hospital: "同济大学附属医院",
						author_name: "就诊人：YOYO",
						cover: "https://www.tongjihospital.com.cn/upload/image/190228/15513191814200.jpg",
						published_at: "2022年5月15日 9:00~9:40",
						status: "wait"
					},
					{
						id: "2",                       
						doctor_name: "接诊人：杨长青",
						title: "消化内科",
						hospital: "同济大学附属医院",
						author_name: "就诊人：YOYO",
						cover: "https://www.tongjihospital.com.cn/upload/image/190227/15512527395725.jpg",
						published_at: "2022年5月14日 19:00~19:40",
						status: "cancel"
					},
					{
						id: "3",
						doctor_name: "接诊人：吴先正",
						title: "急诊科",
						hospital: "同济大学附属医院",
						author_name: "就诊人：YOYO",
						cover: "https://img.36krcdn.com/20191230/v2_43cbd298bed24a18bd023802258f20c8_img_png",
						published_at: "2022年5月13日 19:00~19:40",
						status: "finish"
					},
					{
						id: "4",
						doctor_name: "接诊人：吴先正",
						title: "急诊科",
						hospital: "同济大学附属医院",
						author_name: "就诊人：YOYO",
						cover: "https://img.36krcdn.com/20191230/v2_037f7f799f504a60a848b52fa913ab65_img_png",
						published_at: "2022年5月13日 9:00~9:40",
						status: "cancel"
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
			confirm() {
				this.show = false;
			}
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
			width: 150rpx;
			height: 180rpx;
			border-radius: 10%;
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
