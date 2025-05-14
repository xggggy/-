package com.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 通知信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author
 * @email
 * @date 2022-11-07 20:39:39
 */
public class TongzhixinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 学员账号
	 */

	private String xueyuanzhanghao;

	/**
	 * 学员姓名
	 */

	private String xueyuanxingming;

	/**
	 * 通知时间
	 */

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date tongzhishijian;

	/**
	 * 通知内容
	 */

	private String tongzhineirong;

	/**
	 * 教练账号
	 */

	private String jiaolianzhanghao;

	/**
	 * 教练姓名
	 */

	private String jiaolianxingming;


	/**
	 * 设置：学员账号
	 */

	public void setXueyuanzhanghao(String xueyuanzhanghao) {
		this.xueyuanzhanghao = xueyuanzhanghao;
	}

	/**
	 * 获取：学员账号
	 */
	public String getXueyuanzhanghao() {
		return xueyuanzhanghao;
	}


	/**
	 * 设置：学员姓名
	 */

	public void setXueyuanxingming(String xueyuanxingming) {
		this.xueyuanxingming = xueyuanxingming;
	}

	/**
	 * 获取：学员姓名
	 */
	public String getXueyuanxingming() {
		return xueyuanxingming;
	}


	/**
	 * 设置：通知时间
	 */

	public void setTongzhishijian(Date tongzhishijian) {
		this.tongzhishijian = tongzhishijian;
	}

	/**
	 * 获取：通知时间
	 */
	public Date getTongzhishijian() {
		return tongzhishijian;
	}


	/**
	 * 设置：通知内容
	 */

	public void setTongzhineirong(String tongzhineirong) {
		this.tongzhineirong = tongzhineirong;
	}

	/**
	 * 获取：通知内容
	 */
	public String getTongzhineirong() {
		return tongzhineirong;
	}


	/**
	 * 设置：教练账号
	 */

	public void setJiaolianzhanghao(String jiaolianzhanghao) {
		this.jiaolianzhanghao = jiaolianzhanghao;
	}

	/**
	 * 获取：教练账号
	 */
	public String getJiaolianzhanghao() {
		return jiaolianzhanghao;
	}


	/**
	 * 设置：教练姓名
	 */

	public void setJiaolianxingming(String jiaolianxingming) {
		this.jiaolianxingming = jiaolianxingming;
	}

	/**
	 * 获取：教练姓名
	 */
	public String getJiaolianxingming() {
		return jiaolianxingming;
	}

}
