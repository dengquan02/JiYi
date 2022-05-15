<template>
	<view class="u-page">
		<view class="status_bar">
		<!-- 这里是状态栏 -->
		</view>
		<view style="margin-bottom: 30rpx;">
			<uni-card :is-shadow="false" is-full>
				<!-- 科室名称 -->
				<text class="uni-h4" style="margin-top: 30rpx; margin-left: 10rpx; margin-right: 30rpx;">{{departmentName}}</text>
				<!--科室类别-->
				<uni-tag :inverted="true" :circle="true" :text="departmentClass" type="primary" />
				<!-- <text class="uni-h5" style="margin: 15rpx 10rpx;">{{departmentClass}}</text> -->
				<!-- 医院名称 -->
				<text class="uni-h6" style="display: block;margin: 20rpx 20rpx;">{{hospitalName}}</text>				
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
		<!-- 医生卡片列表 -->
		<view style="background-color: #fff; padding: 20rpx 30rpx;">
			<text>
				精选医生
			</text>
		</view>
		<view v-for="(item, index) in doctorList">
			<uni-card>
				<view class="card-box">
					<image src="http://rbphewwot.hd-bkt.clouddn.com/jiyi%2Fdoctor1.svg" style="height: 100px; width: 100px; margin-left: -150rpx;" mode="aspectFill"></image>
					<view style="height: 100%; align-items: center; text-align: center; margin-left: 60rpx;">
						
						<text class="uni-h5" style="display: block; margin: 10rpx 0;">吴孟达</text>
						<uni-tag :inverted="true" :circle="true" size="small" text="主任医师" type="primary" />
						<text style="display: block; margin: 10rpx 0;">预约量：9</text>
						
					</view>
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
				show: false,  //日历是否弹出
				departmentName:'急诊科',
				departmentClass:'普通科室',
				hospitalName:'同济大学附属医院',
				doctorList:[1,2,3,4,5,6]
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
