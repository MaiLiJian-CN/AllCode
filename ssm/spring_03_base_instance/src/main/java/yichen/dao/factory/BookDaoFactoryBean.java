package yichen.dao.factory;

import org.springframework.beans.factory.FactoryBean;
import yichen.dao.BookDao;
import yichen.dao.Impl.BookDaoImpl;

public class BookDaoFactoryBean implements FactoryBean<BookDao> {
    /*代替原始工厂中创建对象的方法*/
    @Override
    public BookDao getObject() throws Exception {
        return new BookDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return BookDao.class;
    }

    /*选择是否单例*/
    @Override
    public boolean isSingleton() {
        return true;//默认单例
    }
}
