package com.thankson.mall.goods.service;

import com.github.pagehelper.PageInfo;
import com.thankson.mall.goods.pojo.Brand;

import java.util.List;

/**
 * brand业务接口层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
public interface BrandService {

    /**
     * Brand分页条件搜索实现
     *
     * @param brand 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Brand>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Brand> findPage(Brand brand, int page, int size);

    /**
     * Brand分页查询
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Brand>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Brand> findPage(int page, int size);

    /**
     * Brand多条件搜索方法
     *
     * @param brand 查询条件
     * @return List<Brand>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Brand> findList(Brand brand);

    /**
     * 删除Brand
     *
     * @param id       主键ID
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean delete(Integer id);

    /**
     * 修改Brand数据
     *
     * @param brand 修改内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean update(Brand brand);

    /**
     * 新增Brand
     *
     * @param brand 添加内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean add(Brand brand);

    /**
     * 根据ID查询Brand
     *
     * @param id       当前页数
     * @return Brand
     * @author Thankson
     * @date 2020年05月06日
     */
     Brand findById(Integer id);

    /**
     * 查询所有Brand
     *
     * @return List<Brand>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Brand> findAll();
}
