package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.TousuxinxiEntity;
import com.entity.TousuxinxiEntity;
import com.entity.view.TousuxinxiView;
import com.entity.view.TousuxinxiView;
import com.entity.vo.TousuxinxiVO;
import com.entity.vo.TousuxinxiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 投诉信息
 *
 * @author
 * @email
 */
public interface TousuxinxiService extends IService<TousuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<TousuxinxiVO> selectListVO(Wrapper<TousuxinxiEntity> wrapper);

   	TousuxinxiVO selectVO(@Param("ew") Wrapper<TousuxinxiEntity> wrapper);

   	List<TousuxinxiView> selectListView(Wrapper<TousuxinxiEntity> wrapper);

   	TousuxinxiView selectView(@Param("ew") Wrapper<TousuxinxiEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<TousuxinxiEntity> wrapper);


}

