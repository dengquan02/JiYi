<template>
	<view>
		<view class="status_bar">
		    <!-- 这里是状态栏 -->
		</view>
		<view class="wrapper">
			<!-- 顶部 -->
			<view>
				<view class="top">
					<view class="center">
						<view class="center_top">
							<view class="center_img">
								<!-- 这里可以放自己的静态头像 -->
								<image class="login-img2" src="../../../static/imgs/mine.jpg"/>						
								<!-- #ifndef MP-WEIXIN -->
								<!-- <image :src="image"></image> -->
								<!-- #endif -->
								<!-- <open-data type="userAvatarUrl" class="user_head"></open-data> -->
							</view>
							<view class="center_info" @tap="gotoFeeds('/pages/my/set/set')">
								<view class="center_name">
									<!-- 这里可以放自己的名称图片 -->
									<!-- #ifndef MP-WEIXIN -->
									<view>YOYO</view>
									<!-- #endif -->
										<open-data class="nickname" type="userNickName"></open-data>
								</view>
								<view class="center_email">
									<view class="email_text">
										<text>957890361@qq.com</text>
									</view>
								</view>
							</view>	
						</view>
					</view>				
				</view>	
			</view>
			
			<view class="orders">
				<view class="title">我的订单</view>
				<view class="sorts">
					<view class="nav">
						<view
							class="nav_item"
							v-for="(item, index) in navs"
							:key="index"
							@click="navItemClick(item.path)">
							<view :class="item.icon"></view>
							<text>{{item.title}}</text>
					</view>
				</view>			
			</view>
			
			</view>
								
			
			<!-- 其它 -->
				<view class="extra">
					<view @click="gotoPersonal" class="item icon-arrow">我的信息</view>
					<button open-type="feedback" class="item icon-arrow">意见反馈</button>	
				</view>
				
				<view class="extra2" @click="toLogout">
					<view class="list-cell log-out-btn" @click="toLogout">
							<text class="cell-tit">退出登录</text>
					</view>		
				</view>
				
				<!-- <view class="list-cell log-out-btn" @click="toLogout">
						<text class="cell-tit">退出登录</text>
				</view>	 -->		
		</view>
	</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				navs: [
						{
							icon: 'iconfont icon-dingdan',
							title: '反馈记录',
							path: '/pages/Personal/FeedBack/FeedBack'
						},
						{
							icon: 'iconfont icon-dingdanyichenggong',
							title: '历史订单',
							path: '/pages/Personal/HistoryOrder/HistoryOrder'
						},
						{
							icon: 'iconfont icon-yuyuedingdan',
							title: '全部订单',
							path: '/pages/Personal/HistoryOrder/HistoryOrder'
						}
					]
			}
		},
		methods: {
			gotoPersonal(){
				uni.navigateTo({
					url:'/pages/Personal/PersonalInfo/PersonalInfo'
				})
			},
			
			navItemClick (url) {
				uni.navigateTo({
					url
				})
			},
		}
	}
</script>

<style lang="scss">
@import '@/static/iconfont-yyq/iconfont.css';
.status_bar {
	height: var(--status-bar-height);
	width: 100%;
	background-color: #F4F4F4;
}
.wrapper {
	position: absolute;
	// top: 0;
	// bottom: 0;

	width: 100%;
	height: 100%;
	background-color: #F4F4F4;
}
.top {
	width: 100%;
	height: 130px;
	// background: $hospital-color;
	padding-top: 15px;
	position: relative;
}
.center {
	width: 95%;
	height: 100px;
	background: white;
	display: flex;
	flex-direction: column;
	margin: 0 auto;
	border-radius: 5px;
}

.down{
	width: 50%;
	height: 150px;
	background: white;
	display: flex;
	flex-direction: column;
	margin-top: 10px;
	border-radius: 5px;
}

	.address {
		line-height: 1;
		background-color: #fff;
		font-size: 30rpx;
		padding: 25rpx 0 25rpx 20rpx;
		margin: 10rpx 20rpx;
		color: #333;
		border-radius: 4rpx;
	}


.icon-arrow {
		position: relative;

		&::before {
			position: absolute;
			top: 50%;
			right: 20rpx;
			transform: translateY(-50%);
		}
	}

	
	
.center_top {
	display: flex;
	flex-direction: row;
	width: 80%;
	height: 80px;
	margin: 0 auto;
	margin-top: 20rpx;
	border-bottom: 1px solid #EEEEEE;
}

.center_img {
	width: 66px;
	height: 66px;
	border-radius: 20%;
	overflow: hidden;
}

.center_img image {
	width: 100%;
	height: 100%;
	border-radius: 50%;
}

.center_img .user_head {
	width: 100%;
	height: 100%;
}

.center_info {
	display: flex;
	flex-direction: column;
	margin-top: 20rpx;
	margin-left: 30px;
}

.center_name {
	font-size: 20px;
}
.email_text {
		margin-top:  15rpx;
		color: #AAAAAA;
	}
	
	
	.orders {
		margin: 20rpx 20rpx 0 20rpx;
		padding: 40rpx 0;
		background-color: #fff;
		border-radius: 4rpx;
		.title {
			padding-left: 20rpx;
			font-size: 30rpx;
			color: #333;
			padding-bottom: 20rpx;
			border-bottom: 1rpx solid #eee;
			margin-top: -30rpx;
		}

		.sorts {
			.nav {
					display: flex;
					.nav_item {
						width: 33%;
						text-align: center;
						view {
							width: 120rpx;
							height: 120rpx;
							background: $hospital-color;
							border-radius: 60rpx;
							margin: 10px auto;
							line-height: 120rpx;
							color: #fff;
							font-size: 50rpx;
						}
						.icon-tupian {
							font-size: 45rpx;
						}
						text {
							font-size: 28rpx;
						}
					}
				}
		}

		[class*="icon-"] {
			flex: 1;
			font-size: 24rpx;

			&::before {
				display: block;
				font-size: 48rpx;
				margin-bottom: 8rpx;
				color: #ea4451;
			}
		}
	}


.extra {
		margin: 0 20rpx;
		margin-top: 10px;
		background-color: #fff;
		border-radius: 4rpx;

		.item {
			line-height: 1;
			padding: 25rpx 0 25rpx 20rpx;
			border-bottom: 1rpx solid #eee;
			font-size: 30rpx;
			color: #333;
		}

		button {
			text-align: left;
			background-color: #fff;

			&::after {
				border: none;
				border-radius: 0;
			}
		}
	}

.extra2 {
		margin: 0 20rpx;
		margin-bottom: 10px;
		background-color: #fff;
		border-radius: 10rpx;
	}

	
.list-cell{
		margin: 0 20rpx;
		margin-bottom: 10px;
		display:flex;
		align-items:baseline;
		padding: 20px;
		line-height:30upx;
		position:relative;
		background: #fff;
		justify-content: center;
		&.log-out-btn{
			margin-top: 40upx;
			.cell-tit{
				color: $hospital-color;
				text-align: center;
				margin-right: 0;
			}
		}
}


</style>
