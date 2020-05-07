package com.thankson.mall.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thankson.mall.goods.dao.PrefMapper;
import com.thankson.mall.goods.pojo.Pref;
import com.thankson.mall.goods.service.PrefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * pref业务接口实现层
 *
 * @author Thankson
 * @date 2020年05月06日
 */
@Service
public class PrefServiceImpl implements PrefService {

    @Autowired
    private PrefMapper prefMapper;

    @Override
    public PageInfo<Pref> findPage(Pref pref, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pref);
        //执行搜索
        return new PageInfo<>(prefMapper.selectByExample(example));
    }

    @Override
    public PageInfo<Pref> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<>(prefMapper.selectAll());
    }

    @Override
    public List<Pref> findList(Pref pref){
        //构建查询条件
        Example example = createExample(pref);
        //根据构建的条件查询数据
        return prefMapper.selectByExample(example);
    }

    public Example createExample(Pref pref){
        Example example=new Example(Pref.class);
        Example.Criteria criteria = example.createCriteria();
        if(pref!=null){
            // ID
            if(!StringUtils.isEmpty(pref.getId())){
                    criteria.andEqualTo("id",pref.getId());
            }
            // 分类ID
            if(!StringUtils.isEmpty(pref.getCateId())){
                    criteria.andEqualTo("cateId",pref.getCateId());
            }
            // 消费金额
            if(!StringUtils.isEmpty(pref.getBuyMoney())){
                    criteria.andEqualTo("buyMoney",pref.getBuyMoney());
            }
            // 优惠金额
            if(!StringUtils.isEmpty(pref.getPreMoney())){
                    criteria.andEqualTo("preMoney",pref.getPreMoney());
            }
            // 活动开始日期
            if(!StringUtils.isEmpty(pref.getStartTime())){
                    criteria.andEqualTo("startTime",pref.getStartTime());
            }
            // 活动截至日期
            if(!StringUtils.isEmpty(pref.getEndTime())){
                    criteria.andEqualTo("endTime",pref.getEndTime());
            }
            // 类型
            if(!StringUtils.isEmpty(pref.getType())){
                    criteria.andEqualTo("type",pref.getType());
            }
            // 状态
            if(!StringUtils.isEmpty(pref.getState())){
                    criteria.andEqualTo("state",pref.getState());
            }
        }
        return example;
    }

    @Override
    public boolean delete(Integer id){
        int result = prefMapper.deleteByPrimaryKey(id);
        return result > 0;
    }

    @Override
    public boolean update(Pref pref){
        int result = prefMapper.updateByPrimaryKey(pref);
        return result > 0;
    }

    @Override
    public boolean add(Pref pref){
        int result = prefMapper.insert(pref);
        return result > 0;
    }

    @Override
    public Pref findById(Integer id){
        return  prefMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pref> findAll() {
        return prefMapper.selectAll();
    }
}
