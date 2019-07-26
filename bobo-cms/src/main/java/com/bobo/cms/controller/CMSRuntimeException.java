/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: CMSRuntimeException.java 
 * @Prject: bobo-cms
 * @Package: com.bobo.cms.controller 
 * @Description: TODO
 * @author: lq  
 * @date: 2019年7月25日 下午4:22:43 
 * @version: V1.0   
 */
package com.bobo.cms.controller;

/** 
 * @ClassName: CMSRuntimeException 
 * @Description: TODO
 * @author:陈梦成a
 * @date: 2019年7月25日 下午4:22:43  
 */
public class CMSRuntimeException extends Exception {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	public CMSRuntimeException() {
		super();
	}

     public CMSRuntimeException(String message ) {
		super(message);
	}

}
