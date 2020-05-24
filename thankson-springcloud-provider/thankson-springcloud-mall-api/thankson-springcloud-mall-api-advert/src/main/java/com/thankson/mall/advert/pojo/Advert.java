package com.thankson.mall.advert.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * advert实体类
 *
 * @author Thankson
 * @date 2020年04月02日
 */
@Table(name = "tb_advert")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Advert implements Serializable{

	/**
	 * 
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;

	/**
	 * 内容类目Id
	 */
    @Column(name = "category_id")
	private Integer categoryId;

	/**
	 * 内容标题
	 */
    @Column(name = "title")
	private String title;

	/**
	 * 链接
	 */
    @Column(name = "url")
	private String url;

	/**
	 * 图片绝对路径
	 */
    @Column(name = "pic")
	private String pic;

	/**
	 * 有效状态
	 */
    @Column(name = "status")
	private String status;

	/**
	 * 排序
	 */
    @Column(name = "sort_order")
	private Integer sortOrder;

}
