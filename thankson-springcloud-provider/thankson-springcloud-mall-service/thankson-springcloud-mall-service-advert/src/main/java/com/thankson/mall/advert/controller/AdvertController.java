package com.thankson.mall.advert.controller;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.common.util.constant.StatusCode;
import com.thankson.mall.advert.pojo.Advert;
import com.thankson.mall.advert.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * advert控制层
 *
 * @author Thankson
 * @date 2020年04月02日
 */
@RestController
@RequestMapping("/advert")
public class AdvertController {

    @Autowired
    private AdvertService advertService;

    /**
     * Advert分页条件搜索实现
     *
     * @param advert 查询条件
     * @param page   当前页数
     * @param size   每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Advert>> findPage(@RequestBody(required = false) Advert advert, @PathVariable int page, @PathVariable int size) {
        PageInfo<Advert> pageInfo = advertService.findPage(advert, page, size);
        return new Result<>(true, StatusCode.SUCCESS, "查询成功", pageInfo);
    }

    /**
     * Advert分页搜索实现
     *
     * @param page 当前页数
     * @param size 每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年04月02日
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Advert>> findPage(@PathVariable int page, @PathVariable int size) {
        PageInfo<Advert> pageInfo = advertService.findPage(page, size);
        return new Result<>(true, StatusCode.SUCCESS, "查询成功", pageInfo);
    }

    /**
     * Advert多条件搜索实现
     *
     * @param advert 查询条件
     * @return Result<List < Advert>>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PostMapping(value = "/search")
    public Result<List<Advert>> findList(@RequestBody(required = false) Advert advert) {
        List<Advert> list = advertService.findList(advert);
        return new Result<>(true, StatusCode.SUCCESS, "查询成功", list);
    }

    /**
     * 根据ID删除数据
     *
     * @param id 主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年04月02日
     */
    @DeleteMapping(value = "/{id}")
    public Result<Object> delete(@PathVariable Integer id) {
        boolean result = advertService.delete(id);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "删除成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "删除失败");
    }

    /**
     * 修改Advert数据
     *
     * @param advert 修改内容
     * @param id     主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PutMapping(value = "/{id}")
    public Result<Object> update(@RequestBody Advert advert, @PathVariable Integer id) {
        advert.setId(id);
        boolean result = advertService.update(advert);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "修改成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "修改失败");
    }

    /**
     * 新增Advert数据
     *
     * @param advert 新增数据
     * @return Result<Object>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PostMapping
    public Result<Object> add(@RequestBody Advert advert) {
        boolean result = advertService.add(advert);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "添加成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "添加失败");
    }

    /**
     * 根据ID查询Advert数据
     *
     * @param id 主键ID
     * @return Result<Advert>
     * @author Thankson
     * @date 2020年04月02日
     */
    @GetMapping("/{id}")
    public Result<Advert> findById(@PathVariable Integer id) {
        //调用AdvertService实现根据主键查询Advert
        Advert advert = advertService.findById(id);
        return new Result<>(true, StatusCode.SUCCESS, "查询成功", advert);
    }

    /**
     * 查询Advert全部数据
     *
     * @return Result<List < Advert>
     * @author Thankson
     * @date 2020年04月02日
     */
    @GetMapping
    public Result<List<Advert>> findAll() {
        List<Advert> list = advertService.findAll();
        return new Result<>(true, StatusCode.SUCCESS, "查询成功", list);
    }

    /**
     * 根据categoryId查询广告集合
     */
    @GetMapping(value = "/list/category/{id}")
    public Result<List<Advert>> findByCategory(@PathVariable Integer id) {
        //根据分类ID查询广告集合
        List<Advert> contents = advertService.findByCategory(id);
        return new Result<>(true, StatusCode.SUCCESS, "查询成功！", contents);
    }
}
