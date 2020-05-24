package com.thankson.mall.advert.controller;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.common.util.constant.StatusCode;
import com.thankson.mall.advert.pojo.AdvertCategory;
import com.thankson.mall.advert.service.AdvertCategoryService;
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
 * advertCategory控制层
 *
 * @author Thankson
 * @date 2020年04月02日
 */
@RestController
@RequestMapping("/advertCategory")
public class AdvertCategoryController {

    @Autowired
    private AdvertCategoryService advertCategoryService;

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
    public Result<PageInfo<AdvertCategory>> findPage(@RequestBody(required = false) AdvertCategory advertCategory, @PathVariable int page, @PathVariable int size){
        PageInfo<AdvertCategory> pageInfo = advertCategoryService.findPage(advertCategory, page, size);
        return new Result<>(true, StatusCode.SUCCESS,"查询成功",pageInfo);
    }

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
    public Result<PageInfo<AdvertCategory>> findPage(@PathVariable int page, @PathVariable int size){
        PageInfo<AdvertCategory> pageInfo = advertCategoryService.findPage(page, size);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",pageInfo);
    }

    /**
     * AdvertCategory多条件搜索实现
     *
     * @param advertCategory 查询条件
     * @return Result<List<AdvertCategory>>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PostMapping(value = "/search" )
    public Result<List<AdvertCategory>> findList(@RequestBody(required = false) AdvertCategory advertCategory){
        List<AdvertCategory> list = advertCategoryService.findList(advertCategory);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",list);
    }

    /**
     * 根据ID删除数据
     *
     * @param id       主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年04月02日
     */
    @DeleteMapping(value = "/{id}" )
    public Result<Object> delete(@PathVariable Integer id){
        boolean result = advertCategoryService.delete(id);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "删除成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "删除失败");
    }

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
    public Result<Object> update(@RequestBody AdvertCategory advertCategory,@PathVariable Integer id){
        advertCategory.setId(id);
        boolean result = advertCategoryService.update(advertCategory);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "修改成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "修改失败");
    }

    /**
     * 新增AdvertCategory数据
     *
     * @param advertCategory 新增数据
     * @return Result<Object>
     * @author Thankson
     * @date 2020年04月02日
     */
    @PostMapping
    public Result<Object> add(@RequestBody AdvertCategory advertCategory){
        boolean result = advertCategoryService.add(advertCategory);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "添加成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "添加失败");
    }

    /**
     * 根据ID查询AdvertCategory数据
     *
     * @param id       主键ID
     * @return Result<AdvertCategory>
     * @author Thankson
     * @date 2020年04月02日
     */
    @GetMapping("/{id}")
    public Result<AdvertCategory> findById(@PathVariable Integer id){
        //调用AdvertCategoryService实现根据主键查询AdvertCategory
        AdvertCategory advertCategory = advertCategoryService.findById(id);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",advertCategory);
    }

    /**
     * 查询AdvertCategory全部数据
     *
     * @return Result<List<AdvertCategory>
     * @author Thankson
     * @date 2020年04月02日
     */
    @GetMapping
    public Result<List<AdvertCategory>> findAll(){
        List<AdvertCategory> list = advertCategoryService.findAll();
        return new Result<>(true, StatusCode.SUCCESS,"查询成功",list) ;
    }
}
