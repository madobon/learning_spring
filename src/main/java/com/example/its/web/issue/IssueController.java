package com.example.its.web.issue;

import com.example.its.domain.issue.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 課題コントローラ
 */
@Controller
public class IssueController {

    private final IssueService issueService;

    /**
     * コンストラクタ
     * @param issueService 課題サービス
     */
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    /**
     * リスト
     * @param model モデル
     * @return 遷移先
     */
    @GetMapping("/issues")
    public String list(Model model) {
        var list = issueService.findAll();

        model.addAttribute("issueList", list);
        return "issues/list";
    }
}
