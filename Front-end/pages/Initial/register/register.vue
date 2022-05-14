<template>
	<view class="login-form">
		<view class="img-box">
			<view>
				<image class="login-img2" src="../../../static/imgs/dedication.png"/>
			</view>
			<view class="login-img2">
				<text class="login-text">济医</text>
			</view>
		</view>
		<uni-forms :modelValue="formData">
			<uni-forms-item name="tel">
				<uni-easyinput prefixIcon="phone" type="text" v-model="formData.tel" placeholder="请输入手机号" />
			</uni-forms-item>
			<uni-forms-item name="passwd">
				<uni-easyinput prefixIcon="locked" type="text" v-model="formData.passwd" placeholder="请输入密码" />
			</uni-forms-item>
			<uni-forms-item name="id">
				<uni-easyinput prefixIcon="person" type="text" v-model="formData.id" placeholder="请输入身份证号" />
			</uni-forms-item>
			<uni-forms-item name="name">
				<uni-easyinput prefixIcon="paperplane" type="text" v-model="formData.name" placeholder="请输入真实姓名" />
			</uni-forms-item>
		</uni-forms>
		<!-- <text>{{formData.passwd}}</text> -->
		<button class="login-btn" @click="register">注册</button>
	</view>
</template>
<script>
	export default{
		data(){
			return{
				formData:{
					tel:'',
					passwd:'',
					id:'',
					name:''
				}
			}
		},
		methods:{
			register(){
				//注册 , go to home page
				uni.showToast({
					title: '注册成功',
					duration: 2000
				});
				uni.switchTab({
					url:'../../Tabbar/Home1/Home1'
				})
			}
		}
	}
</script>
<style>
	.login-form{
		padding: 30rpx 100rpx;
	}
	.img-box {
		display: flex;
		justify-content: center;
		align-items: center;
		margin-bottom: 30rpx;
		margin-top: 50rpx;
	}
	.login-title{
		height: 100rpx;
		display: inline;
		align-items: center;
	}
	.login-btn{
		height: 82rpx;
		border-radius: 41rpx;
		background-color: #3075EE;
		box-shadow: -1px 12px 11px 0px rgba(28, 89, 170, 0.4);
		text-align: center;
		line-height: 82rpx;
		font-size: 36rpx;
		font-weight: 500;
		color: #fff;
		margin-top: 35rpx;
	}
	.login-img1{
		width: 450rpx;
		height: 300rpx;
	}
	.login-img2{
		width: 120rpx;
		height: 120rpx;
		align-items: center;
		/* padding-top: 300rpx; */
	}
	
	.login-text{
		display: block;
		margin: 30rpx 20rpx;
	}
</style>