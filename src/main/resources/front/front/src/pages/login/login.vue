<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"padding":"40px 20px 20px","boxShadow":"0 1px 6px rgba(0, 0, 0, .1)","margin":"0","borderRadius":"16px","background":"no-repeat left top, no-repeat right bottom,#fff","width":"500px","height":"auto"}' :rules="rules">
			<div v-if="true" :style='{"margin":"0 auto 20px auto","borderColor":"rgba(189, 125, 71, 1)","color":"rgba(189, 125, 71, 1)","textAlign":"center","borderWidth":"3px","width":"50%","letterSpacing":"2px","lineHeight":"44px","fontSize":"24px","fontWeight":"600"}'>驾校管理系统登录</div>
			<el-form-item class="list-item" :style='{"width":"80%","margin":"0 auto 10px"}' prop="username">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"#333"}'>账号：</div>
				<input :style='{"border":"1px solid rgba(189, 125, 71, 1)","padding":"0 10px","boxShadow":"rgba(189, 125, 71, 1)rgba(189, 125, 71, 1)","color":"#666","borderRadius":"4px","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.username" placeholder="请输入账户">
			</el-form-item>
			<el-form-item class="list-item" :style='{"width":"80%","margin":"0 auto 10px"}' prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"#333"}'>密码：</div>
				<input :style='{"border":"1px solid rgba(189, 125, 71, 1)","padding":"0 10px","boxShadow":"rgba(189, 125, 71, 1)rgba(189, 125, 71, 1)","color":"#666","borderRadius":"4px","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.password" placeholder="请输入密码" type="password">
			</el-form-item>
			<el-form-item v-if="roles.length>1" class="list-type" :style='{"width":"80%","margin":"20px auto"}' prop="role">
				<el-radio v-model="loginForm.tableName" :label="item.tableName" v-for="(item, index) in roles" :key="index" @change.native="getCurrentRow(item)">{{item.roleName}}</el-radio>
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"20px auto"}'>
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0 34px","margin":"0 5px","outline":"none","color":"#fff","borderRadius":"4px","background":"radial-gradient(circle, rgba(189, 125, 71, 1) 0%, rgba(189, 125, 71, 1) 81%, rgba(189, 125, 71, 1) 100%)","width":"auto","fontSize":"14px","height":"44px"}' @click="submitForm('loginForm')">登录</el-button>
				<el-button :style='{"border":"1px solid rgba(189, 125, 71, 1)","cursor":"pointer","padding":"0 34px","margin":"0 5px","outline":"none","color":"rgba(189, 125, 71, 1)","borderRadius":"4px","background":"#ecfaea","width":"auto","fontSize":"14px","height":"44px"}' @click="resetForm('loginForm')">重置</el-button>
			</el-form-item>
			<div :style='{"width":"80%","margin":"20px auto"}'>
			<router-link :style='{"cursor":"pointer","margin":"0 5px","fontSize":"14px","textDecoration":"none","color":"rgba(189, 125, 71, 1)","background":"#fff"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='是'" v-for="(item, index) in roles" :key="index">注册{{item.roleName.replace('注册','')}}</router-link>
			</div>
		</el-form>
    </div>
</div>
</template>

<script>


