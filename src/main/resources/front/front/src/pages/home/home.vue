<template>
<div class="home-preview" :style='{"width":"100%","margin":"10px auto","flexWrap":"wrap","justifyContent":"space-between","display":"flex"}'>


	<!-- 系统简介 -->
	<div :style='{"padding":"20px 0","margin":"0 auto","flexWrap":"wrap","background":"none","display":"block","width":"1200px","position":"relative","justifyContent":"space-between","height":"100px","order":"4"}'>
<!--	  <div :style='{"padding":"0 0 6px","color":"#333","top":"80px","textAlign":"center","left":"30px","background":"url(http://codegen.caihongy.cn/20221114/3385b5b1b2ee4976949806fc47f1bbe2.png) no-repeat left bottom","width":"auto","lineHeight":"1.5","fontSize":"30px","position":"absolute"}'>{{systemIntroductionDetail.title}}</div>-->
<!--	  <div :style='{"margin":"0 0 10px","color":"#999","top":"136px","textAlign":"center","left":"30px","width":"auto","lineHeight":"1.5","fontSize":"22px","position":"absolute"}'>{{systemIntroductionDetail.subtitle}}</div>-->
	  <div :style='{"padding":"0","margin":"60px 0 0 ","flexWrap":"wrap","textAlign":"right","background":"none","display":"flex","width":"40%","position":"relative","float":"right","height":"auto"}'>
<!--	    <img :style='{"boxShadow":"12px 12px 1px #eee","margin":"0px","objectFit":"cover","display":"block","width":"100%","position":"block","float":"right","height":"400px"}' :src="baseUrl + systemIntroductionDetail.picture1">-->
<!--	    <img :style='{"margin":"0px","objectFit":"cover","top":"50px","left":"-60%","display":"block","width":"70%","position":"absolute","height":"300px"}' :src="baseUrl + systemIntroductionDetail.picture2">-->
<!--	    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + systemIntroductionDetail.picture3">-->
	  </div>
<!--	  <div :style='{"border":"8px ridge rgba(189, 125, 71, 1)","padding":"110px 20px 20px","margin":"40px 0 10px 0","overflow":"hidden","color":"rgb(102, 102, 102)","background":"rgba(239,249,238,.5)","width":"30%","lineHeight":"24px","fontSize":"16px","textIndent":"2em","float":"left","height":"400px"}' v-html="systemIntroductionDetail.content"></div>-->
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	</div>

<div class="recommend" :style='{"width":"100%","padding":"0 0 50px","margin":"20px 0 20px","background":"#d8dbdf","order":"1","height":"auto"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>

    <div class="title" :style='{"width":"350px","padding":"0 0 20px","margin":"40px auto","lineHeight":"50px","textAlign":"center"}'>
		<span :style='{"color":"rgba(189, 125, 71, 1)","fontSize":"32px","fontWeight":"bold"}'>驾驶知识推荐</span>
	</div>



	<!-- 样式二 -->
	<div class="list list2 index-pv1" :style='{"border":"0px ridge rgba(189, 125, 71, 1)","padding":"20px 0px 0","boxShadow":"inset 0px 0px 0px 0px rgba(189, 125, 71, 1)","margin":"20px auto 0 auto","borderRadius":"12px","flexWrap":"wrap","background":"none","display":"flex","width":"1200px","justifyContent":"space-between","height":"auto"}'>
		<div :style='{"cursor":"pointer","boxShadow":"0 2px 4px rgba(0,0,0,.1)","padding":"0 0 8px","margin":"0 0 20px","borderRadius":"8px","background":"#fff","display":"inline-block","width":"275px","fontSize":"0","position":"relative","height":"auto"}' v-for="(item,index) in jiashizhishiRecommend" class="list-item animation-box" :key="index" @click="toDetail('jiashizhishiDetail', item)">
			<img :style='{"width":"275px","objectFit":"cover","borderRadius":"8px 8px 0 0","display":"inline-block","height":"275px"}' v-if="item.fengmiantu.substr(0,4)=='http'" :src="item.fengmiantu.split(',')[0]" alt="" />
			<img :style='{"width":"275px","objectFit":"cover","borderRadius":"8px 8px 0 0","display":"inline-block","height":"275px"}' v-else :src="baseUrl + (item.fengmiantu?item.fengmiantu.split(',')[0]:'')" alt="" />
			<div class="item-info" :style='{"width":"100%","padding":"0 12px","overflow":"hidden","background":"#fff","display":"inline-block","height":"auto"}'>
				<div class="name line1" :style='{"color":"#333","lineHeight":"30px","fontSize":"14px"}'>{{item.biaoti}}</div>
				<div class="name line1" :style='{"color":"#333","lineHeight":"30px","fontSize":"14px"}'>{{item.biaoqian}}</div>
				<div class="name line1" :style='{"color":"#333","lineHeight":"30px","fontSize":"14px"}'>{{item.kemu}}</div>
			</div>
		</div>
	</div>








	<div @click="moreBtn('jiashizhishi')" :style='{"border":"0","cursor":"pointer","boxShadow":"0 4px 6px rgba(0,0,0,.2)","margin":"20px auto","textAlign":"center","background":"rgba(189, 125, 71, 1)","display":"block","width":"161px","lineHeight":"40px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"16px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"16px"}' class="el-icon-d-arrow-right"></i>
	</div>

