package com.newsfeed.api.util;

import com.newsfeed.api.exception.UnableToFetchException;
import com.newsfeed.api.model.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RestUtil {

    @Value("${news-feed.api-url}")
    private String apiUrl;
    @Value("${news-feed.api-key}")
    private String apikey;
    @Autowired
    private RestTemplate restTemplate;

    public String getNNewsFeeds(Integer n){
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("apikey",apikey)
                .queryParam("q","None")
                .queryParam("max",n).build();
        String newsFeeds = restTemplate.getForObject(builder.toString(), String.class);
        return  newsFeeds;
    }

    public String getNewsFeedsBySearchParams(SearchRequest searchRequest){
        String response=null;
        try {
            UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                    .queryParam("apikey", this.apikey);
            StringBuilder strBuilder = new StringBuilder();
            if (searchRequest.getSearchKeyWord() != null) {
                strBuilder.append(searchRequest.getSearchKeyWord());
            }
            if (searchRequest.getTitle() != null) {
                componentsBuilder.queryParam("in", "title");
                strBuilder.append(" AND ").append(searchRequest.getTitle());
            }
            componentsBuilder.queryParam("q", strBuilder.toString());
            UriComponents builder = componentsBuilder.build();
            response = restTemplate.getForObject(builder.toString(), String.class);
        }catch (Exception e){
            throw new UnableToFetchException("Unable to Fetch News",e);
        }
        return  response;
    }

}
