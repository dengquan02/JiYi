<template>
	<view>
		<view @tap="open">
			<slot>
				<view class="result-box">
					<text class="placeHolder" v-if="!subItem[objType.nameType]">请选择</text>
					<text v-else>{{ selectedItem[objType.nameType] + ' - ' + subItem[objType.nameType] }}</text>
				</view>
			</slot>
		</view>
		<!-- 选择子类 -->
		<uni-popup ref="popup" type="bottom" :mask-click="true">
			<view class="popup-contents">
				<view class="popup-top">
					<text @tap="close">关闭</text>
				</view>
				<view class="data-contents" :style="areaStyles">
					<scroll-view class="tabs" scroll-y scroll-with-animation :scroll-into-view="getScrollPelId" >
						<view class="tabItem" v-for="item in listData" :key="item[objType.idType]" :class="{'tabItemActive': item.checked}" :id="`scrollPel_${item[objType.idType]}`" @tap="selectItem(item)">{{ item[objType.nameType] }}</view>
					</scroll-view>
					<scroll-view class="select-area" scroll-y scroll-with-animation :scroll-into-view="getScrollElId" @scroll="scroll" ref='scroll_view'>
						<view class="part" v-for="item in listData" :key="item[objType.idType]" :id="`scroll_${item[objType.idType]}`">
							<text class="partTitle">{{ item[objType.nameType] }}</text>
							<view class="part-contents">
								<text class="subItem" v-for="opt in item[objType.subType]" :key="opt.id" 
								:class="{ 'subItemActive': opt.checked }" @tap="selectSubItem(item,opt)">{{ opt[objType.nameType] }}</text>
							</view>
						</view>
						<view :style="styleHeight"></view>
					</scroll-view>
				</view>
			</view>
		</uni-popup>
	</view>
</template>

