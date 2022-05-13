<template>
	<view>
		<view class="home">
			<!-- <swiper indicator-dots circular>
				<swiper-item v-for="item in swipers" :key="item.id">
					<image :src="item.img"></image>
				</swiper-item>
			</swiper> -->
			<!-- <view class="nav">
				<view
					class="nav_item"
					v-for="(item, index) in navs"
					:key="index"
					@click="navItemClick(item.path)">
					<view :class="item.icon"></view>
					<text>{{item.title}}</text>
				</view>
			</view> -->
			<view class="hot_goods">
				<view class="tit">
					热门商品
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
				// swipers: [],
				// goods: [],
				// navs: [
				// 	{
				// 		icon: 'iconfont icon-ziyuan',
				// 		title: '热点新闻',
				// 		path: '/pages/DrugStore/ShoppingCart/ShoppingCart'
				// 	},
				// 	{
				// 		icon: 'iconfont icon-guanyuwomen',
				// 		title: '购物车',
				// 		path: '/pages/DrugStore/ShoppingCart/ShoppingCart'
				// 	},
				// 	{
				// 		icon: 'iconfont icon-tupian',
				// 		title: '我的订单',
				// 		path: '/pages/DrugStore/HistoryOrder/HistoryOrder'
				// 	},
				// 	{
				// 		icon: 'iconfont icon-shipin',
				// 		title: '联系我们',
				// 		path: '/pages/DrugStore/HistoryOrder/HistoryOrder'
				// 	}
				// ]
			}
		},
		onLoad() {
			uni.hideTabBar()
			// this.getSwipers()
			// this.getHotGoods()
		},
		// components: {
		// 	goodsList
		// },
		methods: {
			// 获取轮播图数据
			// async getSwipers() {
			// 	const res = await this.$http({
			// 		url: '/api/getlunbo'
			// 	})
			// 	this.swipers = res.data.message
			// },
			// 获取热门商品列表数据
			// async getHotGoods() {
			// 	const res = await this.$http({
			// 		url: '/api/getgoods?pageindex=1'
			// 	})
			// 	this.goods = res.data.message
			// },
			// 导航点击的处理函数
			// navItemClick (url) {
			// 	uni.navigateTo({
			// 		url
			// 	})
			// },
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
		margin-top: 10rpx;
		.tit {
			height: 50px;
			line-height: 50px;
			// color: $shop-color;
			text-align: center;
			letter-spacing: 20px;
			background: #fff;
			margin: 6rpx 0;
		}
	}
}
</style>
