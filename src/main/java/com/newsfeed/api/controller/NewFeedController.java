package com.newsfeed.api.controller;

import com.newsfeed.api.model.SearchRequest;
import com.newsfeed.api.service.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newsfeed")
public class NewFeedController {

    @Autowired
    private NewsFeedService newsFeedService;

    @GetMapping("/getfeeds")
    public ResponseEntity<Object> getNNewsFeeds(@RequestParam(name = "limit",defaultValue = "10",required = false) Integer limit){
        return ResponseEntity.ok(newsFeedService.getNewsFeeds(limit));
    }

    @GetMapping("/getfeedswithfilter")
    public ResponseEntity<Object> getNewsFeedsByFilter(@RequestParam(name = "title",required = false) String title,@RequestParam(name = "keyword",required = true) String keyword){
        SearchRequest searchRequest=new SearchRequest();
        searchRequest.setSearchKeyWord(keyword);
        searchRequest.setTitle(title);
        return ResponseEntity.ok(newsFeedService.getNewsWithFilters(searchRequest));
    }
}
