package com.capg.book.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.book.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
	@Transactional
    @Modifying
    @Query("update Book set title=?2 ,description=?3 where id=?1")
    int updateBook(Integer id, String title, String description);

}