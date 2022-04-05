<template>
  <section class="vh-110">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6 text-black">
        
        <div class="px-5 ms-xl-4">
          <span class="h1 fw-bold mb-0">Today News Talk</span>
        </div>

        <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 pt-5 pt-xl-0 mt-xl-n5">
            <router-view></router-view>
        </div>

      </div>
      <div class="col-sm-6 px-0 d-none d-sm-block">
        <img src="@/assets/news.jpg"
          alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
      </div>
    </div>
  </div>
</section>
</template>

<script>

export default {
name: "UserPage",
    components:{
       
    }
}
</script>

<style>
@media (min-width: 1025px) {
.h-custom-2 {
height: 100%;
}
}
</style>