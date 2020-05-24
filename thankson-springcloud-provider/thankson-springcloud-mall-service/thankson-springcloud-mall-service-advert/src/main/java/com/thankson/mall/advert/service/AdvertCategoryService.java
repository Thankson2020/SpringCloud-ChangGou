package com.thankson.mall.advert.service;

import com.github.pagehelper.PageInfo;
import com.thankson.mall.advert.pojo.AdvertCategory;

import java.util.List;

/**
 * advertCategory业务接口层
 *
 * @author Thankson
 * @date 2020年04月02日
 */
public interface AdvertCategoryService {

    /**
     * AdvertCategory分页条件搜索实现
     *
     * @param advertCategory 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<AdvertCategory>
     * @author Thankson
     * @date 2020年04月02日
     */
    PageInfo<AdvertCategory> findPage(AdvertCategory advertCategory, int page, int size);

    /**
     * AdvertCategory分页查询
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<AdvertCategory>
     * @author Thankson
     * @date 2020年04月02日
     */
    PageInfo<AdvertCategory> findPage(int page, int size);

    /**
     * AdvertCategory多条件搜索方法
     *
     * @param advertCategory 查询条件
     * @return List<AdvertCategory>
     * @author Thankson
     * @date 2020年04月02日
     */
    List<AdvertCategory> findList(AdvertCategory advertCategory);

    /**
     * 删除AdvertCategory
     *
     * @param id       主键ID
     * @return boolean
     * @author Thankson
     * @date 2020年04月02日
     */
    boolean delete(Integer id);

    /**
     * 修改AdvertCategory数据
     *
     * @param advertCategory 修改内容
     * @return boolean
     * @author Thankson
     * @date 2020年04月02日
     */
    boolean update(AdvertCategory advertCategory);

    /**
     * 新增AdvertCategory
     *
     * @param advertCategory 添加内容
     * @return boolean
     * @author Thankson
     * @date 2020年04月02日
     */
    boolean add(AdvertCategory advertCategory);

    /**
     * 根据ID查询AdvertCategory
     *
     * @param id       当前页数
     * @return AdvertCategory
     * @author Thankson
     * @date 2020年04月02日
     */
     AdvertCategory findById(Integer id);

    /**
     * 查询所有AdvertCategory
     *
     * @return List<AdvertCategory>
     * @author Thankson
     * @date 2020年04月02日
     */
    List<AdvertCategory> findAll();
}
