package com.newsfeed.api.service;

import com.newsfeed.api.model.SearchRequest;
import com.newsfeed.api.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsFeedService {
    @Autowired
    private RestUtil restUtil;

    public String getNewsFeeds(Integer limit){
        return restUtil.getNNewsFeeds(limit);
    }

    public String getNewsWithFilters(SearchRequest searchRequest){
        return restUtil.getNewsFeedsBySearchParams(searchRequest);
    }
}
