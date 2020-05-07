package com.thankson.mall.goods.controller;

import com.github.pagehelper.PageInfo;
import com.thankson.common.util.business.Result;
import com.thankson.common.util.constant.StatusCode;
import com.thankson.mall.goods.pojo.Album;
import com.thankson.mall.goods.service.AlbumService;
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
 * 相册
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    /**
     * 多条件分页查询
     *
     * @param album 查询条件
     * @param page  当前页数
     * @param size  每页显示多少条
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Album>> findPage(@RequestBody(required = false) Album album, @PathVariable int page, @PathVariable int size) {
        PageInfo<Album> pageInfo = albumService.findPage(album, page, size);
        return new Result<>(true, StatusCode.SUCCESS, "查询成功", pageInfo);
    }

    /**
     * Album分页搜索实现
     *
     * @param page 当前页数
     * @param size 每页显示多少条
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Album>> findPage(@PathVariable int page, @PathVariable int size) {
        PageInfo<Album> pageInfo = albumService.findPage(page, size);
        return new Result<>(true, StatusCode.SUCCESS, "查询成功", pageInfo);
    }

    /**
     * Album多条件搜索实现
     *
     * @param album 查询条件
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping(value = "/search")
    public Result<List<Album>> findList(@RequestBody(required = false) Album album) {
        List<Album> list = albumService.findList(album);
        return new Result<>(true, StatusCode.SUCCESS, "查询成功", list);
    }

    /**
     * 根据ID删除数据
     *
     * @param id 相册id
     * @author Thankson
     * @date 2020年05月06日
     */
    @DeleteMapping(value = "/{id}")
    public Result<Object> delete(@PathVariable Long id) {
        boolean result = albumService.delete(id);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "删除成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "删除失败");
    }

    /**
     * 修改Album数据
     *
     * @param album 修改内容
     * @param id    相册id
     * @author Thankson
     * @date 2020年05月06日
     */
    @PutMapping(value = "/{id}")
    public Result<Object> update(@RequestBody Album album, @PathVariable Long id) {
        album.setId(id);
        boolean result = albumService.update(album);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "修改成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "修改失败");
    }

    /**
     * 新增Album数据
     *
     * @param album 新增数据
     * @author Thankson
     * @date 2020年05月06日
     */
    @PostMapping
    public Result<Object> add(@RequestBody Album album) {
        boolean result = albumService.add(album);
        if (result) {
            return new Result<>(true, StatusCode.SUCCESS, "添加成功");
        }
        return new Result<>(true, StatusCode.FAILURE, "添加失败");
    }

    /**
     * 根据ID查询Album数据
     *
     * @param id 相册id
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping("/{id}")
    public Result<Album> findById(@PathVariable Long id) {
        //调用AlbumService实现根据主键查询Album
        Album album = albumService.findById(id);
        return new Result<>(true, StatusCode.SUCCESS, "查询成功", album);
    }

    /**
     * 查询Album全部数据
     *
     * @author Thankson
     * @date 2020年05月06日
     */
    @GetMapping
    public Result<List<Album>> findAll() {
        List<Album> list = albumService.findAll();
        return new Result<>(true, StatusCode.SUCCESS, "查询成功", list);
    }
}
