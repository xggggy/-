package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.TongzhixinxiEntity;
import com.entity.view.TongzhixinxiView;
import com.entity.vo.TongzhixinxiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 通知信息
 *
 * @author
 * @email
 * @date 2022-11-07 20:39:39
 */
public interface TongzhixinxiDao extends BaseMapper<TongzhixinxiEntity> {

	List<TongzhixinxiVO> selectListVO(@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);

	TongzhixinxiVO selectVO(@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);

	List<TongzhixinxiView> selectListView(@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);

	List<TongzhixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);

	TongzhixinxiView selectView(@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);


}
