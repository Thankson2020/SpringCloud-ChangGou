package com.thankson.mall.goods.controller;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.common.util.constant.StatusCode;
import com.thankson.mall.goods.pojo.Sku;
import com.thankson.mall.goods.service.SkuService;
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
 * sku控制层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@RestController
@RequestMapping("/sku")
public class SkuController {

    @Autowired
    private SkuService skuService;

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
    public Result<PageInfo<Sku>> findPage(@RequestBody(required = false) Sku sku, @PathVariable int page, @PathVariable int size){
        PageInfo<Sku> pageInfo = skuService.findPage(sku, page, size);
        return new Result<>(true, StatusCode.SUCCESS,"查询成功",pageInfo);
    }

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
    public Result<PageInfo<Sku>> findPage(@PathVariable int page, @PathVariable int size){
        PageInfo<Sku> pageInfo = skuService.findPage(page, size);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",pageInfo);
    }

    /**
     * Sku多条件搜索实现
     *
     * @param sku 查询条件
     * @return Result<List<Sku>>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search" )
    public Result<List<Sku>> findList(@RequestBody(required = false) Sku sku){
        List<Sku> list = skuService.findList(sku);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",list);
    }

    /**
     * 根据ID删除数据
     *
     * @param id       主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @DeleteMapping(value = "/{id}" )
    public Result<Object> delete(@PathVariable String id){
        boolean result = skuService.delete(id);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "删除成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "删除失败");
    }

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
    public Result<Object> update(@RequestBody Sku sku,@PathVariable String id){
        sku.setId(id);
        boolean result = skuService.update(sku);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "修改成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "修改失败");
    }

    /**
     * 新增Sku数据
     *
     * @param sku 新增数据
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping
    public Result<Object> add(@RequestBody Sku sku){
        boolean result = skuService.add(sku);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "添加成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "添加失败");
    }

    /**
     * 根据ID查询Sku数据
     *
     * @param id       主键ID
     * @return Result<Sku>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping("/{id}")
    public Result<Sku> findById(@PathVariable String id){
        //调用SkuService实现根据主键查询Sku
        Sku sku = skuService.findById(id);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",sku);
    }

    /**
     * 查询Sku全部数据
     *
     * @return Result<List<Sku>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping
    public Result<List<Sku>> findAll(){
        List<Sku> list = skuService.findAll();
        return new Result<>(true, StatusCode.SUCCESS,"查询成功",list) ;
    }
}
