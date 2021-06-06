export const request=(params)=>{
  const baseUrl = "http://localhost:8082"
  // const baseUrl = "https://h.mousenat.cn"
   return new Promise((resolve,reject)=>{
     wx.request({ 
      ...params,
      url:baseUrl+params.url,
      success:(result)=>{ 
        resolve(result)
      }, 
      fail:(err)=>{
        reject(err)
      }
     })
   })
}