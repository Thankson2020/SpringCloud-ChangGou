package com.thankson.mall.goods.service;

import com.github.pagehelper.PageInfo;
import com.thankson.mall.goods.pojo.Pref;

import java.util.List;

/**
 * pref业务接口层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
public interface PrefService {

    /**
     * Pref分页条件搜索实现
     *
     * @param pref 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Pref>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Pref> findPage(Pref pref, int page, int size);

    /**
     * Pref分页查询
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Pref>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Pref> findPage(int page, int size);

    /**
     * Pref多条件搜索方法
     *
     * @param pref 查询条件
     * @return List<Pref>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Pref> findList(Pref pref);

    /**
     * 删除Pref
     *
     * @param id       主键ID
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean delete(Integer id);

    /**
     * 修改Pref数据
     *
     * @param pref 修改内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean update(Pref pref);

    /**
     * 新增Pref
     *
     * @param pref 添加内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean add(Pref pref);

    /**
     * 根据ID查询Pref
     *
     * @param id       当前页数
     * @return Pref
     * @author Thankson
     * @date 2020年05月06日
     */
     Pref findById(Integer id);

    /**
     * 查询所有Pref
     *
     * @return List<Pref>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Pref> findAll();
}
