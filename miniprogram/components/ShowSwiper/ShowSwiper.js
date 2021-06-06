// components/ShowSwiper/ShowSwiper.js
import {request} from '../../request/index'
Component({
  /**
   * 组件的属性列表
   */
  properties: {

  },

  /**
   * 组件的初始数据
   */
  data: { 
    swiperList:[],

  },

  /**
   * 组件的方法列表
   */
  methods: {
   
  },
  attached(){
    request({url:'/swiper/url'})  
      .then(result=>{ 
        this.setData({
                swiperList:result.data
              })  
      })
}
})
