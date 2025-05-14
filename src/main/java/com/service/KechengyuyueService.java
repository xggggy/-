package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ExamrecordEntity;
import com.entity.KechengyuyueEntity;
import com.entity.KechengyuyueEntity;
import com.entity.view.KechengxinxiView;
import com.entity.view.KechengyuyueView;
import com.entity.vo.KechengxinxiVO;
import com.entity.vo.KechengyuyueVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 课程信息
 *
 * @author
 * @email
 */
public interface KechengyuyueService extends IService<KechengyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<KechengyuyueVO> selectListVO(Wrapper<KechengyuyueEntity> wrapper);

	KechengyuyueVO selectVO(@Param("ew") Wrapper<KechengyuyueEntity> wrapper);

   	List<KechengyuyueView> selectListView(Wrapper<KechengyuyueEntity> wrapper);

	KechengyuyueView selectView(@Param("ew") Wrapper<KechengyuyueEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengyuyueEntity> wrapper);

	List<Map<String,Object>> echartData();
//	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ExamrecordEntity> wrapper);

}

