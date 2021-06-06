// pages/login/login.js
import {request} from '../../request/index'
var app = getApp()
Page({
  data:{
   username:"",
   password:""
  },
formSubmit:function(e){
  var username = e.detail.value.username;
  var password = e.detail.value.password;
  request({
    url:'/user/login',
    data:{
      username:username,
      password:password
    },
  method:'POST',
  header:{
    "Content-Type":'application/x-www-form-urlencoded'
  },
  })  
  .then(res=>{ 
    if(!res.data.success){
      wx.showModal({
        title: '提示' ,
        content: '密码或用户名错误！请重试' ,
        success: function (res) {
         if (res.confirm) {
          console.log( '用户点击确定' )
         }
        }
      })
     }
     else{
       app.globalData.username = res.data.detail.username;
       app.globalData.canIuse = true;
      wx.showToast({
       title: '登录成功~',
       duration:1000,
       icon: 'success',
       success:function(){
        setTimeout(function(){
          wx.switchTab({
            url: '/pages/index/index',
         })
        },2000)
      }
     })
         }
  })

  // wx.request({
  //   url: 'http://localhost:8082/user/login',
  //   method:'POST',
  //   data:{
  //     username:username,
  //     password:password
  //   },
  //   header:{
  //     "Content-Type":'application/x-www-form-urlencoded'
  //   },
  //   success:function(res){
  //     console.log(res.data)
  //     if(!res.data.success){
  //      wx.showToast({
  //       title: '密码或用户名错误！请重试',
  //       duration:1000,
  //       icon: 'none'
  //     })
  //     }
  //     else{
  //       app.globalData.username = res.data.detail.username;
  //       app.globalData.canIuse = true;
  //      wx.showToast({
  //       title: '登录成功',
  //       duration:1000,
  //       icon: 'none'
  //     })
  //     wx.switchTab({
  //       url: '/pages/index/index',
  //          })
  //         }
  //    }
  // })
}
})