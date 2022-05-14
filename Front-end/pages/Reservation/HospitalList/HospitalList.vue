<template>
	<view>
		<!-- 搜索框 -->
		 <view class="search-bar">
			 <view class="search-bar-box">
			 <image class="search-span" src="../../../static/zjq/search.png"/>
			 <input type="text" value=""  placeholder="搜医院，医生，科室……" class="search-text" maxlength="10"/>
			 </view>
		 </view>
		<!-- 两个按钮 -->
		<view class="btn">
			<button class="left-btn" @click="ToDiagnose()">历史报告</button>
			<button class="right-btn" @click="ToRecord()">预约记录</button>
		</view>
		<!-- 医院排行榜 -->
		<view class="hot_goods">
			<view class="tit">
				医院排行榜
			</view>
			<view class="list">
				<!-- 基于 uni-list 的页面布局 -->
				<uni-list>
					<!-- to 属性携带参数跳转详情页面，当前只为参考 -->
					<uni-list-item :border="true" class="uni-list-item--waterfall" title="自定义商品列表" v-for="item in listData" :key="item">
						<!-- 通过header插槽定义列表左侧图片 -->
						<template v-slot:header>
							<view class="uni-thumb shop-picture">
								<image src="http://rbphewwot.hd-bkt.clouddn.com/jiyi%2Fhospital1.png" mode="aspectFill"></image>
							</view>
						</template>
						<!-- 通过body插槽定义商品布局 -->
						<view slot="body" class="shop">
							<view>
								<view class="uni-title">
									<text class="uni-ellipsis-2">同济大学附属医院</text>
								</view>
								<view>
									<text class="uni-tag hot-tag">三甲医院</text>
									<!-- <text v-for="tag in item.tag" :key="tag" class="uni-tag">tag</text> -->
								</view>
							</view>
							<view>
								<view class="shop-price">
									<text>¥</text>
									<text class="shop-price-text">价格</text>
									<text>.00</text>
								</view>
								<!-- <view class="uni-note">{{ item.comment_count }}条评论 月销量 {{ item.month_sell_count }}</view> -->
								<view class="uni-note ellipsis">
									<text class="uni-ellipsis-1">测试</text>
									<text class="uni-link" @click="ToDetail()">详情 ></text>
								</view>
							</view>
						</view>
					</uni-list-item>
				</uni-list>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				listData:[1,2,3,4,5,6,7]
			}
		},
		created() {
			
		},
		methods: {
			ToDiagnose() {
				uni.navigateTo({
					url: '../HistoryDiagnose/HistoryDiagnose'	
				});
			},
			ToRecord() {
				uni.navigateTo({
					url: '../HistoryReservation/HistoryReservation'	
				});
			},
			ToDetail() {
				uni.navigateTo({
					url: '../ReservationDetail/ReservationDetail'	
				});
			}
		}
	}
</script>

<style lang="scss">
@import '@/common/uni-ui.scss';
// 搜索框
.search-bar{
	width: 100%;
	height: 120rpx;
	margin-top: 5%;
}
.search-bar-box{
	display: flex;
	margin: 0 auto;
	width: 670rpx;
	height: 90rpx;
	border:2rpx solid $hospital-color;
	border-radius: 50rpx;
}
.search-span{
	width: 65rpx;
	height: 56rpx;
	margin-top: 9px;
	margin-left: 30rpx;
}
.search-text{
	width: 100%;
	margin-top: 10px;
	margin-left: 20rpx;
	font-size: 33rpx;
	color: $uni-text-color-disable;
}
.btn {
	margin-top: 15px;
	.left-btn {
		height: 90rpx;
		width: 320rpx;
		border:5rpx solid $hospital-color;
		background-color: rgb(239, 244, 252);
		text-align: center;
		font-size: 32rpx;
		font-weight: 500;
		position: absolute;
		left: 20px;
	}
	.right-btn {
		height: 90rpx;
		width: 320rpx;
		border:5rpx solid $hospital-color;
		background-color: rgb(239, 244, 252);
		text-align: center;
		font-size: 32rpx;
		font-weight: 500;
		position: absolute;
		right: 20px;
	}
}
.hot_goods {
	margin-top: 80px;
	.tit {
		color: $hospital-color;
		font-weight: 520;
		letter-spacing: 1px;
		font-size: 20px;
		margin-left: 20px;
		color: #1a1a1a;
	}
}
page {
	display: flex;
	flex-direction: column;
	box-sizing: border-box;
	min-height: 100%;
	height: auto;
}

.tips {
	color: #67c23a;
	font-size: 14px;
	line-height: 40px;
	text-align: center;
	background-color: #f0f9eb;
	height: 0;
	opacity: 0;
	transform: translateY(-100%);
	transition: all 0.3s;
}

.tips-ani {
	transform: translateY(0);
	height: 40px;
	opacity: 1;
}

.shop {
	flex: 1;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

.shop-picture {
	width: 110px;
	height: 110px;
}

.shop-picture-column {
	width: 100%;
	height: 170px;
	margin-bottom: 10px;
}

.shop-price {
	margin-top: 5px;
	font-size: 12px;
	color: #ff5a5f;
}

.shop-price-text {
	font-size: 16px;
}

.hot-tag {
	background: #ff5a5f;
	border: none;
	color: #fff;
}

.button-box {
	height: 30px;
	line-height: 30px;
	font-size: 12px;
	background: #007AFF;
	color: #fff;
}

.uni-link {
	flex-shrink: 0;
}

.ellipsis {
	display: flex;
	overflow: hidden;
}

.uni-ellipsis-1 {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}

.uni-ellipsis-2 {
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
}


// 默认加入 scoped ，所以外面加一层提升权重
.list {
	.uni-list--waterfall {

		/* #ifndef H5 || APP-VUE */
		// 小程序 编译后会多一层标签，而其他平台没有，所以需要特殊处理一下
		/deep/ .uni-list {
			/* #endif */
			display: flex;
			flex-direction: row;
			flex-wrap: wrap;
			padding: 5px;
			box-sizing: border-box;

			/* #ifdef H5 || APP-VUE */
			// h5 和 app-vue 使用深度选择器，因为默认使用了 scoped ，所以样式会无法穿透
			/deep/
			/* #endif */
			.uni-list-item--waterfall {
				width: 50%;
				box-sizing: border-box;

				.uni-list-item__container {
					padding: 5px;
					flex-direction: column;
				}
			}

			/* #ifndef H5 || APP-VUE */
		}

		/* #endif */
	}
}
</style>
