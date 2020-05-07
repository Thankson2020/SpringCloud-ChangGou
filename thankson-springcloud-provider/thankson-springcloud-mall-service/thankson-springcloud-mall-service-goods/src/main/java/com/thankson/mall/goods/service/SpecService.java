package com.thankson.mall.goods.service;

import com.github.pagehelper.PageInfo;
import com.thankson.mall.goods.pojo.Spec;

import java.util.List;

/**
 * spec业务接口层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
public interface SpecService {

    /**
     * Spec分页条件搜索实现
     *
     * @param spec 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Spec>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Spec> findPage(Spec spec, int page, int size);

    /**
     * Spec分页查询
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Spec>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Spec> findPage(int page, int size);

    /**
     * Spec多条件搜索方法
     *
     * @param spec 查询条件
     * @return List<Spec>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Spec> findList(Spec spec);

    /**
     * 删除Spec
     *
     * @param id       主键ID
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean delete(Integer id);

    /**
     * 修改Spec数据
     *
     * @param spec 修改内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean update(Spec spec);

    /**
     * 新增Spec
     *
     * @param spec 添加内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean add(Spec spec);

    /**
     * 根据ID查询Spec
     *
     * @param id       当前页数
     * @return Spec
     * @author Thankson
     * @date 2020年05月06日
     */
     Spec findById(Integer id);

    /**
     * 查询所有Spec
     *
     * @return List<Spec>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Spec> findAll();
}
