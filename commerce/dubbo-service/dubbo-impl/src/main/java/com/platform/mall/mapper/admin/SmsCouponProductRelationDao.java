package com.platform.mall.mapper.admin;

import com.platform.mall.entity.admin.SmsCouponProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券和产品关系自定义Dao
 * Created by wulinhao on 2020/3/28.
 */
public interface SmsCouponProductRelationDao {
    int insertList(@Param("list") List<SmsCouponProductRelation> productRelationList);
}
