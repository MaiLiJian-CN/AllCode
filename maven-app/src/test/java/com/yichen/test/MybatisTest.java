package com.yichen.test;

import com.yichen.mapper.BrandMapper;
import com.yichen.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void TestSelectAll() throws Exception{
        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper接口的代理对象
        BrandMapper Brandmapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        List<Brand> brands = Brandmapper.selectAll();
        //打印，释放资源
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void TestSelectById() throws Exception{
        int id=1;
        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper接口的代理对象
        BrandMapper Brandmapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
        List<Brand> brands = Brandmapper.selectById(id);
        //打印，释放资源
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void selectByCondition() throws Exception{
        int status=1;
        String brandName="华为";
        String companyName="华为";

        //处理参数
        brandName="%"+brandName+"%";
        companyName="%"+companyName+"%";

        //map方法
        Map map=new HashMap<>();
//        map.put("status",status);
//        map.put("companyName",companyName);
        map.put("brandName",brandName);

        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper接口的代理对象
        BrandMapper Brandmapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
//        List<Brand> brands = Brandmapper.selectByCondition(status,companyName,brandName);
        List<Brand> brands = Brandmapper.selectByCondition(map);

        //打印，释放资源
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void selectByConditionSimple() throws Exception{
//        int status=1;
//        String brandName="华为";
        String companyName="华为";

        //处理参数
//        brandName="%"+brandName+"%";
        companyName="%"+companyName+"%";

        Brand brand=new Brand();
//        brand.setStatus(status);
//        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);

       /* //map方法
        Map map=new HashMap<>();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);*/

        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper接口的代理对象
        BrandMapper Brandmapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
//        List<Brand> brands = Brandmapper.selectByCondition(status,companyName,brandName);
        List<Brand> brands = Brandmapper.selectByConditionSimple(brand);

        //打印，释放资源
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void brandAdd() throws Exception{
        String brandName="蜜雪冰城";
        String companyName="蜜雪冰城有限公司";
        String description="奶茶届的莆田";
        int ordered=10;
        int status=1;
        //处理参数
//        brandName="%"+brandName+"%";
//        companyName="%"+companyName+"%";

        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setOrdered(ordered);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
       /* //map方法
        Map map=new HashMap<>();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);*/

        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper接口的代理对象
        BrandMapper Brandmapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
//        List<Brand> brands = Brandmapper.selectByCondition(status,companyName,brandName);
        Brandmapper.brandAdd(brand);
        Integer id = brand.getId();
        System.out.println(id);
        //打印，释放资源
//        System.out.println(brands);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void brandUpdate() throws Exception{
        String brandName="深职院";
        String companyName="深圳职业技术学院";
        String description="大专职业院校中的清华北大";
        int ordered=100;
        int status=0;
        int id=5;
        //处理参数
//        brandName="%"+brandName+"%";
//        companyName="%"+companyName+"%";

        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setOrdered(ordered);
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setDescription(description);
        brand.setId(5);
       /* //map方法
        Map map=new HashMap<>();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);*/

        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper接口的代理对象
        BrandMapper Brandmapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
//        List<Brand> brands = Brandmapper.selectByCondition(status,companyName,brandName);
        Integer count = Brandmapper.brandUpdate(brand);

        System.out.println(count);
        //打印，释放资源
//        System.out.println(brands);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void brandDelete() throws Exception{
        int[] ids={5,6};
        //处理参数
//        brandName="%"+brandName+"%";
//        companyName="%"+companyName+"%";

//        Brand brand=new Brand();
//        brand.setStatus(status);
//        brand.setOrdered(ordered);
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setDescription(description);
//        brand.setId(5);
       /* //map方法
        Map map=new HashMap<>();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);*/

        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper接口的代理对象
        BrandMapper Brandmapper = sqlSession.getMapper(BrandMapper.class);
        //执行方法
//        List<Brand> brands = Brandmapper.selectByCondition(status,companyName,brandName);
        Brandmapper.brandDelete(ids);

//        System.out.println(count);
        //打印，释放资源
//        System.out.println(brands);
        sqlSession.commit();
        sqlSession.close();
    }
}
