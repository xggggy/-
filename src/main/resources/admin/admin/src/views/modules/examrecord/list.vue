<template>
  <div class="main-content">
    <!-- 列表页 -->
    <template v-if="!showFlag">
      <el-form :style='{"width":"250px","padding":"0 6px","margin":"0 0 20px"}' :inline="true" :model="searchForm" class="center-form-pv">
        <el-row :style='{"flexDirection":"column","display":"flex"}'>
			<div :style='{"margin":"0","flexDirection":"column","display":"flex"}'>
			  <label :style='{"margin":"0","color":"#000","textAlign":"center","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">笔试考试</label>
			  <el-input v-model="searchForm.papername" placeholder="笔试考试名称" clearable></el-input>
			</div>
			<el-button :style='{"border":"1px solid rgba(189, 125, 71, 1)","cursor":"pointer","padding":"0 24px","boxShadow":"0px 2px 2px 0px rgba(189, 125, 71, 1)","outline":"none","margin":"10px 0 0","color":"rgba(189, 125, 71, 1)","borderRadius":"30px","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' round @click="search()">查询</el-button>
		</el-row>
        <el-row :style='{"margin":"20px 0","flexDirection":"column","display":"flex"}'>
          <download-excel v-if="isAuth('examrecord','导出')" class = "export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "考试记录.xls">
                    <!-- 导出excel -->
                    <el-button
					    :style='{"border":"1px solid rgba(189, 125, 71, 1)","cursor":"pointer","padding":"0","boxShadow":"0px 2px 2px 0px rgba(189, 125, 71, 1)","margin":"0 0 10px","outline":"none","color":"rgba(189, 125, 71, 1)","borderRadius":"30px","background":"#fff","width":"100%","fontSize":"14px","height":"40px"}'
                        type="primary"
                    >{{'导出'}}</el-button>
          </download-excel>
          <el-button v-if="isAuth('examrecord','打印')"
            type="success"
			:style='{"border":"1px solid rgba(189, 125, 71, 1)","cursor":"pointer","padding":"0","boxShadow":"0px 2px 2px 0px rgba(189, 125, 71, 1)","margin":"0 0 10px","outline":"none","color":"rgba(189, 125, 71, 1)","borderRadius":"30px","background":"#fff","width":"100%","fontSize":"14px","height":"40px"}'
            @click="printJson"
          >{{'打印'}}</el-button>
        </el-row>
      </el-form>
	  
        <el-table
		  :stripe='false'
		  :style='{"padding":"0","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","borderColor":"#eee","borderRadius":"30px","borderWidth":"1px 0 0 1px","background":"#fff","width":"100%","borderStyle":"solid","height":"fit-content"}'
          :data="dataList"
          border
          v-loading="dataListLoading"
          @selection-change="selectionChangeHandler"
          style="width: 100%;"
        >
          <el-table-column :resizable='true' :sortable='false' prop="username" header-align="center" align="center" sortable label="姓名"></el-table-column>
          <el-table-column
		    :resizable='true' :sortable='false'
            prop="papername"
            header-align="center"
            align="center"
            sortable
            label="笔试考试"
          ></el-table-column>
          <el-table-column
		    :resizable='true' :sortable='false'
            prop="myscore"
            header-align="center"
            align="center"
            sortable
            label="驾校考试得分"
          >
            <template slot-scope="scope">
              <el-tag v-if="scope.row.myscore==0" type="info">{{scope.row.myscore}}</el-tag>
              <el-tag v-else type="warning">{{scope.row.myscore}}</el-tag>
            </template>
          </el-table-column>
          <el-table-column
            header-align="center"
            align="center"
            width="150"
            label="操作"
          >
            <template slot-scope="scope">
              <el-button
                type="text"
                size="small"
				:style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#fff","borderRadius":"30px","background":"rgba(189, 125, 71, 1)","width":"auto","fontSize":"14px","height":"32px"}'
                @click="addOrUpdateHandler(scope.row)"
              >查看详情</el-button>
            </template>
          </el-table-column>
        </el-table>
		
        <el-pagination
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="pageSize"
          :total="totalPage"
          :layout="layouts.join()"
          prev-text="<"
          next-text=">"
          :hide-on-single-page="true"
          :style='{"width":"100%","padding":"0","margin":"20px 0 0","whiteSpace":"nowrap","color":"#333","fontWeight":"500"}'
        ></el-pagination>
    </template>
    <add-or-update v-if="showFlag" :parent="this" ref="addOrUpdate"></add-or-update>
  </div>
</template>
<script>
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
	  layouts: ["total","prev","pager","next","sizes","jumper"],
      searchForm: {
        key: ""
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: false,
      //导出excel
        json_fields: {
        "姓名": "username",    //常规字段
        "试卷名称": "papername",    //常规字段
        "总分": "myscore",    //常规字段
        },
        json_meta: [
          [
            {
              " key ": " charset ",
              " value ": " utf- 8 "
            }
          ]
        ]
    };
  },
  mounted() {
    this.init();
    this.getDataList();
  },
  components: {
    AddOrUpdate
  },
  methods: {
    init() {},
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      var params = {
        page: this.pageIndex,
        limit: this.pageSize
      };
      if (this.searchForm.papername) {
        params["papername"] = `%${this.searchForm.papername}%`;
      }
      this.$http({
        url: this.$api.examrecordgroupby,
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
    addOrUpdateHandler(row) {
      this.showFlag = true;
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(row);
      });
    },
    async printJson() {
      //通过getdata调用后台接口获取数据封装到res
      this.list = this.dataList;
      let data = []
      for (let i=0; i < this.list.length; i++) {
          data.push({
          username: this.list[i].username,
          papername: this.list[i].papername,
          myscore: this.list[i].myscore,
        })
      }
      printJS({
        printable: data,
        properties: [
      {
        field: 'username',
        displayName: '姓名',
        columnSize: 1
      },
      {
        field: 'papername',
        displayName: '试卷名称',
        columnSize: 1
      },
      {
        field: 'myscore',
        displayName: '总分',
        columnSize: 1
      },
        ],
        type: 'json',
        header: '考试记录',
        // 样式设置
        gridStyle: 'border: 2px solid #3971A5;',
        gridHeaderStyle: 'color: red;  border: 2px solid #3971A5;'
      })
    },
  }
};
</script>
<style lang="scss" scoped>
//导出excel
  .export-excel-wrapper{
    display: inline-block;
  }
.form-content {
	background: transparent;
}
.table-content {
	background: transparent;
}
	
	.center-form-pv {
		.el-input {
		  width: auto;
		}
	  .el-date-editor.el-input {
	    width: auto;
	  }
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
