<template>
	<div class="main-content">
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"width":"250px","padding":"0 6px","margin":"0 0 20px"}' :inline="true" :model="searchForm">
				<el-row :style='{"flexDirection":"column","display":"flex"}' >
					<div :style='{"margin":"0","flexDirection":"column","display":"flex"}'>
						<label :style='{"margin":"0","color":"#000","textAlign":"center","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">车辆名称</label>
						<el-input v-model="searchForm.cheliangmingcheng" placeholder="车辆名称" clearable></el-input>
					</div>
					<div :style='{"margin":"0","flexDirection":"column","display":"flex"}'>
						<label :style='{"margin":"0","color":"#000","textAlign":"center","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">车牌号码</label>
						<el-input v-model="searchForm.chepaihaoma" placeholder="车牌号码" clearable></el-input>
					</div>
					<el-button :style='{"border":"1px solid rgba(189, 125, 71, 1)","cursor":"pointer","padding":"0 24px","boxShadow":"0px 2px 2px 0px rgba(189, 125, 71, 1)","outline":"none","margin":"10px 0 0","color":"rgba(189, 125, 71, 1)","borderRadius":"30px","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' type="success" @click="search()">查询</el-button>
				</el-row>

				<el-row :style='{"margin":"20px 0","flexDirection":"column","display":"flex"}'>
					<el-button :style='{"border":"1px solid rgba(189, 125, 71, 1)","cursor":"pointer","padding":"0","boxShadow":"0px 2px 2px 0px rgba(189, 125, 71, 1)","margin":"0 0 10px","outline":"none","color":"rgba(189, 125, 71, 1)","borderRadius":"30px","background":"#fff","width":"100%","fontSize":"14px","height":"40px"}' v-if="isAuth('yuyuexinxi','新增')" type="success" @click="addOrUpdateHandler()">新增</el-button>
					<el-button :style='{"border":"1px solid rgba(189, 125, 71, 1)","cursor":"pointer","padding":"0","boxShadow":"0px 2px 2px 0px rgba(189, 125, 71, 1)","margin":"0 0 10px","outline":"none","color":"rgba(189, 125, 71, 1)","borderRadius":"30px","background":"#fff","width":"100%","fontSize":"14px","height":"40px"}' v-if="isAuth('yuyuexinxi','删除')" :disabled="dataListSelections.length <= 0" type="danger" @click="deleteHandler()">删除</el-button>




				</el-row>
			</el-form>

			<!-- <div> -->
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","borderColor":"#eee","borderRadius":"30px","borderWidth":"1px 0 0 1px","background":"#fff","width":"100%","borderStyle":"solid","height":"fit-content"}'
					v-if="isAuth('yuyuexinxi','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='false' label="索引" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='false'
						prop="yuyuehao"
					label="预约号">
						<template slot-scope="scope">
							{{scope.row.yuyuehao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="cheliangmingcheng"
					label="车辆名称">
						<template slot-scope="scope">
							{{scope.row.cheliangmingcheng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false' prop="cheliangtupian" width="200" label="车辆图片">
						<template slot-scope="scope">
							<div v-if="scope.row.cheliangtupian">
								<img v-if="scope.row.cheliangtupian.substring(0,4)=='http'" :src="scope.row.cheliangtupian.split(',')[0]" width="100" height="100">
								<img v-else :src="$base.url+scope.row.cheliangtupian.split(',')[0]" width="100" height="100">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="jiashizhengleixing"
					label="驾驶证类型">
						<template slot-scope="scope">
							{{scope.row.jiashizhengleixing}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="chepaihaoma"
					label="车牌号码">
						<template slot-scope="scope">
							{{scope.row.chepaihaoma}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="cheliangzhuangkuang"
					label="车辆状况">
						<template slot-scope="scope">
							{{scope.row.cheliangzhuangkuang}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="yuyueshijian"
					label="预约时间">
						<template slot-scope="scope">
							{{scope.row.yuyueshijian}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="jiaolianzhanghao"
					label="教练账号">
						<template slot-scope="scope">
							{{scope.row.jiaolianzhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="jiaolianxingming"
					label="教练姓名">
						<template slot-scope="scope">
							{{scope.row.jiaolianxingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="xueyuanzhanghao"
					label="学员账号">
						<template slot-scope="scope">
							{{scope.row.xueyuanzhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="xueyuanxingming"
					label="学员姓名">
						<template slot-scope="scope">
							{{scope.row.xueyuanxingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="shouji"
					label="手机">
						<template slot-scope="scope">
							{{scope.row.shouji}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="dengjishijian"
					label="登记时间">
						<template slot-scope="scope">
							{{scope.row.dengjishijian}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="zhuangtai"
					label="状态">
						<template slot-scope="scope">
							{{scope.row.zhuangtai}}
						</template>
					</el-table-column>
          <el-table-column :resizable='true' :sortable='false'
                           prop="sfsh"
                           label="是否审核">
            <template slot-scope="scope">
              <span style="margin-right:10px">{{scope.row.sfsh}}</span>
            </template>
          </el-table-column>
          <el-table-column :resizable='true' :sortable='false'
                           prop="shhf"
                           label="审核回复">
          </el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#fff","borderRadius":"30px","background":"rgba(189, 125, 71, 1)","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('yuyuexinxi','查看')" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
							<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#fff","borderRadius":"30px","background":"rgba(189, 125, 71, 1)","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('yuyuexinxi','修改')" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>





							<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#fff","borderRadius":"30px","background":"rgba(189, 125, 71, 1)","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('yuyuexinxi','删除') " type="danger" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
              <el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#fff","borderRadius":"30px","background":"rgba(189, 125, 71, 1)","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('kechengyuyue','审核') " type="danger" size="mini" @click="shDialog(scope.row)">审核</el-button>
            </template>
					</el-table-column>
				</el-table>
				<el-pagination
					@size-change="sizeChangeHandle"
					@current-change="currentChangeHandle"
					:current-page="pageIndex"
					background
					:page-sizes="[10, 20, 30, 50]"
					:page-size="pageSize"
					:layout="layouts.join()"
					:total="totalPage"
					prev-text="<"
					next-text=">"
					:hide-on-single-page="true"
					:style='{"width":"100%","padding":"0","margin":"20px 0 0","whiteSpace":"nowrap","color":"#333","fontWeight":"500"}'
				></el-pagination>
			<!-- </div> -->
		</template>

		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

<!--		<quxiaoyuyue-cross-add-or-update v-if="quxiaoyuyueCrossAddOrUpdateFlag" :parent="this" ref="quxiaoyuyueCrossaddOrUpdate"></quxiaoyuyue-cross-add-or-update>-->

    <el-dialog
        title="审核"
        :visible.sync="sfshVisiable"
        width="50%">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="审核状态">
          <el-select v-model="shForm.sfsh" placeholder="审核状态">
            <el-option label="通过" value="通过"></el-option>
            <el-option label="不通过" value="不通过"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="内容">
          <el-input type="textarea" :rows="8" v-model="shForm.shhf"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="shDialog">取 消</el-button>
        <el-button type="primary" @click="shHandler">确 定</el-button>
      </span>
    </el-dialog>


	</div>
</template>

<script>
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
import quxiaoyuyueCrossAddOrUpdate from "../quxiaoyuyue/add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      chartVisiable1: false,
      chartVisiable2: false,
      chartVisiable3: false,
      chartVisiable4: false,
      chartVisiable5: false,
      addOrUpdateFlag:false,
      quxiaoyuyueCrossAddOrUpdateFlag: false,
      layouts: ["total","prev","pager","next","sizes","jumper"],


    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
    quxiaoyuyueCrossAddOrUpdate,
  },
  methods: {

    contentStyleChange() {
      this.contentPageStyleChange()
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      // if(this.contents.pageTotal) arr.push('total')
      // if(this.contents.pageSizes) arr.push('sizes')
      // if(this.contents.pagePrevNext){
      //   arr.push('prev')
      //   if(this.contents.pagePager) arr.push('pager')
      //   arr.push('next')
      // }
      // if(this.contents.pageJumper) arr.push('jumper')
      // this.layouts = arr.join()
      // this.contents.pageEachNum = 10
    },

    quxiaoyuyueCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.quxiaoyuyueCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','yuyuexinxi');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.quxiaoyuyueCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.quxiaoyuyueCrossaddOrUpdate.init(row.id,type);
      });
    },







    init () {
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
          if(this.searchForm.cheliangmingcheng!='' && this.searchForm.cheliangmingcheng!=undefined){
            params['cheliangmingcheng'] = '%' + this.searchForm.cheliangmingcheng + '%'
          }
          if(this.searchForm.chepaihaoma!='' && this.searchForm.chepaihaoma!=undefined){
            params['chepaihaoma'] = '%' + this.searchForm.chepaihaoma + '%'
          }
      this.$http({
        url: "yuyuexinxi/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },

    // 审核窗口
    shDialog(row){
      this.sfshVisiable = !this.sfshVisiable;
      if(row){
        this.shForm = {
          yuyuehao: row.yuyuehao,
          cheliangmingcheng: row.cheliangmingcheng,
          cheliangtupian: row.cheliangtupian,
          jiashizhengleixing: row.jiashizhengleixing,
          chepaihaoma: row.chepaihaoma,
          cheliangzhuangkuang: row.cheliangzhuangkuang,
          yuyueshijian: row.yuyueshijian,
          jiaolianzhanghao: row.jiaolianzhanghao,
          jiaolianxingming: row.jiaolianxingming,
          xueyuanzhanghao: row.xueyuanzhanghao,
          xueyuanxingming: row.xueyuanxingming,
          shouji: row.shouji,
          dengjishijian: row.dengjishijian,
          zhuangtai: row.zhuangtai,
          addtime: row.addtime,
          sfsh: row.sfsh,
          shhf: row.shhf,
          id: row.id
        }
      }
    },
    // 审核
    shHandler(){
      this.$confirm(`确定操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "yuyuexinxi/update",
          method: "post",
          data: this.shForm
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.getDataList();
                this.shDialog()
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },

    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "yuyuexinxi/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


  }

};
</script>
<style lang="scss" scoped>

	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}

	.el-input {
	  width: auto;
	}

	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 1px solid rgba(189, 125, 71, 1);
				border-radius: 0;
				padding: 0 12px;
				box-shadow: 0px 2px 2px 0px rgba(189, 125, 71, 1);
				outline: none;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}

	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 1px solid rgba(189, 125, 71, 1);
				border-radius: 0;
				padding: 0 10px;
				box-shadow: 0px 2px 2px 0px rgba(189, 125, 71, 1);
				outline: none;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}

	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 1px solid rgba(189, 125, 71, 1);
				border-radius: 0;
				padding: 0 10px 0 30px;
				box-shadow: 0px 2px 2px 0px rgba(189, 125, 71, 1);
				outline: none;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}

	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #999;
				font-weight: 500;
				width: 100%;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: rgba(189, 125, 71, 1);
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 12px 0;
				color: #fff;
				background: transparent;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}


	.el-table /deep/ .el-table__body-wrapper tbody {
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: #fff;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #999;
				background: #fff;
				border-color: #6F6F97;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}


	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 12px 0;
				color: #000;
				background: rgba(147, 199, 179, 0.5);
				border-color: #6F6F97;
				border-width: 0 1px 1px 0;
				border-style: solid;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #999;
				background: #fff;
				border-color: #6F6F97;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}

	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #666;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #666;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #f4f4f5;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: rgba(189, 125, 71, 1);
				text-align: center;
				min-width: 30px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #FFF;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: rgba(189, 125, 71, 1);
				text-align: center;
				min-width: 30px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: #606266;
				display: inline-block;
				font-size: 13px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}

	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #606266;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				display: inline-block;
				width: 50px;
				font-size: 14px;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 3px;
				color: #606266;
				display: inline-block;
				font-size: 14px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
</style>
