package com.thankson.mall.goods.controller;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.common.util.constant.StatusCode;
import com.thankson.mall.goods.pojo.Category;
import com.thankson.mall.goods.service.CategoryService;
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
 * category控制层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

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
    public Result<PageInfo<Category>> findPage(@RequestBody(required = false) Category category, @PathVariable int page, @PathVariable int size){
        PageInfo<Category> pageInfo = categoryService.findPage(category, page, size);
        return new Result<>(true, StatusCode.SUCCESS,"查询成功",pageInfo);
    }

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
    public Result<PageInfo<Category>> findPage(@PathVariable int page, @PathVariable int size){
        PageInfo<Category> pageInfo = categoryService.findPage(page, size);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",pageInfo);
    }

    /**
     * Category多条件搜索实现
     *
     * @param category 查询条件
     * @return Result<List<Category>>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search" )
    public Result<List<Category>> findList(@RequestBody(required = false) Category category){
        List<Category> list = categoryService.findList(category);
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
        boolean result = categoryService.delete(id);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "删除成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "删除失败");
    }

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
    public Result<Object> update(@RequestBody Category category,@PathVariable Integer id){
        category.setId(id);
        boolean result = categoryService.update(category);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "修改成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "修改失败");
    }

    /**
     * 新增Category数据
     *
     * @param category 新增数据
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping
    public Result<Object> add(@RequestBody Category category){
        boolean result = categoryService.add(category);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "添加成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "添加失败");
    }

    /**
     * 根据ID查询Category数据
     *
     * @param id       主键ID
     * @return Result<Category>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping("/{id}")
    public Result<Category> findById(@PathVariable Integer id){
        //调用CategoryService实现根据主键查询Category
        Category category = categoryService.findById(id);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",category);
    }

    /**
     * 查询Category全部数据
     *
     * @return Result<List<Category>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping
    public Result<List<Category>> findAll(){
        List<Category> list = categoryService.findAll();
        return new Result<>(true, StatusCode.SUCCESS,"查询成功",list) ;
    }
}
