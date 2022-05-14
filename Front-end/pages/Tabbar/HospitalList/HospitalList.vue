<template>
	<view>
		<view class="status_bar">
		    <!-- 这里是状态栏 -->
		</view>
		<view class="list">
			<!-- 基于 uni-list 的页面布局 -->
			<uni-list>
				<!-- to 属性携带参数跳转详情页面，当前只为参考 -->
				<uni-list-item :border="true" class="uni-list-item--waterfall" title="自定义商品列表" v-for="item in listData" :key="item">
					<!-- 通过header插槽定义列表左侧图片 -->
					<template v-slot:header>
						<view class="uni-thumb shop-picture">
							<image src="http://rbphewwot.hd-bkt.clouddn.com/jiyi%2Fhospital1.png" mode="aspectFill"></image>
						</view>
					</template>
					<!-- 通过body插槽定义商品布局 -->
					<view slot="body" class="shop">
						<view>
							<view class="uni-title">
								<text class="uni-ellipsis-2">同济大学附属医院</text>
							</view>
							<view>
								<text class="uni-tag hot-tag">三甲医院</text>
								<!-- <text v-for="tag in item.tag" :key="tag" class="uni-tag">tag</text> -->
							</view>
						</view>
						<view>
							<view class="shop-price">
								<text>¥</text>
								<text class="shop-price-text">价格</text>
								<text>.00</text>
							</view>
							<!-- <view class="uni-note">{{ item.comment_count }}条评论 月销量 {{ item.month_sell_count }}</view> -->
							<view class="uni-note ellipsis">
								<text class="uni-ellipsis-1">测试</text>
								<text class="uni-link">详情 ></text>
							</view>
						</view>
					</view>
				</uni-list-item>
			</uni-list>
		</view>
	</view>
</template>

<script>
	export default {
		components: {},
		data() {
			return {
				listData:[1,2,3,4,5,6,7]
			};
		}
		
	};
</script>

<style lang="scss">
	@import '@/common/uni-ui.scss';
	.status_bar {
		height: var(--status-bar-height);
		width: 100%;
	    background-color: $hospital-color;
	}
	page {
		display: flex;
		flex-direction: column;
		box-sizing: border-box;
		background-color: #efeff4;
		min-height: 100%;
		height: auto;
	}

	.tips {
		color: #67c23a;
		font-size: 14px;
		line-height: 40px;
		text-align: center;
		background-color: #f0f9eb;
		height: 0;
		opacity: 0;
		transform: translateY(-100%);
		transition: all 0.3s;
	}

	.tips-ani {
		transform: translateY(0);
		height: 40px;
		opacity: 1;
	}

	.shop {
		flex: 1;
		display: flex;
		flex-direction: column;
		justify-content: space-between;
	}

	.shop-picture {
		width: 110px;
		height: 110px;
	}

	.shop-picture-column {
		width: 100%;
		height: 170px;
		margin-bottom: 10px;
	}

	.shop-price {
		margin-top: 5px;
		font-size: 12px;
		color: #ff5a5f;
	}

	.shop-price-text {
		font-size: 16px;
	}

	.hot-tag {
		background: #ff5a5f;
		border: none;
		color: #fff;
	}

	.button-box {
		height: 30px;
		line-height: 30px;
		font-size: 12px;
		background: #007AFF;
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


	// 默认加入 scoped ，所以外面加一层提升权重
	.list {
		.uni-list--waterfall {

			/* #ifndef H5 || APP-VUE */
			// 小程序 编译后会多一层标签，而其他平台没有，所以需要特殊处理一下
			/deep/ .uni-list {
				/* #endif */
				display: flex;
				flex-direction: row;
				flex-wrap: wrap;
				padding: 5px;
				box-sizing: border-box;

				/* #ifdef H5 || APP-VUE */
				// h5 和 app-vue 使用深度选择器，因为默认使用了 scoped ，所以样式会无法穿透
				/deep/
				/* #endif */
				.uni-list-item--waterfall {
					width: 50%;
					box-sizing: border-box;

					.uni-list-item__container {
						padding: 5px;
						flex-direction: column;
					}
				}

				/* #ifndef H5 || APP-VUE */
			}

			/* #endif */
		}
	}
</style>
