<template>
	<view class="u-page">
		<view class="status_bar">
		<!-- 这里是状态栏 -->
		</view>
		<view style="margin-bottom: 30rpx; text-align: center;">
			<uni-card :is-shadow="false" is-full>
				<!-- 医院名称 -->
				<text class="uni-h4" style="margin-top: 30rpx; display: block;">{{hospitalName}}</text>
				<!-- 科室名称 -->
				<text class="uni-h6" style="margin-top: 30rpx; display: block;">{{departmentName}}</text>				
			</uni-card>
		</view>
		<view style="margin-bottom: 30rpx; text-align: center;">
			<uni-card :is-shadow="false" is-full>
				<view class="card-box">
					<image src="http://rbphewwot.hd-bkt.clouddn.com/jiyi%2Fdoctor1.svg" style="height: 100px; width: 100px; margin-left: -150rpx;" mode="aspectFill"></image>
					<view style="height: 100%; align-items: center; text-align: center; margin-left: 60rpx;">
						
						<text class="uni-h5" style="display: block; margin: 10rpx 0;">吴孟达</text>
						<uni-tag :inverted="true" :circle="true" size="small" text="主任医师" type="primary" />
						<text class="uni-h6" style="display: block; margin: 10rpx 0;">性别：男</text>
						<text style="display: block; margin: 10rpx 0;">预约量：9</text>
					</view>
				</view>			
			</uni-card>
		</view>
		<u-cell-group>
			<u-cell
				@click="showCalendar"
				title="选择日期"
				:label="dateValue"
				isLink
			>
			</u-cell>
		</u-cell-group>
		<u-calendar
			:show="show"
			mode="range"
			@confirm="confirm"
			@close="close"
		></u-calendar>
		<!-- 可预约列表卡片 -->
		<view v-for="(item, index) in timeList">
			<uni-card is-full>
				<view class="card-box">
					<view style="width: 1300rpx;">
						<view>
							<text style="display: block;">{{dateValue}}</text>
							<text style="display: block;">16:00~16:30</text>
						</view>
						<text style="display: block;">剩余量：1</text>
					</view>
					<u-button
					    text="预约"
					    size="normal"
					    plain
						shape="circle"
						color="#1058D1"
					></u-button>
				</view>
			</uni-card>
		</view>
	</view>
</template>
<script>
	export default {
		data() {
			const d = new Date()
			const year = d.getFullYear()
			//月份的获取需要注意
			let month = d.getMonth() + 1
			month = month < 10 ? `0${month}` : month
			const day  = d.getDate()
			const value  = year.toString() + '-' + month.toString() + '-' + day.toString()
			return {
				dateValue:value, //日期
				show: false,  //日历是否弹出time
				doctorName:'吴孟达',
				departmentName:'急诊科',
				hospitalName:'同济大学附属医院',
				timeList:[1]
			}
		},
		methods: {
			showCalendar() {
				this.show = true
			},
			confirm(e) {
				this.show = false
				console.log(e);
				this.dateValue = e[0] + '~' + e[e.length - 1]
			},
			close() {
				this.show = false
			}
		},
	}
</script>

<style lang="scss">
	.u-page {
		padding: 0;
	}
 // @import '@/common/uni-ui.scss';
	 .status_bar {
		height: var(--status-bar-height);
		width: 100%;
		 background-color: $hospital-color;
	 }
	 .myform{
		padding: 20rpx 30rpx;
	 }
	 .title{
		 text-align: center;
	 }
	 .card-box {
	 	display: flex;
	 	justify-content: center;
	 	align-items: center;
	 	margin-bottom: 10rpx;
	 }
</style>
