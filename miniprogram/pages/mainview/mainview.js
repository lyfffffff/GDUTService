//引入用来发送请求的方法,把路径补全
import {request} from '../../request/index'
const app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    //轮播图数组
    navigationList:[]
  },
  /**
   * 生命周期函数--监听页面加载
   */ 
  //页面开始加载会触发的事件
  onLoad: function (options) {
    //1，获取首页楼层异步请求
    //调用楼层数据
      this.getNavigationList()
  },
  //获取首页楼层数据
  getNavigationList(){
    request({url:'/navigation/url'})  
      .then(result=>{ 
        this.setData({
                navigationList:result.data
              })
      })
  },
  toCommunity:function(e){
    app.globalData.cates_name = e.currentTarget.dataset.item
    // wx.switchTab({
    //   url: '/pages/community/community'
    // })
  }
})