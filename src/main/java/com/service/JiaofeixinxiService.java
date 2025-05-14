package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.JiaofeixinxiEntity;
import com.entity.view.JiaofeixinxiView;
import com.entity.vo.JiaofeixinxiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 缴费信息
 *
 * @author
 * @email
 */
public interface JiaofeixinxiService extends IService<JiaofeixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<JiaofeixinxiVO> selectListVO(Wrapper<JiaofeixinxiEntity> wrapper);

   	JiaofeixinxiVO selectVO(@Param("ew") Wrapper<JiaofeixinxiEntity> wrapper);

   	List<JiaofeixinxiView> selectListView(Wrapper<JiaofeixinxiEntity> wrapper);

   	JiaofeixinxiView selectView(@Param("ew") Wrapper<JiaofeixinxiEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaofeixinxiEntity> wrapper);

	List<Map<String,Object>> echartData();
}

