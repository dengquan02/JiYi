<template>
	<view>
		<view class="text-group">
			<view>2022.05.14 19：00~21：00</view>
			<view style="margin-left: 40px;" class="status">待就诊</view>
		</view>
		<u-gap height="20" bgColor="#fafafa"></u-gap>
		<u-cell-group>
			<u-cell icon="home-fill" title="就诊医院" value="同济大学附属医院"></u-cell>
			<u-cell icon="bell-fill" title="就诊科室" value="急诊科"></u-cell>
			<u-cell icon="mic" title="医生" value="伪装者"></u-cell>
			<u-cell icon="plus-people-fill" title="就诊人" value="周洁琼"></u-cell>
			<u-cell icon="rmb-circle-fill" title="费用" value="以医院实际为准"></u-cell>
		</u-cell-group>
		<view class="btn-group">
			<u-button type="error" :plain="true" text="取消预约"></u-button>
			<view style="width: 220px;"></view>
			<u-button type="primary" :plain="true" text="再次预约" @click="ToRes()"></u-button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			ToRes() {
				uni.redirectTo({
					url: '../HospitalList/HospitalList'	
				});
			}
		}
	}
</script>

<style lang="scss">
.text-group {
	margin: 20px 20px 20px 20px;
	display: flex;
	flex-direction: row;
	.status {
		color: rgba(0, 0, 0, 0.4);
	}
}
.btn-group {
	margin: 0 auto; 
	margin-top: 40px;
	text-align: "center";
	width: 220px;
	display: flex;
	flex-direction: row;
}
</style>
