package com.thankson.mall.goods.service;

import com.github.pagehelper.PageInfo;
import com.thankson.mall.goods.pojo.Sku;

import java.util.List;

/**
 * sku业务接口层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
public interface SkuService {

    /**
     * Sku分页条件搜索实现
     *
     * @param sku 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Sku>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Sku> findPage(Sku sku, int page, int size);

    /**
     * Sku分页查询
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Sku>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Sku> findPage(int page, int size);

    /**
     * Sku多条件搜索方法
     *
     * @param sku 查询条件
     * @return List<Sku>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Sku> findList(Sku sku);

    /**
     * 删除Sku
     *
     * @param id       主键ID
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean delete(String id);

    /**
     * 修改Sku数据
     *
     * @param sku 修改内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean update(Sku sku);

    /**
     * 新增Sku
     *
     * @param sku 添加内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean add(Sku sku);

    /**
     * 根据ID查询Sku
     *
     * @param id       当前页数
     * @return Sku
     * @author Thankson
     * @date 2020年05月06日
     */
     Sku findById(String id);

    /**
     * 查询所有Sku
     *
     * @return List<Sku>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Sku> findAll();
}
