<template>
	<view>
		<view class="u-demo-block__content">
		    <u-row
		        justify="space-between"
		        gutter="10"
		    >
		        <u-col span="4">
					<view class="demo-layout img-box">
						<u--image shape="circle" :src="src" width="80px" height="80px"></u--image>
					</view>
		        </u-col>
		        <u-col span="3">
		            <view class="demo-layout bg-purple-light">
						吴正问
					</view>
		        </u-col>
		        <u-col span="5">
		            <view class="demo-layout bg-purple-dark">
						副主任医师
					</view>
		        </u-col>
		    </u-row>
		</view>
		<u-gap height="20" bgColor="#fafafa"></u-gap>
		<u-cell-group>
			<u-cell icon="home-fill" title="就诊医院" value="同济大学附属医院"></u-cell>
			<u-cell icon="bell-fill" title="就诊科室" value="急诊科"></u-cell>
			<u-cell icon="calendar-fill" title="门诊时间" value="2022.05.14"></u-cell>
			<u-cell icon="edit-pen-fill" title="门诊类型" value="专家"></u-cell>
			<u-cell icon="rmb-circle-fill" title="费用" value="以医院实际为准"></u-cell>
		</u-cell-group>
		<u-line></u-line>
		<view>
			<u--text style="margin-left: 15px;margin-top: 10px;" text="我已了解以下规则并同意："></u--text>
			<u--text style="margin-left: 25px;margin-top: 10px;" type="warning" text="*实名制预约，信息不符将无法取号"></u--text>
			<u--text style="margin-left: 25px;margin-top: 5px;margin-bottom: 10px;" type="warning" text="*停诊将邮件通知，请保持邮箱畅通"></u--text>
		</view>
		<u-gap height="20" bgColor="#fafafa"></u-gap>
		<u-cell-group>
			<u-cell icon="plus-people-fill" title="就诊人" value="周洁琼"></u-cell>
			<u-cell icon="clock-fill" title="就诊时间段" value="16:00~16:30"></u-cell>
		</u-cell-group>
		<view style="padding: 10px;margin-top: 30px;">
			<u-button text="提交预约" shape="circle" color="linear-gradient(to right, rgb(16, 88, 209), rgb(84, 150, 255))" @click="ToConfirm()"></u-button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				src: 'https://cdn.uviewui.com/uview/album/1.jpg',
			}
		},
		methods: {
			ToConfirm() {
				uni.navigateTo({
					url: '../ReservationConfirm/ReservationConfirm'	
				});
			}
		}
	}
</script>

<style lang="scss">
.wrap {
	padding: 10px;
}

.demo-layout {
	margin-left: 20px;
	// height: 80px;
	margin-bottom: 5px;
	margin-top: 5px;
}

.img_box {
	margin-left: 20px;
	margin-bottom: 10px;
	margin-top: 10px;
}

.bg-purple-light {
	margin-top: 13px;
	font-size: 16px;
}

.bg-purple-dark {
	margin-top: 13px;
	color: rgba(0, 0, 0, 0.4);
	font-size: 16px;
}
</style>
