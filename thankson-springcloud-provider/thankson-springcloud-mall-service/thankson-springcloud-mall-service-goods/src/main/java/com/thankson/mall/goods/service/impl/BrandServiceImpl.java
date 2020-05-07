package com.thankson.mall.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thankson.mall.goods.dao.BrandMapper;
import com.thankson.mall.goods.pojo.Brand;
import com.thankson.mall.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * brand业务接口实现层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageInfo<Brand> findPage(Brand brand, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(brand);
        //执行搜索
        return new PageInfo<>(brandMapper.selectByExample(example));
    }

    @Override
    public PageInfo<Brand> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<>(brandMapper.selectAll());
    }

    @Override
    public List<Brand> findList(Brand brand){
        //构建查询条件
        Example example = createExample(brand);
        //根据构建的条件查询数据
        return brandMapper.selectByExample(example);
    }

    public Example createExample(Brand brand){
        Example example=new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if(brand!=null){
            // 品牌id
            if(!StringUtils.isEmpty(brand.getId())){
                    criteria.andEqualTo("id",brand.getId());
            }
            // 品牌名称
            if(!StringUtils.isEmpty(brand.getName())){
                    criteria.andLike("name","%"+brand.getName()+"%");
            }
            // 品牌图片地址
            if(!StringUtils.isEmpty(brand.getImage())){
                    criteria.andEqualTo("image",brand.getImage());
            }
            // 品牌的首字母
            if(!StringUtils.isEmpty(brand.getLetter())){
                    criteria.andEqualTo("letter",brand.getLetter());
            }
            // 排序
            if(!StringUtils.isEmpty(brand.getSeq())){
                    criteria.andEqualTo("seq",brand.getSeq());
            }
        }
        return example;
    }

    @Override
    public boolean delete(Integer id){
        int result = brandMapper.deleteByPrimaryKey(id);
        return result > 0;
    }

    @Override
    public boolean update(Brand brand){
        int result = brandMapper.updateByPrimaryKey(brand);
        return result > 0;
    }

    @Override
    public boolean add(Brand brand){
        int result = brandMapper.insert(brand);
        return result > 0;
    }

    @Override
    public Brand findById(Integer id){
        return  brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
}
