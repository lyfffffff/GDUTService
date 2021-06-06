// pages/publish/publish.js
import {request} from '../../request/index'
const app =getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    // canIuse:true,
  canIuse:app.globalData.canIuse,
   color1:"red",
   color2:"red",
   color3:"red",
   info_title:"",
   info_content:"",
   info_price:"",
   info_phone:"",
   info_datestart:"",
   info_dateend:"",
   fromList:[], 
   isphone:false,
   show:false,
   selectData:["校园跑腿","二手交易","校园兼职","告白墙","其他","信息分享","疑难解答","周边美食"],
   index:0,
   cates_name:"",
   username:app.globalData.username
  },

  /**
   * 生命周期函数--监听页面加载
   */
onLoad: function (options) {
    
  },
  onShow:function(){
    this.setData({
      canIuse:app.globalData.canIuse,
      username:app.globalData.username,
      cates_name:this.data.selectData[this.data.index]
    })
  },
  bindShowCategory:function(){
         this.setData({
           show:!this.data.show
         }) 
  },
  mySelect:function(e){
    let Index = e.currentTarget.dataset.index;
    this.setData({
      index:Index,
      show:!this.data.show,
      cates_name:this.data.selectData[Index]
    })
    console.log(this.data.cates_name)

  }, 
  bindTitleBlur:function(e){
    if(e.detail.value.length >= 2&&e.detail.value.length<=10){
      this.setData({
        color1: '#5E616D'
      })
    }
      else{
        this.setData({
          color1: 'red'
        })
      }
  },
  bindPhoneBlur:function(e){
    var value = e.detail.value
    var regs=/^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])|(18[0-9])|(19[8,9]))\d{8}$/
    if(!regs.test(value)&&!(value.trim().length == 0))
    {
    this.setData({
      color2: 'red',
      isphone:false
    })
  }
  else{
    this.setData({
      color2: '#5E616D',
      isphone:true
    })

  }
      
  },
  bindConentBulr:function(e){
    if(e.detail.value.length >= 10 && e.detail.value.length<=300){
      this.setData({
        color3: '#5E616D'
      })
    }
    else{
      this.setData({
        color3: 'red'
      })
    }
  },
  fromSubmit:function(e){
    var that = this
    console.log("from提交了！！")
  var info_title = e.detail.value.info_title;
  var info_content = e.detail.value.info_content;
  var info_phone = e.detail.value.info_phone;
  var info_price = e.detail.value.info_price;
  var info_datestart = e.detail.value.info_datestart;
  var info_dateend = e.detail.value.info_dateend;
  console.log("用户："+this.data.username+"类别："+this.data.cates_name+"标题："+info_title+"内容："+info_content+"电话"+info_phone+"价格"+info_price+"开始日期"+info_datestart+"结束日期"+info_dateend)
  request({
    url:'/information/insert',
    data:{
        cates_name:this.data.cates_name,
        username:this.data.username,
        info_title:info_title,
        info_content:info_content,
        info_phone:info_phone,
        info_price:info_price,
        info_datestart:info_datestart,
        info_dateend:info_dateend
    },
    method:'POST',
    header:{
    "Content-Type":'application/x-www-form-urlencoded'
    },
  })  
  .then(res=>{ 
    console.log(res.data)
        if(res.data.success==false){
          wx.showModal({
            title: '失败' ,
            content: res.data.msg ,
            success: function (res) {
             if (res.confirm) {
              console.log( '用户点击确定' )
             }
            } 
          })
        }
        else{  
         wx.showToast({
          title: '发布成功~',
          duration:1000,
          icon: 'success'
        })
       that.setData({
        info_title:'',
        info_content:'',
        info_phone:'',
        info_price:'',
        info_datestart:'',
        info_dateend:'',
        index:0

       })
            }
  })
  }
})