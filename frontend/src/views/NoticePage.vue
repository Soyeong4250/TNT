<template>
	<div class = "notice">
		<b-container>
			<h1>공지사항</h1>
			<div class="box">
				<router-view></router-view>
			</div>
		</b-container>
	</div>
</template>

<script>

export default {

}
</script>

<style>

img {
	width: 5%;
	height: 5%;
}

.box {
	border-top: 0.1em solid #0f4c82;
	margin-top: 2em;
}

</style>