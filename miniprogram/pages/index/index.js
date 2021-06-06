//Page Object
const app = getApp()
Page({
  data: {
  avatarUrl:"",
  canIuse:"",
  username:"",
  toAuthor:'/pages/author/author',
  toPublish:'/pages/mypublish/mypublish',
  toCollect:'/pages/mycollect/mycollect',
  toFeedback:'/pages/feedback/feedback',
  },
  toNavi:function(){
  console.log(app.globalData.username)
  console.log(app.globalData.canIuse)
  },
  onShow:function(){
    this.setData({
      canIuse:app.globalData.canIuse,
      username:app.globalData.username,
      avatarUrl:app.globalData.avatarUrl,
    })
  },
  isAuthor:function(){
    if(this.data.username=="微信用户"){
      wx.navigateTo({
        url: '/pages/author/author',
      })
    }else{
      wx.showToast({
        title: '您已授权~',
      })
    }
  },
  toOut:function(){
    var that = this
    if(this.data.username=="微信用户"){
      wx.showModal({
      title: '提示',
      content: '您尚未登录~',
      success (res) {
        if (res.confirm) {
          console.log("你没登录啦")
        }
      }
    })
    }
    else{
    wx.showModal({
      title: '提示',
      content: '确认是否要退出？',
      success (res) {
      if (res.confirm) {
        app.globalData.canIuse=false
        app.globalData.username="微信用户"
        that.setData({
          canIuse:false,
          username:"微信用户",
        }) 
        wx.showToast({
          title: '您已安全退出',     
        })     
      }
    }
  })
}
  },
  xx:function(e){
    console.log(e)
    app.globalData.username = e.detail.userInfo.nickName;
    app.globalData.canIuse = true;
    app.globalData.avatarUrl = e.detail.userInfo.avatarUrl;
    wx.switchTab({
      url: '/pages/publish/publish',
    })
  }
});