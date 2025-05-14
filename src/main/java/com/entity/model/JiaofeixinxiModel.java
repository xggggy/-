package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 缴费信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author
 * @email
 * @date 2022-11-07 20:39:39
 */
public class JiaofeixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 驾校名称
	 */

	private String jiaxiaomingcheng;

	/**
	 * 驾校地址
	 */

	private String jiaxiaodizhi;

	/**
	 * 学费
	 */

	private String xuefei;

	/**
	 * 学员账号
	 */

	private String xueyuanzhanghao;

	/**
	 * 学员姓名
	 */

	private String xueyuanxingming;

	/**
	 * 缴费时间
	 */

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date jiaofeishijian;

	/**
	 * 备注
	 */

	private String beizhu;

	/**
	 * 是否支付
	 */

	private String ispay;


	/**
	 * 设置：驾校名称
	 */

	public void setJiaxiaomingcheng(String jiaxiaomingcheng) {
		this.jiaxiaomingcheng = jiaxiaomingcheng;
	}

	/**
	 * 获取：驾校名称
	 */
	public String getJiaxiaomingcheng() {
		return jiaxiaomingcheng;
	}


	/**
	 * 设置：驾校地址
	 */

	public void setJiaxiaodizhi(String jiaxiaodizhi) {
		this.jiaxiaodizhi = jiaxiaodizhi;
	}

	/**
	 * 获取：驾校地址
	 */
	public String getJiaxiaodizhi() {
		return jiaxiaodizhi;
	}


	/**
	 * 设置：学费
	 */

	public void setXuefei(String xuefei) {
		this.xuefei = xuefei;
	}

	/**
	 * 获取：学费
	 */
	public String getXuefei() {
		return xuefei;
	}


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
	 * 设置：缴费时间
	 */

	public void setJiaofeishijian(Date jiaofeishijian) {
		this.jiaofeishijian = jiaofeishijian;
	}

	/**
	 * 获取：缴费时间
	 */
	public Date getJiaofeishijian() {
		return jiaofeishijian;
	}


	/**
	 * 设置：备注
	 */

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}


	/**
	 * 设置：是否支付
	 */

	public void setIspay(String ispay) {
		this.ispay = ispay;
	}

	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
