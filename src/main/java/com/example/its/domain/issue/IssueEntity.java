package com.example.its.domain.issue;

/**
 * 課題エンティティ
 * @param id ID
 * @param summary 概要
 * @param description 説明
 */
public record IssueEntity(long id, String summary, String description) {
}