package com.newsfeed.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest {
    private String title;
    private String searchKeyWord;
}
