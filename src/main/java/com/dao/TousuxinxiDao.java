package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.TousuxinxiEntity;
import com.entity.TousuxinxiEntity;
import com.entity.view.TongzhixinxiView;
import com.entity.view.TousuxinxiView;
import com.entity.vo.TongzhixinxiVO;
import com.entity.vo.TousuxinxiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 投诉信息
 *
 * @author
 * @email
 */
public interface TousuxinxiDao extends BaseMapper<TousuxinxiEntity> {

	List<TousuxinxiVO> selectListVO(@Param("ew") Wrapper<TousuxinxiEntity> wrapper);

	TousuxinxiVO selectVO(@Param("ew") Wrapper<TousuxinxiEntity> wrapper);

	List<TousuxinxiView> selectListView(@Param("ew") Wrapper<TousuxinxiEntity> wrapper);

	List<TousuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<TousuxinxiEntity> wrapper);

	TousuxinxiView selectView(@Param("ew") Wrapper<TousuxinxiEntity> wrapper);


}
