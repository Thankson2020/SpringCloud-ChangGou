package com.thankson.mall.advert.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thankson.mall.advert.dao.AdvertMapper;
import com.thankson.mall.advert.pojo.Advert;
import com.thankson.mall.advert.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * advert业务接口实现层
 *
 * @author Thankson
 * @date 2020年04月02日
 */
@Service
public class AdvertServiceImpl implements AdvertService {

    @Autowired
    private AdvertMapper advertMapper;

    @Override
    public PageInfo<Advert> findPage(Advert advert, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(advert);
        //执行搜索
        return new PageInfo<>(advertMapper.selectByExample(example));
    }

    @Override
    public PageInfo<Advert> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<>(advertMapper.selectAll());
    }

    @Override
    public List<Advert> findList(Advert advert){
        //构建查询条件
        Example example = createExample(advert);
        //根据构建的条件查询数据
        return advertMapper.selectByExample(example);
    }

    public Example createExample(Advert advert){
        Example example=new Example(Advert.class);
        Example.Criteria criteria = example.createCriteria();
        if(advert!=null){
            // 
            if(!StringUtils.isEmpty(advert.getId())){
                    criteria.andEqualTo("id",advert.getId());
            }
            // 内容类目Id
            if(!StringUtils.isEmpty(advert.getCategoryId())){
                    criteria.andEqualTo("categoryId",advert.getCategoryId());
            }
            // 内容标题
            if(!StringUtils.isEmpty(advert.getTitle())){
                    criteria.andLike("title","%"+advert.getTitle()+"%");
            }
            // 链接
            if(!StringUtils.isEmpty(advert.getUrl())){
                    criteria.andEqualTo("url",advert.getUrl());
            }
            // 图片绝对路径
            if(!StringUtils.isEmpty(advert.getPic())){
                    criteria.andEqualTo("pic",advert.getPic());
            }
            // 有效状态
            if(!StringUtils.isEmpty(advert.getStatus())){
                    criteria.andEqualTo("status",advert.getStatus());
            }
            // 排序
            if(!StringUtils.isEmpty(advert.getSortOrder())){
                    criteria.andEqualTo("sortOrder",advert.getSortOrder());
            }
        }
        return example;
    }

    @Override
    public boolean delete(Integer id){
        int result = advertMapper.deleteByPrimaryKey(id);
        return result > 0;
    }

    @Override
    public boolean update(Advert advert){
        int result = advertMapper.updateByPrimaryKey(advert);
        return result > 0;
    }

    @Override
    public boolean add(Advert advert){
        int result = advertMapper.insert(advert);
        return result > 0;
    }

    @Override
    public Advert findById(Integer id){
        return  advertMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Advert> findAll() {
        return advertMapper.selectAll();
    }

    @Override
    public List<Advert> findByCategory(Integer id) {
        Advert advert = new Advert();
        advert.setCategoryId(id);
        advert.setStatus("1");
        return advertMapper.select(advert);
    }
}
