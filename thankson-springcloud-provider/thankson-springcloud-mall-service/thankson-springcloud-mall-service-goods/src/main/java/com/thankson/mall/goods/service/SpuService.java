package com.thankson.mall.goods.service;

import com.github.pagehelper.PageInfo;
import com.thankson.mall.goods.pojo.Spu;

import java.util.List;

/**
 * spu业务接口层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
public interface SpuService {

    /**
     * Spu分页条件搜索实现
     *
     * @param spu 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Spu>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Spu> findPage(Spu spu, int page, int size);

    /**
     * Spu分页查询
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Spu>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Spu> findPage(int page, int size);

    /**
     * Spu多条件搜索方法
     *
     * @param spu 查询条件
     * @return List<Spu>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Spu> findList(Spu spu);

    /**
     * 删除Spu
     *
     * @param id       主键ID
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean delete(String id);

    /**
     * 修改Spu数据
     *
     * @param spu 修改内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean update(Spu spu);

    /**
     * 新增Spu
     *
     * @param spu 添加内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean add(Spu spu);

    /**
     * 根据ID查询Spu
     *
     * @param id       当前页数
     * @return Spu
     * @author Thankson
     * @date 2020年05月06日
     */
     Spu findById(String id);

    /**
     * 查询所有Spu
     *
     * @return List<Spu>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Spu> findAll();
}
