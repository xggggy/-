package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiaxiaocheliangEntity;
import com.entity.view.JiaxiaocheliangView;

import com.service.JiaxiaocheliangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 驾校车辆
 * 后端接口
 * @author
 * @email
 */
@RestController
@RequestMapping("/jiaxiaocheliang")
public class JiaxiaocheliangController {
    @Autowired
    private JiaxiaocheliangService jiaxiaocheliangService;

    @Autowired
    private StoreupService storeupService;




    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaxiaocheliangEntity jiaxiaocheliang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaxiaojiaolian")) {
			jiaxiaocheliang.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaxiaocheliangEntity> ew = new EntityWrapper<JiaxiaocheliangEntity>();

		PageUtils page = jiaxiaocheliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaxiaocheliang), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaxiaocheliangEntity jiaxiaocheliang,
		HttpServletRequest request){
        EntityWrapper<JiaxiaocheliangEntity> ew = new EntityWrapper<JiaxiaocheliangEntity>();

		PageUtils page = jiaxiaocheliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaxiaocheliang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaxiaocheliangEntity jiaxiaocheliang){
       	EntityWrapper<JiaxiaocheliangEntity> ew = new EntityWrapper<JiaxiaocheliangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaxiaocheliang, "jiaxiaocheliang"));
        return R.ok().put("data", jiaxiaocheliangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaxiaocheliangEntity jiaxiaocheliang){
        EntityWrapper< JiaxiaocheliangEntity> ew = new EntityWrapper< JiaxiaocheliangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaxiaocheliang, "jiaxiaocheliang"));
		JiaxiaocheliangView jiaxiaocheliangView =  jiaxiaocheliangService.selectView(ew);
		return R.ok("查询驾校车辆成功").put("data", jiaxiaocheliangView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaxiaocheliangEntity jiaxiaocheliang = jiaxiaocheliangService.selectById(id);
		jiaxiaocheliang.setClicknum(jiaxiaocheliang.getClicknum()+1);
		jiaxiaocheliangService.updateById(jiaxiaocheliang);
        return R.ok().put("data", jiaxiaocheliang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaxiaocheliangEntity jiaxiaocheliang = jiaxiaocheliangService.selectById(id);
		jiaxiaocheliang.setClicknum(jiaxiaocheliang.getClicknum()+1);
		jiaxiaocheliangService.updateById(jiaxiaocheliang);
        return R.ok().put("data", jiaxiaocheliang);
    }



    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        JiaxiaocheliangEntity jiaxiaocheliang = jiaxiaocheliangService.selectById(id);
        if(type.equals("1")) {
        	jiaxiaocheliang.setThumbsupnum(jiaxiaocheliang.getThumbsupnum()+1);
        } else {
        	jiaxiaocheliang.setCrazilynum(jiaxiaocheliang.getCrazilynum()+1);
        }
        jiaxiaocheliangService.updateById(jiaxiaocheliang);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaxiaocheliangEntity jiaxiaocheliang, HttpServletRequest request){
    	jiaxiaocheliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaxiaocheliang);
        jiaxiaocheliangService.insert(jiaxiaocheliang);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaxiaocheliangEntity jiaxiaocheliang, HttpServletRequest request){
    	jiaxiaocheliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaxiaocheliang);
        jiaxiaocheliangService.insert(jiaxiaocheliang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaxiaocheliangEntity jiaxiaocheliang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaxiaocheliang);
        jiaxiaocheliangService.updateById(jiaxiaocheliang);//全部更新
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaxiaocheliangService.deleteBatchIds(Arrays.asList(ids));
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

		Wrapper<JiaxiaocheliangEntity> wrapper = new EntityWrapper<JiaxiaocheliangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaxiaojiaolian")) {
			wrapper.eq("jiaolianzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = jiaxiaocheliangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}





}
