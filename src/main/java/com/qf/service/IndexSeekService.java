package com.qf.service;

import com.qf.vo.LayuiR;
import com.qf.vo.R;

/**
 * @ClassName: IndexSeekService
 * @Author: 蒋福林
 * @Date: 2020/7/21
 * @Time: 19：48
 */
public interface IndexSeekService {

    //LayuiR indexSeek(String goods_name, int pageNo, int pageSize);
    R indexSeek(String goods_name);
    R indexByBrand(int goods_brand);
}
