package com.newsfeed.api.util;

import com.newsfeed.api.model.SearchRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestUtilTest {
    @InjectMocks
    public RestUtil restUtil;
    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp(){
        ReflectionTestUtils.setField(restUtil,"apiUrl","http://localhost:8080/newssearch");
        ReflectionTestUtils.setField(restUtil,"apikey","abcdefgh");
    }

    @Test
    public void testGetNNewsFeeds(){
        when(restTemplate.getForObject(anyString(),any())).thenReturn("abc");
        String nNewsFeeds = restUtil.getNNewsFeeds(10);
        assertEquals("abc",nNewsFeeds);
    }

    @Test
    public void testGetNewsFeedsBySearchParams(){
        when(restTemplate.getForObject(anyString(),any())).thenReturn("abc");
        SearchRequest searchRequest=new SearchRequest();
        searchRequest.setTitle("rain");
        String nNewsFeeds = restUtil.getNewsFeedsBySearchParams(searchRequest);
        assertEquals("abc",nNewsFeeds);
    }


}
