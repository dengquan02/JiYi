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
		
		<!-- 全部医生 -->
		<view class="hot_goods">
			<view class="tit">
				医&nbsp;&nbsp;&nbsp;&nbsp;生&nbsp;&nbsp;&nbsp;&nbsp;列&nbsp;&nbsp;&nbsp;&nbsp;表
			</view>
			<!-- 请选择日期 -->
			<view>
				<u-calendar :show="show" :mode="mode" @confirm="confirm"></u-calendar>
				<u-button  type="primary" :plain="true" @click="show = true">2022年5月15日（点击切换日期）</u-button>
			</view>
			<!-- 医生列表 -->
			<view class="hot_hos">
				<view class="hos_list" @click="hosItemClick()">
					<view
						class="hos_item"
						v-for="item in hos"
						:key="item.id"
						@click="navigator(item.id)">
						<image :src="item.img_url" mode=""></image>
						<view class="right1">
							<view class="price">
							<text>{{item.name}}</text>
							</view>
							<view class="name">
								<text>{{item.title}}</text>
								<text>预约量：{{item.reserve}}</text>
							</view>
							<view class="title">
								<view class='text-group' v-for="item2 in item.description" :key="item2.id">
									<text>{{item2.content}}</text>
								</view>
							</view>
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
				show: false,
				mode: 'single',
				department: {
					'name': '消化内科',
					'title': [
						{
							'id': 1,
							'name': '院重点学科'
						},
						{
							'id': 2,
							'name': '市重点学科'
						}
					],
					'hospital': '同济大学附属医院'
				},
				hos: [
					{
						'id': 1,
						'img_url': 'https://www.tongjihospital.com.cn/upload/image/190228/15513191814200.jpg',
						'name': '王志荣',
						'title': '主任医师',
						'reserve': 11,
						'description': [
							{
								'id': 0,
								'content': '\"天道酬勤，恪守天职\"'
							},
							{
								'id': 1,
								'content': '\"内窥镜下消化道粘膜病变切除（EMR）\"'
							},
							{
								'id': 2,
								'content': '\"国家自然基金委借聘专家\"'
							},
						]
					},
					{
						'id': 2,
						'img_url': 'https://www.tongjihospital.com.cn/upload/image/190227/15512527395725.jpg',
						'name': '杨长青',
						'title': '学科带头人',
						'reserve': 3,
						'description': [
							{
								'id': 0,
								'content': '\"奋斗自我，真诚待人，奉献社会\"'
							},
							{
								'id': 1,
								'content': '\"肝胆疾病胃肠疾病\"'
							},
							{
								'id': 2,
								'content': '\"上海市中西医结合学会消化分会主委\"'
							},
						]
					},
					{
						'id': 3,
						'img_url': 'https://www.tongjihospital.com.cn/upload/image/190228/15513456275727.jpg',
						'name': '许树长',
						'title': '主任医师',
						'reserve': 3,
						'description': [
							{
								'id': 0,
								'content': '\"仁心仁术，济人济世\"'
							},
							{
								'id': 1,
								'content': '\"消化道疾病的内镜微创手术\"'
							},
							{
								'id': 2,
								'content': '\"国家消化道早癌防治中心联盟首席专家\"'
							},
						]
					},
					{
						'id': 4,
						'img_url': 'https://www.tongjihospital.com.cn/upload/image/190225/15510635231232.jpg',
						'name': '陈莹',
						'title': '副主任医师',
						'reserve': 10,
						'description': [
							{
								'id': 0,
								'content': '\"硕士\"'
							},
							{
								'id': 1,
								'content': '\"功能性及胃肠动力性疾病的临床诊治\"'
							},
							{
								'id': 2,
								'content': '\"上海市消化内镜专业委员会青年委员\"'
							},
						]
					},
				],
			}
		},
		methods: {
			confirm(e) {
				console.log(e);
				this.show = false;
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
.hos_list {
	// margin-left: 10px;
	margin-right: 13px;
	flex-wrap: wrap;
	// justify-content: space-between;
	.hos_item {
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
			border-radius: 20rpx;
			width: 80px;
			height: 120px;
			display: block;
			margin-left: 10px;
		}
		.right1 {
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
					color: #1a1a1a;
					font-size: 28rpx;
					margin-left: 30rpx;
				}
			}
			.title {
				font-size: 28rpx;
				line-height: 30rpx;
				padding: 10rpx 0 15rpx 0;
				color: #7e7e7e;
				.text-group {
					margin-top: 12rpx;
				}
			}
		}
		
	}
}
</style>
