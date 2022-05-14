<template>
	<view>
		<view class="status_bar">
		    <!-- 这里是状态栏 -->
		</view>
		<view class="hot_docs">
			<view class="tit">
				医&nbsp;&nbsp;&nbsp;&nbsp;院&nbsp;&nbsp;&nbsp;&nbsp;列&nbsp;&nbsp;&nbsp;&nbsp;表
			</view>
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
		methods: {
			
		}
	}
</script>

<style lang="scss">
.status_bar {
	height: var(--status-bar-height);
	width: 100%;
	background-color: #ddd;
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
