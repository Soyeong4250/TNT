<template>
  <!--Section: News of the day-->
<div class="news-wrap">
<div class="row gx-5">
  <div class="news-thumb col-5" data-bs-toggle="modal" :data-bs-target="'#newsModal'+category+state.thumbnailnews">
      <img class="thumb" :src="state.news.tumbnailUrl" alt="">
      <div class="thumb-info"><span>{{state.news.title}}</span></div>
        <!-- Modal -->
        <div class="modal fade" :id="'newsModal'+category+state.thumbnailnews" tabindex="-1" aria-labelledby="newsModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
            <div class="modal-content">
            <div class="modal-header">
                <p class="modal-title" id="newsModalLabel">{{state.news.title}}</p>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>{{state.news.company}}</p>
                <img class="modal-image" :src="state.news.tumbnailUrl" alt="">
                <div class="news-content">{{state.news.content}}</div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
            </div>
        </div>
        </div>
  </div>
  <div class="col-7 sub-news-group">
      <div class="subnews" :key="index" v-for="(news,index) in state.newsList">
          <div v-if="index!=state.thumbnailnews">
            <span class="thumb-info" data-bs-toggle="modal" :data-bs-target="'#newsModal'+category+index">{{news.title}}</span>
            <!-- Modal -->
                <div class="modal fade" :id="'newsModal'+category+index" tabindex="-1" aria-labelledby="newsModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                <div class="modal-content">
                <div class="modal-header">
                <span class="modal-title" id="newsModalLabel">{{news.title}}</span>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>{{news.company}}</p>
                    <img class="modal-image" :src="news.tumbnailUrl" alt="">
                    <div class="news-content">{{news.content}}</div>
                </div>
                <div class="modal-footer">
                    <span>기사 원문 : </span><a :href="news.newsUrl">{{news.newsUrl}}</a>
                </div>
                </div>
            </div>
            </div>
          </div>
      </div>
  </div>
  </div>
</div>

<!--Section: News of the day-->
</template>

<script>
import { reactive } from '@vue/reactivity'
import { computed } from '@vue/runtime-core'
import {useStore} from 'vuex'
export default {
name:"MainTab",
props:{
    category: String,
},
setup(props){
    const store=useStore();
    const state=reactive({
        newsList: computed(()=>{
            if(props.category=="정치")
                return store.state.newsStore.politicsNewsList;
            else if(props.category=="경제")
                return store.state.newsStore.economyNewsList;
            else if(props.category=="IT")
                return store.state.newsStore.itNewsList;
            else if(props.category=="사회")
                return store.state.newsStore.socialNewsList;
            else if(props.category=="생활")
                return store.state.newsStore.lifeNewsList;
            else
                return store.state.newsStore.opinionNewsList;
        }),
        thumbnailnews: 0,
        isModalViewed:false,
        news: computed(()=>{
            //console.log(state.newsList[0])
            for (let index = 0; index < state.newsList.length; index++) {
                if(state.newsList[index].tumbnailUrl=="") continue;
                else{
                    state.thumbnailnews=index;
                    break;
                }
            }
            return state.newsList[state.thumbnailnews];
        })
    })
    store.dispatch("newsStore/getCategoryNews",{
                category: props.category,
                page: 1,
            })
    
    return{
        state,
    }
}
}
</script>

<style scoped>


.news-thumb .thumb{
    display:block;
    width: 65%;
    height: 65%;
    margin-right:5%;
    margin-top: 30px;
    margin-bottom: 10px;
    border-radius: 5px;
}

.thumb-info:hover {
    text-decoration: underline;
    cursor: pointer;
}

.subnews {
    margin-bottom: 10px;
    margin-left: auto;
    margin-right: auto;
}

.modal-title{
    font-size:2em;
    font-family: 'NanumBarunGothicBold',sans-serif;
}

.modal-image {
    width: 90%;
    height : 30%;
    margin-bottom: 10px;
    padding-left: 50px;
}

.news-wrap {
    margin-left: 5%;
    margin-right: 5%;
}

.news-content {
    line-height: 200%;
    font-size : 17px;
    width : 90%;
    margin-left: auto;
    margin-right: auto;
}

.sub-news-group{
    margin-top:20px;
}
</style>