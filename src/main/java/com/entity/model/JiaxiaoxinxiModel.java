package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 驾校信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author
 * @email
 */
public class JiaxiaoxinxiModel implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 驾校地址
	 */

	private String jiaxiaodizhi;

	/**
	 * 封面
	 */

	private String fengmian;

	/**
	 * 学费
	 */

	private Float xuefei;

	/**
	 * 负责人
	 */

	private String fuzeren;

	/**
	 * 联系方式
	 */

	private String lianxifangshi;

	/**
	 * 成立时间
	 */

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date chenglishijian;

	/**
	 * 驾校简介
	 */

	private String jiaxiaojianjie;


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
	 * 设置：封面
	 */

	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}

	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}


	/**
	 * 设置：学费
	 */

	public void setXuefei(Float xuefei) {
		this.xuefei = xuefei;
	}

	/**
	 * 获取：学费
	 */
	public Float getXuefei() {
		return xuefei;
	}


	/**
	 * 设置：负责人
	 */

	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}

	/**
	 * 获取：负责人
	 */
	public String getFuzeren() {
		return fuzeren;
	}


	/**
	 * 设置：联系方式
	 */

	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}

	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}


	/**
	 * 设置：成立时间
	 */

	public void setChenglishijian(Date chenglishijian) {
		this.chenglishijian = chenglishijian;
	}

	/**
	 * 获取：成立时间
	 */
	public Date getChenglishijian() {
		return chenglishijian;
	}


	/**
	 * 设置：驾校简介
	 */

	public void setJiaxiaojianjie(String jiaxiaojianjie) {
		this.jiaxiaojianjie = jiaxiaojianjie;
	}

	/**
	 * 获取：驾校简介
	 */
	public String getJiaxiaojianjie() {
		return jiaxiaojianjie;
	}

}
