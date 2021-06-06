// pages/feedback/feedback.js
import {request} from '../../request/index'
var app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    username:app.globalData.username,
    feedbackList:[],
    index:0,
    tabs: [
    {
      text: "反馈",
      iconPath: "../../images/feedback.png",
      selectedIconPath: "../../images/_feedback.png",
      isActive:true
    },
    {
      text: "我的",
      iconPath: "/images/myfeedback.png",
      selectedIconPath: "/images/_myfeedback.png",
      isActive:false
    }]
  },
  tabChange(e) {
    // console.log('tab change', e)
    this.setData({
      index: e.detail.index
    })
  },
  onLoad: function (options) {

  },
  onShow:function(){
    var that = this
    this.setData({
      username:app.globalData.username,
    })
    request({
      url:'/feedback/select',
      data:{
      username:this.data.username,
    },
      method:'POST',
      header:{
        "Content-Type":'application/x-www-form-urlencoded'
      },
      })  
      .then(res=>{
        console.log(res.data) 
       that.setData({
         feedbackList:res.data 
       })
      })
  },
  fromSubmit:function(e){
    var feedback_content = e.detail.value.feedback_content;
    request({
      url:'/feedback/insert',
      data:{
      username:this.data.username,
      feedback_content:feedback_content
    },
      method:'POST',
      header:{
        "Content-Type":'application/x-www-form-urlencoded'
      },
      })  
      .then(res=>{ 
        console.log(res.data)
        wx.showToast({
          title: '成功反馈，感谢！',
          duration:1000,
          success:function(){
            setTimeout(()=>
              wx.redirectTo({
                url: '/pages/feedback/feedback',
              })
            ,1000)
          }
        })
      })
  },
  contentChange(e){
    const index = e.detail.index;
    console.log(e)
    let tabs =this.data.tabs;
    tabs.forEach((v,i)=>i===index?v.isActive=true:v.isActive=false)
    this.setData({
      tabs
    })

  },
  getFeedback:function(){
    var that = this
    request({
      url:'/feedback/select',
      data:{
      username:this.data.username,
    },
      method:'POST',
      header:{
        "Content-Type":'application/x-www-form-urlencoded'
      },
      })  
      .then(res=>{
        console.log(res.data) 
       that.setData({
         feedbackList:res.data 
       })
      })
  }
  
})