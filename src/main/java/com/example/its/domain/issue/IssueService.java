package com.example.its.domain.issue;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 課題サービス
 */
@Service
public class IssueService {

    private final IssueRepository issueRepository;

    /**
     * コンストラクタ
     * @param issueRepository 課題リポジトリ
     */
    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    /**
     * 全件検索
     * @return 課題一覧
     */
    public List<IssueEntity> findAll(){
        return issueRepository.findAll();
    }

    /**
     * 登録（トランザクション制御あり）
     * @param summary 概要
     * @param description 説明
     */
    @Transactional
    public void create(String summary, String description) {
        issueRepository.insert(summary, description);
    }

    /**
     * 取得
     * @param issueId 課題ID
     * @return 課題エンティティ
     */
    public IssueEntity findById(long issueId) {
       return issueRepository.findById(issueId);
    }
}
