// pages/search/search.js
import {request} from '../../request/index'
Page({
// 1,输入值绑定 只改变事件，input事件
// 2，合法判断
// 检验通过，把值发送到后台
  /**
   * 页面的初始数据
   */
  data:{
    infoList:[],
    isFocus:false,
    inputValue:""

  },
  TimeId:-1,

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
 
  onShow: function () {

  },
  handleInput(e){
    console.log(e)
    const value = e.detail.value;
    console.log(value)
    if(!value.trim()){
      this.setData({
        infoList:[],
        isFocus:false
      })
      return
    }else{
      this.setData({
        isFocus:true
      })
      clearTimeout(this.TimeId)
      this.TimeId=setTimeout(()=>{
        request({
          url:'/information/getbysearch',
          data:{
            info_content:value,
            info_title:value,
            cates_name:value 
          },
          method:'POST',
          header:{
            "Content-Type":'application/x-www-form-urlencoded'
          },
          })  
          .then(res=>{ 
            console.log(res.data)
            this.setData({
              infoList:res.data
                  })
          })
      },1000)
     

    }

  },
  handleCancel(){
    this.setData({
      inputValue:"",
      infoList:[],
      isFocus:false
    })

  }

  
  
})