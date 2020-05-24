package com.thankson.mall.advert.service;

import com.github.pagehelper.PageInfo;
import com.thankson.mall.advert.pojo.Advert;

import java.util.List;

/**
 * advert业务接口层
 *
 * @author Thankson
 * @date 2020年04月02日
 */
public interface AdvertService {

    /**
     * Advert分页条件搜索实现
     *
     * @param advert 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Advert>
     * @author Thankson
     * @date 2020年04月02日
     */
    PageInfo<Advert> findPage(Advert advert, int page, int size);

    /**
     * Advert分页查询
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Advert>
     * @author Thankson
     * @date 2020年04月02日
     */
    PageInfo<Advert> findPage(int page, int size);

    /**
     * Advert多条件搜索方法
     *
     * @param advert 查询条件
     * @return List<Advert>
     * @author Thankson
     * @date 2020年04月02日
     */
    List<Advert> findList(Advert advert);

    /**
     * 删除Advert
     *
     * @param id       主键ID
     * @return boolean
     * @author Thankson
     * @date 2020年04月02日
     */
    boolean delete(Integer id);

    /**
     * 修改Advert数据
     *
     * @param advert 修改内容
     * @return boolean
     * @author Thankson
     * @date 2020年04月02日
     */
    boolean update(Advert advert);

    /**
     * 新增Advert
     *
     * @param advert 添加内容
     * @return boolean
     * @author Thankson
     * @date 2020年04月02日
     */
    boolean add(Advert advert);

    /**
     * 根据ID查询Advert
     *
     * @param id       当前页数
     * @return Advert
     * @author Thankson
     * @date 2020年04月02日
     */
     Advert findById(Integer id);

    /**
     * 查询所有Advert
     *
     * @return List<Advert>
     * @author Thankson
     * @date 2020年04月02日
     */
    List<Advert> findAll();

    /**
     * 根据categoryId查询广告集合
     * @param id
     * @return
     */
    List<Advert> findByCategory(Integer id);
}