<script>
	import { throttle } from './util.js'
	export default {
		name:"uiPopupLinkage",
		props:{
			/* 选传-初始化数据，若不需要初始化，则可以不传 */
			initData:{
				type: Object,
				default(){
					return {}
				}
			},
			/* 必传-数据源 */
			propsData: {
				type: Array,
				default: []
			},
			/* 选传-定义数据格式，要求大类数据与子类数据中对应idType和nameType的keyname相同，subType为子数组名称。
				默认值：idType为"id"，nameType为"name"，"subType"为"sub"。哪个不同修改哪个，比如：
				1，若源数据中idType为"code"，则修改"idType"的值为"code"
				2，若源数据中nameType为"value"，则修改"idType"的值为"value"
				3，若源数据中subType为"child"，则修改"subType"的值为"child"
				注意：只需要修改与默认值不同的keyname即可，相同的可以不传，会自动识别为默认值，若都相同，则objType可以不传
			 */
			objType: {
				type: Object,
				default(){ 
					return {
						idType: 'id',
						nameType: 'name',
						subType: 'sub',
					}
				}
			},
			// 选传-滚动区域的高度，若不需要另外设置，可以不传
			navHeight: {
				type: Number,
				default: 300
			}
		},
		data() {
			return {
				initDataObj: {}, // 接收初始化数据
				listData: [], // 接收源数据
				
				subItem: {}, // 点击子类时保存子类信息(用来判断是否有选中过某子类，如果有选中过就一定有值，否则为空对象)
				item: {}, // 仅选择大类的时候保存（此时未选中子类），用来初始化
				selectedItem: {}, // 用来保存选中的子类信息（包括大类信息）
				
				scrollPelId: '', // 需要滚动到的大类盒子的Id 
				scrollElId: '', // 需要滚动到包含子类的part盒子的Id
				scrollRefs: [], // 收集所有滚动的盒子的ref(即每一个part板块)
				refsTopArr: [], // 生成所有滚动盒子顶部里滚动上边界的距离（height）
				restHeight: '', // 滚动内容最底下填补高度，仅用来占位
			};
		},
		watch:{
			'objType': {
				immediate: true,
				handler(val){
					this.objType.idType = val.idType || 'id'
					this.objType.nameType = val.nameType || 'name'
					this.objType.subType = val.subType || 'sub'
				}
			},
			'initData': {
				immediate: true,
				handler(val){
					console.log('init data changed', val)
					this.initDataObj = val
				}
			},
			'propsData': {
				immediate: true,
				handler(val){
					// console.log('props data changed', val)
					this.listData = val
					this.scrollRefs = val.map(item=>{return 'scroll_'+item[this.objType.idType]})
					// console.log( this.initDataObj )
					if( this.initDataObj.hasOwnProperty('item')&&this.initDataObj.item[this.objType.idType] ) this.initSelect(this.initDataObj)
				}
			}
		},
		methods:{
			/* 弹框打开是，初始化选择项，通过与初始数据的对应的id来比较，如果相同则为初始选中项 */
			initSelect(val){
				this.listData.map(item=>{
					item.checked = item[this.objType.idType].toString() === val?.item?.[this.objType.idType].toString()
					if( item.checked ){
						this.item = this.selectedItem = item
						item[this.objType.subType].map(opt=>{
							opt.checked = opt[this.objType.idType].toString() === val?.subItem?.[this.objType.idType].toString()
							if(opt.checked) this.subItem = opt
						})
					}
				})
			},
			/* 选择大类中的某一项 */
			selectItem(item){
				/* 先清空之前的选中状态，然后再重新赋值选中 */
				this.listData.map(mapItem=>{
					mapItem.checked = false
				})
				item.checked = true
				this.item = item
				this.scrollElId = `scroll_${item[this.objType.idType]}`
			},
			/* 选择子数组中某一项 */
			selectSubItem(item, opt){
				/* 先清空之前的选中状态，然后再重新赋值选中 */
				this.listData.map(mapItem=>{
					mapItem.checked = false
					mapItem[this.objType.subType].map(mapOpt=>{
						mapOpt.checked = false
					})
				})
				opt.checked = !opt.checked
				item.checked = opt.checked
				
				this.scrollPelId = `scrollPel_${item[this.objType.idType]}`
				this.selectedItem = item
				this.subItem = opt
				this.listData = JSON.parse(JSON.stringify(this.listData))
				this.close()
			},
			
			open() {
				if( this.listData.length===0 ) return console.log('waiting data')
				this.$refs.popup.open()
				/* 注意，打开后的一系列初始化操作，必须放在nextTick函数中，否则本次打开不会执行 */
				this.$nextTick(()=>{
					// 如果有选中过子类，则自动滚动至对应的大类信息，否则就默认在首位
					if( this.subItem?.[this.objType.idType] && this.item?.[this.objType.idType] ){
						this.scrollElId = `scroll_${this.selectedItem[this.objType.idType]}`
					}else{
						this.selectItem(this.listData[0])
					}
					
					// 获取每一个part的top值，等于该part上面所有的part的高度的总和
					this.refsTopArr = [0]
					this.scrollRefs.map((item,index)=>{
						let view = uni.createSelectorQuery().in(this).select(`#${item}`);
						view.fields({size: true}, data => {
						  this.refsTopArr.push( this.refsTopArr[index]+data.height)
						}).exec()
					})
					
					const pElId = this.listData.filter(item=>item.checked===true)[0]?.[this.objType.idType]
					// console.log( 'pElId', pElId )
					this.scrollPelId = `scrollPel_${pElId}`
				})
			},
			close() {
				this.$refs.popup.close()
				// 如果有子类被选中了，则用选中子类信息来赋值，否则就只能是大类信息了
				this.item = this.subItem?.[this.objType.idType] ? this.selectedItem : this.item
				this.scrollElId = ''

				/* 定义返回值，通过result方法emit给父组件 */
				const result = {item:{},subItem:{}}
				result.item[ this.objType.idType ] = this.selectedItem?.[this.objType.idType]
				result.item[ this.objType.nameType ] = this.selectedItem?.[this.objType.nameType]
				result.subItem[ this.objType.idType ] = this.subItem?.[this.objType.idType]
				result.subItem[ this.objType.nameType ] = this.subItem?.[this.objType.nameType]
				
				this.$emit('result', result)
			},
			/* 滚动时实现双联动，已设置节流操作 */
			scroll: throttle(function(e){
				for( let i=0; i<this.refsTopArr.length; ++i ){
					if( e.detail.scrollTop>=this.refsTopArr[i]-40 && e.detail.scrollTop<this.refsTopArr[i+1]){
						if( !this.listData[i].checked ){
							this.listData.map(mapItem=>{
								mapItem.checked = false
							})
							this.listData[i].checked = true
							this.scrollPelId = `scrollPel_${this.listData[i][this.objType.idType]}`
							this.listData = JSON.parse(JSON.stringify(this.listData))
						}
					}
				}
				this.scrollElId = ''
			}, 100)
		},
		computed:{
			/* 大类item的滚动id */
			getScrollPelId() {
				return this.scrollPelId
			},
			/* 子类part的滚动id */
			getScrollElId() {
				return this.scrollElId
			},
			/* 滚动区域的高度 */
			areaStyles(){
				return  `height: ${this.navHeight}px`
			},
			/* 占位盒子的高度 */
			styleHeight(){
				// 计算出最后一个part的高度，与整个展示区做对比，如果大于展示区高度，则不需要填充高度，否则填充剩下的高度
				// 填充高度是为了让最后一个part能够置顶
				const lastHeight = this.refsTopArr[this.refsTopArr.length-1] - this.refsTopArr[this.refsTopArr.length-2]
				if( lastHeight > this.navHeight ) return `height: 0px`
				return `height: ${this.navHeight - lastHeight}px`
			}
		}
	}
