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
			<view class="hot_docs">
				<view class="docs_list">
					<view
						class="docs_item"
						v-for="item in docs"
						:key="item.id"
						@click="navigator(item.id)">
						<image :src="item.img_url" mode=""></image>
						<view class="right">
							<view class="price">
							<text>{{item.name}}</text>
							<!-- <text>￥{{item.market_price}}</text> -->
							</view>
							<view class="name">
								<text>{{item.title}}</text>
								<text>{{item.telephone}}(点击拨打)</text>
							</view>
							<view class="title">
								<text>{{item.location}}</text>
							</view>
						</view>
						
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				docs: [
					{
						'id': 1,
						'img_url': 'https://img1.baidu.com/it/u=3798921190,477604720&fm=253&fmt=auto&app=120&f=JPEG?w=547&h=500',
						'name': '上海市康达医院',
						'title': '三甲医院',
						'telephone': '(021)62436666',
						'location': '上海市浦东新区芙蓉花路333号'
					},
					{
						'id': 2,
						'img_url': 'https://img2.baidu.com/it/u=4161381737,1583172565&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=640',
						'name': '苏州市吴江区儿童医院',
						'title': '三级儿童专科医院',
						'telephone': '0512-60905199',
						'location': '江苏省苏州市吴江区公园路176号'
					},
					{
						'id': 3,
						'img_url': 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbkimg.cdn.bcebos.com%2Fpic%2F8c1001e93901213f5601fe8f5ee736d12f2e95b7&refer=http%3A%2F%2Fbkimg.cdn.bcebos.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1655138251&t=3a80897a8e3e8f1cc337904c1da0e553',
						'name': '东莞市清溪医院',
						'title': '二级医院',
						'telephone': '(0769)38828810',
						'location': '东莞市清溪镇香芒中路6号'
					},
					{
						'id': 4,
						'img_url': 'https://webmap0.bdimg.com/client/services/thumbnails?width=132&height=104&align=center,center&quality=100&src=https%3A%2F%2Ftaojin-his.cdn.bcebos.com%2F3b87e950352ac65ce1063071f7f2b21193138ab5.jpg',
						'name': '同济大学附属医院',
						'title': '二甲医院',
						'telephone': '(021)65988837',
						'location': '上海市杨浦区赤峰路50号'
					},
					{
						'id': 5,
						'img_url': 'https://img0.baidu.com/it/u=4171396014,1341149277&fm=253&fmt=auto&app=138&f=JPEG?w=704&h=500',
						'name': '潍坊市中医院',
						'title': '公立三甲中医',
						'telephone': '(0536)8190000',
						'location': '山东省潍坊市奎文区潍州路1055号'
					},
					{
						'id': 6,
						'img_url': 'https://img0.baidu.com/it/u=208618486,1236716984&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=333',
						'name': '渭南市第二医院',
						'title': '综合性二级医院',
						'telephone': '0913-2072149',
						'location': '渭南市临渭区朝阳大街东段2号'
					},
					{
						'id': 7,
						'img_url': 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbkimg.cdn.bcebos.com%2Fpic%2F8c1001e93901213f5601fe8f5ee736d12f2e95b7&refer=http%3A%2F%2Fbkimg.cdn.bcebos.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1655138251&t=3a80897a8e3e8f1cc337904c1da0e553',
						'name': '东莞市清溪医院',
						'title': '二级医院',
						'telephone': '(0769)38828810',
						'location': '东莞市清溪镇香芒中路6号'
					},
					{
						'id': 8,
						'img_url': 'https://img0.baidu.com/it/u=3653902697,3561130456&fm=253&fmt=auto&app=138&f=JPEG?w=640&h=327',
						'name': '哈医大肿瘤医院',
						'title': '专科医院',
						'telephone': '0451-85556000',
						'location': '黑龙江省哈尔滨市南岗区哈平路150号'
					},
				],
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
.hot_docs {
	background: #eee;
	overflow: hidden;
	margin-top: 10px;
	.tit {
		height: 50px;
		line-height: 50px;
		color: $hospital-color;
		text-align: center;
		background: #fff;
		margin: 6rpx 0;
		font-weight:500;
	}
}
.docs_list {
	// margin-left: 10px;
	margin-right: 13px;
	flex-wrap: wrap;
	// justify-content: space-between;
	.docs_item {
		background: #fff;
		width: 100%;
		border-radius: 10px;
		margin: 10rpx 0rpx 10rpx 10rpx;
		padding: 15rpx;
		box-sizing: border-box;
		display: flex;
		flex-direction: row;
		image {
			// display: flex;
			// flex-direction: row;
			border-radius: 10px;
			width: 80px;
			height: 80px;
			display: block;
			margin-left: 10px;
		}
		.right {
			margin-left: 10px;
			.price {
				display: flex;
				flex-direction: column;
				color: #1a1a1a;
				font-size: 36rpx;
				font-weight: 500;
			}
			.name {
				color: $hospital-color;
				font-size: 28rpx;
				margin: 20rpx 0 5rpx 0;
				line-height: 50rpx;
				text:nth-child(2) {
					color: #ccc;
					font-size: 28rpx;
					margin-left: 30rpx;
				}
			}
			.title {
				font-size: 28rpx;
				line-height: 30rpx;
				padding: 10rpx 0 15rpx 0;
			}
		}
		
	}
}
</style>
