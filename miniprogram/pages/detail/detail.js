// pages/detail/detail.js
import {request} from '../../request/index'
const app =getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    username:"",
    isCollect:false,
    src:'../../images/collect.png',
    collectSrc:'../../images/collect.png',
    collectSrc1:'../../images/_collect.png',
    isShow:true,
    info_id:0,
    info_username:"",
    info_title:"",
    info_content:"",
    info_price:"",
    info_phone:"",
    info_price:"",
    info_datestart:"",
    info_dateend:"",
    cates_name:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.info_title)
    this.setData({
    info_id:parseInt(options.info_id),
    info_username:options.username,
    info_title:options.info_title,
    info_content:options.info_content,
    info_phone:options.info_phone,
    info_price:options.info_price,
    info_datestart:options.info_datestart,
    info_dateend:options.info_dateend,
    cates_name:options.cates_name
    })
  },
  onShow:function(){
    var that = this
    this.setData({
      // username:"gdutpeople"
    username:app.globalData.username
    })
    if(this.data.username=="微信用户")
    {
      console.log("用户没登录！")

    }else{
    //查找是否有该用户收藏过此信息的记录，有则将图标改为蓝色，避免多次收藏同一信息
    request({
         url:'/collect/iscollect',
         method:"POST",
         data:{
           username:this.data.username,
           info_id:this.data.info_id
      },
         header:{
            "Content-Type":'application/x-www-form-urlencoded'
          }    
         })  
          .then(res=>{ 
           console.log(res.data)
            if(res.data.success == true){
              that.setData({
            src:that.data.collectSrc1
         })
    } 
         })
    }
  },
    
  collectInfo:function(res){
    if(this.data.username=="微信用户"){
      wx.showToast({
        title: '请先登录!',
        duration:1000,
        icon: 'error'
      })
    }
    else{
    let src;
    //若未收藏
  if(res.currentTarget.dataset.msg==this.data.collectSrc){
   src=this.data.collectSrc1
   request({
     url:'/collect/insert',
     method:"POST",
     data:{
       username:this.data.username,
       info_id:this.data.info_id
  },
     header:{
        "Content-Type":'application/x-www-form-urlencoded'
      }    
     })  
      .then(res=>{ 
       wx.showToast({
          title: '收藏成功！！',
          duration:1000,
          icon: 'success'
        })
      })

 }
   else{
      //  若已收藏
       src=this.data.collectSrc
       request({
          url:'/collect/delete',
          method:"POST",
          data:{
            username:this.data.info_username,
            info_id:this.data.info_id
          },
          header:{
           "Content-Type":'application/x-www-form-urlencoded'
          }
   })  
      .then(res=>{ 
        wx.showToast({
          title: '取消收藏成功！！',
          duration:1000,
          icon: 'success'
        })
      })
 }
         this.setData({
             src:src
         })
  }
}
  
})