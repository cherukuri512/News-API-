package com.newsfeed.api.service;

import com.newsfeed.api.model.SearchRequest;
import com.newsfeed.api.util.RestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NewsFeedServiceTest {
    @Mock
    private RestUtil restUtil;
    @InjectMocks
    private NewsFeedService newsFeedService;
    @Test
    public void getNewsFeedsTest(){
        when(restUtil.getNNewsFeeds(10)).thenReturn("abc");
        String newsFeeds = newsFeedService.getNewsFeeds(10);
        assertEquals("abc",newsFeeds);
    }

    @Test
    public void getNewsWithFilters(){
        when(restUtil.getNewsFeedsBySearchParams(any())).thenReturn("abc");
        SearchRequest searchRequest=new SearchRequest();
        searchRequest.setTitle("rain");
        String newsFeeds = newsFeedService.getNewsWithFilters(searchRequest);
        assertEquals("abc",newsFeeds);
    }
}
