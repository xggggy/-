<template>
<div :style='{"padding":"20px 20px 40px","margin":"10px auto 0","borderColor":"rgba(189, 125, 71, 1)","borderRadius":"12px","background":"#fff","borderWidth":"3px","width":"1200px","position":"relative","borderStyle":"solid dashed double double"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="预约号" prop="yuyuehao">
            <el-input v-model="ruleForm.yuyuehao" 
                placeholder="预约号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="车辆名称" prop="cheliangmingcheng">
            <el-input v-model="ruleForm.cheliangmingcheng" 
                placeholder="车辆名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="车辆图片" v-if="type!='cross' || (type=='cross' && !ro.cheliangtupian)" prop="cheliangtupian">
            <file-upload
            tip="点击上传车辆图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.cheliangtupian?ruleForm.cheliangtupian:''"
            @change="cheliangtupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' class="upload" v-else label="车辆图片" prop="cheliangtupian">
                <img v-if="ruleForm.cheliangtupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.cheliangtupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.cheliangtupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="车牌号码" prop="chepaihaoma">
            <el-input v-model="ruleForm.chepaihaoma" 
                placeholder="车牌号码" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="车辆状况" prop="cheliangzhuangkuang">
            <el-input v-model="ruleForm.cheliangzhuangkuang" 
                placeholder="车辆状况" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="预约时间" prop="yuyueshijian">
            <el-input v-model="ruleForm.yuyueshijian" 
                placeholder="预约时间" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="教练账号" prop="jiaolianzhanghao">
            <el-input v-model="ruleForm.jiaolianzhanghao" 
                placeholder="教练账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="教练姓名" prop="jiaolianxingming">
            <el-input v-model="ruleForm.jiaolianxingming" 
                placeholder="教练姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="学员账号" prop="xueyuanzhanghao">
            <el-input v-model="ruleForm.xueyuanzhanghao" 
                placeholder="学员账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="学员姓名" prop="xueyuanxingming">
            <el-input v-model="ruleForm.xueyuanxingming" 
                placeholder="学员姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="手机" prop="shouji">
            <el-input v-model="ruleForm.shouji" 
                placeholder="手机" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="取消时间" prop="quxiaoshijian" >
              <el-date-picker
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.quxiaoshijian" 
                  type="datetime"
                  placeholder="取消时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="取消原因" prop="quxiaoyuanyin">
            <editor 
                :style='{"padding":"0","boxShadow":"0 0 0px rgba(75,223,201,.5)","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.quxiaoyuanyin" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"radial-gradient(circle, rgba(189, 125, 71, 1) 0%, rgba(189, 125, 71, 1) 81%, rgba(189, 125, 71, 1) 100%)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid rgba(189, 125, 71, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(189, 125, 71, 1)","borderRadius":"4px","background":"#ecfaea","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            yuyuehao : false,
            cheliangmingcheng : false,
            cheliangtupian : false,
            chepaihaoma : false,
            cheliangzhuangkuang : false,
            yuyueshijian : false,
            jiaolianzhanghao : false,
            jiaolianxingming : false,
            xueyuanzhanghao : false,
            xueyuanxingming : false,
            shouji : false,
            quxiaoyuanyin : false,
            quxiaoshijian : false,
            sfsh : false,
            shhf : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          yuyuehao: '',
          cheliangmingcheng: '',
          cheliangtupian: '',
          chepaihaoma: '',
          cheliangzhuangkuang: '',
          yuyueshijian: '',
          jiaolianzhanghao: '',
          jiaolianxingming: '',
          xueyuanzhanghao: '',
          xueyuanxingming: '',
          shouji: '',
          quxiaoyuanyin: '',
          quxiaoshijian: '',
        },
        rules: {
          yuyuehao: [
          ],
          cheliangmingcheng: [
            { required: true, message: '车辆名称不能为空', trigger: 'blur' },
          ],
          cheliangtupian: [
          ],
          chepaihaoma: [
            { required: true, message: '车牌号码不能为空', trigger: 'blur' },
          ],
          cheliangzhuangkuang: [
          ],
          yuyueshijian: [
          ],
          jiaolianzhanghao: [
          ],
          jiaolianxingming: [
          ],
          xueyuanzhanghao: [
          ],
          xueyuanxingming: [
          ],
          shouji: [
          ],
          quxiaoyuanyin: [
            { required: true, message: '取消原因不能为空', trigger: 'blur' },
          ],
          quxiaoshijian: [
          ],
          sfsh: [
          ],
          shhf: [
          ],
        },
      };
    },
    computed: {



    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.quxiaoshijian = this.getCurDateTime()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='yuyuehao'){
              this.ruleForm.yuyuehao = obj[o];
              this.ro.yuyuehao = true;
              continue;
            }
            if(o=='cheliangmingcheng'){
              this.ruleForm.cheliangmingcheng = obj[o];
              this.ro.cheliangmingcheng = true;
              continue;
            }
            if(o=='cheliangtupian'){
              this.ruleForm.cheliangtupian = obj[o].split(",")[0];
              this.ro.cheliangtupian = true;
              continue;
            }
            if(o=='chepaihaoma'){
              this.ruleForm.chepaihaoma = obj[o];
              this.ro.chepaihaoma = true;
              continue;
            }
            if(o=='cheliangzhuangkuang'){
              this.ruleForm.cheliangzhuangkuang = obj[o];
              this.ro.cheliangzhuangkuang = true;
              continue;
            }
            if(o=='yuyueshijian'){
              this.ruleForm.yuyueshijian = obj[o];
              this.ro.yuyueshijian = true;
              continue;
            }
            if(o=='jiaolianzhanghao'){
              this.ruleForm.jiaolianzhanghao = obj[o];
              this.ro.jiaolianzhanghao = true;
              continue;
            }
            if(o=='jiaolianxingming'){
              this.ruleForm.jiaolianxingming = obj[o];
              this.ro.jiaolianxingming = true;
              continue;
            }
            if(o=='xueyuanzhanghao'){
              this.ruleForm.xueyuanzhanghao = obj[o];
              this.ro.xueyuanzhanghao = true;
              continue;
            }
            if(o=='xueyuanxingming'){
              this.ruleForm.xueyuanxingming = obj[o];
              this.ro.xueyuanxingming = true;
              continue;
            }
            if(o=='shouji'){
              this.ruleForm.shouji = obj[o];
              this.ro.shouji = true;
              continue;
            }
            if(o=='quxiaoyuanyin'){
              this.ruleForm.quxiaoyuanyin = obj[o];
              this.ro.quxiaoyuanyin = true;
              continue;
            }
            if(o=='quxiaoshijian'){
              this.ruleForm.quxiaoshijian = obj[o];
              this.ro.quxiaoshijian = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if(json.xueyuanzhanghao!=''&&json.xueyuanzhanghao){
                this.ruleForm.xueyuanzhanghao = json.xueyuanzhanghao
            }
            if(json.xueyuanxingming!=''&&json.xueyuanxingming){
                this.ruleForm.xueyuanxingming = json.xueyuanxingming
            }
            if(json.shouji!=''&&json.shouji){
                this.ruleForm.shouji = json.shouji
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('quxiaoyuyue/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('quxiaoyuyue/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('quxiaoyuyue/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('quxiaoyuyue/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
      cheliangtupianUploadChange(fileUrls) {
          this.ruleForm.cheliangtupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid rgba(189, 125, 71, 1);
	  border-radius: 4px;
	  padding: 0 12px;
	  box-shadow: rgba(189, 125, 71, 1)rgba(189, 125, 71, 1);
	  outline: none;
	  color: #666;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid rgba(189, 125, 71, 1);
	  border-radius: 4px;
	  padding: 0 10px;
	  box-shadow: rgba(189, 125, 71, 1)rgba(189, 125, 71, 1);
	  outline: none;
	  color: #666;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid rgba(189, 125, 71, 1);
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  box-shadow: rgba(189, 125, 71, 1)rgba(189, 125, 71, 1);
	  outline: none;
	  color: #666;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px solid rgba(189, 125, 71, 1);
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: rgba(189, 125, 71, 1)rgba(189, 125, 71, 1);
	  color: rgba(189, 125, 71, 1);
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid rgba(189, 125, 71, 1);
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: rgba(189, 125, 71, 1)rgba(189, 125, 71, 1);
	  color: rgba(189, 125, 71, 1);
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid rgba(189, 125, 71, 1);
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: rgba(189, 125, 71, 1)rgba(189, 125, 71, 1);
	  color: rgba(189, 125, 71, 1);
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid rgba(189, 125, 71, 1);
	  border-radius: 4px;
	  padding: 12px;
	  box-shadow: rgba(189, 125, 71, 1)rgba(189, 125, 71, 1);
	  outline: none;
	  color: #666;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
