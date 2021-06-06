// pages/mycollect/mycollect.js
import {request} from '../../request/index'
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    username:app.globalData.username,
    collectList:[],
    record:false

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  onPageNotFound(res){
    wx.navigateTo({
      url: '/pages/mycollect/mycollect',
    })
  },
  onShow:function(){
    this.setData({
      username:app.globalData.username,
    })
    var that = this 
    request({
    url:'/collect/getbyusername',
      data:{username:this.data.username},
    method:'POST',
    header:{
      "Content-Type":'application/x-www-form-urlencoded'
    },
    })  
    .then(res=>{ 
      console.log(res.data)
      if(res.data.length==0){
        console.log(res.data)
        that.setData({
          record:true
        })
      }
      else{
        // this.success属于闭包，不可以使用this，因为指代本身
        that.setData({
          collectList:res.data
        })
      }
    })
  
  },
  isDelete:function(e){
    var that = this
    let info_id = parseInt(e.currentTarget.dataset.name)
    console.log(info_id)
    wx.showModal({
      title: '提示',
      content: '确认是否要取消收藏此信息？',
      success (res) {
      if (res.confirm) {
        request({
          url:'/collect/delete',
          data:{
            username:that.data.username,
            info_id:info_id
          },
        method:'POST', 
        header:{
          "Content-Type":'application/x-www-form-urlencoded'
        },
        })  
        .then(res=>{ 
          console.log(res.data)
            wx.showToast({
              title: '取消收藏成功！',
              duration:1000,
              icon: 'success',
              success:function(){
                setTimeout(function(){
                  wx.redirectTo({
                    url: '/pages/mycollect/mycollect',
                  })
                },1000)
              }
            })
        })
        
      
      
      }

  }

})
}
})