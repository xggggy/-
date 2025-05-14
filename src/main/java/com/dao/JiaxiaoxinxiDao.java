package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.JiaxiaoxinxiEntity;
import com.entity.view.JiaxiaoxinxiView;
import com.entity.vo.JiaxiaoxinxiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 驾校信息
 *
 * @author
 * @email
 */
public interface JiaxiaoxinxiDao extends BaseMapper<JiaxiaoxinxiEntity> {

	List<JiaxiaoxinxiVO> selectListVO(@Param("ew") Wrapper<JiaxiaoxinxiEntity> wrapper);

	JiaxiaoxinxiVO selectVO(@Param("ew") Wrapper<JiaxiaoxinxiEntity> wrapper);

	List<JiaxiaoxinxiView> selectListView(@Param("ew") Wrapper<JiaxiaoxinxiEntity> wrapper);

	List<JiaxiaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiaxiaoxinxiEntity> wrapper);

	JiaxiaoxinxiView selectView(@Param("ew") Wrapper<JiaxiaoxinxiEntity> wrapper);


}
