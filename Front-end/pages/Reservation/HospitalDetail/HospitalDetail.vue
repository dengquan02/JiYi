<template>
	<view class="u-page">
		<view class="status_bar">
		<!-- 这里是状态栏 -->
		</view>
		<view style="margin-bottom: 30rpx;">
			<uni-card :is-shadow="false" is-full>
				<!-- 医院名称 -->
				<text class="uni-h4" style="margin-top: 30rpx; margin-left: 10rpx; margin-right: 30rpx;">{{hospitalName}}</text>
				<!--电话-->
				<text class="uni-h6" style="display: block;margin: 20rpx 20rpx;">{{hospitalTel}}</text>				
				<!-- <text class="uni-h5" style="margin: 15rpx 10rpx;">{{departmentClass}}</text> -->
				<!-- 医院地址 -->
				<text class="uni-h6" style="display: block;margin: 20rpx 20rpx;">{{hospitalAddress}}</text>				
			</uni-card>
		</view>
		<!-- SubSection实现选择什么类别科室 -->
		<view class="u-demo-block">
			<view class="u-demo-block__content">
				<u-subsection
					:list="list"
					mode="button"
					:current="curNow"
					activeColor="#1058D1"
					@change="changeSection"
				></u-subsection>
			</view>
		</view>
		<!-- 列表，这里可以使用v-show实现列表选择 -->
		<view class="uni-card" v-for="(item,index) in allDepartments">
			<uni-card :isFull="true">{{item}}</uni-card>
		</view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				list: ['全部科室','市重点学科', '院重点学科', '特色学科'],
				allDepartments:[
					'急诊科',
					'普通外科',
					'妇产科',
					'骨科',
					'神经精神学科',
					'心血管内科',
					'中医科',
					'老年医学科',
					'消化内科',
					'神经外科中心'],
				cityDepartments:['急诊科',
					'普通外科',
					'妇产科',
					'骨科'],
				hospitalDepartments:['妇产科',
					'骨科',
					'神经精神学科',
					'心血管内科'],
				specialDepartments:['骨科',
					'神经精神学科',
					'心血管内科',
					'中医科',
					'老年医学科'],
				curNow: 1,//当前的列表类别
				hospitalTel:'(021) 56051080',
				hospitalAddress:'上海市新村路389号',
				hospitalName:'同济大学附属医院',
				doctorList:[1,2,3,4,5,6]
			}
		},
		methods: {
			changeSection(index) {
				this.curNow = index
			}
		},
	}
</script>

<style lang="scss">
	// @import '@/common/uni-ui.scss';
	.album {
		@include flex;
		align-items: flex-start;
		&__avatar {
			background-color: #1058D1 ;
			padding: 5px;
			border-radius: 3px;
		}

		&__content {
			margin-left: 10px;
			flex: 1;
		}
	}
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
