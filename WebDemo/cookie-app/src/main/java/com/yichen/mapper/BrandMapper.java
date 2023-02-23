package com.yichen.mapper;

import com.yichen.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 添加
     * @param brand
     */
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName}," +
            "#{ordered},#{description},#{status})")
    void add(Brand brand);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from tb_brand where id=#{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id=#{id}")
    void update(Brand brand);
    /*update 表名 set 列名1=值1，列名2=值2,… [where 条件];
    update stu set sex='女' where name='张三';不加where全部修改*/

    @Delete("delete from tb_brand where id=#{id}")
    void deleteById(int id);
//    16.	删除数据 from 表名 [where 条件];

}
