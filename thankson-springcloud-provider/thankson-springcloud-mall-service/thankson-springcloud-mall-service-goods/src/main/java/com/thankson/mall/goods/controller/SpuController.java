package com.thankson.mall.goods.controller;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.common.util.constant.StatusCode;
import com.thankson.mall.goods.pojo.Spu;
import com.thankson.mall.goods.service.SpuService;
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
 * spu控制层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@RestController
@RequestMapping("/spu")
public class SpuController {

    @Autowired
    private SpuService spuService;

    /**
     * Spu分页条件搜索实现
     *
     * @param spu 查询条件
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Spu>> findPage(@RequestBody(required = false) Spu spu, @PathVariable int page, @PathVariable int size){
        PageInfo<Spu> pageInfo = spuService.findPage(spu, page, size);
        return new Result<>(true, StatusCode.SUCCESS,"查询成功",pageInfo);
    }

    /**
     * Spu分页搜索实现
     *
     * @param page     当前页数
     * @param size     每页显示多少条
     * @return Result<PageInfo>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo<Spu>> findPage(@PathVariable int page, @PathVariable int size){
        PageInfo<Spu> pageInfo = spuService.findPage(page, size);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",pageInfo);
    }

    /**
     * Spu多条件搜索实现
     *
     * @param spu 查询条件
     * @return Result<List<Spu>>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search" )
    public Result<List<Spu>> findList(@RequestBody(required = false) Spu spu){
        List<Spu> list = spuService.findList(spu);
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
        boolean result = spuService.delete(id);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "删除成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "删除失败");
    }

    /**
     * 修改Spu数据
     *
     * @param spu 修改内容
     * @param id       主键ID
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PutMapping(value="/{id}")
    public Result<Object> update(@RequestBody Spu spu,@PathVariable String id){
        spu.setId(id);
        boolean result = spuService.update(spu);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "修改成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "修改失败");
    }

    /**
     * 新增Spu数据
     *
     * @param spu 新增数据
     * @return Result<Object>
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping
    public Result<Object> add(@RequestBody Spu spu){
        boolean result = spuService.add(spu);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "添加成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "添加失败");
    }

    /**
     * 根据ID查询Spu数据
     *
     * @param id       主键ID
     * @return Result<Spu>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping("/{id}")
    public Result<Spu> findById(@PathVariable String id){
        //调用SpuService实现根据主键查询Spu
        Spu spu = spuService.findById(id);
        return new Result<>(true,StatusCode.SUCCESS,"查询成功",spu);
    }

    /**
     * 查询Spu全部数据
     *
     * @return Result<List<Spu>
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping
    public Result<List<Spu>> findAll(){
        List<Spu> list = spuService.findAll();
        return new Result<>(true, StatusCode.SUCCESS,"查询成功",list) ;
    }
}
