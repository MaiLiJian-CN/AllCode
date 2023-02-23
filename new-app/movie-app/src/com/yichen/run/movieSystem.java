package com.yichen.run;

import com.yichen.bean.Customer;
import com.yichen.bean.MovieDemo;
import com.yichen.bean.User;
import com.yichen.bean.business;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class movieSystem {
    /**
     *集合存储所有用户
     */
    public static final List<User> ALL_USERS=new ArrayList<>();

    /**
     * 键值对存储商家排片 商家=【影1，影2...】
     */
    public static final Map<business, List<MovieDemo>> ALL_MOVIES=new HashMap<>();

    /**
     * 测试数据
     */
    static {
        //客户数据
        Customer c1=new Customer();
        c1.setUsername("刘德华");
        c1.setLoginName("mlj123");
        c1.setPassword("123456");
        c1.setSex('男');
        c1.setMoney(10000);
        c1.setPhone("110110");
        ALL_USERS.add(c1);

        Customer c2 = new Customer();
        c2.setLoginName("gzl888");
        c2.setPassword("123456");
        c2.setUsername("黑马关之琳");
        c2.setSex('女');
        c2.setMoney(2000);
        c2.setPhone("111111");
        ALL_USERS.add(c2);

        business b = new business();
        b.setLoginName("baozugong888");
        b.setPassword("123456");
        b.setUsername("黑马包租公");
        b.setMoney(0);
        b.setSex('男');
        b.setPhone("110110");
        b.setAddress("火星6号2B二层");
        b.setShopName("甜甜圈国际影城");
        ALL_USERS.add(b);
        // 注意，商家一定需要加入到店铺排片信息中去
        List<MovieDemo> movies=new ArrayList<>();
        ALL_MOVIES.put(b,movies);

        business b2 = new business();
        b2.setLoginName("baozupo888");
        b2.setPassword("123456");
        b2.setUsername("黑马包租婆");
        b2.setMoney(0);
        b2.setSex('女');
        b2.setPhone("110110");
        b2.setAddress("火星8号8B八层");
        b2.setShopName("巧克力国际影城");
        ALL_USERS.add(b2);
        // 注意，商家一定需要加入到店铺排片信息中去
        List<MovieDemo> movies3 = new ArrayList<>();
        ALL_MOVIES.put(b2 , movies3); // b2 = []
    }

    //静态输入对象
    public static final Scanner SYS_SC=new Scanner(System.in);

    //确定登录对象
    public static User loginUser;

    //放映时间对象
    public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    //日志对象
    public static final Logger LOGGER= LoggerFactory.getLogger("movieSystem.class");

    public static void main(String[] args) {
        //操作界面
        while (true) {
            System.out.println("===========首页============");
            System.out.println("1：登录");
            System.out.println("2：商家注册");
            System.out.println("3：用户注册");
            System.out.println("请选择操作：");
            String command=SYS_SC.nextLine();
            switch (command){
                case "1":
                    //登录
                    login();
                    break;
                case "2":
                    //商家注册
                    break;
                case "3":
                    //用户注册
                    break;
                default:
                    System.out.println("操作有误！");

            }
        }
    }

    /**
     * 登录功能
     */
    private static void login() {
        while (true) {
            System.out.println("输入登录用户名");
            String loginName=SYS_SC.nextLine();
            System.out.println("输入登录密码");
            String password=SYS_SC.nextLine();

            User user=getUserByLoginName(loginName);
            if (user!=null){
                if (user.getPassword().equals(password)){
                    System.out.println("登陆成功");
                    loginUser=user;
                    LOGGER.info(loginUser.getUsername()+"登录系统");
                    //判断客户类还是商家类
                    if (user instanceof Customer){
                        shopCustom_main();
                    }else {
                        shopBusiness_main();
                    }
                    break;
                }else {
                    System.out.println("密码错误，重新输入");
                }
            }else {
                System.out.printf("无此用户，重新输入");
            }
        }
    }

    /**
     * 商家后台操作界面
     */
    private static void shopBusiness_main() {
        while (true) {
            System.out.println("============黑马电影商家界面===================");
            System.out.println(loginUser.getUsername() + (loginUser.getSex()=='男'? "先生":"女士" + "欢迎您进入系统"));
            System.out.println("1、展示详情:");
            System.out.println("2、上架电影:");
            System.out.println("3、下架电影:");
            System.out.println("4、修改电影:");
            System.out.println("5、退出:");
            System.out.println("请输入您要操作的命令：");
            String command = SYS_SC.nextLine();
            switch (command){
                case "1":
                    // 展示全部排片信息
                    shopBusiness_infos();
                    break;
                case "2":
                    // 上架电影信息
                    addMovie();
                    break;
                case "3":
                    // 下架电影信息
                    deleteMovie();
                    break;
                case "4":
                    // 修改电影信息
                    updateMovie();
                    break;
                case "5":
                    return; // 干掉方法
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }

    /**
     *影片下架
     */
    private static void deleteMovie() {
        business b=(business) loginUser;
        List<MovieDemo> movies=ALL_MOVIES.get(b);
        System.out.println("=============下架页面===============");
        if (movies.size()==0){
            System.out.println("当前无影片");
            return;
        }
        while (true) {
            System.out.println("请输入下架影片名：");
            String movieName=SYS_SC.nextLine();

            MovieDemo getMovie=movieCheck(movieName);
            if (getMovie!=null){
                System.out.println("《"+getMovie.getMovie_name()+"》"+"下架成功");
                movies.remove(getMovie);
                shopBusiness_infos();
                return;
            }else {
                System.out.println("查无此片");
            }
        }
    }

    /**
     *模糊查询
     */
    public static MovieDemo movieCheck(String movieName){
        business b=(business) loginUser;
        List<MovieDemo> movies=ALL_MOVIES.get(b);
        for (MovieDemo movie : movies) {
            if (movie.getMovie_name().contains(movieName)){
                return movie;
            }
        }
        return null;
    }

    /**
     * 修改影片信息
     */
    private static void updateMovie() {
        business b=(business) loginUser;
        List<MovieDemo> movies=ALL_MOVIES.get(b);
        System.out.println("=============影片修改页面===============");
        if (movies.size()==0){
            System.out.println("当前无影片");
            return;
        }
        while (true) {
            System.out.println("请输入修改影片名：");
            String movieName=SYS_SC.nextLine();
            MovieDemo getMovie = movieCheck(movieName);
            if (getMovie!=null){
                //修改
                System.out.println("请输入修改后的电影片名");
                String name=SYS_SC.nextLine();
                System.out.println("请输入修改后的电影主演");
                String actor=SYS_SC.nextLine();
                System.out.println("请输入修改后的电影时长");
                String time=SYS_SC.nextLine();
                System.out.println("请输入修改后的电影票价");
                String price=SYS_SC.nextLine();
                System.out.println("请输入修改后的电影票数");
                String total=SYS_SC.nextLine();
            while (true) {
                    System.out.println("请输入修改后的电影放映时间");
                    String sTime=SYS_SC.nextLine();

                    try {
                        getMovie.setMovie_name(name);
                        getMovie.setActor(actor);
                        getMovie.setTime(Double.valueOf(time));
                        getMovie.setPrice(Double.valueOf(price));
                        getMovie.setNumber(Integer.valueOf(total));
                        getMovie.setStartTime(sdf.parse(sTime));
                        shopBusiness_infos();
                        return;
                    } catch (Exception e) {
                        LOGGER.error("修改解析出了问题");
                        e.printStackTrace();
                    }
                }
            }else {
                System.out.println("查无此片");
            }
        }
    }

    /**
     * 商家进行电影上架
     */
    private static void addMovie() {
        business b=(business) loginUser;
        List<MovieDemo> movies=ALL_MOVIES.get(b);
        LOGGER.info(b.getShopName()+"上架电影");

        System.out.println("请输入上架电影片名");
        String name=SYS_SC.nextLine();
        System.out.println("请输入上架电影主演");
        String actor=SYS_SC.nextLine();
        System.out.println("请输入上架电影时长");
        String time=SYS_SC.nextLine();
        System.out.println("请输入上架电影票价");
        String price=SYS_SC.nextLine();
        System.out.println("请输入上架电影票数");
        String total=SYS_SC.nextLine();
        while (true) {
            System.out.println("请输入电影放映时间");
            String sTime=SYS_SC.nextLine();
            /**
             MovieDemo(String movie_name, String actor, Double time, Double price, int number, Date startTime)
             */
            try {
                MovieDemo movieDemo=new MovieDemo(name,actor,Double.valueOf(time),Double.valueOf(price),Integer.valueOf(total),
                        sdf.parse(sTime));
                movies.add(movieDemo);
                shopBusiness_infos();
                return;
            } catch (ParseException e) {
                LOGGER.error("时间解析出了问题");
                e.printStackTrace();
            }
        }
    }

    /**
     * 展现商家数据
     */
    private static void shopBusiness_infos() {
        System.out.println("===============商家详情================");
        business b=(business) loginUser;
        LOGGER.info(b.getShopName()+"查看系统");
        System.out.println(b.getShopName()+"\t\t电话"+b.getPhone()+"\t\t地址"+b.getAddress());
        List<MovieDemo> movies=ALL_MOVIES.get(b);
        if (movies.size()>0) {
            System.out.println("电影\t\t"+"\t\t主演"+"\t\t时长"+ "\t\t评分"+"\t\t票价"+"\t\t余票"+"\t\t放映时间");
            for (MovieDemo movie : movies) {
                System.out.println(movie.getMovie_name()+"\t\t"+movie.getActor()+"\t\t"+movie.getTime()+"\t\t"+
                        movie.getScore()+"\t\t"+movie.getPrice()+"\t\t"+movie.getNumber()+"\t\t"+sdf.format(movie.getStartTime()));
            }
        }else {
            System.out.println(" 您当前没有电影上映");
        }
    }

    /**
     * 客户界面
     */
    private static void shopCustom_main() {
        System.out.println("============黑马电影客户界面===================");
        System.out.println(loginUser.getUsername() + (loginUser.getSex()=='男'? "先生":"女士" + "欢迎您进入系统"));
        while (true) {
            System.out.println("请您选择要操作的功能：");
            System.out.println("1、展示全部影片信息功能:");
            System.out.println("2、根据电影名称查询电影信息:");
            System.out.println("3、评分功能:");
            System.out.println("4、购票功能:");
            System.out.println("5、退出系统:");
            System.out.println("余额"+ loginUser.getMoney());
            System.out.println("请输入您要操作的命令：");
            String command = SYS_SC.nextLine();
            switch (command){
                case "1":
                    // 展示全部排片信息
                    showmovieAll();
                    break;
                case "2":
                    break;
                case "3":
                    // 评分功能
                    break;
                case "4":
                    buyMovie();
                    // 购票功能
                    break;
                case "5":
                    return; // 干掉方法
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }

    private static void buyMovie() {
        showmovieAll();
        System.out.println("=========用户购票功能============");
        while (true) {
            System.out.println("请输入购票门店");
            String shopName=SYS_SC.nextLine();
            business getBusiness = getShopName(shopName);
            if (getBusiness!=null){
                //查片
                while (true) {
                    System.out.println("请输入片名");
                    String movieName=SYS_SC.nextLine();
                    MovieDemo getMovie = checkMovie(getBusiness,movieName);
                    if (getMovie!=null){
                        //开始买票
                        System.out.println("请输入购买票数：");
                        String number=SYS_SC.nextLine();
                        int buyNumber=Integer.valueOf(number);
                        if (getMovie.getNumber()>=buyNumber){
                            //买票
                            double money= BigDecimal.valueOf(getMovie.getPrice()).multiply(BigDecimal.valueOf(buyNumber))
                                    .doubleValue();
                            if (loginUser.getMoney()>=money){
                                //余额足够
                                System.out.println("===========操作成功=============");
                                LOGGER.info(loginUser.getUsername()+"购买"+getMovie.getMovie_name());
                                loginUser.setMoney(loginUser.getMoney()-money);
                                getMovie.setNumber(getMovie.getNumber()-buyNumber);
                                System.out.println(loginUser.getUsername()+"购买"+getMovie.getMovie_name()+
                                        ",票数"+buyNumber+",余额："+loginUser.getMoney());
                                return;
                            }else {
                                System.out.println("余额不足");
                                break;
                            }
                        }else {
                            System.out.println("票数不够,重新选择电影");
                            break;
                        }

                    }else {
                        System.out.println("无此电影");
                        break;
                    }
                }
            }else {
                System.out.println("无此商家");
                break;
            }
        }
    }

    private static MovieDemo checkMovie(business business,String movieName) {
        List<MovieDemo> movieDemos=ALL_MOVIES.get(business);
        for (MovieDemo movie : movieDemos) {
            if(movie.getMovie_name().contains(movieName)){
                return  movie;
            }
        }
        return null;

    }

    private static business getShopName(String shopName) {
        Set<business> businesses=ALL_MOVIES.keySet();
        for (business business : businesses) {
            if (business.getShopName().equals(shopName)){
                return business;
            }
        }
        return null;
    }

    /**
     * 展示商家信息
     */
    private static void showmovieAll() {
        System.out.println("展现所有商家影片信息");
        ALL_MOVIES.forEach((business, movies) -> {
            System.out.println(business.getShopName()+"\t\t电话"+business.getPhone()+"\t\t地址"+business.getAddress());
            System.out.println("\t\t电影\t\t"+"\t\t主演"+"\t\t时长"+ "\t\t评分"+"\t\t票价"+"\t\t余票"+"\t\t放映时间");
            for (MovieDemo movie : movies) {
                System.out.println(movie.getMovie_name()+"\t\t"+movie.getActor()+"\t\t"+movie.getTime()+"\t\t"+
                        movie.getScore()+"\t\t"+movie.getPrice()+"\t\t"+movie.getNumber()+"\t\t"+sdf.format(movie.getStartTime()));
            }
        });

    }

    /**
     * 登录校验
     */

    public static User getUserByLoginName(String loginName){
        for (User user : ALL_USERS) {
            if (user.getLoginName().equalsIgnoreCase(loginName)){
                return user;
            }
        }
        return null;
    }
}
