package com.thankson.mall.goods.feign;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.mall.goods.pojo.Sku;
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
 * skuFeign层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@FeignClient(name="goods")
@RequestMapping("/sku")
public interface SkuFeign {

    /**
     * Sku分页条件搜索实现
     *
     * @param sku 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Sku sku, @PathVariable  int page, @PathVariable  int size);

    /**
     * Sku分页搜索实现
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
     * Sku多条件搜索实现
     *
     * @param sku 查询条件
     * @return Result<List<Sku>>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search" )
    Result<List<Sku>> findList(@RequestBody(required = false) Sku sku);

    /**
     * 根据ID删除数据
     *
     * @param id       主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /**
     * 修改Sku数据
     *
     * @param sku 修改内容
     * @param id       主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Sku sku,@PathVariable String id);

    /**
     * 新增Sku数据
     *
     * @param sku 新增数据
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping
    Result add(@RequestBody Sku sku);

    /**
     * 根据ID查询Sku数据
     *
     * @param id       主键ID
     * @return Result<Sku>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping("/{id}")
    Result<Sku> findById(@PathVariable String id);

    /**
     * 查询Sku全部数据
     *
     * @return Result<List<Sku>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping
    Result<List<Sku>> findAll();
}