package com.example.questionnaire.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@EnableCaching
@Configuration
public class CaffeineCacheConfig {
	
	public CacheManager cacheManager () {
		CaffeineCacheManager cacheManager =new CaffeineCacheManager();
		cacheManager.setCaffeine(Caffeine.newBuilder()
				//設定過期時間  1.最後一次寫入2.訪問後過一段時間
				.expireAfterAccess(600,TimeUnit.SECONDS)
				//初始緩存空間大小
				.initialCapacity(100)
				//緩存最大筆數
				.maximumSize(500));
		return cacheManager;
	}
	
	

}
