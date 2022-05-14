
var isReady=false;var onReadyCallbacks=[];
var isServiceReady=false;var onServiceReadyCallbacks=[];
var __uniConfig = {"pages":["pages/Initial/init/init","pages/Initial/loading/loading","pages/Initial/login/login","pages/Initial/register/register","pages/Tabbar/Home/Home","pages/DrugStore/Homepage/Homepage","pages/DrugStore/ShoppingCart/ShoppingCart","pages/DrugStore/HistoryOrder/HistoryOrder","pages/Covid/covid-19/covid-19","pages/Tabbar/HospitalList/HospitalList","pages/Tabbar/My/My","pages/Tabbar/AI/AI","pages/Reservation/HospitalList/HospitalList","pages/DrugStore/News/News","pages/DrugStore/Contact/Contact","pages/Reservation/HospitalDetail/HospitalDetail","pages/DrugStore/GoodDetail/GoodDetail","pages/Personal/PersonalInfo/PersonalInfo","pages/Personal/FeedBack/FeedBack","pages/DrugStore/CreateOrder/CreateOrder","pages/Reservation/HistoryDiagnose/HistoryDiagnose","pages/Reservation/HistoryReservation/HistoryReservation","pages/Reservation/ReservationDetail/ReservationDetail","pages/Reservation/ReservationConfirm/ReservationConfirm","pages/DrugStore/Payment/Payment","pages/Personal/IDConfirm/IDConfirm"],"window":{"navigationStyle":"custom","navigationBarTextStyle":"black","navigationBarTitleText":"uni-app","navigationBarBackgroundColor":"#F8F8F8","backgroundColor":"#F8F8F8"},"tabBar":{"list":[{"pagePath":"pages/Tabbar/Home/Home","text":"首页","iconPath":"static/tabbar/homepage.png","selectedIconPath":"static/tabbar/homepage-active.png"},{"pagePath":"pages/Tabbar/HospitalList/HospitalList","text":"医院","iconPath":"static/tabbar/hospital.png","selectedIconPath":"static/tabbar/hospital-active.png"},{"pagePath":"pages/Tabbar/AI/AI","text":"智能问诊","iconPath":"./static/tabbar/doctor-active.png","selectedIconPath":"static/tabbar/doctor.png"},{"pagePath":"pages/Tabbar/My/My","text":"我的","iconPath":"static/tabbar/me.png","selectedIconPath":"static/tabbar/me-active.png"}]},"nvueCompiler":"uni-app","nvueStyleCompiler":"uni-app","renderer":"auto","splashscreen":{"alwaysShowBeforeRender":true,"autoclose":false},"appname":"Jiyi","compilerVersion":"3.4.7","entryPagePath":"pages/Initial/init/init","networkTimeout":{"request":60000,"connectSocket":60000,"uploadFile":60000,"downloadFile":60000}};
var __uniRoutes = [{"path":"/pages/Initial/init/init","meta":{"isQuit":true},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/Initial/loading/loading","meta":{},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/Initial/login/login","meta":{},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/Initial/register/register","meta":{},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/Tabbar/Home/Home","meta":{"isQuit":true,"isTabBar":true},"window":{"navigationBarTitleText":"uni-app"}},{"path":"/pages/DrugStore/Homepage/Homepage","meta":{},"window":{"navigationStyle":"default","navigationBarTitleText":"购药商城","enablePullDownRefresh":false,"navigationBarBackgroundColor":"#b50e03","navigationBarTextStyle":"white"}},{"path":"/pages/DrugStore/ShoppingCart/ShoppingCart","meta":{},"window":{"navigationBarTitleText":"购物车","enablePullDownRefresh":false,"navigationStyle":"default","navigationBarBackgroundColor":"#b50e03","navigationBarTextStyle":"white"}},{"path":"/pages/DrugStore/HistoryOrder/HistoryOrder","meta":{},"window":{"enablePullDownRefresh":false,"navigationStyle":"default","navigationBarTitleText":"历史订单","navigationBarBackgroundColor":"#b50e03","navigationBarTextStyle":"white"}},{"path":"/pages/Covid/covid-19/covid-19","meta":{},"window":{"navigationStyle":"default","navigationBarTitleText":"疫情实时","enablePullDownRefresh":false,"navigationBarBackgroundColor":"#1058D1","navigationBarTextStyle":"white"}},{"path":"/pages/Tabbar/HospitalList/HospitalList","meta":{"isQuit":true,"isTabBar":true},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/Tabbar/My/My","meta":{"isQuit":true,"isTabBar":true},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/Tabbar/AI/AI","meta":{"isQuit":true,"isTabBar":true},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/Reservation/HospitalList/HospitalList","meta":{},"window":{"navigationStyle":"default","navigationBarTitleText":"预约挂号","enablePullDownRefresh":false,"navigationBarBackgroundColor":"#1058D1","navigationBarTextStyle":"white"}},{"path":"/pages/DrugStore/News/News","meta":{},"window":{"navigationBarTitleText":"热点资讯","enablePullDownRefresh":false,"navigationStyle":"default","navigationBarBackgroundColor":"#b50e03","navigationBarTextStyle":"white"}},{"path":"/pages/DrugStore/Contact/Contact","meta":{},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/Reservation/HospitalDetail/HospitalDetail","meta":{},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/DrugStore/GoodDetail/GoodDetail","meta":{},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/Personal/PersonalInfo/PersonalInfo","meta":{},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/Personal/FeedBack/FeedBack","meta":{},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/DrugStore/CreateOrder/CreateOrder","meta":{},"window":{"enablePullDownRefresh":false,"navigationStyle":"default","navigationBarTitleText":"订单","navigationBarBackgroundColor":"#b50e03","navigationBarTextStyle":"white"}},{"path":"/pages/Reservation/HistoryDiagnose/HistoryDiagnose","meta":{},"window":{"navigationStyle":"default","navigationBarTitleText":"历史报告","enablePullDownRefresh":false,"navigationBarBackgroundColor":"#1058D1","navigationBarTextStyle":"white"}},{"path":"/pages/Reservation/HistoryReservation/HistoryReservation","meta":{},"window":{"navigationStyle":"default","navigationBarTitleText":"预约记录","enablePullDownRefresh":false,"navigationBarBackgroundColor":"#1058D1","navigationBarTextStyle":"white"}},{"path":"/pages/Reservation/ReservationDetail/ReservationDetail","meta":{},"window":{"navigationStyle":"default","navigationBarTitleText":"预约详情","enablePullDownRefresh":false,"navigationBarBackgroundColor":"#1058D1","navigationBarTextStyle":"white"}},{"path":"/pages/Reservation/ReservationConfirm/ReservationConfirm","meta":{},"window":{"navigationStyle":"default","navigationBarTitleText":"预约单详情","enablePullDownRefresh":false,"navigationBarBackgroundColor":"#1058D1","navigationBarTextStyle":"white"}},{"path":"/pages/DrugStore/Payment/Payment","meta":{},"window":{"enablePullDownRefresh":false,"navigationStyle":"default","navigationBarTitleText":"支付","navigationBarBackgroundColor":"#b50e03","navigationBarTextStyle":"white"}},{"path":"/pages/Personal/IDConfirm/IDConfirm","meta":{},"window":{"navigationStyle":"default","navigationBarTitleText":"实名认证","enablePullDownRefresh":false,"navigationBarBackgroundColor":"#1058D1","navigationBarTextStyle":"white"}}];
__uniConfig.onReady=function(callback){if(__uniConfig.ready){callback()}else{onReadyCallbacks.push(callback)}};Object.defineProperty(__uniConfig,"ready",{get:function(){return isReady},set:function(val){isReady=val;if(!isReady){return}const callbacks=onReadyCallbacks.slice(0);onReadyCallbacks.length=0;callbacks.forEach(function(callback){callback()})}});
__uniConfig.onServiceReady=function(callback){if(__uniConfig.serviceReady){callback()}else{onServiceReadyCallbacks.push(callback)}};Object.defineProperty(__uniConfig,"serviceReady",{get:function(){return isServiceReady},set:function(val){isServiceReady=val;if(!isServiceReady){return}const callbacks=onServiceReadyCallbacks.slice(0);onServiceReadyCallbacks.length=0;callbacks.forEach(function(callback){callback()})}});
service.register("uni-app-config",{create(a,b,c){if(!__uniConfig.viewport){var d=b.weex.config.env.scale,e=b.weex.config.env.deviceWidth,f=Math.ceil(e/d);Object.assign(__uniConfig,{viewport:f,defaultFontSize:Math.round(f/20)})}return{instance:{__uniConfig:__uniConfig,__uniRoutes:__uniRoutes,global:void 0,window:void 0,document:void 0,frames:void 0,self:void 0,location:void 0,navigator:void 0,localStorage:void 0,history:void 0,Caches:void 0,screen:void 0,alert:void 0,confirm:void 0,prompt:void 0,fetch:void 0,XMLHttpRequest:void 0,WebSocket:void 0,webkit:void 0,print:void 0}}}});
