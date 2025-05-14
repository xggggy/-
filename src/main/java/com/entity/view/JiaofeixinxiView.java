package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.JiaofeixinxiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 缴费信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author
 * @email
 * @date 2022-11-07 20:39:39
 */
@TableName("jiaofeixinxi")
public class JiaofeixinxiView  extends JiaofeixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiaofeixinxiView(){
	}

 	public JiaofeixinxiView(JiaofeixinxiEntity jiaofeixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, jiaofeixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
