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
 * advertCategory实体类
 *
 * @author Thankson
 * @date 2020年04月02日
 */
@Table(name = "tb_advert_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdvertCategory implements Serializable{

	/**
	 * 类目Id
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

}
