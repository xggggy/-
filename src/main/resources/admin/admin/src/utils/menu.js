const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-brand",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "学员",
                    "menuJump": "列表",
                    "tableName": "xueyuan"
                }],
                "menu": "学员管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-similar",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "驾校教练",
                    "menuJump": "列表",
                    "tableName": "jiaxiaojiaolian"
                }],
                "menu": "驾校教练管理"
            }, {"child":[{"appFrontIcon":"cuIcon-form","buttons":["新增","查看","修改","删除"],
                    "menu":"驾校信息","menuJump":"列表","tableName":"jiaxiaoxinxi"}],
                "menu":"驾校信息管理"},{
                "child": [{
                    "appFrontIcon": "cuIcon-keyboard",
                    "buttons": ["新增", "查看", "修改", "删除", "查看评论", "预约"],
                    "menu": "驾校车辆",
                    "menuJump": "列表",
                    "tableName": "jiaxiaocheliang"
                }],
                "menu": "驾校车辆管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-paint",
                    "buttons": ["查看", "修改", "删除", "审核"],
                    "menu": "预约信息",
                    "menuJump": "列表",
                    "tableName": "yuyuexinxi"
                }],
                "menu": "预约信息管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-circle",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "课程信息",
                    "menuJump": "列表",
                    "tableName": "kechengxinxi"
                }],
                "menu": "课程信息管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-circle",
                    "buttons": ["新增", "查看", "修改", "删除", "审核"],
                    "menu": "课程预约",
                    "menuJump": "列表",
                    "tableName": "kechengyuyue"
                }],
                "menu": "课程预约管理"
            },{
                "child": [{
                    "appFrontIcon": "cuIcon-time",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "考试预约",
                    "menuJump": "列表",
                    "tableName": "kaoshiyuyue"
                }],
                "menu": "考试预约管理"
            },{
                "child": [{
                    "appFrontIcon": "cuIcon-taxi",
                    "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
                    "menu": "驾驶知识",
                    "menuJump": "列表",
                    "tableName": "jiashizhishi"
                }],
                "menu": "驾驶知识管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-discover",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "学员成绩",
                    "menuJump": "列表",
                    "tableName": "xueyuanchengji"
                }],
                "menu": "学员成绩管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-copy",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "笔试考试管理",
                    "tableName": "exampaper"
                }],
                "menu": "笔试考试管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-calendar",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "考试题目管理",
                    "tableName": "examquestion"
                }],
                "menu": "考试题目管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-wenzi",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "轮播图管理",
                    "tableName": "config"
                }, {
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "驾校公告",
                    "tableName": "news"
                }],
                "menu": "系统管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-time",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "考试安排列表",
                    "menuJump": "列表",
                    "tableName": "kaoshianpai"
                }],
                "menu": "考试安排管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-baby",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "笔试考试列表",
                    "tableName": "exampaperlist"
                }, {
                    "appFrontIcon": "cuIcon-read",
                    "buttons": ["查看", "删除"],
                    "menu": "驾校考试记录",
                    "tableName": "examrecord"
                }],
                "menu": "驾校考试管理"
            },{
                "child": [{
                    "appFrontIcon": "cuIcon-baby",
                    "buttons": ["查看","删除"],
                    "menu": "缴费信息",
                    "tableName": "jiaofeixinxi"
                }],
                "menu": "缴费信息管理"
            },{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],
                    "menu":"消息通知","menuJump":"列表","tableName":"tongzhixinxi"}],
                "menu":"消息通知管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","处理"],
                    "menu":"投诉信息","menuJump":"列表","tableName":"tousuxinxi"}],
                "menu":"投诉信息管理"},{
                "child": [
                    {
                        "appFrontIcon": "cuIcon-group",
                        "buttons": [
                            "新增",
                            "查看",
                            "修改",
                            "删除"
                        ],
                        "menu": "统计图表",
                        "tableName": "statistics"
                    }
                ],
                "menu": "统计图表"
            }],"frontMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-full",
                    "buttons": ["查看", "预约"],
                    "menu": "驾校车辆列表",
                    "menuJump": "列表",
                    "tableName": "jiaxiaocheliang"
                }],
                "menu": "驾校车辆模块"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-time",
                    "buttons": ["查看", "预约"],
                    "menu": "考试安排列表",
                    "menuJump": "列表",
                    "tableName": "kaoshianpai"
                }],
                "menu": "考试安排模块"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-rank",
                    "buttons": ["查看"],
                    "menu": "驾驶知识列表",
                    "menuJump": "列表",
                    "tableName": "jiashizhishi"
                }],
                "menu": "驾驶知识模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "管理员",
            "tableName": "users"
        }, {
            "backMenu": [{"child":[{"appFrontIcon":"cuIcon-form","buttons":["新增","查看","修改","删除"],
                    "menu":"驾校信息","menuJump":"列表","tableName":"jiaxiaoxinxi"}],
                "menu":"驾校信息管理"},{
                "child": [{
                    "appFrontIcon": "cuIcon-circle",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "课程信息",
                    "menuJump": "列表",
                    "tableName": "kechengxinxi"
                }],
                "menu": "课程信息管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-circle",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "课程预约",
                    "menuJump": "列表",
                    "tableName": "kechengyuyue"
                }],
                "menu": "课程预约管理"
            },{
                "child": [{
                    "appFrontIcon": "cuIcon-keyboard",
                    "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
                    "menu": "驾校车辆",
                    "menuJump": "列表",
                    "tableName": "jiaxiaocheliang"
                }],
                "menu": "驾校车辆管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-paint",
                    "buttons": ["查看", "删除"],
                    "menu": "预约信息",
                    "menuJump": "列表",
                    "tableName": "yuyuexinxi"
                }],
                "menu": "预约信息管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-time",
                    "buttons": ["查看"],
                    "menu": "考试安排列表",
                    "menuJump": "列表",
                    "tableName": "kaoshianpai"
                }],
                "menu": "考试安排管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-time",
                    "buttons": ["查看"],
                    "menu": "考试预约",
                    "menuJump": "列表",
                    "tableName": "kaoshiyuyue"
                }],
                "menu": "考试预约管理"
            },{
                "child": [{
                    "appFrontIcon": "cuIcon-discover",
                    "buttons": ["查看"],
                    "menu": "学员成绩",
                    "menuJump": "列表",
                    "tableName": "xueyuanchengji"
                }],
                "menu": "学员成绩管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-calendar",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "考试题目管理",
                    "tableName": "examquestion"
                }],
                "menu": "考试题目管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-copy",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "笔试考试管理",
                    "tableName": "exampaper"
                }],
                "menu": "笔试考试管理"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-baby",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "笔试考试列表",
                    "tableName": "exampaperlist"
                }, {
                    "appFrontIcon": "cuIcon-read",
                    "buttons": ["查看", "删除"],
                    "menu": "驾校考试记录",
                    "tableName": "examrecord"
                }, {
                    "appFrontIcon": "cuIcon-cardboard",
                    "buttons": ["查看", "删除"],
                    "menu": "错题本",
                    "tableName": "examfailrecord"
                }],
                "menu": "驾校考试管理"
            },{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看", "新增", "修改", "删除"],
                    "menu":"消息通知","menuJump":"列表","tableName":"tongzhixinxi"}],
                "menu":"消息通知管理"},{
                "child": [
                    {
                        "appFrontIcon": "cuIcon-group",
                        "buttons": [
                            "新增",
                            "查看",
                            "修改",
                            "删除"
                        ],
                        "menu": "统计图表",
                        "tableName": "statistics"
                    }
                ],
                "menu": "统计图表"
            }],
            "frontMenu": [{
                "child": [{
                    "appFrontIcon": "cuIcon-full",
                    "buttons": ["查看", "预约"],
                    "menu": "驾校车辆列表",
                    "menuJump": "列表",
                    "tableName": "jiaxiaocheliang"
                }],
                "menu": "驾校车辆模块"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-time",
                    "buttons": ["查看", "预约"],
                    "menu": "考试安排列表",
                    "menuJump": "列表",
                    "tableName": "kaoshianpai"
                }],
                "menu": "考试安排模块"
            }, {
                "child": [{
                    "appFrontIcon": "cuIcon-rank",
                    "buttons": ["查看"],
                    "menu": "驾驶知识列表",
                    "menuJump": "列表",
                    "tableName": "jiashizhishi"
                }],
                "menu": "驾驶知识模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "是",
            "roleName": "驾校教练",
            "tableName": "jiaxiaojiaolian"
        }]
    }
}
export default menu;
