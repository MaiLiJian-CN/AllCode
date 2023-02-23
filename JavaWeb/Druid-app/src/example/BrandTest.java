package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;
import org.testng.annotations.Test;
import pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.lang.annotation.Target;
import java.net.URL;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {
    /**
     *1.sql:select * from tb_brand;
     */
    List<Brand> brands=new ArrayList<>();
    @Test
    public void testSelectALl() throws Exception{
        //加载配置文件
        Properties prop=new Properties();
        //定义一个ClassLoader类加载器
        ClassLoader cls= JdbcUtils.class.getClassLoader();
        URL res=cls.getResource("druid.properties");
        String path=res.getPath();

        prop.load(new FileInputStream(path));
        //获取连接池对象
        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接Connection
        Connection coon=dataSource.getConnection();

        //定义sql语句
        String sql="select * from tb_brand";

        //获取PPTS对象
        PreparedStatement ppts=coon.prepareStatement(sql);

        //执行sql
        ResultSet resultSet = ppts.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");
            Brand brand=new Brand(id,brandName,companyName,ordered,description,status);
            brands.add(brand);
        }
        //释放资源
        resultSet.close();
        ppts.close();
        coon.close();
        //打印列表
        for (Brand brand : brands) {
            System.out.println(brand.getId()+" "+brand.getBrandName()+" "+brand.getCompanyName()+
                    " "+brand.getOrdered()+" "+brand.getDescription()+" "+brand.getStatus());
        }
    }
    @Test
    public void testAdd() throws Exception{
        String brandName="香飘飘";
        String companyName="香飘飘公司";
        int order=1;
        String description="绕地球一圈";
        int status=1;

        //加载配置文件
        Properties prop=new Properties();
        //定义一个ClassLoader类加载器
        ClassLoader cls= JdbcUtils.class.getClassLoader();
        URL res=cls.getResource("druid.properties");
        String path=res.getPath();

        prop.load(new FileInputStream(path));
        //获取连接池对象
        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接Connection
        Connection coon=dataSource.getConnection();

        //定义sql语句
        String sql =
                "insert into tb_brand(brand_name,company_name, ordered, description, status) values(?,?,?,?,?);";

        //获取PPTS对象
        PreparedStatement ppts=coon.prepareStatement(sql);

        //设置参数
        ppts.setString(1,brandName);
        ppts.setString(2,companyName);
        ppts.setInt(3,order);
        ppts.setString(4,description);
        ppts.setInt(5,status);

        //执行sql
        int  count= ppts.executeUpdate();
        if (count>0) System.out.println("添加成功");else System.out.println("添加失败");
        /**
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");
            Brand brand=new Brand(id,brandName,companyName,ordered,description,status);
            brands.add(brand);
        }
         */
        //释放资源

        ppts.close();
        coon.close();
        //打印列表
        /**
        for (Brand brand : brands) {
            System.out.println(brand.getId()+" "+brand.getBrandName()+" "+brand.getCompanyName()+
                    " "+brand.getOrdered()+" "+brand.getDescription()+" "+brand.getStatus());
        }
         */
    }
    @Test
    public void testUpdate() throws Exception{
        String brandName="香飘飘飘飘";
        String companyName="香飘飘飘飘公司";
        int order=100;
        String description="绕地球十圈";
        int status=1;
        int id=4;

        //加载配置文件
        Properties prop=new Properties();
        //定义一个ClassLoader类加载器
        ClassLoader cls= JdbcUtils.class.getClassLoader();
        URL res=cls.getResource("druid.properties");
        String path=res.getPath();

        prop.load(new FileInputStream(path));
        //获取连接池对象
        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接Connection
        Connection coon=dataSource.getConnection();

        //定义sql语句
        String sql = "update tb_brand set brand_name=?,company_name=?,ordered=?,description=?,status=?" +
                " where id=?;";

        //获取PPTS对象
        PreparedStatement ppts=coon.prepareStatement(sql);

        //设置参数
        ppts.setString(1,brandName);
        ppts.setString(2,companyName);
        ppts.setInt(3,order);
        ppts.setString(4,description);
        ppts.setInt(5,status);
        ppts.setInt(6,id);

        //执行sql
        int  count= ppts.executeUpdate();
        if (count>0) System.out.println("修改成功");else System.out.println("修改失败");
        /**
         while (resultSet.next()){
         int id = resultSet.getInt("id");
         String brandName = resultSet.getString("brand_name");
         String companyName = resultSet.getString("company_name");
         int ordered = resultSet.getInt("ordered");
         String description = resultSet.getString("description");
         int status = resultSet.getInt("status");
         Brand brand=new Brand(id,brandName,companyName,ordered,description,status);
         brands.add(brand);
         }
         */
        //释放资源

        ppts.close();
        coon.close();
        //打印列表
        /**
         for (Brand brand : brands) {
         System.out.println(brand.getId()+" "+brand.getBrandName()+" "+brand.getCompanyName()+
         " "+brand.getOrdered()+" "+brand.getDescription()+" "+brand.getStatus());
         }
         */
    }

}
