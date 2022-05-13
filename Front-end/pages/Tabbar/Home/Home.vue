 <template>
	 <view>
		<view class="status_bar">
		    <!-- 这里是状态栏 -->
		</view>
		<view class="login-form">
			<!-- 搜索框 -->
			<uni-easyinput prefixIcon="search"  type="text" placeholder="搜医院,医生,科室..." v-model="formData.tel" />
			<!-- 三个按钮 -->
			<view class="button-box">
				<uni-card spacing="5px" padding="0 5px " @click="ToCovid()">
					<image src="http://rbphewwot.hd-bkt.clouddn.com/jiyi%2Fyiqin.svg" style="height: 100rpx; width: 100rpx; margin: 0 auto;"></image>
					<view style="text-align: center;">
						疫情
					</view>
				</uni-card>
				<uni-card spacing="5px" padding="0 5px " @click="ToReservation()">
					<image src="http://rbphewwot.hd-bkt.clouddn.com/jiyi%2Fyuyue.svg" style="height: 100rpx; width: 100rpx; margin: 0 auto;"></image>
					<view style="text-align: center;">
						预约
					</view>
				</uni-card>
				<uni-card spacing="5px" padding="0 5px " @click="ToDrug()">
					<image src="http://rbphewwot.hd-bkt.clouddn.com/jiyi%2Fbuy.svg" style="height: 100rpx; width: 100rpx; margin: 0 auto;"></image>
					<view style="text-align: center;">
						购药
					</view>
				</uni-card>
			</view>
			<!-- 列表 -->
			<view class="list">
				<view style="background-color: #fff; padding: 20rpx 30rpx;">
					<text>
						精选医生
					</text>
				</view>
				<!-- 基于 uni-list 的页面布局 -->
				<uni-list class="uni-list--waterfall">
					<uni-list-item :border="false" class="uni-list-item--waterfall" title="自定义商品列表" v-for="item in listData" :key="item">
						<!-- 通过header插槽定义列表左侧图片 -->
						<template v-slot:header>
							<view class="uni-thumb shop-picture shop-picture-column">
								<!-- <image :src="item.pic_url" style="height: 100px; width: 100px; margin: 0 auto;" mode="aspectFill"></image> -->
								<image src="http://rbphewwot.hd-bkt.clouddn.com/jiyi%2Fdoctor1.svg" style="height: 100px; width: 100px; margin: 0 auto;" mode="aspectFill"></image>
							</view>
						</template>
						<!-- 通过body插槽定义商品布局 -->
						<template v-slot:body>
							<view class="shop">
								<view>
									<view class="uni-title">
										<!-- <text class="uni-ellipsis-2">{{ item.hospital }}</text> -->
										<text class="uni-ellipsis-2">同济大学附属医院</text>
									</view>
									<view>
										<!-- <text class="uni-tag hot-tag">{{ item.department }}</text> -->
										<text class="uni-tag hot-tag">肝脏科</text>
									</view>
								</view>
								<view>
									<view class="shop-price">
										<text>¥</text>
										<!-- <text class="shop-price-text">{{ item.price }}</text> -->
										<text class="shop-price-text">200</text>
										<text>.00</text>
									</view>
									
									<view class="uni-note ellipsis">
										<!-- <view class="uni-ellipsis-1" style="margin-right: 10rpx;">{{ item.name }}</view> -->
										<view class="uni-ellipsis-1" style="margin-right: 10rpx;">吴孟达</view>
										<!-- <view class="uni-ellipsis-1">{{ item.title }}</view> -->
										<view class="uni-ellipsis-1">主任医师</view>
									</view>
								</view>
							</view>
						</template>
					</uni-list-item>
				</uni-list>
			</view>
		</view>
	 </view>
 </template>
 <script>
 	export default{
 		data(){
 			return{
 				formData:{
 					tel:'',
 					passwd:''
 				},
 				listData:[
 					// {
 					// 	_id:1,
 					// 	pic_url:'http://rbphewwot.hd-bkt.clouddn.com/jiyi%2Fbuy.svg',
 					// 	hospital:'医院',
 					// 	department:'科室',
 					// 	title:'职称',
 					// 	name:'名字',
 					// 	price:'价钱'
 					// },
 					1,2,3,4,5,6,7
 				]
 			}
 		},
 		methods: {
			ToCovid() {
				uni.navigateTo({
					url: '../../Covid/covid-19/covid-19'	
				});
			},
			ToReservation() {
				uni.navigateTo({
					url: '../../Reservation/HospitalList/HospitalList'	
				});
			},
			ToDrug() {
				uni.navigateTo({
					url: '../../DrugStore/Homepage/Homepage'	
				});
			},
 		}
 	}
 </script>
 
 <style lang="scss">
 	@import '@/common/uni-ui.scss';
	.status_bar {
		height: var(--status-bar-height);
		width: 100%;
	    background-color: $hospital-color;
	}
 	.login-form{
 		padding: 60rpx 40rpx;
 	}
 	.button-box {
 		display: flex;
 		justify-content: center;
 		align-items: center;
 		margin-bottom: 10rpx;
 	}
 	.login-card{
 		
 	}
 	.login-img1{
 		width: 450rpx;
 		height: 300rpx;
 	}
 	.login-img2{
 		width: 100rpx;
 		height: 100rpx;
 	}
 	.login-text{
 		display: block;
 	}
 	.shop-price {
 		margin-top: 5px;
 		font-size: 12px;
 		color: #65a0ff;
 	}
 
 	.shop-price-text {
 		font-size: 16px;
 	}
 
 	.hot-tag {
 		background: #65a0ff;
 		border: none;
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
 
 	// 默认加入 scoped ，所以外面加一层提升权重, 下面是网格化的关键
 	.list {
 		.uni-list--waterfall {
 			
 
 			/* #ifndef H5 || APP-VUE */
 			// 小程序 编译后会多一层标签，而其他平台没有，所以需要特殊处理一下
 			::v-deep .uni-list {
 			/* #endif */
 			// background-color: #F5F5F5;
 				display: flex;
 				flex-direction: row;
 				flex-wrap: wrap;
 				padding: 5px;
 				box-sizing: border-box;
 				 
 				/* #ifdef H5 || APP-VUE */
 				// h5 和 app-vue 使用深度选择器，因为默认使用了 scoped ，所以样式会无法穿透
 				::v-deep
 				/* #endif */
 				  .uni-list-item--waterfall {
 					width: 50%;
 					box-sizing: border-box;
 					.uni-list-item__container {
 						display: flex;
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
