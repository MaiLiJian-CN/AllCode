import com.yichen.config.SpringConfig;
import com.yichen.domain.Account;
import com.yichen.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App2 {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = ctx.getBean(AccountService.class);
        List<Account> all = accountService.findAll();
        System.out.println(all);
    }
}
