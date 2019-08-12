/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: RedisHashtest.java 
 * @Prject: rediswekk2
 * @Package: com.chenmengcheng.test 
 * @Description: TODO
 * @author: lq  
 * @date: 2019年8月12日 上午8:58:11 
 * @version: V1.0   
 */
package com.chenmengcheng.test;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chenmengcheng.domain.User;
import com.chenmengcheng.utils.RandomUitl;
import com.chenmengcheng.utils.StringUtil;

/** 
 * @ClassName: RedisHashtest 
 * @Description: TODO
 * @author:陈梦成a
 * @date: 2019年8月12日 上午8:58:11  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class RedisHashtest {
	
	@Resource
	private RedisTemplate<String, Serializable> redis;
	
	@Test
	public void hash_jdk() {
		
		Map<String, Serializable> map = new HashMap<String, Serializable>();
		
		for(int i = 0 ; i < 10000 ;i ++) {
			map.put("reidshash_jdk", new User(i, StringUtil.generateChineseName() + StringUtil.randomChineseString(2),StringUtil.sex(),
					"13" + RandomUitl.randomString(9), 
					StringUtil.generateChineseName(),null
					));		
		}
		long start = System.currentTimeMillis();
		
		redis.opsForHash().putAll("redihash", map);
		
		long end = System.currentTimeMillis();
		
		System.out.println("hashJDK 时间为" + (end-start));
	}
	

}
