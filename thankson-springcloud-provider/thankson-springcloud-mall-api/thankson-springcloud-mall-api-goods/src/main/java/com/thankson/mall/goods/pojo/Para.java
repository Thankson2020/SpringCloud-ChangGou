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
 * para实体类
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@Table(name = "tb_para")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Para implements Serializable{

	/**
	 * id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;

	/**
	 * 名称
	 */
    @Column(name = "name")
	private String name;

	/**
	 * 选项
	 */
    @Column(name = "options")
	private String options;

	/**
	 * 排序
	 */
    @Column(name = "seq")
	private Integer seq;

	/**
	 * 模板ID
	 */
    @Column(name = "template_id")
	private Integer templateId;

}
