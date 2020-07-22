package com.qf.service.impl;

import com.qf.dao.IndexSeekDao;
import com.qf.dto.IndexDto;
import com.qf.pojo.Goods;
import com.qf.pojo.User;
import com.qf.service.IndexSeekService;
import com.qf.vo.LayuiR;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: IndexSeekServiceImpl
 * @Author: 蒋福林
 * @Date: 2020/7/21
 * @Time: 19：50
 */

@Service
public class IndexSeekServiceImpl implements IndexSeekService{

    @Autowired
    private IndexSeekDao indexSeekDao;

    @Override
    public R indexSeek (String goods_name) {
        goods_name = "%"+ goods_name +"%";
        List<IndexDto> list = indexSeekDao.indexSeek(goods_name);
        return R.ok(list);
    }

    @Override
    public R indexByBrand (int goods_brand) {
        List<IndexDto> list = indexSeekDao.indexByBrand(goods_brand);
        return R.ok(list);
    }

    /*@Override
    public LayuiR indexSeek (String goods_name, int pageNo, int pageSize) {
        IndexDto indexDto = new IndexDto();
        List<IndexDto> list = indexSeekDao.indexSeek(goods_name, pageNo, pageSize);

        LayuiR r = new LayuiR();
        r.setCode(200);
        r.setMsg("成功");
        r.setCount(list.size());
        r.setData(list);
        System.out.println("r = " + r);
        return r;
    }*/

    //根据
}
