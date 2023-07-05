//package com.newsfeed.api.config;
//
//import net.sf.ehcache.Ehcache;
//import org.apache.http.client.cache.HttpCacheStorage;
//import org.apache.http.impl.client.cache.CacheConfig;
//import org.apache.http.impl.client.cache.CachingHttpClientBuilder;
//import org.apache.http.impl.client.cache.ehcache.EhcacheHttpCacheStorage;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.Cache;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.cache.HttpCacheStorage;
//import org.apache.http.impl.client.cache.CacheConfig;
//import org.apache.http.impl.client.cache.CachingHttpClientBuilder;
//import org.apache.http.impl.client.cache.ehcache.EhcacheHttpCacheStorage;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//
//@Configuration
//@EnableCaching
//public class AppConfig {
//    public static final int DEFAULT_MAX_CACHE_ENTRIES = 10;
//
//    @Value("#{cacheManager.getCache('httpClient')}")
//    private Cache httpClientCache;
//
//    @Bean
//    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
//        PoolingHttpClientConnectionManager result = new PoolingHttpClientConnectionManager();
//        result.setMaxTotal(20);
//        return result;
//    }
//
//    @Bean
//    public CacheConfig cacheConfig() {
//        CacheConfig result = CacheConfig
//                .custom()
//                .setMaxCacheEntries(DEFAULT_MAX_CACHE_ENTRIES)
//                .build();
//        return result;
//    }
//
//    @Bean
//    public HttpCacheStorage httpCacheStorage() {
//        Ehcache ehcache = (Ehcache) this.httpClientCache.getNativeCache();
//        HttpCacheStorage result = new EhcacheHttpCacheStorage(ehcache);
//        return result;
//    }
//
//    @Bean
//    public HttpClient httpClient(PoolingHttpClientConnectionManager poolingHttpClientConnectionManager,
//                                 CacheConfig cacheConfig, HttpCacheStorage httpCacheStorage) {
//
//        HttpClient result = CachingHttpClientBuilder
//                .create()
//                .setCacheConfig(cacheConfig)
//                .setHttpCacheStorage(httpCacheStorage)
//                .disableRedirectHandling()
//                .setConnectionManager(poolingHttpClientConnectionManager)
//                .build();
//        return result;
//    }
//
//    @Bean
//    public RestTemplate restTemplate(HttpClient httpClient) {
//        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//        requestFactory.setHttpClient(httpClient);
//        return new RestTemplate(requestFactory);
//    }
//}
