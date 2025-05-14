package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.TongzhixinxiEntity;
import com.entity.view.TongzhixinxiView;
import com.entity.vo.TongzhixinxiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 通知信息
 *
 * @author
 * @email
 * @date 2022-11-07 20:39:39
 */
public interface TongzhixinxiService extends IService<TongzhixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<TongzhixinxiVO> selectListVO(Wrapper<TongzhixinxiEntity> wrapper);

   	TongzhixinxiVO selectVO(@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);

   	List<TongzhixinxiView> selectListView(Wrapper<TongzhixinxiEntity> wrapper);

   	TongzhixinxiView selectView(@Param("ew") Wrapper<TongzhixinxiEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<TongzhixinxiEntity> wrapper);


}

