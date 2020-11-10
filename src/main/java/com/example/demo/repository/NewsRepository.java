package com.example.demo.repository;

import com.example.demo.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends JpaRepository<NewsEntity,Long> {
    @Query(value = "SELECT * FROM news WHERE category_id = :categoryId", nativeQuery = true)
    List<NewsEntity> findByCategoryId(@Param("categoryId") Long categoryId );
}
