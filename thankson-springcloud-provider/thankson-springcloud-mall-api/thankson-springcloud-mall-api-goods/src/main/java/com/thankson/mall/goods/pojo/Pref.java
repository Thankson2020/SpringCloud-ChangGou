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
import java.util.Date;

/**
 * pref实体类
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@Table(name = "tb_pref")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pref implements Serializable{

	/**
	 * ID
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;

	/**
	 * 分类ID
	 */
    @Column(name = "cate_id")
	private Integer cateId;

	/**
	 * 消费金额
	 */
    @Column(name = "buy_money")
	private Integer buyMoney;

	/**
	 * 优惠金额
	 */
    @Column(name = "pre_money")
	private Integer preMoney;

	/**
	 * 活动开始日期
	 */
    @Column(name = "start_time")
	private Date startTime;

	/**
	 * 活动截至日期
	 */
    @Column(name = "end_time")
	private Date endTime;

	/**
	 * 类型
	 */
    @Column(name = "type")
	private String type;

	/**
	 * 状态
	 */
    @Column(name = "state")
	private String state;

}
