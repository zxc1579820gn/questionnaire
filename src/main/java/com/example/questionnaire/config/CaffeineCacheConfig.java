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
				//�]�w�L���ɶ�  1.�̫�@���g�J2.�X�ݫ�L�@�q�ɶ�
				.expireAfterAccess(600,TimeUnit.SECONDS)
				//��l�w�s�Ŷ��j�p
				.initialCapacity(100)
				//�w�s�̤j����
				.maximumSize(500));
		return cacheManager;
	}
	
	

}
