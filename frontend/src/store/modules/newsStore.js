import axios from "axios";

export const newsStore={
    namespaced : true,
    state:()=>({
        select : "",
        text : "",
        selectAndText : [],
        politicsNewsList:[],
        lifeNewsList:[],
        economyNewsList:[],
        itNewsList:[],
        socialNewsList:[],
        opinionNewsList:[],
    }),
    getters:{
        GET_NEWS_LIST(state){
            return state.politicsNewsList;
        },
    },
    mutations:{
          setSearchSelect(state, select){
              state.select=select;
          },
          setSearchText(state, text){
              state.text=text;
              state.selectAndText={
                  select: state.select,
                  text : state.text,
            }
          },
          setNewsList(state,newsList){
            
            if(newsList.category=="정치")
                state.politicsNewsList=newsList.content;
            else if(newsList.category=="경제")
                state.economyNewsList=newsList.content;
            else if(newsList.category=="사회")
                state.socialNewsList=newsList.content;
            else if(newsList.category=="IT")
                state.itNewsList=newsList.content;
            else if(newsList.category=="생활")
                state.lifeNewsList=newsList.content;
            else
                state.opinionNewsList=newsList.content;
            //console.log(state.politicsNewsList);
          }
    },
    actions:{
        getCategoryNews({commit}, params){
            axios
            .get(process.env.VUE_APP_API_URL+"/news/find/category",{params:params})
            .then((response)=>{
                commit("setNewsList",{content : response.data.content,category:params.category})
                //console.log(response.data.content,params.category)
            })
        }
    },
}