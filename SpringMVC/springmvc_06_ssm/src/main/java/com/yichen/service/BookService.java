package com.yichen.service;

import com.yichen.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {
    /**
     * 保存数据
     * @param book
     * @return
     */
    public boolean save(Book book);

    /**
     * 更新数据
     * @param book
     * @return
     */
    public boolean update(Book book);

    /**
     * 根据Id删除数据
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    public Book getById(Integer id);

    /**
     * 查询所有信息
     * @return
     */
    public List<Book> getAll();
}
