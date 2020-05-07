package com.thankson.mall.goods.pojo;

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
 * 商品分类
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@Table(name = "tb_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category implements Serializable{

	/**
	 * 分类ID
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;

	/**
	 * 分类名称
	 */
    @Column(name = "name")
	private String name;

	/**
	 * 商品数量
	 */
    @Column(name = "goods_num")
	private Integer goodsNum;

	/**
	 * 是否显示
	 */
    @Column(name = "is_show")
	private String isShow;

	/**
	 * 是否导航
	 */
    @Column(name = "is_menu")
	private String isMenu;

	/**
	 * 排序
	 */
    @Column(name = "seq")
	private Integer seq;

	/**
	 * 上级ID
	 */
    @Column(name = "parent_id")
	private Integer parentId;

	/**
	 * 模板ID
	 */
    @Column(name = "template_id")
	private Integer templateId;

}
