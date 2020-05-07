package com.thankson.mall.goods.service;

import com.github.pagehelper.PageInfo;
import com.thankson.mall.goods.pojo.Template;

import java.util.List;

/**
 * template业务接口层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
public interface TemplateService {

    /**
     * Template分页条件搜索实现
     *
     * @param template 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Template>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Template> findPage(Template template, int page, int size);

    /**
     * Template分页查询
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return PageInfo<Template>
     * @author Thankson
     * @date 2020年05月06日
     */
    PageInfo<Template> findPage(int page, int size);

    /**
     * Template多条件搜索方法
     *
     * @param template 查询条件
     * @return List<Template>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Template> findList(Template template);

    /**
     * 删除Template
     *
     * @param id       主键ID
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean delete(Integer id);

    /**
     * 修改Template数据
     *
     * @param template 修改内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean update(Template template);

    /**
     * 新增Template
     *
     * @param template 添加内容
     * @return boolean
     * @author Thankson
     * @date 2020年05月06日
     */
    boolean add(Template template);

    /**
     * 根据ID查询Template
     *
     * @param id       当前页数
     * @return Template
     * @author Thankson
     * @date 2020年05月06日
     */
     Template findById(Integer id);

    /**
     * 查询所有Template
     *
     * @return List<Template>
     * @author Thankson
     * @date 2020年05月06日
     */
    List<Template> findAll();
}
