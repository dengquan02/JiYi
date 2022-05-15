 <template>
	 <view>
		<view class="status_bar">
		    <!-- 这里是状态栏 -->
		</view>
		<!-- 搜索框 -->
		<view class="search-bar">
			<view class="search-bar-box">
				<image class="search-span" src="../../../static/zjq/search.png" @click="search()"/>
				<input type="text" v-model="inputName" placeholder="搜医院，医生，科室……" class="search-text" maxlength="10" confirm-type="search" @confirm="inputConfirm()" @input="onKeyInput()"/>
			</view>
		</view>
		<!-- 导航栏 -->
		<view class="nav">
			<view
				class="nav_item"
				v-for="(item, index) in navs"
				:key="index"
				@click="navItemClick(item.path)">
				<view :class="item.icon"></view>
				<text>{{item.title}}</text>
			</view>
		</view>
		<!-- 列表 -->
		<view class="hot_docs">
			<view class="tit">
				热门医生
			</view>
			<view class="docs_list">
				<view
					class="docs_item"
					v-for="item in docs"
					:key="item.id"
					@click="navigator(item.id)">
					<image :src="item.img_url" mode=""></image>
					<view class="price">
						<text>{{item.name}}</text>
						<text>￥{{item.market_price}}</text>
					</view>
					<view class="name">
						{{item.title}}
					</view>
					<view class="title">
						<u-tag :text=item.hospital type="success" size="mini" plain style="margin-right: 10px;"></u-tag>
						<u-tag :text=item.doctor  type="warning" size="mini" plain></u-tag>
					</view>
				</view>
			</view>
		</view>
	 </view>
 </template>
 <script>
 	export default{
 		data() {
 			return {
				inputName: '',
				searchName: '',
				docs: [
					{
						'id': 4,
						'img_url': 'https://pics5.baidu.com/feed/d62a6059252dd42adf465cf2ff03acb3c8eab8d8.jpeg?token=109c660b1f2798c147912ac94199c238',
						'name': '温馨',
						'market_price': '70',
						'title': '渭南市第二医院 妇科',
						'hospital': '综合性二级医院',
						'doctor': '主任'
					},
					{
						'id': 3,
						'img_url': 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fappimg.dzwww.com%2Fshare%2F2020%2F08%2F19%2F461fe23306e95da_750.jpg&refer=http%3A%2F%2Fappimg.dzwww.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1655134671&t=60c77c1ebeb4bb95a0ad0c5ec00101de',
						'name': '吴江',
						'market_price': '50',
						'title': '潍坊市中医院 泌尿科',
						'hospital': '公立三甲中医',
						'doctor': '主治医师'
					},
					{
						'id': 2,
						'img_url': 'https://img0.baidu.com/it/u=83393396,2997980422&fm=253&fmt=auto&app=138&f=PNG?w=480&h=720',
						'name': '纪强',
						'market_price': '80',
						'title': '哈医大肿瘤医院 重症医学',
						'hospital': '专科医院',
						'doctor': '副主任'
					},
					{
						'id': 1,
						'img_url': 'https://zhuanjia.cdn.bcebos.com/zhuanjia/0b9f10f80e58f5ead25faa583.png',
						'name': '张启山',
						'market_price': '100',
						'title': '同济大学附属医院 骨科',
						'hospital': '二甲医院',
						'doctor': '主任'
					},
				],
				navs: [
					{
						icon: 'iconfont icon-xgyq',
						title: '疫情实时',
						path: '/pages/Covid/covid-19/covid-19'
					},
					{
						icon: 'iconfont icon-yijianyuyue',
						title: '预约挂号',
						path: '/pages/Reservation/HospitalList/HospitalList'
					},
					{
						icon: 'iconfont icon-gouyaojilu',
						title: '购药商城',
						path: '/pages/DrugStore/Homepage/Homepage'
					}
				]
 			}
 		},
		onLoad() {
			this.getDocList()
		},
 		methods: {
			getDocList(){
				uni.request({
					url:'http://100.80.61.47:8008/api/v1/doctor/list',
					method:'GET',	
					header: {
						'content-type': 'application/x-www-form-urlencoded'
					},
					success: (res) => {
						this.docs = res.data.doctor_list;
					}
				})				
			},
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
			// 回车键确定
			inputConfirm(event) {
				// 确定之后跳转到哪里
				console.log(event.detail.value)
			},
			//边输入边触发 得到文本框的值
			onKeyInput(event) {
				// 把值赋给data中的变量
				console.log(event.target.value)
			},
			//点击搜索图标 跳转页面
			search() {
				uni.request({				
					url:'http://100.80.61.47:8008/api/v1/search',
					method:'GET',	
					data: { inputName: this.inputName },
					header: {
						'content-type': 'application/x-www-form-urlencoded'
					},
					success: (res) => {
						if(this.inputName == "") return;
						this.searchName = res.data.name;
						// 若为医院
						if(res.data.type == 'hospital') {
							console.log(this.searchName)
							// 页面跳转
							uni.navigateTo({
								url: '../../Reservation/HospitalDetail/HospitalDetail/hospital_id=?' + res.data.hospital_id	
							});
						}
						// 若为科室
						else if(res.data.type == 'department') {
							console.log(this.searchName)
							// 页面跳转
							uni.navigateTo({
								url: '../../Reservation/DepartmentDetail/DepartmentDetail/department_id=?' + res.data.department_id	
							});
						}
						// 若为医生
						else if(res.data.type == 'doctor') {
							console.log(this.searchName)
							// 页面跳转
							uni.navigateTo({
								url: '../../Reservation/DoctorDetail/DoctorDetail/doctor_id=?' + res.data.doctor_id	
							});
						}
					}
				})
				console.log(this.friendName)
			},
			// 导航点击的处理函数
			navItemClick (url) {
				uni.navigateTo({
					url
				})
			},
 		}
 	}
 </script>
 
 <style lang="scss">
 	@import '@/common/uni-ui.scss';
	@import '@/static/iconfont-zjq-shouye/iconfont.css';
	// 搜索框
	.search-bar{
		width: 100%;
		height: 120rpx;
		margin-top: 5%;
	}
	.search-bar-box{
		display: flex;
		margin: 0 auto;
		width: 670rpx;
		height: 90rpx;
		border:4rpx solid $hospital-color;
		border-radius: 50rpx;
	}
	.search-span{
		width: 65rpx;
		height: 56rpx;
		margin-top: 9px;
		margin-left: 30rpx;
	}
	.search-text{
		width: 100%;
		margin-top: 10px;
		margin-left: 20rpx;
		font-size: 33rpx;
		color: $uni-text-color-disable;
	}
	.status_bar {
		height: var(--status-bar-height);
		width: 100%;
	    background-color: #ddd;
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
	.hot_docs {
		background: #eee;
		overflow: hidden;
		margin-top: 10px;
		.tit {
			height: 50px;
			line-height: 50px;
			color: $hospital-color;
			text-align: center;
			letter-spacing: 20px;
			background: #fff;
			margin: 6rpx 0;
			font-weight:550;
		}
	}
	.docs_list {
		padding: 0 15rpx;
		display: flex;
		flex-wrap: wrap;
		justify-content: space-between;
		.docs_item {
			border-radius: 5%;
			background: #fff;
			width: 355rpx;
			margin: 10rpx 0;
			padding: 15rpx;
			box-sizing: border-box;
			image {
				border-radius: 5%;
				width: 100%;
				height: 150px;
				display: block;
				margin: 0 auto;
			}
			.price {
				color: $hospital-color;
				font-size: 36rpx;
				margin: 20rpx 0 5rpx 0;
				text:nth-child(2) {
					color: #ccc;
					font-size: 28rpx;
					margin-left: 10rpx;
				}
			}
			.name {
				font-size: 28rpx;
				line-height: 50rpx;
				padding: 10rpx 0 15rpx 0;
			}
			.title {
				display: flex;
				flex-direction: row;
			}
		}
	}
	.nav {
		display: flex;
		.nav_item {
			width: 33%;
			text-align: center;
			view {
				width: 150rpx;
				height: 150rpx;
				background: $hospital-color;
				border-radius: 10rpx;
				margin: 10px auto;
				line-height: 120rpx;
				color: #fff;
				font-size: 50rpx;
			}
			.icon-xgyq {
				font-size: 40px;
				text-align: center;
				line-height:75px;
			}
			.icon-gouyaojilu {
				font-size: 40px;
				text-align: center;
				line-height:75px;
			}
			.icon-yijianyuyue {
				font-size: 40px;
				text-align: center;
				line-height:75px;
			}
			text {
				font-size: 30rpx;
			}
		}
	}
 </style>
