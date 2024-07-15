package com.example.its.web.issue;

import com.example.its.domain.issue.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 課題コントローラ
 */
@Controller
@RequestMapping("/issues")
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
    @GetMapping
    public String showList(Model model) {
        var list = issueService.findAll();

        model.addAttribute("issueList", list);
        return "issues/list";
    }

    /**
     * 登録フォーム
     */
    @GetMapping("creationForm")
    public String showCreationForm(@ModelAttribute IssueForm form) {
        return "issues/creationForm";
    }

    @PostMapping
    public String create(IssueForm form, Model model) {
        issueService.create(form.summary(), form.description());
        return showList(model); // TODO: リロードボタン対策が必要
    }
}
