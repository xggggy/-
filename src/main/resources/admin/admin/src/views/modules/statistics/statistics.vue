<template>
  <div>
    <div class="echart" id="mychart" :style="myChartStyle"></div>
    <div class="echart" id="mychartxueyuan" :style="mychartxueyuan"></div>
    <div class="echart" id="mychartkecheng" :style="mychartkecheng"></div>
  </div>

</template>

<script>
import * as echarts from "echarts";

export default {
  data() {
    return {
      selectedCategory: '', // 默认查询条件
      category: '', // 默认查询条件
      categories: ['Category1', 'Category2', 'Category3'], // 类别列表
      xData: [], //横坐标
      yData: [], //数据
      xueyuanXData: [], //横坐标
      xueyuanYData: [], //数据
      kechengXData: [], //横坐标
      kechengYData: [], //数据
      myChartStyle: { float: "left", width: "33%", height: "400px" }, //图表样式
      mychartxueyuan: { float: "right", width: "33%", height: "400px" }, //图表样式
      mychartkecheng: { float: "left", width: "33%", height: "400px" } //图表样式
    };
  },
  mounted() {
    this.jiaxiaocheliangList();
    this.jiaofeixinxiList();
    this.kechengList();
  },
  methods: {
    jiaxiaocheliangList() {
      this.$http({
        url: "yuyuexinxi/echartsData",
        data:{},
        method: "post",
      }).then(({ data }) => {
        this.xData = [];
        this.yData = [];
        for (let i = 0; i < data.data.length; i++) {
          this.xData[i] = data.data[i].zhuangtai;
          this.yData[i] = data.data[i].cheliangCount;

        }
        this.initEcharts();

      });

    },
    jiaofeixinxiList() {
      this.$http({
        url: "jiaofeixinxi/echartsData",
        data:{},
        method: "post",
      }).then(({ data }) => {
        this.xueyuanXData = [];
        this.xueyuanYData = [];
        for (let i = 0; i < data.data.length; i++) {
          this.xueyuanXData[i] = data.data[i].ispay;
          this.xueyuanYData[i] = data.data[i].xueyuanCount;

        }
        this.jiaofeiinitEcharts();

      });

    },
    kechengList() {
      this.$http({
        url: "kechengyuyue/echartsData",
        data:{},
        method: "post",
      }).then(({ data }) => {
        this.kechengXData = [];
        this.kechengYData = [];
        for (let i = 0; i < data.data.length; i++) {
          this.kechengXData[i] = data.data[i].kechengmingcheng;
          this.kechengYData[i] = data.data[i].xueyuanCount;

        }
        this.kechenginitEcharts();

      });

    },
    initEcharts() {
      // 基本柱状图
      const option = {
        title: {
          text: '车辆预约统计图'
        },
        xAxis: {
          data: this.xData
        },
        yAxis: {},
        series: [
          {
            type: "bar", //形状为柱状图
            data: this.yData
          }
        ]
      };
      const myChart = echarts.init(document.getElementById("mychart"));
      myChart.setOption(option);
      //随着屏幕大小调节图表
      window.addEventListener("resize", () => {
        myChart.resize();
      });
    },
    jiaofeiinitEcharts() {
      // 基本柱状图
      const option = {
        title: {
          text: '学员缴费统计图'
        },
        xAxis: {
          data: this.xueyuanXData
        },
        yAxis: {},
        series: [
          {
            type: "bar", //形状为柱状图
            data: this.xueyuanYData
          }
        ]
      };
      const myChart = echarts.init(document.getElementById("mychartxueyuan"));
      myChart.setOption(option);
      //随着屏幕大小调节图表
      window.addEventListener("resize", () => {
        myChart.resize();
      });
    },
    kechenginitEcharts() {
      // 基本柱状图
      const option = {
        title: {
          text: '课程预约统计图'
        },
        xAxis: {
          data: this.kechengXData
        },
        yAxis: {},
        series: [
          {
            type: "bar", //形状为柱状图
            data: this.kechengYData
          }
        ]
      };
      const myChart = echarts.init(document.getElementById("mychartkecheng"));
      myChart.setOption(option);
      //随着屏幕大小调节图表
      window.addEventListener("resize", () => {
        myChart.resize();
      });
    }
  }
};
</script>