</script>

<style lang="scss" scoped>
	.result-box{
		display: block;
		width: 100vw;
		height: 30px;
		line-height: 30px;
		text-align: center;
		background-color: #eeeeee;
		.placeHolder{
			color: gray;
		}
	}
	
	.popup-top{
		padding: 0 20px;
		display: flex;
		flex-direction: row;
		justify-content: flex-end;
	}
	
	.popup-contents {
		padding: 20px 0;
		border-radius: 12px 12px 0 0;
		background-color: white;
		.data-contents{
			height: 300px;
			margin-top: 10px;
			display: flex;
			justify-content: space-between;
		}
		
	}
	
	.tabs{
		height: 100%;
		max-width: fit-content;
		.tabItem{
			padding: 2px 20px;
			margin-left: 0;
			margin-bottom: 20px;
			border-left: 2px solid white;
		}
		.tabItemActive{
			border-left: 2px solid blue;
			color: blue;
		}
		
		// #ifdef H5
		/deep/ &>.uni-scroll-view{
			overflow: hidden;
		}
		/deep/ &>.uni-scroll-view>.uni-scroll-view{
			padding-right: 16px;
		}
		// #endif
	}
	
	.select-area{
		height: 100%;
		overflow: auto;
		border-left: 1px solid lightgray;
		.part{
			padding: 0 5px;
			display: flex;
			flex-direction: column;
			padding-bottom: 40px;
			.partTitle{
				margin-left: 15px;
				font-weight: bolder;
			}
			.part-contents{
				display: flex;
				flex-flow: row wrap;
				.subItem {
					margin: 15px 0 0 15px;
					padding: 5px 12px;
					background-color: lightgray;
					border-radius: 6px;
				}
				.subItemActive {
					color: blue;
					background-color: #E7F3FF;
				}
			}
		}

		// #ifdef H5
		/deep/ &>.uni-scroll-view{
			overflow: hidden;
		}
		/deep/ &>.uni-scroll-view>.uni-scroll-view{
			padding-right: 16px;
		}
		// #endif
	}
</style>
