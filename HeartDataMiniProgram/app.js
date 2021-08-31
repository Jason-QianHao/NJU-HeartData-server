// app.js
App({
  onLaunch() {
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
    })
  },
  globalData: {
    userInfo: null,
    //openid: "", // 之前用作测试，后面openid不传到小程序端
    pepoleid: "",
    filepath: "",
    domain: "http://3a40r96515.zicp.vip"
  }
})
