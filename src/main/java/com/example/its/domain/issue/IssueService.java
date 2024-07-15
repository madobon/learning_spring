package com.example.its.domain.issue;

import org.springframework.stereotype.Service;

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
}
