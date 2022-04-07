<template>
	<b-tr>
		<!-- <b-td>{{ cnt }}</b-td> -->
		<b-td class="text-left">
			<span class="thumb-info" data-bs-toggle="modal" :data-bs-target="'#newsModal'+category+index">{{ title }}</span>
		</b-td>
		<b-td>{{ company }}</b-td>
		<!-- <b-td>{{ changeDateFormat }}</b-td> -->
		<!-- Modal -->
		<div class="modal fade" :id="'newsModal'+category+index" tabindex="-1" aria-labelledby="newsModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg modal-dialog-scrollable">
				<div class="modal-content">
					<div class="modal-header">
					<h5 class="modal-title" id="newsModalLabel">{{ title }}</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
							<div class="d-flex" sytle="padding: 0 0">								
							<img class="modal-image mx-auto" :src="tumbnailUrl" alt="tumbnail" style="width: 100%; height: 100%;">
							</div>
							<div>{{	content	}}</div>
							<div style="text-align:right; padding-left: 1em; padding-top: 1em">{{	reporter }}</div>
							<div style="text-align:right; padding-left: 1em; padding-top:1em">{{	company	}}</div>
					</div>
					<div class="modal-footer">
							<span>기사 원문 : </span><a :href="url">{{ url }}</a>
					</div>
				</div>
			</div>
    </div>
	</b-tr>
</template>

<script>
// import moment from "moment";
import dayjs from "dayjs";

export default {
	component: {
		dayjs,
	},
	data() {
		return {
			
		};
	},
	props: {
		index: Number,
		category: String,
		company: String,
		date: String,
		url: String,
		reporter: String,
		title: String,
		tumbnailUrl: String,
		content: String,
	},
	computed: {
		// changeDateFormat() {
		// 	// return moment(new Date(this.date)).format("YY.MM.DD");
		// 	return dayjs(this.date).format("YYYY.MM.DD");
		// },
	},
	
}
</script>

<style>
.title, .title:hover {
  text-decoration: none;
  color: black
}
.modal-image {
    width: 90%;
    height : 30%;
    padding-left: 20px;
    margin-bottom: 10px;
}
</style>