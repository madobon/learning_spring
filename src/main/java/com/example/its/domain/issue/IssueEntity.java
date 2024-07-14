package com.example.its.domain.issue;

/**
 * 課題エンティティ
 * @param id
 * @param summary
 * @param description
 */
public record IssueEntity(long id, String summary, String description) {
}