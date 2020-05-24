package com.thankson.mall.advert.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thankson.mall.advert.dao.AdvertCategoryMapper;
import com.thankson.mall.advert.pojo.AdvertCategory;
import com.thankson.mall.advert.service.AdvertCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * advertCategory业务接口实现层
 *
 * @author Thankson
 * @date 2020年04月02日
 */
@Service
public class AdvertCategoryServiceImpl implements AdvertCategoryService {

    @Autowired
    private AdvertCategoryMapper advertCategoryMapper;

    @Override
    public PageInfo<AdvertCategory> findPage(AdvertCategory advertCategory, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(advertCategory);
        //执行搜索
        return new PageInfo<>(advertCategoryMapper.selectByExample(example));
    }

    @Override
    public PageInfo<AdvertCategory> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<>(advertCategoryMapper.selectAll());
    }

    @Override
    public List<AdvertCategory> findList(AdvertCategory advertCategory){
        //构建查询条件
        Example example = createExample(advertCategory);
        //根据构建的条件查询数据
        return advertCategoryMapper.selectByExample(example);
    }

    public Example createExample(AdvertCategory advertCategory){
        Example example=new Example(AdvertCategory.class);
        Example.Criteria criteria = example.createCriteria();
        if(advertCategory!=null){
            // 类目Id
            if(!StringUtils.isEmpty(advertCategory.getId())){
                    criteria.andEqualTo("id",advertCategory.getId());
            }
            // 分类名称
            if(!StringUtils.isEmpty(advertCategory.getName())){
                    criteria.andLike("name","%"+advertCategory.getName()+"%");
            }
        }
        return example;
    }

    @Override
    public boolean delete(Integer id){
        int result = advertCategoryMapper.deleteByPrimaryKey(id);
        return result > 0;
    }

    @Override
    public boolean update(AdvertCategory advertCategory){
        int result = advertCategoryMapper.updateByPrimaryKey(advertCategory);
        return result > 0;
    }

    @Override
    public boolean add(AdvertCategory advertCategory){
        int result = advertCategoryMapper.insert(advertCategory);
        return result > 0;
    }

    @Override
    public AdvertCategory findById(Integer id){
        return  advertCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AdvertCategory> findAll() {
        return advertCategoryMapper.selectAll();
    }
}
