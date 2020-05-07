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
 * 商品-品牌关系
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@Table(name = "tb_category_brand")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryBrand implements Serializable{

	/**
	 * 分类ID
	 */
	@Id
    @Column(name = "category_id")
	private Integer categoryId;

	/**
	 * 品牌ID
	 */
    @Column(name = "brand_id")
	private Integer brandId;

}
