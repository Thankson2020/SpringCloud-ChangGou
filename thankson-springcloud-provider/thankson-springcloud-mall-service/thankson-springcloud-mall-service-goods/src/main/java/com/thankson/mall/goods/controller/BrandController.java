package com.thankson.mall.goods.controller;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.common.util.constant.StatusCode;
import com.thankson.mall.goods.pojo.Brand;
import com.thankson.mall.goods.service.BrandService;
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
 * brand控制层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * Brand分页条件搜索实现
     *
     * @param brand 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Brand>> findPage(@RequestBody(required = false) Brand brand, @PathVariable int page, @PathVariable int size){
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result<>(true, StatusCode.SUCCESS,"查询成功",pageInfo);
    }

    /**
     * Brand分页搜索实现
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Brand>> findPage(@PathVariable int page, @PathVariable int size){
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",pageInfo);
    }

    /**
     * Brand多条件搜索实现
     *
     * @param brand 查询条件
     * @return Result<List<Brand>>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search" )
    public Result<List<Brand>> findList(@RequestBody(required = false) Brand brand){
        List<Brand> list = brandService.findList(brand);
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
    public Result<Object> delete(@PathVariable Integer id){
        boolean result = brandService.delete(id);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "删除成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "删除失败");
    }

    /**
     * 修改Brand数据
     *
     * @param brand 修改内容
     * @param id       主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PutMapping(value="/{id}")
    public Result<Object> update(@RequestBody Brand brand,@PathVariable Integer id){
        brand.setId(id);
        boolean result = brandService.update(brand);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "修改成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "修改失败");
    }

    /**
     * 新增Brand数据
     *
     * @param brand 新增数据
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping
    public Result<Object> add(@RequestBody Brand brand){
        boolean result = brandService.add(brand);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "添加成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "添加失败");
    }

    /**
     * 根据ID查询Brand数据
     *
     * @param id       主键ID
     * @return Result<Brand>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id){
        //调用BrandService实现根据主键查询Brand
        Brand brand = brandService.findById(id);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",brand);
    }

    /**
     * 查询Brand全部数据
     *
     * @return Result<List<Brand>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> list = brandService.findAll();
        return new Result<>(true, StatusCode.SUCCESS,"查询成功",list) ;
    }
}
