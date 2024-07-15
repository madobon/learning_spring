package com.example.its.web.issue;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 課題フォーム
 * @param summary
 * @param description
 */
public record IssueForm(
        @NotBlank @Size(max = 256) String summary,
        @NotBlank @Size(max = 256) String description) {
}
