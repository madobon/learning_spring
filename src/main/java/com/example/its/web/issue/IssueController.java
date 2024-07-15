package com.example.its.web.issue;

import com.example.its.domain.issue.IssueEntity;
import com.example.its.domain.issue.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
     * 一覧表示
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
     * 登録フォーム表示
     */
    @GetMapping("creationForm")
    public String showCreationForm(@ModelAttribute IssueForm form) {
        return "issues/creationForm";
    }

    /**
     * 登録処理（PRGパターン）
     * @param form 課題フォーム
     * @param model モデル
     * @return 遷移先
     */
    @PostMapping
    public String create(
        @Validated IssueForm form,
        BindingResult bindingResult,
        Model model) {

        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }

        issueService.create(form.summary(), form.description());

        return "redirect:/issues";
    }

    /**
     * 詳細表示
     * @param issueId 課題ID
     * @param model モデル
     * @return 遷移先
     */
    @GetMapping("/{issueId}")
    public String showDetail(@PathVariable("issueId") long issueId, Model model) {
        var data = issueService.findById(issueId);
        model.addAttribute("issue", data);
        return "issues/detail";
    }
}
