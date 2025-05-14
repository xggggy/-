package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.TongzhixinxiEntity;
import com.entity.TousuxinxiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 投诉信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author
 * @email
 */
@TableName("tousuxinxi")
public class TousuxinxiView extends TousuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TousuxinxiView(){
	}

 	public TousuxinxiView(TousuxinxiEntity tousuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, tousuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