</div>


<div class="news" :style='{"width":"100%","padding":"40px 0 60px","margin":"-80px 0 10px","background":"#d8dbdf","order":"5"}'>
	<div v-if="false" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>

	<div class="title" :style='{"width":"350px","padding":"0 0 20px","margin":"20px auto 50px","lineHeight":"50px","textAlign":"center"}'>
		<span :style='{"color":"rgba(189, 125, 71, 1)","fontSize":"32px","fontWeight":"bold"}'>驾校公告</span>
	</div>









	<!-- 样式八 -->
	<div v-if="newsList.length" class="list list8 index-pv1" :style='{"padding":"0px","margin":"0 auto","flexWrap":"wrap","background":"none","display":"flex","width":"1200px","justifyContent":"space-between","height":"auto"}'>
	  <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" :style='{"cursor":"pointer","padding":"0px","margin":"0 0px 24px","borderRadius":"8px","background":"#fff","display":"flex","width":"49%","height":"auto"}' class="list-item animation-box">
	    <div :style='{"padding":"20px 30px","borderRadius":"0 8px 8px 0","background":"url(http://codegen.caihongy.cn/20221115/98c8979411ac40ec84ef25dced228936.jpg) no-repeat center top","width":"100%","backgroundSize":"100% 100%","height":"210px","order":"2"}'>
	      <div :style='{"whiteSpace":"nowrap","overflow":"hidden","color":"#333","fontSize":"14px","lineHeight":"26px","textOverflow":"ellipsis","fontWeight":"bold"}'>{{newsList[0].title}}</div>
	      <div :style='{"overflow":"hidden","color":"#666","background":"none","fontSize":"14px","lineHeight":"24px","textIndent":"2em","height":"120px"}'>{{newsList[0].introduction}}</div>
	      <div :style='{"color":"#999","fontSize":"12px","lineHeight":"20px"}'>{{newsList[0].addtime.split(" ")[0]}}</div>
	    </div>
	    <img :style='{"width":"180px","objectFit":"cover","borderRadius":"8px 0 0 8px","height":"210px"}' :src="baseUrl + newsList[0].picture" >
	  </div>
	  <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" :style='{"cursor":"pointer","padding":"0px","margin":"0 0px 24px","borderRadius":"8px","background":"#fff","display":"flex","width":"49%","height":"auto"}' class="list-item animation-box">
	    <img :style='{"width":"180px","objectFit":"cover","borderRadius":"8px 0 0 8px","height":"210px"}' :src="baseUrl + newsList[1].picture" >
	    <div :style='{"width":"100%","padding":"20px 30px","backgroundSize":"100% 100%","borderRadius":"0 8px 8px 0","background":"url(http://codegen.caihongy.cn/20221115/98c8979411ac40ec84ef25dced228936.jpg) no-repeat center top","height":"210px"}'>
	      <div :style='{"whiteSpace":"nowrap","overflow":"hidden","color":"#333","fontSize":"14px","lineHeight":"26px","textOverflow":"ellipsis","fontWeight":"bold"}'>{{newsList[1].title}}</div>
	      <div :style='{"fontSize":"14px","lineHeight":"24px","overflow":"hidden","color":"#666","textIndent":"2em","height":"120px"}'>{{newsList[1].introduction}}</div>
	      <div :style='{"color":"#999","fontSize":"12px","lineHeight":"24px"}'>{{newsList[1].addtime.split(" ")[0]}}</div>
	    </div>
	  </div>
	  <div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" :style='{"cursor":"pointer","padding":"0px","margin":"0 0px","borderRadius":"8px","background":"#fff","display":"flex","width":"49%","height":"auto"}' class="list-item animation-box">
	    <div :style='{"padding":"20px 30px","borderRadius":"0 8px 8px 0","background":"url(http://codegen.caihongy.cn/20221115/98c8979411ac40ec84ef25dced228936.jpg) no-repeat center top","width":"100%","backgroundSize":"100% 100%","height":"210px","order":"2"}'>
	      <div :style='{"whiteSpace":"nowrap","overflow":"hidden","color":"#333","fontSize":"14px","lineHeight":"26px","textOverflow":"ellipsis","fontWeight":"bold"}'>{{newsList[2].title}}</div>
	      <div :style='{"fontSize":"14px","lineHeight":"24px","overflow":"hidden","color":"#666","textIndent":"2em","height":"120px"}'>{{newsList[2].introduction}}</div>
	      <div :style='{"color":"#999","fontSize":"12px","lineHeight":"24px"}'>{{newsList[2].addtime.split(" ")[0]}}</div>
	    </div>
	    <img :style='{"width":"180px","objectFit":"cover","borderRadius":"8px 0 0 8px","height":"210px"}' :src="baseUrl + newsList[2].picture" >
	  </div>
	  <div @click="toDetail('newsDetail', newsList[3])" v-if="newsList.length>3" :style='{"cursor":"pointer","padding":"0px","margin":"0 0px","borderRadius":"8px","background":"#fff","display":"flex","width":"49%","height":"auto"}' class="list-item animation-box">
	    <img :style='{"width":"180px","objectFit":"cover","borderRadius":"8px 0 0 8px","height":"210px"}' :src="baseUrl + newsList[3].picture" >
	    <div :style='{"width":"100%","padding":"20px 30px","backgroundSize":"100% 100%","borderRadius":"0 8px 8px 0","background":"url(http://codegen.caihongy.cn/20221115/98c8979411ac40ec84ef25dced228936.jpg) no-repeat center top","height":"210px"}'>
	      <div :style='{"whiteSpace":"nowrap","overflow":"hidden","color":"#333","fontSize":"14px","lineHeight":"26px","textOverflow":"ellipsis","fontWeight":"bold"}'>{{newsList[3].title}}</div>
	      <div :style='{"fontSize":"14px","lineHeight":"24px","overflow":"hidden","color":"#666","textIndent":"2em","height":"120px"}'>{{newsList[3].introduction}}</div>
	      <div :style='{"color":"#999","fontSize":"12px","lineHeight":"24px"}'>{{newsList[3].addtime.split(" ")[0]}}</div>
	    </div>
	  </div>
	</div>



	<div @click="moreBtn('news')" :style='{"border":"0","margin":"50px auto 0","textAlign":"center","background":"rgba(189, 125, 71, 1)","display":"block","width":"161px","lineHeight":"40px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>

