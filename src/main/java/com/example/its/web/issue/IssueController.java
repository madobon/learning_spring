package com.example.its.web.issue;

import com.example.its.domain.issue.IssueEntity;
import com.example.its.domain.issue.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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

    @GetMapping("/issues")
    public String showList(Model model) {
        var list = issueService.findAll();

        model.addAttribute("issueList", list);
        return "issues/list";
    }
}
