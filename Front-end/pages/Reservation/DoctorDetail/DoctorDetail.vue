<template>
	<u-avatar :src="src1" shape="circle"></u-avatar>
</template>

<script>
	export default {
		data() {
			return {
				src1: 'https://cdn.uviewui.com/uview/album/1.jpg',
				src2: 'https://cdn.uviewui.com/uview/album/2.jpg',
				src3: 'https://cdn.uviewui.com/uview/album/3.jpg',
				src4: 'https://cdn.uviewui.com/uview/album/4.jpg',
				src5: 'https://cdn.uviewui.com/uview/album/5.jpg',
				src6: 'https://cdn.uviewui.com/uview/album/6.jpg',
				src7: 'https://cdn.uviewui.com/uview/album/noExist.jpg',
				urls: [
					'https://cdn.uviewui.com/uview/album/1.jpg',
					'https://cdn.uviewui.com/uview/album/2.jpg',
					'https://cdn.uviewui.com/uview/album/3.jpg',
					'https://cdn.uviewui.com/uview/album/4.jpg',
					'https://cdn.uviewui.com/uview/album/7.jpg',
					'https://cdn.uviewui.com/uview/album/6.jpg',
					'https://cdn.uviewui.com/uview/album/5.jpg'
				]
			}
		},
		onLoad() {

		},
		methods: {
			click(name) {
				console.log('click', name);
			}
		},
	}
</script>

<style lang="scss">
	.u-demo-block__content {
		@include flex;
		align-items: center;
	}

	.u-avatar-item {
		margin-right: 30px;
	}
</style>
