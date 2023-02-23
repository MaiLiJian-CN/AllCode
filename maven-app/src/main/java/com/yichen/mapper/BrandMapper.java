package com.yichen.mapper;

import com.yichen.pojo.Brand;
import com.yichen.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     * 查询所有
     */
    public List<Brand> selectAll();

    /**
     * 查看详情:根据id查看
     */
    List<Brand> selectById(int id);

    /**
     * 多条件查询
     */
 /*   List<Brand> selectByCondition(@Param("status")int status,@Param("companyName")String companyName,
                                  @Param("brandName")String brandName);*/
    List<Brand> selectByCondition(Map map);

    /**
     * 单条件查询
     */
    List<Brand> selectByConditionSimple(Brand brand);

    /**
     * 添加功能
     */
    void brandAdd(Brand brand);

    /**
     * 修改功能
     */
    Integer brandUpdate(Brand brand);

    /**
     * 批量删除
     */
    void brandDelete(@Param("ids") int[] ids);
}
