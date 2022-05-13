<template>
	<view class="form">
		<!-- 最上方的logo图标 -->
		<view class="img-box">
			<image class="login-img1" src="http://rbphewwot.hd-bkt.clouddn.com/jiyi/login.png"/>
		</view>
		<!-- 表单 -->
		<uni-forms class="login-form" :modelValue="formData">
			<uni-forms-item name="tel">
				<uni-easyinput prefixIcon="person" type="text" v-model="formData.tel" placeholder="请输入手机号" />
			</uni-forms-item>
			<uni-forms-item name="passwd">
				<uni-easyinput prefixIcon="locked" type="password" v-model="formData.passwd" placeholder="请输入密码" />
			</uni-forms-item>
		</uni-forms>
		<!-- 提交按钮 -->
		<button class="login-btn" @click="login">登录</button>
	</view>
</template>
<script>
	export default{
		data(){
			return{
				formData:{
					tel:'',
					passwd:''
				}
			}
		},
		methods:{
			login(){
				//login , go to home page
				uni.showToast({
					title: '登录成功',
					duration: 2000
				});
				uni.navigateTo({
					// url:'/pages/home/home'
					url:'../register/register'
				})
			}
		}
	}
</script>
<style>
	.form{
		padding: 30rpx 100rpx;
		margin-top: 200rpx;
	}
	.login-form{
		margin-bottom: 50rpx;
	}
	.img-box {
		display: flex;
		justify-content: center;
		align-items: center;
		margin-bottom: 100rpx;
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
</style>