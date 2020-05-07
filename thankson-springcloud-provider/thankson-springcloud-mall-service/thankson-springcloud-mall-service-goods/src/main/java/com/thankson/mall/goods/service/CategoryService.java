package com.thankson.mall.goods.service;

import com.github.pagehelper.PageInfo;
import com.thankson.mall.goods.pojo.Category;

import java.util.List;

/**
 * category业务接口层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
public interface CategoryService {

    /**
     * Category分页条件搜索实现
     *
     * @param category 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Category>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Category> findPage(Category category, int page, int size);

    /**
     * Category分页查询
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Category>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Category> findPage(int page, int size);

    /**
     * Category多条件搜索方法
     *
     * @param category 查询条件
     * @return List<Category>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Category> findList(Category category);

    /**
     * 删除Category
     *
     * @param id       主键ID
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean delete(Integer id);

    /**
     * 修改Category数据
     *
     * @param category 修改内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean update(Category category);

    /**
     * 新增Category
     *
     * @param category 添加内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean add(Category category);

    /**
     * 根据ID查询Category
     *
     * @param id       当前页数
     * @return Category
     * @author Thankson
     * @date 2020年05月06日
     */
     Category findById(Integer id);

    /**
     * 查询所有Category
     *
     * @return List<Category>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Category> findAll();
}
