<template>
<div :style='{"padding":"20px 20px 40px","margin":"10px auto 0","borderColor":"rgba(189, 125, 71, 1)","borderRadius":"12px","background":"#fff","borderWidth":"3px","width":"1200px","position":"relative","borderStyle":"solid dashed double double"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
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
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="驾驶证类型" prop="jiashizhengleixing">
            <el-input v-model="ruleForm.jiashizhengleixing" 
                placeholder="驾驶证类型" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="车牌号码" prop="chepaihaoma">
            <el-input v-model="ruleForm.chepaihaoma" 
                placeholder="车牌号码" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="车辆状况" prop="cheliangzhuangkuang">
            <el-input v-model="ruleForm.cheliangzhuangkuang" 
                placeholder="车辆状况" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="可约时间" prop="keyueshijian">
            <el-input v-model="ruleForm.keyueshijian" 
                placeholder="可约时间" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="教练账号" prop="jiaolianzhanghao">
            <el-input v-model="ruleForm.jiaolianzhanghao" 
                placeholder="教练账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="教练姓名" prop="jiaolianxingming">
            <el-input v-model="ruleForm.jiaolianxingming" 
                placeholder="教练姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="车辆信息" prop="cheliangxinxi">
            <editor 
                :style='{"padding":"0","boxShadow":"0 0 0px rgba(75,223,201,.5)","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.cheliangxinxi" 
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
            cheliangmingcheng : false,
            cheliangtupian : false,
            jiashizhengleixing : false,
            chepaihaoma : false,
            cheliangzhuangkuang : false,
            cheliangxinxi : false,
            keyueshijian : false,
            jiaolianzhanghao : false,
            jiaolianxingming : false,
            thumbsupnum : false,
            crazilynum : false,
            clicknum : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          cheliangmingcheng: '',
          cheliangtupian: '',
          jiashizhengleixing: '',
          chepaihaoma: '',
          cheliangzhuangkuang: '',
          cheliangxinxi: '',
          keyueshijian: '',
          jiaolianzhanghao: '',
          jiaolianxingming: '',
        },
        rules: {
          cheliangmingcheng: [
            { required: true, message: '车辆名称不能为空', trigger: 'blur' },
          ],
          cheliangtupian: [
          ],
          jiashizhengleixing: [
          ],
          chepaihaoma: [
            { required: true, message: '车牌号码不能为空', trigger: 'blur' },
          ],
          cheliangzhuangkuang: [
          ],
          cheliangxinxi: [
          ],
          keyueshijian: [
          ],
          jiaolianzhanghao: [
          ],
          jiaolianxingming: [
          ],
          thumbsupnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          crazilynum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          clicknum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
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
            if(o=='jiashizhengleixing'){
              this.ruleForm.jiashizhengleixing = obj[o];
              this.ro.jiashizhengleixing = true;
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
            if(o=='cheliangxinxi'){
              this.ruleForm.cheliangxinxi = obj[o];
              this.ro.cheliangxinxi = true;
              continue;
            }
            if(o=='keyueshijian'){
              this.ruleForm.keyueshijian = obj[o];
              this.ro.keyueshijian = true;
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
            if(o=='thumbsupnum'){
              this.ruleForm.thumbsupnum = obj[o];
              this.ro.thumbsupnum = true;
              continue;
            }
            if(o=='crazilynum'){
              this.ruleForm.crazilynum = obj[o];
              this.ro.crazilynum = true;
              continue;
            }
            if(o=='clicknum'){
              this.ruleForm.clicknum = obj[o];
              this.ro.clicknum = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if(json.jiaolianzhanghao!=''&&json.jiaolianzhanghao){
                this.ruleForm.jiaolianzhanghao = json.jiaolianzhanghao
            }
            if(json.jiaolianxingming!=''&&json.jiaolianxingming){
                this.ruleForm.jiaolianxingming = json.jiaolianxingming
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('jiaxiaocheliang/detail/${id}', {emulateJSON: true}).then(res => {
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
                 this.$http.get('jiaxiaocheliang/list', {
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


                          this.$http.post('jiaxiaocheliang/add', this.ruleForm).then(res => {
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


                  this.$http.post('jiaxiaocheliang/add', this.ruleForm).then(res => {
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
