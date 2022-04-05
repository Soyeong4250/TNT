<template>
  <div>
    <div class="topNews">
      <h3>{{}}에 대한 검색결과</h3>
      <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="https://mimgnews.pstatic.net/image/origin/014/2022/04/03/4813743.jpg?type=nf264_176&ut=20220403184504" class="thumbnail d-inline w-25 m-3" alt="첫번째 뉴스">
            <div class="" style="display:inline-block;">
              <h5>First slide label</h5>
              <p>Some representative placeholder content for the first slide.</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="https://mimgnews.pstatic.net/image/origin/057/2022/04/05/1653974.jpg?type=nf264_176&ut=20220405133907" class="thumbnail d-inline w-25 m-3" alt="두번째 뉴스">
            <div class="" style="display:inline-block;">
              <h5>Second slide label</h5>
              <p>Some representative placeholder content for the first slide.</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="https://mimgnews.pstatic.net/image/origin/056/2022/04/04/11241781.jpg?type=nf264_176&ut=20220404222358" class="thumbnail d-inline w-25 m-3" alt="세번째 뉴스">
            <div class="" style="display:inline-block;">
              <h5>Third slide label</h5>
              <p>Some representative placeholder content for the first slide.</p>
            </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
          <!-- <span class="carousel-control-prev-icon" aria-hidden="true"></span> -->
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
          <!-- <span class="carousel-control-next-icon" aria-hidden="true"></span> -->
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    </div>
    <div>
      <b-row>
        <b-col v-if="this.news.length">
          <b-table-simple hover responsive outlined>
            <b-thead head-variant="light">
              <colgroup>
                <col style="width: 85%" />
                <col style="width: 15%" />
              </colgroup>
            </b-thead>
            <b-tbody>
              <notice-list-item
                v-for="(n, index) in this.news"
                :key="index"
                :cnt="`${index + 1}`"
                :title="n.title"
                :newspaper="n.newspaper"
                />
            </b-tbody>
          </b-table-simple>
        </b-col>
        <b-col v-else>
          <b-table-simple hover responsive outlined>
            <b-tbody>
              <b-td class="text-center" colspan="4" style="padding: 3em;">
                <img src="@/assets/caution.png" alt="caution.png">
                <b>등록된 뉴스가 없습니다.</b>
              </b-td>
            </b-tbody>
          </b-table-simple>
        </b-col>
      </b-row>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return{

    }
  },
  computed: {

  },
  

}
</script>

<style>
.carousel-item {
  min-height: 10em;
  /* border: 1px solid black; */
}

</style>