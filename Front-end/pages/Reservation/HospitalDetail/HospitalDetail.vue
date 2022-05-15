<template>
	<view>
		<!-- 顶部标题 -->
		<view class='right'>
			<view class="price">
			<text>{{hospital.name}}</text>
			</view>
			<view class="name">
				<u-tag :text=hospital.title  type="success" size="mini" plain></u-tag>
				<text>{{hospital.telephone}}(点击拨打)</text>
			</view>
			<view class="title">
				<text>地址：{{hospital.location}}</text>
			</view>
		</view>
		
		<u-gap height="20" bgColor="#fafafa"></u-gap>
		
		<!-- 双栏列表 -->
		<view class="hot_goods">
			<view class="tit">
				科&nbsp;&nbsp;&nbsp;&nbsp;室&nbsp;&nbsp;&nbsp;&nbsp;列&nbsp;&nbsp;&nbsp;&nbsp;表
			</view>
			<view class="scroll-panel" id="scroll-panel">
				<view class="list-box">
					<view class="left">
						<scroll-view scroll-y="true" 
						:style="{ 'height':scrollHeight }"
						:scroll-into-view="leftIntoView"
						:scroll-with-animation="true"
						>
							<view class="item" 
								v-for="(item,index) in leftArray"
								:key="index" 
								:class="{ 'active':index==leftIndex }" 
								:id="'left-'+index"
								:data-index="index"
								@tap="leftTap"
							>{{item}}</view>
				        </scroll-view>
					</view>
					<view class="main">
						<swiper class="swiper" :style="{ 'height':scrollHeight }" 
							:current="leftIndex" @change="swiperChange"
							 vertical="true" duration="300">
							<swiper-item v-for="(item,index) in mainArray" :key="index">
								<scroll-view  scroll-y="true" :style="{ 'height':scrollHeight }">
									<view class="goods" v-for="(item2,index2) in item.list" :key="index2">
										<!-- <image src="/static/logo.png" mode=""></image> -->
										<view class="describe" @click="rightTap()">{{item2}}</view>
									</view>
								</scroll-view>
							</swiper-item>
						</swiper>
					</view>
				</view>
			</view>
		</view>
		
		<u-gap height="20" bgColor="#fafafa"></u-gap>
		
		<!-- 地图 -->
		<view class="hot_goods">
			<view class="tit">
				医&nbsp;&nbsp;&nbsp;&nbsp;院&nbsp;&nbsp;&nbsp;&nbsp;位&nbsp;&nbsp;&nbsp;&nbsp;置
			</view>
			<view>
				<map
					class="map"
					:longitude="longtitude"
					:latitude="latitude"
					:markers="marker"
					:scale="scale">
				</map>
			</view>
		</view>
		
		<u-gap height="20" bgColor="#fafafa"></u-gap>
		
		<!-- 图册 -->
		<view class="hot_goods">
			<view class="tit">
				医&nbsp;&nbsp;&nbsp;&nbsp;院&nbsp;&nbsp;&nbsp;&nbsp;图&nbsp;&nbsp;&nbsp;&nbsp;册
			</view>
			<view class="home">
				<swiper indicator-dots circular>
					<swiper-item v-for="item in swipers" :key="item.id">
						<image :src="item.img"></image>
					</swiper-item>
				</swiper>
			</view>
		</view>
		
		<u-gap height="20" bgColor="#fafafa"></u-gap>
		
		<view class="copyright">
			<text class="cr">{{cr}}</text>
		</view>
		
		<u-gap height="2" bgColor="#fafafa"></u-gap>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				hospital: {
					'name': '同济大学附属医院',
					'title': '二甲医院',
					'telephone': '(021)65988837',
					'location': '上海市杨浦区赤峰路50号'
				},
				longtitude: 121.507458,
				latitude: 31.286118,
				marker: [
					{
						longtitude: 121.507458,
						latitude: 31.286118,
						iconPath: '/static/logo.png',
						width: 30,
						height: 30
					}
				],
				scale: 13,
				swipers: [
					{
						'id': 1,
						'img': 'https://www.tongjihospital.com.cn/upload/image/200410/15865016156719.jpg'
					},
					{
						'id': 2,
						'img': 'https://img2.baidu.com/it/u=359466598,349672704&fm=253&fmt=auto&app=120&f=JPEG?w=982&h=653'
					},
					{
						'id': 3,
						'img': 'https://www.tongjihospital.com.cn/upload/image/200410/15865028892821.jpg'
					}
				],
				cr: '-- JIYI --',
				scrollHeight:'400px',
				leftArray:[],
				mainArray:[],
				leftIndex:0
			}
		},
		computed:{
			/* 计算左侧滚动位置定位 */
			leftIntoView(){
				return `left-${this.leftIndex > 5 ? (this.leftIndex-5):0}`;
			}
		},
		mounted(){
			/* 等待DOM挂载完成 */
			this.$nextTick(()=>{
				/* 在非H5平台，nextTick回调后有概率获取到错误的元素高度，则添加200ms的延迟来减少BUG的产生 */
				setTimeout(()=>{
					/* 等待滚动区域初始化完成 */
					this.initScrollView().then(()=>{
						/* 获取列表数据，你的代码从此处开始 */
						this.getListData();
					})
				},200);
			})
		},
		methods: {
			/* 初始化滚动区域 */
			initScrollView(){
				return new Promise((resolve, reject)=>{
					let view = uni.createSelectorQuery().select('#scroll-panel');
					view.boundingClientRect(res => {
						this.scrollHeight = `${res.height}px`;
						this.$nextTick(()=>{
							resolve();
						})
					}).exec();
				});
			},
			/* 获取列表数据 */
			getListData(){
				// Promise 为 ES6 新增的API ，有疑问的请自行学习该方法的使用。
				new Promise((resolve,reject)=>{
					/* 因无真实数据，当前方法模拟数据。正式项目中将此处替换为 数据请求即可 */
					uni.showLoading();
					setTimeout(()=>{
						/* 因无真实数据，当前方法模拟数据 */
						let [left,main]=[[],[]];
						
						left.push("全部科室");
						list = ["急诊科", "普通外科", "妇产科", "骨科", "神经精神学科", "心血管内科", "中医科", "老年医学科", "消化内科", "神经外科中心"]
						main.push({list});
						
						left.push("市重点科室");
						list = ["急诊科", "中医科", "神经外科中心"]
						main.push({list});
						
						left.push("院重点科室");
						list = ["普通外科", "妇产科"]
						main.push({list});
						
						left.push("特色学科");
						let list = ["神经精神学科", "心血管内科",]
						main.push({list})
						
						
						// 将请求接口返回的数据传递给 Promise 对象的 then 函数。
						resolve({left,main});
					},1000);
				}).then((res)=>{
					console.log('-----------请求接口返回数据示例-------------');
					console.log(res);
					
					uni.hideLoading();
					this.leftArray=res.left;
					this.mainArray=res.main;
				});
			},
			/* 左侧导航点击 */
			leftTap(e){
				let index=e.currentTarget.dataset.index;
				this.leftIndex=Number(index);
			},
			/* 右侧导航点击 */
			rightTap(e){
				uni.navigateTo({
					url: '../DepartmentDetail/DepartmentDetail'	
				});
			},
			/* 轮播图切换 */
			swiperChange(e){
				let index=e.detail.current;
				this.leftIndex=Number(index);
			}
		}
	}
