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
 * 模板
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@Table(name = "tb_template")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Template implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 模板名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 规格数量
     */
    @Column(name = "spec_num")
    private Integer specNum;

    /**
     * 参数数量
     */
    @Column(name = "para_num")
    private Integer paraNum;

}
