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
				<!-- <goodsList :goods="goods" @goodsItemClick="goodsItemClick"></goodsList> -->
			</view>
		</view>
	</view>
</template>

<script>
	// import goodsList from '../../../components/goods-list/goods-list.vue'
	export default {
		data() {
			return {
				swipers: [],
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
				]
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
</style>
