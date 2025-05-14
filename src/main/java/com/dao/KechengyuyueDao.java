package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ExamrecordEntity;
import com.entity.KechengyuyueEntity;
import com.entity.KechengyuyueEntity;
import com.entity.view.ExamrecordView;
import com.entity.view.KechengxinxiView;
import com.entity.view.KechengyuyueView;
import com.entity.vo.KechengxinxiVO;
import com.entity.vo.KechengyuyueVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 课程信息
 *
 * @author
 * @email
 * @date 2022-11-07 20:39:39
 */
public interface KechengyuyueDao extends BaseMapper<KechengyuyueEntity> {

	List<KechengyuyueVO> selectListVO(@Param("ew") Wrapper<KechengyuyueEntity> wrapper);

	KechengyuyueVO selectVO(@Param("ew") Wrapper<KechengyuyueEntity> wrapper);

	List<KechengyuyueView> selectListView(@Param("ew") Wrapper<KechengyuyueEntity> wrapper);

	List<KechengyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<KechengyuyueEntity> wrapper);

	KechengyuyueView selectView(@Param("ew") Wrapper<KechengyuyueEntity> wrapper);

	List<Map<String,Object>> echartData();

//	List<ExamrecordView> selectGroupBy(Pagination page, @Param("ew") Wrapper<ExamrecordEntity> wrapper);

}
