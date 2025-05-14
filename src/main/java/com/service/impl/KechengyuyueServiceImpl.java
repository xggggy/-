package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.KechengxinxiDao;
import com.dao.KechengyuyueDao;
import com.entity.ExamrecordEntity;
import com.entity.KechengyuyueEntity;
import com.entity.view.ExamrecordView;
import com.entity.view.KechengyuyueView;
import com.entity.view.KechengyuyueView;
import com.entity.vo.KechengxinxiVO;
import com.entity.vo.KechengyuyueVO;
import com.service.KechengxinxiService;
import com.service.KechengyuyueService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("kechengyuyueService")
public class KechengyuyueServiceImpl extends ServiceImpl<KechengyuyueDao, KechengyuyueEntity> implements KechengyuyueService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengyuyueEntity> page = this.selectPage(
                new Query<KechengyuyueEntity>(params).getPage(),
                new EntityWrapper<KechengyuyueEntity>()
        );
        return new PageUtils(page);
    }

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengyuyueEntity> wrapper) {
		  Page<KechengyuyueView> page =new Query<KechengyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
	public List<KechengyuyueVO> selectListVO(Wrapper<KechengyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public KechengyuyueVO selectVO(Wrapper<KechengyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<KechengyuyueView> selectListView(Wrapper<KechengyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengyuyueView selectView(Wrapper<KechengyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

	@Override
	public List<Map<String, Object>> echartData() {
		return baseMapper.echartData();
	}

	/*@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ExamrecordEntity> wrapper) {
		Page<ExamrecordView> page =new Query<ExamrecordView>(params).getPage();
		page.setRecords(baseMapper.selectGroupBy(page,wrapper));
		PageUtils pageUtil = new PageUtils(page);
		return pageUtil;
	}*/
}
