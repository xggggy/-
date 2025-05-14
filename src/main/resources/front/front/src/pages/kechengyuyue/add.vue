<template>
<div :style='{"width":"1000px","padding":"20px","margin":"10px auto","position":"relative","borderRadius":"20px","background":"#fff"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="110px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#f6f6f6"}' label="课程编号" prop="kechengbianhao">
              <el-input v-model="ruleForm.kechengbianhao" placeholder="课程编号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#f6f6f6"}' label="课程名称" prop="kechengmingcheng">
            <el-input v-model="ruleForm.kechengmingcheng" 
                placeholder="课程名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#f6f6f6"}' label="课程类型" prop="kechengleixing">
            <el-input v-model="ruleForm.kechengleixing" 
                placeholder="课程类型" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#f6f6f6"}' label="上课时间" prop="shangkeshijian">
            <el-input v-model="ruleForm.shangkeshijian" 
                placeholder="上课时间" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#f6f6f6"}' label="上课地点" prop="shangkedidian">
            <el-input v-model="ruleForm.shangkedidian" 
                placeholder="上课地点" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#f6f6f6"}' label="课程图片" prop="kechengtupian">
            <file-upload
            tip="点击上传课程图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.kechengtupian?ruleForm.kechengtupian:''"
            @change="kechengtupianUploadChange"
            ></file-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#f6f6f6"}' label="课程视频" prop="kechengshipin">
            <file-upload
            tip="点击上传课程视频"
            action="file/upload"
            :limit="1"
            :multiple="true"
            :fileUrls="ruleForm.kechengshipin?ruleForm.kechengshipin:''"
            @change="kechengshipinUploadChange"
            ></file-upload>
          </el-form-item> 
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#f6f6f6"}' label="教练账号" prop="jiaolianzhanghao">
            <el-input v-model="ruleForm.jiaolianzhanghao" 
                placeholder="教练账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#f6f6f6"}' label="教练姓名" prop="jiaolianxingming">
            <el-input v-model="ruleForm.jiaolianxingming" 
                placeholder="教练姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#f6f6f6"}' label="学员账号" prop="xueyuanzhanghao">
            <el-select  @change="xueyuanzhanghaoChange" v-model="ruleForm.xueyuanzhanghao" placeholder="请选择学员账号">
              <el-option
                  v-for="(item,index) in xueyuanzhanghaoOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#f6f6f6"}' label="学员姓名" prop="xueyuanxingming">
            <el-input v-model="ruleForm.xueyuanxingming" 
                placeholder="学员姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#f6f6f6"}' label="课程介绍" prop="kechengjieshao">
            <editor 
                :style='{"minHeight":"300px","padding":"0","margin":"0","borderColor":"#01AE9D","backgroundColor":"#fff","borderRadius":"0","borderWidth":"1px","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.kechengjieshao" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#00ae9d","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#999","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          kechengbianhao: this.getUUID(),
          kechengmingcheng: '',
          kechengleixing: '',
          shangkeshijian: '',
          shangkedidian: '',
          kechengtupian: '',
          kechengshipin: '',
          jiaolianzhanghao: '',
          jiaolianxingming: '',
          xueyuanzhanghao: '',
          xueyuanxingming: '',
          kechengjieshao: '',
        },
        xueyuanzhanghaoOptions: [],
        rules: {
          kechengbianhao: [
          ],
          kechengmingcheng: [
          ],
          kechengleixing: [
          ],
          shangkeshijian: [
          ],
          shangkedidian: [
          ],
          kechengtupian: [
          ],
          kechengshipin: [
          ],
          jiaolianzhanghao: [
          ],
          jiaolianxingming: [
          ],
          xueyuanzhanghao: [
          ],
          xueyuanxingming: [
          ],
          kechengjieshao: [
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
            if(o=='kechengbianhao'){
              this.ruleForm.kechengbianhao = obj[o];
              continue;
            }
            if(o=='kechengmingcheng'){
              this.ruleForm.kechengmingcheng = obj[o];
              continue;
            }
            if(o=='kechengleixing'){
              this.ruleForm.kechengleixing = obj[o];
              continue;
            }
            if(o=='shangkeshijian'){
              this.ruleForm.shangkeshijian = obj[o];
              continue;
            }
            if(o=='shangkedidian'){
              this.ruleForm.shangkedidian = obj[o];
              continue;
            }
            if(o=='kechengtupian'){
              this.ruleForm.kechengtupian = obj[o];
              continue;
            }
            if(o=='kechengshipin'){
              this.ruleForm.kechengshipin = obj[o];
              continue;
            }
            if(o=='jiaolianzhanghao'){
              this.ruleForm.jiaolianzhanghao = obj[o];
              continue;
            }
            if(o=='jiaolianxingming'){
              this.ruleForm.jiaolianxingming = obj[o];
              continue;
            }
            if(o=='xueyuanzhanghao'){
              this.ruleForm.xueyuanzhanghao = obj[o];
              continue;
            }
            if(o=='xueyuanxingming'){
              this.ruleForm.xueyuanxingming = obj[o];
              continue;
            }
            if(o=='kechengjieshao'){
              this.ruleForm.kechengjieshao = obj[o];
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
        this.$http.get('option/xueyuan/xueyuanzhanghao', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.xueyuanzhanghaoOptions = res.data.data;
          }
        });
      },
      // 下二随
      xueyuanzhanghaoChange () {
        this.$http.get('follow/xueyuan/xueyuanzhanghao?columnValue=' + this.ruleForm.xueyuanzhanghao, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            if(res.data.data.xueyuanxingming){
              this.ruleForm.xueyuanxingming = res.data.data.xueyuanxingming
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('kechengxinxi/detail/${id}', {emulateJSON: true}).then(res => {
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
                 this.$http.get('kechengxinxi/list', {
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


                          this.$http.post('kechengxinxi/add', this.ruleForm).then(res => {
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


                  this.$http.post('kechengxinxi/add', this.ruleForm).then(res => {
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
      kechengtupianUploadChange(fileUrls) {
          this.ruleForm.kechengtupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
      kechengshipinUploadChange(fileUrls) {
          this.ruleForm.kechengshipin = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
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
	  width: 110px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: center;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 110px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 2px solid #01AE9D;
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #000;
	  width: 300px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 2px solid #01AE9D;
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #000;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 2px solid #01AE9D;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  outline: none;
	  color: #000;
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
	  border: 1px dashed #999;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #000;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px dashed #999;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #000;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px dashed #999;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #000;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 2px solid #01AE9D;
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #000;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
