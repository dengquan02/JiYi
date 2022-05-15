<template>
	<view>
		<view class="home">
			<swiper indicator-dots circular>
				<swiper-item v-for="item in swipers" :key="item.id">
					<image :src="item.img"></image>
				</swiper-item>
			</swiper>
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
			<view class="hot_goods">
				<view class="tit">
					热&nbsp;&nbsp;&nbsp;&nbsp;门&nbsp;&nbsp;&nbsp;&nbsp;商&nbsp;&nbsp;&nbsp;&nbsp;品
				</view>
				<view class="goods_list">
					<view
						class="goods_item"
						v-for="item in goods"
						:key="item.id"
						@click="navigator(item.id)">
						<image :src="item.img_url" mode=""></image>
						<view class="price">
							<text>￥{{item.sell_price}}</text>
							<text>市场价￥{{item.market_price}}</text>
						</view>
						<view class="name">
							{{item.title}}
						</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	// import goodsList from '../../../components/goods-list/goods-list.vue'
	export default {
		data() {
			return {
				swipers: [
					{
						'id': 1,
						'img': 'http://kano.guahao.cn/S3i434966678?token=MWNiODRjMzZmYjllM2I3MzM1ZTkzYTNlMzJkOTZlZTJfTUQ1COUSTOM&v=1.0'
					},
					{
						'id': 2,
						'img': 'https://img0.baidu.com/it/u=1288210293,3278583697&fm=253&fmt=auto&app=138&f=JPEG?w=1500&h=500'
					},
					{
						'id': 3,
						'img': 'https://img2.baidu.com/it/u=2432013445,2051009811&fm=253&fmt=auto&app=138&f=JPEG?w=1280&h=460'
					},
					{
						'id': 4,
						'img': 'https://img2.baidu.com/it/u=178642286,892712417&fm=253&fmt=auto&app=138&f=JPEG?w=900&h=300'
					}
				],
				// goods: [],
				navs: [
					{
						icon: 'iconfont icon-news',
						title: '热点资讯',
						path: '/pages/DrugStore/News/News'
					},
					{
						icon: 'iconfont icon-gouwuche',
						title: '购物车',
						path: '/pages/DrugStore/ShoppingCart/ShoppingCart'
					},
					{
						icon: 'iconfont icon-shouye',
						title: '我的订单',
						path: '/pages/DrugStore/HistoryOrder/HistoryOrder'
					},
					{
						icon: 'iconfont icon-lianxiwomen',
						title: '联系我们',
						path: '/pages/DrugStore/Contact/Contact'
					}
				],
				goods: [
					{
						'id': 1,
						'img_url': '/static/imgs/kouzhao.png',
						'sell_price': '14.99',
						'title': '【H901】医用外科口罩',
						'market_price': '20'
					},
					{
						'id': 2,
						'img_url': '/static/imgs/jiujing.png',
						'sell_price': '19.9',
						'title': '免洗消毒凝胶 75%酒精',
						'market_price': '25'
					},
					{
						'id': 3,
						'img_url': '/static/imgs/mianqian.png',
						'sell_price': '5.5',
						'title': '家用消毒棉签',
						'market_price': '8.8'
					},
					{
						'id': 4,
						'img_url': '/static/imgs/chouzhi.png',
						'sell_price': '3.5',
						'title': '【原木纯品】清风抽纸',
						'market_price': '3.85'
					},
				],
			}
		},
		onLoad() {
			uni.hideTabBar()
			this.setTitleText()
			this.setTitleBackground()
			// this.getSwipers()
			// this.getHotGoods()
		},
		// components: {
		// 	goodsList
		// },
		methods: {
			setTitleText() {
				uni.setNavigationBarTitle({
					title: "购药商城"
				})
			},
			setTitleBackground() {
				uni.setNavigationBarColor({
					frontColor: "#ffffff", // 导航栏文字设置
					backgroundColor: "#007AFF"// 导航栏背景色设置
				})
			},
			// 获取轮播图数据
			async getSwipers() {
				// const res = await this.$http({
				// 	url: '/api/getlunbo'
				// })
				// this.swipers = res.data.message
				this.swipers = [
					{
						"id": 1,
						"url": "https://img1.baidu.com/it/u=3757403282,3297426190&fm=253&fmt=auto&app=138&f=JPEG?w=1280&h=333"
					}
				]
			},
			// 获取热门商品列表数据
			// async getHotGoods() {
			// 	const res = await this.$http({
			// 		url: '/api/getgoods?pageindex=1'
			// 	})
			// 	this.goods = res.data.message
			// },
			// 导航点击的处理函数
			navItemClick (url) {
				uni.navigateTo({
					url
				})
			},
			// // 导航到商品详情页
			// goodsItemClick (id) {
			// 	uni.navigateTo({
			// 		url: '/pages/DrugStore/goods-detail/goods-detail'
			// 	});
			// }
		}
	}
</script>

<style lang="scss">
@import '@/static/iconfont/iconfont.css';
.home {
	swiper {
		width: 750rpx;
		height: 380rpx;
		image {
			height: 100%;
			width: 100%;
		}
	}
	.nav {
		display: flex;
		.nav_item {
			width: 25%;
			text-align: center;
			view {
				width: 120rpx;
				height: 120rpx;
				background: $shop-color;
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
	.hot_goods {
		background: #eee;
		overflow: hidden;
		margin-top: 10px;
		.tit {
			height: 50px;
			line-height: 50px;
			color: $shop-color;
			text-align: center;
			font-weight: 500;
			background: #fff;
			margin: 10rpx 0;
		}
	}
}
.goods_list {
	padding: 0 15rpx;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	.goods_item {
		background: #fff;
		border-radius: 5%;
		margin: 10rpx 0;
		padding: 15rpx;
		width: 355rpx;
		box-sizing: border-box;
		image {
			border-radius: 5%;
			width: 100%;
			height: 180px;
			display: block;
			margin: 0 auto;
		}
		.price {
			color: $shop-color;
			font-size: 36rpx;
			margin: 20rpx 0 5rpx 0;
			text:nth-child(2) {
				color: #ccc;
				font-size: 28rpx;
				margin-left: 10rpx;
				text-decoration: line-through;
			}
		}
		.name {
			font-size: 30rpx;
			line-height: 50rpx;
			padding: 10rpx 0 15rpx 0;
		}
	}
}
</style>
