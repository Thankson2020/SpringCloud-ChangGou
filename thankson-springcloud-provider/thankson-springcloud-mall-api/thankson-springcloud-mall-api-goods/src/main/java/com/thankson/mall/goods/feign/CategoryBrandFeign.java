package com.thankson.mall.goods.feign;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.mall.goods.pojo.CategoryBrand;
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
 * categoryBrandFeign层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@FeignClient(name="goods")
@RequestMapping("/categoryBrand")
public interface CategoryBrandFeign {

    /**
     * CategoryBrand分页条件搜索实现
     *
     * @param categoryBrand 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) CategoryBrand categoryBrand, @PathVariable  int page, @PathVariable  int size);

    /**
     * CategoryBrand分页搜索实现
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
     * CategoryBrand多条件搜索实现
     *
     * @param categoryBrand 查询条件
     * @return Result<List<CategoryBrand>>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search" )
    Result<List<CategoryBrand>> findList(@RequestBody(required = false) CategoryBrand categoryBrand);

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
     * 修改CategoryBrand数据
     *
     * @param categoryBrand 修改内容
     * @param id       主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody CategoryBrand categoryBrand,@PathVariable Integer id);

    /**
     * 新增CategoryBrand数据
     *
     * @param categoryBrand 新增数据
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping
    Result add(@RequestBody CategoryBrand categoryBrand);

    /**
     * 根据ID查询CategoryBrand数据
     *
     * @param id       主键ID
     * @return Result<CategoryBrand>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping("/{id}")
    Result<CategoryBrand> findById(@PathVariable Integer id);

    /**
     * 查询CategoryBrand全部数据
     *
     * @return Result<List<CategoryBrand>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping
    Result<List<CategoryBrand>> findAll();
}