package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.TousuxinxiEntity;
import com.entity.XueyuanEntity;
import com.entity.view.TousuxinxiView;
import com.service.TousuxinxiService;
import com.service.XueyuanService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 投诉信息
 * 后端接口
 * @author
 * @email
 */
@RestController
@RequestMapping("/tousuxinxi")
public class TousuxinxiController {
    @Autowired
    private TousuxinxiService tousuxinxiService;

	@Autowired
	private XueyuanService xueyuanService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, TousuxinxiEntity tousuxinxi,
				  HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xueyuan")) {
			tousuxinxi.setXueyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TousuxinxiEntity> ew = new EntityWrapper<TousuxinxiEntity>();


		PageUtils page = tousuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tousuxinxi), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TousuxinxiEntity tousuxinxi,
		HttpServletRequest request){
        EntityWrapper<TousuxinxiEntity> ew = new EntityWrapper<TousuxinxiEntity>();

		PageUtils page = tousuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tousuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TousuxinxiEntity tousuxinxi){
       	EntityWrapper<TousuxinxiEntity> ew = new EntityWrapper<TousuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tousuxinxi, "tousuxinxi"));
        return R.ok().put("data", tousuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TousuxinxiEntity tousuxinxi){
        EntityWrapper< TousuxinxiEntity> ew = new EntityWrapper< TousuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tousuxinxi, "tousuxinxi"));
		TousuxinxiView tousuxinxiView =  tousuxinxiService.selectView(ew);
		return R.ok("查询投诉信息成功").put("data", tousuxinxiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TousuxinxiEntity tousuxinxi = tousuxinxiService.selectById(id);
        return R.ok().put("data", tousuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TousuxinxiEntity tousuxinxi = tousuxinxiService.selectById(id);
        return R.ok().put("data", tousuxinxi);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TousuxinxiEntity tousuxinxi, HttpServletRequest request){
    	tousuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tousuxinxi);

        tousuxinxiService.insert(tousuxinxi);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TousuxinxiEntity tousuxinxi, HttpServletRequest request){
    	tousuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		tousuxinxi.setTousushijian(new Date());
		tousuxinxi.setXueyuanzhanghao((String) request.getSession().getAttribute("username"));
		tousuxinxi.setXueyuanxingming(xueyuanService.selectView(new EntityWrapper<XueyuanEntity>().eq("xueyuanxingming",request.getSession().getAttribute("username"))).getXueyuanxingming());
        tousuxinxiService.insert(tousuxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TousuxinxiEntity tousuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tousuxinxi);
        tousuxinxiService.updateById(tousuxinxi);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tousuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    @RequestMapping("/chexiao/{id}")
    public R chexiao(@PathVariable("id") Long id){
       TousuxinxiEntity tousuxinxi = tousuxinxiService.selectById(id);
	   if("已处理".equals(tousuxinxi.getZhuangtai())){
		   return R.error("该投诉已处理，不可再撤销！");
	   }else{
		   return R.ok();
	   }
    }
    @RequestMapping("/chuli/{id}")
    public R chuli(@PathVariable("id") Long id){
       	TousuxinxiEntity tousuxinxi = tousuxinxiService.selectById(id);
		tousuxinxi.setZhuangtai("已处理");

		tousuxinxiService.updateById(tousuxinxi);

		return R.ok();
    }

    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);

		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}

		Wrapper<TousuxinxiEntity> wrapper = new EntityWrapper<TousuxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xueyuan")) {
			wrapper.eq("xueyuanzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaolian")) {
			wrapper.eq("jiaolianzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = tousuxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}









}
