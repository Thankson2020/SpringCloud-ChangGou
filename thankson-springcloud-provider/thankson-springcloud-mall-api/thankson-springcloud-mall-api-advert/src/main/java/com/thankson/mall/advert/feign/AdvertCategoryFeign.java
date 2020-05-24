package com.thankson.mall.advert.feign;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.mall.advert.pojo.AdvertCategory;
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
 * advertCategoryFeign层
 *
 * @author Thankson
 * @date 2020年04月02日
 */
@FeignClient(name="mall-advertCategory")
@RequestMapping("/advertCategory")
public interface AdvertCategoryFeign {

    /**
     * AdvertCategory分页条件搜索实现
     *
     * @param advertCategory 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) AdvertCategory advertCategory, @PathVariable int page, @PathVariable int size);

    /**
     * AdvertCategory分页搜索实现
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年04月02日
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /**
     * AdvertCategory多条件搜索实现
     *
     * @param advertCategory 查询条件
     * @return Result<List<AdvertCategory>>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PostMapping(value = "/search" )
    Result<List<AdvertCategory>> findList(@RequestBody(required = false) AdvertCategory advertCategory);

    /**
     * 根据ID删除数据
     *
     * @param id       主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年04月02日
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /**
     * 修改AdvertCategory数据
     *
     * @param advertCategory 修改内容
     * @param id       主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody AdvertCategory advertCategory, @PathVariable Integer id);

    /**
     * 新增AdvertCategory数据
     *
     * @param advertCategory 新增数据
     * @return Result<Object>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PostMapping
    Result add(@RequestBody AdvertCategory advertCategory);

    /**
     * 根据ID查询AdvertCategory数据
     *
     * @param id       主键ID
     * @return Result<AdvertCategory>
     * @author Thankson
     * @date 2020年04月02日
     */
    @GetMapping("/{id}")
    Result<AdvertCategory> findById(@PathVariable Integer id);

    /**
     * 查询AdvertCategory全部数据
     *
     * @return Result<List<AdvertCategory>
     * @author Thankson
     * @date 2020年04月02日
     */
    @GetMapping
    Result<List<AdvertCategory>> findAll();
}