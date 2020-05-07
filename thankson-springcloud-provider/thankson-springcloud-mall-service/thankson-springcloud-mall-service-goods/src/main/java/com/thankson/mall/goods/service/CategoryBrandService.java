package com.thankson.mall.goods.service;

import com.github.pagehelper.PageInfo;
import com.thankson.mall.goods.pojo.CategoryBrand;

import java.util.List;

/**
 * categoryBrand业务接口层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
public interface CategoryBrandService {

    /**
     * CategoryBrand分页条件搜索实现
     *
     * @param categoryBrand 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<CategoryBrand>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<CategoryBrand> findPage(CategoryBrand categoryBrand, int page, int size);

    /**
     * CategoryBrand分页查询
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<CategoryBrand>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<CategoryBrand> findPage(int page, int size);

    /**
     * CategoryBrand多条件搜索方法
     *
     * @param categoryBrand 查询条件
     * @return List<CategoryBrand>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<CategoryBrand> findList(CategoryBrand categoryBrand);

    /**
     * 删除CategoryBrand
     *
     * @param id       主键ID
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean delete(Integer id);

    /**
     * 修改CategoryBrand数据
     *
     * @param categoryBrand 修改内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean update(CategoryBrand categoryBrand);

    /**
     * 新增CategoryBrand
     *
     * @param categoryBrand 添加内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean add(CategoryBrand categoryBrand);

    /**
     * 根据ID查询CategoryBrand
     *
     * @param id       当前页数
     * @return CategoryBrand
     * @author Thankson
     * @date 2020年05月06日
     */
     CategoryBrand findById(Integer id);

    /**
     * 查询所有CategoryBrand
     *
     * @return List<CategoryBrand>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<CategoryBrand> findAll();
}
