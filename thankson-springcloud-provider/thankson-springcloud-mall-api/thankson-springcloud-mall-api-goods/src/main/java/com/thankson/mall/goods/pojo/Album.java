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
 * 相册
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@Table(name = "tb_album")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Album implements Serializable{

	/**
	 * 编号
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;

	/**
	 * 相册名称
	 */
    @Column(name = "title")
	private String title;

	/**
	 * 相册封面
	 */
    @Column(name = "image")
	private String image;

	/**
	 * 图片列表
	 */
    @Column(name = "image_items")
	private String imageItems;

}
