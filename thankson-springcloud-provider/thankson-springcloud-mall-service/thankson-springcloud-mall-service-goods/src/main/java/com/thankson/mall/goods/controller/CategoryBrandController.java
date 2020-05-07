package com.thankson.mall.goods.controller;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.common.util.constant.StatusCode;
import com.thankson.mall.goods.pojo.CategoryBrand;
import com.thankson.mall.goods.service.CategoryBrandService;
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
 * categoryBrand控制层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@RestController
@RequestMapping("/categoryBrand")
public class CategoryBrandController {

    @Autowired
    private CategoryBrandService categoryBrandService;

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
    public Result<PageInfo<CategoryBrand>> findPage(@RequestBody(required = false) CategoryBrand categoryBrand, @PathVariable int page, @PathVariable int size){
        PageInfo<CategoryBrand> pageInfo = categoryBrandService.findPage(categoryBrand, page, size);
        return new Result<>(true, StatusCode.SUCCESS,"查询成功",pageInfo);
    }

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
    public Result<PageInfo<CategoryBrand>> findPage(@PathVariable int page, @PathVariable int size){
        PageInfo<CategoryBrand> pageInfo = categoryBrandService.findPage(page, size);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",pageInfo);
    }

    /**
     * CategoryBrand多条件搜索实现
     *
     * @param categoryBrand 查询条件
     * @return Result<List<CategoryBrand>>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search" )
    public Result<List<CategoryBrand>> findList(@RequestBody(required = false) CategoryBrand categoryBrand){
        List<CategoryBrand> list = categoryBrandService.findList(categoryBrand);
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
        boolean result = categoryBrandService.delete(id);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "删除成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "删除失败");
    }

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
    public Result<Object> update(@RequestBody CategoryBrand categoryBrand,@PathVariable Integer id){
        categoryBrand.setCategoryId(id);
        boolean result = categoryBrandService.update(categoryBrand);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "修改成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "修改失败");
    }

    /**
     * 新增CategoryBrand数据
     *
     * @param categoryBrand 新增数据
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping
    public Result<Object> add(@RequestBody CategoryBrand categoryBrand){
        boolean result = categoryBrandService.add(categoryBrand);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "添加成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "添加失败");
    }

    /**
     * 根据ID查询CategoryBrand数据
     *
     * @param id       主键ID
     * @return Result<CategoryBrand>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping("/{id}")
    public Result<CategoryBrand> findById(@PathVariable Integer id){
        //调用CategoryBrandService实现根据主键查询CategoryBrand
        CategoryBrand categoryBrand = categoryBrandService.findById(id);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",categoryBrand);
    }

    /**
     * 查询CategoryBrand全部数据
     *
     * @return Result<List<CategoryBrand>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping
    public Result<List<CategoryBrand>> findAll(){
        List<CategoryBrand> list = categoryBrandService.findAll();
        return new Result<>(true, StatusCode.SUCCESS,"查询成功",list) ;
    }
}