</script>

<style lang="scss">
.right {
	height: 120px;
	margin-left: 20px;
	.price {
		margin-top: 30px;
		display: flex;
		flex-direction: column;
		color: #1a1a1a;
		font-size: 44rpx;
		font-weight: 600;
	}
	.name {
		display: flex;
		flex-direction: row;
		// color: $hospital-color;
		font-size: 33rpx;
		margin: 20rpx 0 5rpx 0;
		line-height: 60rpx;
		text:nth-child(2) {
			color: #ababab;
			font-size: 33rpx;
			margin-left: 30rpx;
		}
	}
	.title {
		font-size: 33rpx;
		line-height: 60rpx;
		padding: 10rpx 0 15rpx 0;
	}
}
.map {
	width: 100%;
	height: 450rpx;
}
.hot_goods {
	background: #eee;
	overflow: hidden;
	.tit {
		height: 50px;
		line-height: 50px;
		// color: $hospital-color;
		font-size: 35rpx;
		text-align: center;
		background: #fff;
		margin: 6rpx 0;
		font-weight:500;
	}
}
.home {
	swiper {
		width: 750rpx;
		height: 380rpx;
		image {
			height: 100%;
			width: 100%;
		}
	}
}
.list-box{
	display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: flex-start;
    align-items: flex-start;
    align-content: flex-start;
	font-size: 28rpx;
	
	.left{
		width: 250rpx;
		background-color: #f6f6f6;
		line-height: 80rpx;
		box-sizing: border-box;
		font-size: 32rpx;
		text-align: center;
		
		.item{
			// padding-left: 20rpx;
			position: relative;
			&:not(:first-child) {
				margin-top: 1px;
			
				&::after {
					content: '';
					display: block;
					height: 0;
					border-top: #d6d6d6 solid 1px;
					width: 620upx;
					position: absolute;
					top: -1px;
					right: 0;
					transform:scaleY(0.5);	/* 1px像素 */
				}
			}
			
			&.active,&:active{
				color: $hospital-color;
				background-color: #fff;
			}
		}
	}
	.main {
		background-color: #fff;
		padding-left: 10px;
		width: 0;
		flex-grow: 1;
		box-sizing: border-box;
		
		line-height: 30px;
		
		.swiper{
			height: 500px;
		}
		
		.goods{
			display: flex;
			flex-direction: row;
			flex-wrap: nowrap;
			justify-content: flex-start;
			align-items: center;
			align-content: center;
			margin-bottom: 10rpx;
			
			.describe{
				font-size: 30rpx;
				color: #7e7e7e;
			}
		}
	}
}
.copyright {
	display: flex;
	justify-content: center;
	margin-top: 20px;
	margin-bottom: 20px;
	font-size: 30rpx;
	/* font-weight: 500; */
	color: #1a1a1a;
}
</style>
