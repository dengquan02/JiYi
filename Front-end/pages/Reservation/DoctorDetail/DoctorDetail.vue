<template>
	<view>
		<!-- 顶部标题 -->
		<view class='right'>
			<view class="price">
				<text>{{department.name}}</text>
				<text>{{department.hospital}}</text>
			</view>
			<view class="name">
				<view class="tag" v-for="item in department.title" :key="item.id">
					<u-tag :text=item.name  type="success" size="mini" plain ></u-tag>
				</view>
			</view>
		</view>
		
		<u-gap height="20" bgColor="#fafafa"></u-gap>
		
		<!-- 可预约时段 -->
		<view class="hot_goods">
			<view class="tit">
				可&nbsp;&nbsp;&nbsp;&nbsp;预&nbsp;&nbsp;&nbsp;&nbsp;约&nbsp;&nbsp;&nbsp;&nbsp;时&nbsp;&nbsp;&nbsp;&nbsp;段
			</view>
			<!-- 请选择日期 -->
			<view>
				<u-calendar :show="show" :mode="mode" @confirm="confirm"></u-calendar>
				<u-button  type="primary" :plain="true" @click="show = true">2022年5月15日（点击切换日期）</u-button>
			</view>
			<view>
				<uni-list>
					<view class="uni-list-cell" hover-class="uni-list-cell-hover" v-for="(value, key) in listData" :key="key" @click="goDetail(value)">
						<view class="uni-media-list">
							<view class="uni-media-list-body">
							   <view class="uni-media-list-text-top">{{ value.date }}&nbsp;{{value.time}}</view>
								<view class="uni-media-list-text-bottom">
									<text>剩余量：{{ value.reserve_ctn }}</text>
								</view>
							</view>
							<view class="uni-media-list-logo">
								<button class="left-btn" @click="ToDetail(value.id)">预约</button>
							</view>
						</view>
						<u-line></u-line>
					</view>
				</uni-list>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				show: false,
				mode: 'single',
				department: {
					'name': '王志荣',
					'title': [
						{
							'id': 1,
							'name': '主任医师'
						},
						{
							'id': 2,
							'name': '国家自然基金委借聘专家'
						}
					],
					'hospital': '同济大学附属医院 消化内科'
				},
				listData: [{
						id: "1",                       
						date: "2022年5月15日",
						time: "9:00~9:40",
						reserve_ctn: 1
					},
					{
						id: "2",
						date: "2022年5月15日",
						time: "10:00~11:40",
						reserve_ctn: 4
					},
					{
						id: "3",
						date: "2022年5月15日",
						time: "13:00~13:40",
						reserve_ctn: 1
					},
					{
						id: "4",
						date: "2022年5月15日",
						time: "16:00~18:40",
						reserve_ctn: 13
					}
				],
			}
		},
		methods: {
			confirm(e) {
				console.log(e);
				this.show = false;
			},
			ToDetail(id) {
				uni.navigateTo({
					url: '../ReservationDetail/ReservationDetail?doc_id='+this.department.name+'&time='+id
				});
			}
		}
	}
</script>

<style lang="scss">
.right {
	height: 80px;
	margin-left: 20px;
	.price {
		margin-top: 30px;
		display: flex;
		flex-direction: row;
		color: #1a1a1a;
		font-size: 44rpx;
		font-weight: 600;
		text:nth-child(2) {
			color: #ababab;
			font-size: 33rpx;
			margin-left: 40rpx;
			font-weight: 300;
			margin-top: 10rpx;
		}
	}
	.name {
		// color: $hospital-color;
		display: flex;
		flex-direction: row;
		font-size: 33rpx;
		margin: 30rpx 30rpx 5rpx 0;
		line-height: 60rpx;
		.tag {
			margin-right: 30rpx;
		}
	}
	.title {
		font-size: 33rpx;
		line-height: 60rpx;
		padding: 10rpx 0 15rpx 0;
	}
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
.uni-media-list{
	display: flex;
	flex-direction: row;
	margin-left: 32rpx;
	margin-right: 32rpx;
	margin-top: 30rpx;
	margin-bottom: 30rpx;
	
	.uni-media-list-logo {
		width: 200rpx;
		height: 100rpx;
		.left-btn {
			border:5rpx solid $hospital-color;
			background-color: rgb(239, 244, 252);
			text-align: center;
			font-size: 32rpx;
			font-weight: 500;
			position: absolute;
			right: 20px;
		}
	}
	
	
	.uni-media-list-body {
		flex-direction: row;
		height: auto;
		margin-left: 20rpx;
		margin-right: 20rpx;
		justify-content: space-around;
	}
	 
	.uni-media-list-text-top {
		height: 40rpx;
		font-size: 33rpx;
		overflow: hidden;
	}
	 
	.uni-media-list-text-bottom {
		display: flex;
		flex-direction: row;
		margin-top: 20rpx;
		font-size: 30rpx;
		color: $hospital-color;
	}
}
</style>
