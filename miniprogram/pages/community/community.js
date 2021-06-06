// pages/search/search.js
import {request} from '../../request/index'
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    leftMenuList:[
      "校园跑腿",
      "二手交易",
      "信息分享",
      "周边美食",
      "疑难解答",
      "校园兼职",
      "告白墙",
      "其他"
    ],
    infoList:[],
    username:"微信用户",
    cates_name:app.globalData.cates_name,
    Click:-1
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onShow:function(){
    var that = this
    this.setData({
      cates_name:app.globalData.cates_name,
    })
    if(this.data.cates_name!==""){
      for(var i = 0; i<this.data.leftMenuList.length;i++){
        if(this.data.leftMenuList[i] == this.data.cates_name){
          this.setData({
            Click:i
          })
        }
      }
      request({
      url:'/information/getbycate',
      data:{cates_name:this.data.cates_name},
      method:'POST',
      header:{
        "Content-Type":'application/x-www-form-urlencoded'
      },
      })  
      .then(res=>{ 
        this.setData({
          infoList:res.data
              })
      })
      app.globalData.cates_name=""
    }
    else{
      this.setData({
        Click:0
      })
      request({
        url:'/information/getbycate',
        data:{cates_name:"校园跑腿"},
      method:'POST',
      header:{
        "Content-Type":'application/x-www-form-urlencoded'
      },
      })  
      .then(res=>{ 
        this.setData({
          infoList:res.data
              })
      })
  }
  
},
getInformationByCate:function(e){
  var index = e.currentTarget.dataset.index
  this.setData({
    Click:index
  })
  // console.log(this.data.Click)
  // console.log(e.currentTarget.id)
  var that = this
  request({
    url:'/information/getbycate',
    data:{cates_name:e.currentTarget.id},
  method:'POST',
  header:{
    "Content-Type":'application/x-www-form-urlencoded'
  },
  })  
  .then(res=>{ 
    this.setData({
      infoList:res.data
          })
  })

}


  
})