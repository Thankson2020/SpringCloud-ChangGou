package com.thankson.mall.goods.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 标准产品单位
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@Table(name = "tb_spu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Spu implements Serializable{

	/**
	 * 主键
	 */
	@Id
    @Column(name = "id")
	private String id;

	/**
	 * 货号
	 */
    @Column(name = "sn")
	private String sn;

	/**
	 * SPU名
	 */
    @Column(name = "name")
	private String name;

	/**
	 * 副标题
	 */
    @Column(name = "caption")
	private String caption;

	/**
	 * 品牌ID
	 */
    @Column(name = "brand_id")
	private Integer brandId;

	/**
	 * 一级分类
	 */
    @Column(name = "category1_id")
	private Integer category1Id;

	/**
	 * 二级分类
	 */
    @Column(name = "category2_id")
	private Integer category2Id;

	/**
	 * 三级分类
	 */
    @Column(name = "category3_id")
	private Integer category3Id;

	/**
	 * 模板ID
	 */
    @Column(name = "template_id")
	private Integer templateId;

	/**
	 * 运费模板id
	 */
    @Column(name = "freight_id")
	private Integer freightId;

	/**
	 * 图片
	 */
    @Column(name = "image")
	private String image;

	/**
	 * 图片列表
	 */
    @Column(name = "images")
	private String images;

	/**
	 * 售后服务
	 */
    @Column(name = "sale_service")
	private String saleService;

	/**
	 * 介绍
	 */
    @Column(name = "introduction")
	private String introduction;

	/**
	 * 规格列表
	 */
    @Column(name = "spec_items")
	private String specItems;

	/**
	 * 参数列表
	 */
    @Column(name = "para_items")
	private String paraItems;

	/**
	 * 销量
	 */
    @Column(name = "sale_num")
	private Integer saleNum;

	/**
	 * 评论数
	 */
    @Column(name = "comment_num")
	private Integer commentNum;

	/**
	 * 是否上架
	 */
    @Column(name = "is_marketable")
	private String isMarketable;

	/**
	 * 是否启用规格
	 */
    @Column(name = "is_enable_spec")
	private String isEnableSpec;

	/**
	 * 是否删除
	 */
    @Column(name = "is_delete")
	private String isDelete;

	/**
	 * 审核状态
	 */
    @Column(name = "status")
	private String status;

}
