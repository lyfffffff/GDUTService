// pages/mypublish/mypublish.js
import {request} from '../../request/index'
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    username:app.globalData.username,
    userList:[],
    record:false
  },
  onShow:function(){
    this.setData({ 
      username:app.globalData.username,
    })
    var that = this 
    request({
      url:'/information/getbyusername',
      data:{username:this.data.username},
    method:'POST',
    header:{
      "Content-Type":'application/x-www-form-urlencoded'
    },
    })  
    .then(res=>{ 
      console.log(res.data)
      if(res.data.length==0){
        that.setData({
          record:true
        })
      }
      else{
      // this.success属于闭包，不可以使用this，因为指代本身
      that.setData({
        userList:res.data
      })
    }
    })
  },
  isUpdate:function(){
    // wx.navigateTo({
    //   url: '/pages/update/update?info_id={{item.info_id}}&username={{item.username}}&info_title={{item.info_title}}&info_content={{item.info_content}}&info_phone={{item.info_phone}}&info_price={{item.info_price}}&info_datestart={{item.info_datestart}}&info_dateend={{item.info_dateend}}&cates_name={{item.cates_name}}'
    // })
  },
 isDelete:function(e){
  let info_id = parseInt(e.currentTarget.dataset.name)
   wx.showModal({
    title: '提示',
    content: '确认是否要删除此信息？',
    success (res) {
    if (res.confirm) {
      console.log(info_id)
      request({
        url:'/information/delete',
        data:{info_id:info_id},
      method:'POST',
      header:{
        "Content-Type":'application/x-www-form-urlencoded'
      },
      })  
      .then(res=>{ 
        console.log(res.data)
        wx.showToast({
          title: '删除发布成功！',
          duration:1000,
          icon: 'none',
          success:function(){
            wx.redirectTo({
              url: '/pages/mypublish/mypublish',
            })
              }
        })
      })
    }
  }
   
})
   }
  
})