package com.thankson.mall.advert.feign;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.mall.advert.pojo.Advert;
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
 * advertfeign层
 *
 * @author Thankson
 * @date 2020年04月02日
 */
@FeignClient(name="mall-advert")
@RequestMapping("/advert")
public interface AdvertFeign {

    /**
     * Advert分页条件搜索实现
     *
     * @param advert 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Advert advert, @PathVariable int page, @PathVariable int size);

    /**
     * Advert分页搜索实现
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
     * Advert多条件搜索实现
     *
     * @param advert 查询条件
     * @return Result<List<Advert>>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PostMapping(value = "/search" )
    Result<List<Advert>> findList(@RequestBody(required = false) Advert advert);

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
     * 修改Advert数据
     *
     * @param advert 修改内容
     * @param id       主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Advert advert, @PathVariable Integer id);

    /**
     * 新增Advert数据
     *
     * @param advert 新增数据
     * @return Result<Object>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PostMapping
    Result add(@RequestBody Advert advert);

    /**
     * 根据ID查询Advert数据
     *
     * @param id       主键ID
     * @return Result<Advert>
     * @author Thankson
     * @date 2020年04月02日
     */
    @GetMapping("/{id}")
    Result<Advert> findById(@PathVariable Integer id);

    /**
     * 查询Advert全部数据
     *
     * @return Result<List<Advert>
     * @author Thankson
     * @date 2020年04月02日
     */
    @GetMapping
    Result<List<Advert>> findAll();

    /***
     * 根据分类ID查询所有广告
     */
    @GetMapping(value = "/list/category/{id}")
    Result<List<Advert>> findByCategory(@PathVariable Integer id);

}