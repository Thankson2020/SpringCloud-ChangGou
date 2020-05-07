package com.thankson.mall.goods.feign;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.mall.goods.pojo.Category;
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
 * categoryFeign层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@FeignClient(name="goods")
@RequestMapping("/category")
public interface CategoryFeign {

    /**
     * Category分页条件搜索实现
     *
     * @param category 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Category category, @PathVariable  int page, @PathVariable  int size);

    /**
     * Category分页搜索实现
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
     * Category多条件搜索实现
     *
     * @param category 查询条件
     * @return Result<List<Category>>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search" )
    Result<List<Category>> findList(@RequestBody(required = false) Category category);

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
     * 修改Category数据
     *
     * @param category 修改内容
     * @param id       主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Category category,@PathVariable Integer id);

    /**
     * 新增Category数据
     *
     * @param category 新增数据
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping
    Result add(@RequestBody Category category);

    /**
     * 根据ID查询Category数据
     *
     * @param id       主键ID
     * @return Result<Category>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping("/{id}")
    Result<Category> findById(@PathVariable Integer id);

    /**
     * 查询Category全部数据
     *
     * @return Result<List<Category>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping
    Result<List<Category>> findAll();
}