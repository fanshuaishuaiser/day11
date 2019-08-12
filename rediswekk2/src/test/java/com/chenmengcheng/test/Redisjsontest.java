/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: Redisjsontest.java 
 * @Prject: rediswekk2
 * @Package: com.chenmengcheng.test 
 * @Description: TODO
 * @author: lq  
 * @date: 2019年8月12日 上午8:57:59 
 * @version: V1.0   
 */
package com.chenmengcheng.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
 * @ClassName: Redisjsontest 
 * @Description: TODO
 * @author:陈梦成a
 * @date: 2019年8月12日 上午8:57:59  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans2.xml")
public class Redisjsontest {
	
	@Resource
	private RedisTemplate<String, Serializable> redis ;
	
	@Test
	public void re_json() {
		List<User> list = new ArrayList<User>();
		
		for(int i = 0 ; i < 100000 ;i ++) {
			list.add(new User(i, StringUtil.generateChineseName() + StringUtil.randomChineseString(2), StringUtil.sex(),
					"13" + RandomUitl.randomString(9), 
					StringUtil.generateChineseName(),null
					));
		}
		
		long start = System.currentTimeMillis();
		
		for (User user : list) {
			
			redis.opsForValue().set("u_"+user.getId(), user);
			
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Josn序列化时间"+ (end-start));
	}
	


}