</div>


<div class="lists" :style='{"width":"100%","padding":"0","margin":"20px 0 0px","background":"none","order":"2"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>

	<div class="title" :style='{"width":"350px","padding":"0 0 20px","margin":"20px auto 30px","lineHeight":"50px","textAlign":"center"}'>
	  <span :style='{"color":"rgba(189, 125, 71, 1)","fontSize":"32px","fontWeight":"bold"}'>驾校车辆展示</span>
	</div>




	<!-- 样式三 -->
	<div class="list list3 index-pv1">
		<div class="swiper-container" id="listsjiaxiaocheliang" :style='{"padding":"20px 10px","boxShadow":"rgba(189, 125, 71, 1)rgba(189, 125, 71, 1)","borderColor":"rgba(189, 125, 71, 1)","borderRadius":"8px","background":"#fff","borderWidth":"6px","width":"1200px","borderStyle":"groove double solid double","height":"auto"}'>
			<div class="swiper-wrapper">
				<div class="swiper-slide animation-box" :style='{"border":"0","cursor":"pointer","padding":"0 0 8px","boxShadow":"0 1px 2px rgba(0,0,0,.1)","borderRadius":"8px","background":"#fff","fontSize":"0","position":"relative"}' v-for="(item,index) in jiaxiaocheliangList" :key="index" @click="toDetail('jiaxiaocheliangDetail', item)">
					<img :name="item.id" :style='{"border":"0","width":"100%","borderRadius":"8px 8px 0 0","height":"240px"}' v-if="item.cheliangtupian.substr(0,4)=='http'" :src="item.cheliangtupian.split(',')[0]" alt="" />
					<img :name="item.id" :style='{"border":"0","width":"100%","borderRadius":"8px 8px 0 0","height":"240px"}' v-else :src="baseUrl + (item.cheliangtupian?item.cheliangtupian.split(',')[0]:'')" alt="" />
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333","background":"#fff"}'>{{item.cheliangmingcheng}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333","background":"#fff"}'>{{item.cheliangzhuangkuang}}</div>
            </div>
        </div>
			<!-- 如果需要导航按钮 -->
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>







	<div @click="moreBtn('jiaxiaocheliang')" :style='{"border":"0","boxShadow":"0 4px 6px rgba(0,0,0,.2)","margin":"30px auto","textAlign":"center","background":"rgba(189, 125, 71, 1)","display":"block","width":"161px","lineHeight":"40px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>


