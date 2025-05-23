import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import ExamPaper from '../pages/exam/examPaper'
import Exam from '../pages/exam/exam'
import ExamList from '../pages/exam/examList'
import ExamRecord from '../pages/exam/examRecord'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import xueyuanList from '../pages/xueyuan/list'
import xueyuanDetail from '../pages/xueyuan/detail'
import xueyuanAdd from '../pages/xueyuan/add'
import jiaxiaojiaolianList from '../pages/jiaxiaojiaolian/list'
import jiaxiaojiaolianDetail from '../pages/jiaxiaojiaolian/detail'
import jiaxiaojiaolianAdd from '../pages/jiaxiaojiaolian/add'
import jiaxiaocheliangList from '../pages/jiaxiaocheliang/list'
import jiaxiaocheliangDetail from '../pages/jiaxiaocheliang/detail'
import jiaxiaocheliangAdd from '../pages/jiaxiaocheliang/add'
import yuyuexinxiList from '../pages/yuyuexinxi/yuyuexinxiList'
import yuyuexinxiDetail from '../pages/yuyuexinxi/detail'
import yuyuexinxiAdd from '../pages/yuyuexinxi/add'
import quxiaoyuyueList from '../pages/quxiaoyuyue/list'
import quxiaoyuyueDetail from '../pages/quxiaoyuyue/detail'
import quxiaoyuyueAdd from '../pages/quxiaoyuyue/add'
import kaoshianpaiList from '../pages/kaoshianpai/list'
import kaoshianpaiDetail from '../pages/kaoshianpai/detail'
import kaoshianpaiAdd from '../pages/kaoshianpai/add'
import kaoshiyuyueList from '../pages/kaoshiyuyue/list'
import kaoshiyuyueDetail from '../pages/kaoshiyuyue/detail'
import kaoshiyuyueAdd from '../pages/kaoshiyuyue/add'
import quxiaokaoshiList from '../pages/quxiaokaoshi/list'
import quxiaokaoshiDetail from '../pages/quxiaokaoshi/detail'
import quxiaokaoshiAdd from '../pages/quxiaokaoshi/add'
import jiashizhishiList from '../pages/jiashizhishi/list'
import jiashizhishiDetail from '../pages/jiashizhishi/detail'
import jiashizhishiAdd from '../pages/jiashizhishi/add'
import xueyuanchengjiList from '../pages/xueyuanchengji/list'
import xueyuanchengjiDetail from '../pages/xueyuanchengji/detail'
import xueyuanchengjiAdd from '../pages/xueyuanchengji/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import kechengxinxiList from '../pages/kechengxinxi/list'
import kechengxinxiDetail from '../pages/kechengxinxi/detail'
import kechengxinxiAdd from '../pages/kechengxinxi/add'
import calendar from '../pages/calendar/rili'
import jiaofeixinxiList from '../pages/jiaofeixinxi/jiaofeixinxiList'
import jiaofeixinxiDetail from '../pages/jiaofeixinxi/detail'
import jiaofeixinxiAdd from '../pages/jiaofeixinxi/add'
import tongzhixinxiList from '../pages/tongzhixinxi/tongzhixinxiList'
import tongzhixinxiDetail from '../pages/tongzhixinxi/detail'
import tongzhixinxiAdd from '../pages/tongzhixinxi/add'
import jiaxiaoxinxiList from '../pages/jiaxiaoxinxi/list'
import jiaxiaoxinxiDetail from '../pages/jiaxiaoxinxi/detail'
import jiaxiaoxinxiAdd from '../pages/jiaxiaoxinxi/add'
import tousuxinxiList from '../pages/tousuxinxi/tousuxinxiList'
import tousuxinxiDetail from '../pages/tousuxinxi/detail'
import tousuxinxiAdd from '../pages/tousuxinxi/add'
import kechengyuyueList from '../pages/kechengyuyue/kechengyuyueList'
import kechengyuyueDetail from '../pages/kechengyuyue/detail'
import kechengyuyueAdd from '../pages/kechengyuyue/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'examPaper',
					component: ExamPaper
				},
				{
					path: 'examList',
					component:ExamList
				},
				{
					path: 'examRecord/:type',
					component:ExamRecord
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'xueyuan',
					component: xueyuanList
				},
				{
					path: 'xueyuanDetail',
					component: xueyuanDetail
				},
				{
					path: 'xueyuanAdd',
					component: xueyuanAdd
				},
				{
					path: 'jiaxiaojiaolian',
					component: jiaxiaojiaolianList
				},
				{
					path: 'jiaxiaojiaolianDetail',
					component: jiaxiaojiaolianDetail
				},
				{
					path: 'jiaxiaojiaolianAdd',
					component: jiaxiaojiaolianAdd
				},
				{
					path: 'jiaxiaocheliang',
					component: jiaxiaocheliangList
				},
				{
					path: 'jiaxiaocheliangDetail',
					component: jiaxiaocheliangDetail
				},
				{
					path: 'jiaxiaocheliangAdd',
					component: jiaxiaocheliangAdd
				},
				{
					path: 'yuyuexinxiList',
					component: yuyuexinxiList
				},
				{
					path: 'yuyuexinxiDetail',
					component: yuyuexinxiDetail
				},
				{
					path: 'yuyuexinxiAdd',
					component: yuyuexinxiAdd
				},
				{
					path: 'quxiaoyuyue',
					component: quxiaoyuyueList
				},
				{
					path: 'quxiaoyuyueDetail',
					component: quxiaoyuyueDetail
				},
				{
					path: 'quxiaoyuyueAdd',
					component: quxiaoyuyueAdd
				},
				{
					path: 'kaoshianpai',
					component: kaoshianpaiList
				},
				{
					path: 'kaoshianpaiDetail',
					component: kaoshianpaiDetail
				},
				{
					path: 'kaoshianpaiAdd',
					component: kaoshianpaiAdd
				},
				{
					path: 'kaoshiyuyue',
					component: kaoshiyuyueList
				},
				{
					path: 'kaoshiyuyueDetail',
					component: kaoshiyuyueDetail
				},
				{
					path: 'kaoshiyuyueAdd',
					component: kaoshiyuyueAdd
				},
				{
					path: 'quxiaokaoshi',
					component: quxiaokaoshiList
				},
				{
					path: 'quxiaokaoshiDetail',
					component: quxiaokaoshiDetail
				},
				{
					path: 'quxiaokaoshiAdd',
					component: quxiaokaoshiAdd
				},
				{
					path: 'jiashizhishi',
					component: jiashizhishiList
				},
				{
					path: 'jiashizhishiDetail',
					component: jiashizhishiDetail
				},
				{
					path: 'jiashizhishiAdd',
					component: jiashizhishiAdd
				},
				{
					path: 'xueyuanchengji',
					component: xueyuanchengjiList
				},
				{
					path: 'xueyuanchengjiDetail',
					component: xueyuanchengjiDetail
				},
				{
					path: 'xueyuanchengjiAdd',
					component: xueyuanchengjiAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
				{
					path: 'kechengxinxi',
					component: kechengxinxiList
				},
				{
					path: 'kechengxinxiDetail',
					component: kechengxinxiDetail
				},
				{
					path: 'kechengxinxiAdd',
					component: kechengxinxiAdd
				},
				{
					path: 'tongzhixinxiList',
					component: tongzhixinxiList
				},
				{
					path: 'tongzhixinxiDetail',
					component: tongzhixinxiDetail
				},
				{
					path: 'tongzhixinxiAdd',
					component: tongzhixinxiAdd
				},
				{
					path: 'jiaxiaoxinxi',
					component: jiaxiaoxinxiList
				},
				{
					path: 'jiaxiaoxinxiDetail',
					component: jiaxiaoxinxiDetail
				},
				{
					path: 'jiaxiaoxinxiAdd',
					component: jiaxiaoxinxiAdd
				},
				{
					path: 'jiaofeixinxiList',
					component: jiaofeixinxiList
				},
				{
					path: 'jiaofeixinxiDetail',
					component: jiaofeixinxiDetail
				},
				{
					path: 'jiaofeixinxiAdd',
					component: jiaofeixinxiAdd
				},
				{
					path: 'tousuxinxiList',
					component:tousuxinxiList
				},
				{
					path: 'tousuxinxiDetail',
					component: tousuxinxiDetail
				},
				{
					path: 'tousuxinxiAdd',
					component: tousuxinxiAdd
				},
				{
					path: 'kechengyuyueList',
					component:kechengyuyueList
				},
				{
					path: 'kechengyuyueDetail',
					component: kechengyuyueDetail
				},
				{
					path: 'kechengyuyueAdd',
					component: kechengyuyueAdd
				},
				{
					path: 'calendar',
					component: calendar
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
		{
			path: '/exam',
			component: Exam
		}
	]
})
