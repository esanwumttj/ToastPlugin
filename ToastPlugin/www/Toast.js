var exec = require('cordova/exec');
var platform = require('Cordova/platorm');
module.exports = {
    // 要在HTML中调用的js 方法
    ShowToast:function(content,length) {
    //主方说明，第三个参数为插件的类名，第四参数为 插件的方法名
    exec(null, null,"ToastPlugin","Toast",[content,length]);
};
