package com.thankson.mall.goods.feign;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.mall.goods.pojo.Template;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * templateFeign层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@FeignClient(name="goods")
@RequestMapping("/template")
public interface TemplateFeign {

    /**
     * Template分页条件搜索实现
     *
     * @param template 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Template template, @PathVariable  int page, @PathVariable  int size);

    /**
     * Template分页搜索实现
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /**
     * Template多条件搜索实现
     *
     * @param template 查询条件
     * @return Result<List<Template>>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search" )
    Result<List<Template>> findList(@RequestBody(required = false) Template template);

    /**
     * 根据ID删除数据
     *
     * @param id       主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /**
     * 修改Template数据
     *
     * @param template 修改内容
     * @param id       主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Template template,@PathVariable Integer id);

    /**
     * 新增Template数据
     *
     * @param template 新增数据
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping
    Result add(@RequestBody Template template);

    /**
     * 根据ID查询Template数据
     *
     * @param id       主键ID
     * @return Result<Template>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping("/{id}")
    Result<Template> findById(@PathVariable Integer id);

    /**
     * 查询Template全部数据
     *
     * @return Result<List<Template>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping
    Result<List<Template>> findAll();
}