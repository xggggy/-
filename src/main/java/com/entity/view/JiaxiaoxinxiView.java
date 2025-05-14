package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.JiaxiaoxinxiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 驾校信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author
 * @email
 */
@TableName("jiaxiaoxinxi")
public class JiaxiaoxinxiView extends JiaxiaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiaxiaoxinxiView(){
	}

 	public JiaxiaoxinxiView(JiaxiaoxinxiEntity jiaxiaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, jiaxiaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
