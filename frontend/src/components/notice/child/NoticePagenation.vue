<template>
	<div class="overflow-auto mt-3">
    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      first-number
			last-number
    ></b-pagination>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
	data() {
		return {
			rows : this.length,
			currentPage : 1,
			perPage : 7,
		}
	},
	props: {
		length : {type: Number},
	},
	computed: {
		...mapGetters(["notices"]),
	}
}
</script>

<style>

</style>