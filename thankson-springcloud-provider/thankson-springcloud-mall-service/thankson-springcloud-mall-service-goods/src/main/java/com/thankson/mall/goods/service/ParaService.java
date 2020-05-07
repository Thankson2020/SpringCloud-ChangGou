package com.thankson.mall.goods.service;

import com.github.pagehelper.PageInfo;
import com.thankson.mall.goods.pojo.Para;

import java.util.List;

/**
 * para业务接口层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
public interface ParaService {

    /**
     * Para分页条件搜索实现
     *
     * @param para 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Para>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Para> findPage(Para para, int page, int size);

    /**
     * Para分页查询
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Para>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Para> findPage(int page, int size);

    /**
     * Para多条件搜索方法
     *
     * @param para 查询条件
     * @return List<Para>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Para> findList(Para para);

    /**
     * 删除Para
     *
     * @param id       主键ID
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean delete(Integer id);

    /**
     * 修改Para数据
     *
     * @param para 修改内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean update(Para para);

    /**
     * 新增Para
     *
     * @param para 添加内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean add(Para para);

    /**
     * 根据ID查询Para
     *
     * @param id       当前页数
     * @return Para
     * @author Thankson
     * @date 2020年05月06日
     */
     Para findById(Integer id);

    /**
     * 查询所有Para
     *
     * @return List<Para>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Para> findAll();
}