export default {
	//数据集合
	data() {
		return {
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除"],"menu":"学员","menuJump":"列表","tableName":"xueyuan"}],"menu":"学员管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"驾校教练","menuJump":"列表","tableName":"jiaxiaojiaolian"}],"menu":"驾校教练管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除","查看评论","预约"],"menu":"驾校车辆","menuJump":"列表","tableName":"jiaxiaocheliang"}],"menu":"驾校车辆管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","修改","删除","取消"],"menu":"预约信息","menuJump":"列表","tableName":"yuyuexinxi"}],"menu":"预约信息管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","修改","删除","审核"],"menu":"取消预约","menuJump":"列表","tableName":"quxiaoyuyue"}],"menu":"取消预约管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["新增","查看","修改","删除","预约"],"menu":"考试安排","menuJump":"列表","tableName":"kaoshianpai"}],"menu":"考试安排管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","修改","删除","取消"],"menu":"考试预约","menuJump":"列表","tableName":"kaoshiyuyue"}],"menu":"考试预约管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","修改","删除","审核"],"menu":"取消考试","menuJump":"列表","tableName":"quxiaokaoshi"}],"menu":"取消考试管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["新增","查看","修改","删除","查看评论"],"menu":"驾驶知识","menuJump":"列表","tableName":"jiashizhishi"}],"menu":"驾驶知识管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除"],"menu":"学员成绩","menuJump":"列表","tableName":"xueyuanchengji"}],"menu":"学员成绩管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["新增","查看","修改","删除"],"menu":"笔试考试管理","tableName":"exampaper"}],"menu":"笔试考试管理"},{"child":[{"appFrontIcon":"cuIcon-calendar","buttons":["新增","查看","修改","删除"],"menu":"考试题目管理","tableName":"examquestion"}],"menu":"考试题目管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-wenzi","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"驾校公告","tableName":"news"}],"menu":"系统管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","删除"],"menu":"错题本","tableName":"examfailrecord"},{"appFrontIcon":"cuIcon-baby","buttons":["新增","查看","修改","删除"],"menu":"笔试考试列表","tableName":"exampaperlist"},{"appFrontIcon":"cuIcon-read","buttons":["查看","删除","导出"],"menu":"驾校考试记录","tableName":"examrecord"}],"menu":"驾校考试管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-full","buttons":["查看","预约"],"menu":"驾校车辆列表","menuJump":"列表","tableName":"jiaxiaocheliang"}],"menu":"驾校车辆模块"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","预约"],"menu":"考试安排列表","menuJump":"列表","tableName":"kaoshianpai"}],"menu":"考试安排模块"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["查看"],"menu":"驾驶知识列表","menuJump":"列表","tableName":"jiashizhishi"}],"menu":"驾驶知识模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","删除","取消"],"menu":"预约信息","menuJump":"列表","tableName":"yuyuexinxi"}],"menu":"预约信息管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","删除"],"menu":"取消预约","menuJump":"列表","tableName":"quxiaoyuyue"}],"menu":"取消预约管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","删除","支付","取消"],"menu":"考试预约","menuJump":"列表","tableName":"kaoshiyuyue"}],"menu":"考试预约管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","删除"],"menu":"取消考试","menuJump":"列表","tableName":"quxiaokaoshi"}],"menu":"取消考试管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看"],"menu":"学员成绩","menuJump":"列表","tableName":"xueyuanchengji"}],"menu":"学员成绩管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-full","buttons":["查看","预约"],"menu":"驾校车辆列表","menuJump":"列表","tableName":"jiaxiaocheliang"}],"menu":"驾校车辆模块"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","预约"],"menu":"考试安排列表","menuJump":"列表","tableName":"kaoshianpai"}],"menu":"考试安排模块"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["查看"],"menu":"驾驶知识列表","menuJump":"列表","tableName":"jiashizhishi"}],"menu":"驾驶知识模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"学员","tableName":"xueyuan"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除","查看评论"],"menu":"驾校车辆","menuJump":"列表","tableName":"jiaxiaocheliang"}],"menu":"驾校车辆管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","删除"],"menu":"预约信息","menuJump":"列表","tableName":"yuyuexinxi"}],"menu":"预约信息管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","审核","删除"],"menu":"取消预约","menuJump":"列表","tableName":"quxiaoyuyue"}],"menu":"取消预约管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看"],"menu":"考试预约","menuJump":"列表","tableName":"kaoshiyuyue"}],"menu":"考试预约管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","审核"],"menu":"取消考试","menuJump":"列表","tableName":"quxiaokaoshi"}],"menu":"取消考试管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看"],"menu":"学员成绩","menuJump":"列表","tableName":"xueyuanchengji"}],"menu":"学员成绩管理"},{"child":[{"appFrontIcon":"cuIcon-calendar","buttons":["新增","查看","修改","删除"],"menu":"考试题目管理","tableName":"examquestion"}],"menu":"考试题目管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["新增","查看","修改","删除"],"menu":"笔试考试管理","tableName":"exampaper"}],"menu":"笔试考试管理"},{"child":[{"appFrontIcon":"cuIcon-baby","buttons":["新增","查看","修改","删除"],"menu":"笔试考试列表","tableName":"exampaperlist"},{"appFrontIcon":"cuIcon-read","buttons":["查看","删除"],"menu":"驾校考试记录","tableName":"examrecord"},{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","删除"],"menu":"错题本","tableName":"examfailrecord"}],"menu":"驾校考试管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-full","buttons":["查看","预约"],"menu":"驾校车辆列表","menuJump":"列表","tableName":"jiaxiaocheliang"}],"menu":"驾校车辆模块"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","预约"],"menu":"考试安排列表","menuJump":"列表","tableName":"kaoshianpai"}],"menu":"考试安排模块"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["查看"],"menu":"驾驶知识列表","menuJump":"列表","tableName":"jiashizhishi"}],"menu":"驾驶知识模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"驾校教练","tableName":"jiaxiaojiaolian"}],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: '请输入账户', trigger: 'blur' }
				],
				password: [
					{ required: true, message: '请输入密码', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}]
		}
	},
	created() {
        for(let item in this.roleMenus) {
            if(this.roleMenus[item].hasFrontLogin=='是') {
                this.roles.push(this.roleMenus[item]);
            }
        }
	},
	mounted() {
	},
    //方法集合
    methods: {
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']

			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
      getCurrentRow(row) {
        this.role = row.roleName;
      },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("请选择登录用户类型");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get(`${this.loginForm.tableName}/login`, {params: this.loginForm}).then(res => {
              if (res.data.code === 0) {
                localStorage.setItem('Token', res.data.token);
                localStorage.setItem('UserTableName', this.loginForm.tableName);
                localStorage.setItem('username', this.loginForm.username);
                localStorage.setItem('adminName', this.loginForm.username);
                localStorage.setItem('sessionTable', this.loginForm.tableName);
                localStorage.setItem('role', this.role);
                localStorage.setItem('keyPath', this.$config.indexNav.length+2);
                this.$router.push('/index/center');
                this.$message({
                  message: '登录成功',
                  type: 'success',
                  duration: 1500,
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background-image:url("../../assets/1744965628563.jpg") ;

		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}

		.list-item /deep/ .el-input .el-input__inner {
			border: 1px solid rgba(189, 125, 71, 1);
			border-radius: 4px;
			padding: 0 10px;
			box-shadow: rgba(189, 125, 71, 1)rgba(189, 125, 71, 1);
			color: #666;
			width: 100%;
			font-size: 14px;
			height: 44px;
		}

		.list-code /deep/ .el-input .el-input__inner {
			border: 1px solid rgba(189, 125, 71, 1);
			border-radius: 4px;
			padding: 0 10px;
			box-shadow: rgba(189, 125, 71, 1)rgba(189, 125, 71, 1);
			outline: none;
			color: #666;
			display: inline-block;
			vertical-align: middle;
			width: calc(100% - 156px);
			font-size: 14px;
			height: 44px;
		}

		.list-type /deep/ .el-radio__input .el-radio__inner {
			background: rgba(53, 53, 53, 0);
			border-color: #666666;
		}
		.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
			background: rgba(189, 125, 71, 1);
			border-color: rgba(189, 125, 71, 1);
		}
		.list-type /deep/ .el-radio__label {
			color: #666666;
			font-size: 14px;
		}
		.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
			color: rgba(189, 125, 71, 1);
			font-size: 14px;
		}
	}
</style>
