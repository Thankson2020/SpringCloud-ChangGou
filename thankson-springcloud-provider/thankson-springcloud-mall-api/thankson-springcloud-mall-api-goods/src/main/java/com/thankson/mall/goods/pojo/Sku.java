package com.thankson.mall.goods.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 库存量单位
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@Table(name = "tb_sku")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sku implements Serializable{

	/**
	 * 商品id
	 */
	@Id
    @Column(name = "id")
	private String id;

	/**
	 * 商品条码
	 */
    @Column(name = "sn")
	private String sn;

	/**
	 * SKU名称
	 */
    @Column(name = "name")
	private String name;

	/**
	 * 价格（分）
	 */
    @Column(name = "price")
	private Integer price;

	/**
	 * 库存数量
	 */
    @Column(name = "num")
	private Integer num;

	/**
	 * 库存预警数量
	 */
    @Column(name = "alert_num")
	private Integer alertNum;

	/**
	 * 商品图片
	 */
    @Column(name = "image")
	private String image;

	/**
	 * 商品图片列表
	 */
    @Column(name = "images")
	private String images;

	/**
	 * 重量（克）
	 */
    @Column(name = "weight")
	private Integer weight;

	/**
	 * 创建时间
	 */
    @Column(name = "create_time")
	private Date createTime;

	/**
	 * 更新时间
	 */
    @Column(name = "update_time")
	private Date updateTime;

	/**
	 * SPUID
	 */
    @Column(name = "spu_id")
	private String spuId;

	/**
	 * 类目ID
	 */
    @Column(name = "category_id")
	private Integer categoryId;

	/**
	 * 类目名称
	 */
    @Column(name = "category_name")
	private String categoryName;

	/**
	 * 品牌名称
	 */
    @Column(name = "brand_name")
	private String brandName;

	/**
	 * 规格
	 */
    @Column(name = "spec")
	private String spec;

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
	 * 商品状态 1-正常，2-下架，3-删除
	 */
    @Column(name = "status")
	private String status;

	/**
	 * 
	 */
    @Column(name = "version")
	private Integer version;

}
