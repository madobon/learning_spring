package com.example.its.domain.issue;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 課題レポジトリ
 */
@Mapper
public interface IssueRepository {

    /**
     * 全件検索
     * @return 課題一覧
     */
    @Select("select * from issues")
    List<IssueEntity> findAll();

    /**
     * 登録
     * @param summary 概要
     * @param description 説明
     */
    @Insert("insert into issues (summary, description) values(#{summary}, #{description})")
    void insert(String summary, String description);
}
