// pages/login/login.js
import {request} from '../../request/index'
Page({
  data:{
   username:"",
   password:""
  },

formSubmit:function(e){
  var formData = e.detail.value;
  request({
    url:'/user/regist',
    data:formData,
  method:'POST',
  header:{
    "Content-Type":'application/x-www-form-urlencoded'
  },
  })  
  .then(res=>{ 
    if(!res.data.success){
      wx.showModal({
        title: '提示' ,
        content: '该用户名已存在！请重试' ,
        success: function (res) {
         if (res.confirm) {
          console.log( '用户点击确定' )
         }
        }
       })
     }
     else{
      wx.showModal({
        title: '成功' ,
        content: '已注册成功，点击立即登录' ,
        success: function (res) {
         if (res.confirm) { 
            wx.navigateTo({
              url: '/pages/login/login',
            })
         }
        }
       })
     }
  })
  // wx.request({
  //   url: 'http://localhost:8082/user/regist',
  //   method:'POST',
  //   data:formData,
  //   header:{
  //     "Content-Type":'application/x-www-form-urlencoded'
  //   },
  //   success:function(res){
  //     console.log(res.data)
  //     if(!res.data.success){
  //      wx.showToast({
  //       title: '用户名已存在！请重试',
  //       duration:1000,
  //       icon: 'none'
  //     })
  //     }
  //     else{
  //     wx.showToast({
  //       title: '注册成功，去登录吧！',
  //       duration:1000,
  //       icon: 'none'
  //     })
  //      wx.navigateTo({
  //        url: '/pages/login/login',
  //      })
  //     }
  //   }
  // })

}
})