package com.newsfeed.api.controller;


import com.newsfeed.api.service.NewsFeedService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NewFeedController.class)
public class NewsFeedControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private NewsFeedService feedService;

    @Test
    public void getNNewsFeeds() throws Exception
    {
        when(feedService.getNewsFeeds(anyInt())).thenReturn("abc");
        mockMvc.perform(MockMvcRequestBuilders
                .get("/newsfeed/getfeeds")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNewsFeedsByFilter() throws Exception
    {
        when(feedService.getNewsWithFilters(any())).thenReturn("abc");
        mockMvc.perform(MockMvcRequestBuilders
                .get("/newsfeed/getfeedswithfilter?keyword=rain")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
