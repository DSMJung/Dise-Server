package com.example.dise.domain.feed.controller.dto.request;

import com.example.dise.domain.feed.domain.type.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateFeedRequest {

    @NotNull(message = "title은 Null이 불가합니다.")
    @Size(max = 20, message = "title은 최대 20자입니다.")
    private String title;

    @NotNull(message = "content는 Null이 불가합니다.")
    @Size(max = 1000, message = "content는 최대 1000자입니다.")
    private String content;

    @NotNull
    private Category category;

}
