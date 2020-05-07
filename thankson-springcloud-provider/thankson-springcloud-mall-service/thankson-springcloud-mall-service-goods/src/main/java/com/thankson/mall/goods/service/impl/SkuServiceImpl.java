package com.thankson.mall.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thankson.mall.goods.dao.SkuMapper;
import com.thankson.mall.goods.pojo.Sku;
import com.thankson.mall.goods.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * sku业务接口实现层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public PageInfo<Sku> findPage(Sku sku, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sku);
        //执行搜索
        return new PageInfo<>(skuMapper.selectByExample(example));
    }

    @Override
    public PageInfo<Sku> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<>(skuMapper.selectAll());
    }

    @Override
    public List<Sku> findList(Sku sku){
        //构建查询条件
        Example example = createExample(sku);
        //根据构建的条件查询数据
        return skuMapper.selectByExample(example);
    }

    public Example createExample(Sku sku){
        Example example=new Example(Sku.class);
        Example.Criteria criteria = example.createCriteria();
        if(sku!=null){
            // 商品id
            if(!StringUtils.isEmpty(sku.getId())){
                    criteria.andEqualTo("id",sku.getId());
            }
            // 商品条码
            if(!StringUtils.isEmpty(sku.getSn())){
                    criteria.andEqualTo("sn",sku.getSn());
            }
            // SKU名称
            if(!StringUtils.isEmpty(sku.getName())){
                    criteria.andLike("name","%"+sku.getName()+"%");
            }
            // 价格（分）
            if(!StringUtils.isEmpty(sku.getPrice())){
                    criteria.andEqualTo("price",sku.getPrice());
            }
            // 库存数量
            if(!StringUtils.isEmpty(sku.getNum())){
                    criteria.andEqualTo("num",sku.getNum());
            }
            // 库存预警数量
            if(!StringUtils.isEmpty(sku.getAlertNum())){
                    criteria.andEqualTo("alertNum",sku.getAlertNum());
            }
            // 商品图片
            if(!StringUtils.isEmpty(sku.getImage())){
                    criteria.andEqualTo("image",sku.getImage());
            }
            // 商品图片列表
            if(!StringUtils.isEmpty(sku.getImages())){
                    criteria.andEqualTo("images",sku.getImages());
            }
            // 重量（克）
            if(!StringUtils.isEmpty(sku.getWeight())){
                    criteria.andEqualTo("weight",sku.getWeight());
            }
            // 创建时间
            if(!StringUtils.isEmpty(sku.getCreateTime())){
                    criteria.andEqualTo("createTime",sku.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(sku.getUpdateTime())){
                    criteria.andEqualTo("updateTime",sku.getUpdateTime());
            }
            // SPUID
            if(!StringUtils.isEmpty(sku.getSpuId())){
                    criteria.andEqualTo("spuId",sku.getSpuId());
            }
            // 类目ID
            if(!StringUtils.isEmpty(sku.getCategoryId())){
                    criteria.andEqualTo("categoryId",sku.getCategoryId());
            }
            // 类目名称
            if(!StringUtils.isEmpty(sku.getCategoryName())){
                    criteria.andEqualTo("categoryName",sku.getCategoryName());
            }
            // 品牌名称
            if(!StringUtils.isEmpty(sku.getBrandName())){
                    criteria.andEqualTo("brandName",sku.getBrandName());
            }
            // 规格
            if(!StringUtils.isEmpty(sku.getSpec())){
                    criteria.andEqualTo("spec",sku.getSpec());
            }
            // 销量
            if(!StringUtils.isEmpty(sku.getSaleNum())){
                    criteria.andEqualTo("saleNum",sku.getSaleNum());
            }
            // 评论数
            if(!StringUtils.isEmpty(sku.getCommentNum())){
                    criteria.andEqualTo("commentNum",sku.getCommentNum());
            }
            // 商品状态 1-正常，2-下架，3-删除
            if(!StringUtils.isEmpty(sku.getStatus())){
                    criteria.andEqualTo("status",sku.getStatus());
            }
            // 
            if(!StringUtils.isEmpty(sku.getVersion())){
                    criteria.andEqualTo("version",sku.getVersion());
            }
        }
        return example;
    }

    @Override
    public boolean delete(String id){
        int result = skuMapper.deleteByPrimaryKey(id);
        return result > 0;
    }

    @Override
    public boolean update(Sku sku){
        int result = skuMapper.updateByPrimaryKey(sku);
        return result > 0;
    }

    @Override
    public boolean add(Sku sku){
        int result = skuMapper.insert(sku);
        return result > 0;
    }

    @Override
    public Sku findById(String id){
        return  skuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Sku> findAll() {
        return skuMapper.selectAll();
    }
}
