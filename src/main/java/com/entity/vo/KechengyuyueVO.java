package com.entity.vo;

import java.io.Serializable;


/**
 * 课程信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author
 * @email
 */
public class KechengyuyueVO implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 课程名称
	 */

	private String kechengmingcheng;

	/**
	 * 上课时间
	 */

	private String shangkeshijian;

	/**
	 * 上课地点
	 */

	private String shangkedidian;

	/**
	 * 课程图片
	 */

	private String kechengtupian;

	/**
	 * 课程视频
	 */

	private String kechengshipin;

	/**
	 * 教练账号
	 */

	private String jiaolianzhanghao;

	/**
	 * 教练姓名
	 */

	private String jiaolianxingming;

	/**
	 * 学员账号
	 */

	private String xueyuanzhanghao;

	/**
	 * 学员姓名
	 */

	private String xueyuanxingming;

	/**
	 * 课程介绍
	 */

	private String kechengjieshao;

	/**
	 * 是否审核
	 */

	private String sfsh;

	/**
	 * 审核回复
	 */

	private String shhf;


	/**
	 * 设置：课程名称
	 */

	public void setKechengmingcheng(String kechengmingcheng) {
		this.kechengmingcheng = kechengmingcheng;
	}

	/**
	 * 获取：课程名称
	 */
	public String getKechengmingcheng() {
		return kechengmingcheng;
	}


	/**
	 * 设置：上课时间
	 */

	public void setShangkeshijian(String shangkeshijian) {
		this.shangkeshijian = shangkeshijian;
	}

	/**
	 * 获取：上课时间
	 */
	public String getShangkeshijian() {
		return shangkeshijian;
	}


	/**
	 * 设置：上课地点
	 */

	public void setShangkedidian(String shangkedidian) {
		this.shangkedidian = shangkedidian;
	}

	/**
	 * 获取：上课地点
	 */
	public String getShangkedidian() {
		return shangkedidian;
	}


	/**
	 * 设置：课程图片
	 */

	public void setKechengtupian(String kechengtupian) {
		this.kechengtupian = kechengtupian;
	}

	/**
	 * 获取：课程图片
	 */
	public String getKechengtupian() {
		return kechengtupian;
	}


	/**
	 * 设置：课程视频
	 */

	public void setKechengshipin(String kechengshipin) {
		this.kechengshipin = kechengshipin;
	}

	/**
	 * 获取：课程视频
	 */
	public String getKechengshipin() {
		return kechengshipin;
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
	 * 设置：课程介绍
	 */

	public void setKechengjieshao(String kechengjieshao) {
		this.kechengjieshao = kechengjieshao;
	}

	/**
	 * 获取：课程介绍
	 */
	public String getKechengjieshao() {
		return kechengjieshao;
	}

	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
