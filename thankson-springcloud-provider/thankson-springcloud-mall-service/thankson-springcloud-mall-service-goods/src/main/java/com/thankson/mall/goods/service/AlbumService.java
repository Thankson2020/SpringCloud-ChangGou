package com.thankson.mall.goods.service;

import com.github.pagehelper.PageInfo;
import com.thankson.mall.goods.pojo.Album;

import java.util.List;

/**
 * album业务接口层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
public interface AlbumService {

    /**
     * 多条件分页查询
     *
     * @param album 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Album> findPage(Album album, int page, int size);

    /**
     * Album分页查询
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Album>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Album> findPage(int page, int size);

    /**
     * Album多条件搜索方法
     *
     * @param album 查询条件
     * @return List<Album>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Album> findList(Album album);

    /**
     * 删除Album
     *
     * @param id       主键ID
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean delete(Long id);

    /**
     * 修改Album数据
     *
     * @param album 修改内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean update(Album album);

    /**
     * 新增Album
     *
     * @param album 添加内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean add(Album album);

    /**
     * 根据ID查询Album
     *
     * @param id       当前页数
     * @return Album
     * @author Thankson
     * @date 2020年05月06日
     */
     Album findById(Long id);

    /**
     * 查询所有Album
     *
     * @return List<Album>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Album> findAll();
}