</div>
<div class="lists" :style='{"width":"100%","padding":"0","margin":"20px 0 0px","background":"none","order":"2"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>

	<div class="title" :style='{"width":"350px","padding":"0 0 20px","margin":"20px auto 30px","lineHeight":"50px","textAlign":"center"}'>
	  <span :style='{"color":"rgba(189, 125, 71, 1)","fontSize":"32px","fontWeight":"bold"}'>考试安排展示</span>
	</div>




	<!-- 样式三 -->
	<div class="list list3 index-pv1">
		<div class="swiper-container" id="listskaoshianpai" :style='{"padding":"20px 10px","boxShadow":"rgba(189, 125, 71, 1)rgba(189, 125, 71, 1)","borderColor":"rgba(189, 125, 71, 1)","borderRadius":"8px","background":"#fff","borderWidth":"6px","width":"1200px","borderStyle":"groove double solid double","height":"auto"}'>
			<div class="swiper-wrapper">
				<div class="swiper-slide animation-box" :style='{"border":"0","cursor":"pointer","padding":"0 0 8px","boxShadow":"0 1px 2px rgba(0,0,0,.1)","borderRadius":"8px","background":"#fff","fontSize":"0","position":"relative"}' v-for="(item,index) in kaoshianpaiList" :key="index" @click="toDetail('kaoshianpaiDetail', item)">
					<img :name="item.id" :style='{"border":"0","width":"100%","borderRadius":"8px 8px 0 0","height":"240px"}' v-if="item.fengmian.substr(0,4)=='http'" :src="item.fengmian.split(',')[0]" alt="" />
					<img :name="item.id" :style='{"border":"0","width":"100%","borderRadius":"8px 8px 0 0","height":"240px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333","background":"#fff"}'>{{item.kaoshikemu}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333","background":"#fff"}'>考试费用:{{item.kaoshifeiyong}}</div>
            </div>
        </div>
			<!-- 如果需要导航按钮 -->
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>







	<div @click="moreBtn('kaoshianpai')" :style='{"border":"0","boxShadow":"0 4px 6px rgba(0,0,0,.2)","margin":"30px auto","textAlign":"center","background":"rgba(189, 125, 71, 1)","display":"block","width":"161px","lineHeight":"40px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>


</div>
<div class="lists" :style='{"width":"100%","padding":"0","margin":"20px 0 0px","background":"none","order":"2"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>

	<div class="title" :style='{"width":"350px","padding":"0 0 20px","margin":"20px auto 30px","lineHeight":"50px","textAlign":"center"}'>
	  <span :style='{"color":"rgba(189, 125, 71, 1)","fontSize":"32px","fontWeight":"bold"}'>驾驶知识展示</span>
	</div>




	<!-- 样式三 -->
	<div class="list list3 index-pv1">
		<div class="swiper-container" id="listsjiashizhishi" :style='{"padding":"20px 10px","boxShadow":"rgba(189, 125, 71, 1)rgba(189, 125, 71, 1)","borderColor":"rgba(189, 125, 71, 1)","borderRadius":"8px","background":"#fff","borderWidth":"6px","width":"1200px","borderStyle":"groove double solid double","height":"auto"}'>
			<div class="swiper-wrapper">
				<div class="swiper-slide animation-box" :style='{"border":"0","cursor":"pointer","padding":"0 0 8px","boxShadow":"0 1px 2px rgba(0,0,0,.1)","borderRadius":"8px","background":"#fff","fontSize":"0","position":"relative"}' v-for="(item,index) in jiashizhishiList" :key="index" @click="toDetail('jiashizhishiDetail', item)">
					<img :name="item.id" :style='{"border":"0","width":"100%","borderRadius":"8px 8px 0 0","height":"240px"}' v-if="item.fengmiantu.substr(0,4)=='http'" :src="item.fengmiantu.split(',')[0]" alt="" />
					<img :name="item.id" :style='{"border":"0","width":"100%","borderRadius":"8px 8px 0 0","height":"240px"}' v-else :src="baseUrl + (item.fengmiantu?item.fengmiantu.split(',')[0]:'')" alt="" />
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333","background":"#fff"}'>{{item.biaoti}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333","background":"#fff"}'>{{item.biaoqian}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333","background":"#fff"}'>{{item.kemu}}</div>
            </div>
        </div>
			<!-- 如果需要导航按钮 -->
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>







	<div @click="moreBtn('jiashizhishi')" :style='{"border":"0","boxShadow":"0 4px 6px rgba(0,0,0,.2)","margin":"30px auto","textAlign":"center","background":"rgba(189, 125, 71, 1)","display":"block","width":"161px","lineHeight":"40px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>


</div>


</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        systemIntroductionDetail: {},
        newsList: [],
        jiashizhishiRecommend: [],

        jiaxiaocheliangList: [],
        kaoshianpaiList: [],
        jiashizhishiList: [],
      }
    },
    created() {
      this.baseUrl = this.$config.baseUrl;
      this.getNewsList();
      this.getSystemIntroduction();
      this.getList();
    },
    //方法集合
    methods: {
      getSystemIntroduction() {
          this.$http.get('systemintro/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.systemIntroductionDetail = res.data.data;
            }
          })
      },
		getNewsList() {
			this.$http.get('news/list', {params: {
				page: 1,
				limit: 4,
			order: 'desc'}}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;


				}
			});
		},
		getList() {
          let autoSortUrl = "";
          autoSortUrl = "jiashizhishi/autoSort";
			this.$http.get(autoSortUrl, {params: {
				page: 1,
				limit: 8,
			}}).then(res => {
				if (res.data.code == 0) {
					this.jiashizhishiRecommend = res.data.data.list;


					// 商品列表样式五

				}
			});

			this.$http.get('jiaxiaocheliang/list', {params: {
				page: 1,
				limit: 10,
			}}).then(res => {
				if (res.data.code == 0) {
					this.jiaxiaocheliangList = res.data.data.list;
					let options = {"observer":true,"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"observeParents":true,"loop":true,"slidesPerView":"5","speed":500,"spaceBetween":20,"autoplay":{"delay":3000,"disableOnInteraction":false}}
					options.pagination = {el:'null'}
					if(options.slidesPerView) {
						options.slidesPerView = Number(options.slidesPerView);
					}
					if(options.spaceBetween) {
						options.spaceBetween = Number(options.spaceBetween);
					}
					this.$nextTick(() => {
						new Swiper ('#listsjiaxiaocheliang', options)
					})

					// 商品列表样式五

				}
			});
			this.$http.get('kaoshianpai/list', {params: {
				page: 1,
				limit: 10,
			}}).then(res => {
				if (res.data.code == 0) {
					this.kaoshianpaiList = res.data.data.list;
					let options = {"observer":true,"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"observeParents":true,"loop":true,"slidesPerView":"5","speed":500,"spaceBetween":20,"autoplay":{"delay":3000,"disableOnInteraction":false}}
					options.pagination = {el:'null'}
					if(options.slidesPerView) {
						options.slidesPerView = Number(options.slidesPerView);
					}
					if(options.spaceBetween) {
						options.spaceBetween = Number(options.spaceBetween);
					}
					this.$nextTick(() => {
						new Swiper ('#listskaoshianpai', options)
					})

					// 商品列表样式五

				}
			});
			this.$http.get('jiashizhishi/list', {params: {
				page: 1,
				limit: 10,
			}}).then(res => {
				if (res.data.code == 0) {
					this.jiashizhishiList = res.data.data.list;
					let options = {"observer":true,"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"observeParents":true,"loop":true,"slidesPerView":"5","speed":500,"spaceBetween":20,"autoplay":{"delay":3000,"disableOnInteraction":false}}
					options.pagination = {el:'null'}
					if(options.slidesPerView) {
						options.slidesPerView = Number(options.slidesPerView);
					}
					if(options.spaceBetween) {
						options.spaceBetween = Number(options.spaceBetween);
					}
					this.$nextTick(() => {
						new Swiper ('#listsjiashizhishi', options)
					})

					// 商品列表样式五

				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {detailObj: JSON.stringify(item)}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {

		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}

			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}

			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}

			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}

			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}

			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }

        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}

			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}

			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}

				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}

				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}

			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}

			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1.01) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}

			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}

			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}

		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}

			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}

			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}

			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}

			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}

			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}

			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}

			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}

			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}

			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1.01) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}

			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}

			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}

		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}

			.list3 .swiper-button-prev::after {
				color: rgba(189, 125, 71, 1);
			}

			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }

        .list3 .swiper-button-next::after {
				color: rgba(189, 125, 71, 1);
			}

			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}

			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}

			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}

			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}

			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}

				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}

				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}

			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}

			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1.01) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}

			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}

			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
</style>
