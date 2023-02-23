package yichen.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("yichen")
//@PropertySource加载properties配置文件
//@PropertySource({"jdbc.properties"})
public class SpringConfig {
}
