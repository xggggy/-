package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.JiaxiaoxinxiEntity;
import com.entity.view.JiaxiaoxinxiView;
import com.entity.vo.JiaxiaoxinxiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 驾校信息
 *
 * @author
 * @email
 */
public interface JiaxiaoxinxiService extends IService<JiaxiaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<JiaxiaoxinxiVO> selectListVO(Wrapper<JiaxiaoxinxiEntity> wrapper);

   	JiaxiaoxinxiVO selectVO(@Param("ew") Wrapper<JiaxiaoxinxiEntity> wrapper);

   	List<JiaxiaoxinxiView> selectListView(Wrapper<JiaxiaoxinxiEntity> wrapper);

   	JiaxiaoxinxiView selectView(@Param("ew") Wrapper<JiaxiaoxinxiEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaxiaoxinxiEntity> wrapper);


}

