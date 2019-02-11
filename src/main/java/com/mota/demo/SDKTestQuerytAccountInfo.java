/*
 *  Copyright (c) 2014 The CCP project authors. All Rights Reserved.
 *
 *  Use of this source code is governed by a Beijing Speedtong Information Technology Co.,Ltd license
 *  that can be found in the LICENSE file in the root of the web site.
 *
 *   http://www.yuntongxun.com
 *
 *  An additional intellectual property rights grant can be found
 *  in the file PATENTS.  All contributing project authors may
 *  be found in the AUTHORS file in the root of the source tree.
 */
package com.mota.demo;

import java.util.HashMap;
import java.util.Set;

import com.mota.sdk.CCPRestSDK;
import com.mota.sdk.CCPRestSDK.BodyType;


public class SDKTestQuerytAccountInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashMap<String, Object> result = null;

		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init("app.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		restAPI.setAccount("8a48b5515427d2760154319dbd2e0d88", "39a0b5ac1b2044278ca0841d81f1e432");;// 初始化主帐号和主帐号TOKEN
		restAPI.setAppId("8aaf07086772ac61016773b46d42025b");// 初始化应用ID
		result = restAPI.queryAccountInfo();

		System.out.println("SDKTestQuerytAccountInfo result=" + result);
		
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
		//Account = {dateCreated=2016-04-20 11:01:41, balance=-13714.478146, subBalance=0.000000, type=0, friendlyName=南京乾璟通网络科技有限公司, dateUpdated=2018-12-13 15:52:33, status=1}
//		属性	类型	约束	说明
//		statusCode	String	必选	请求状态码，取值000000（成功），可参考Rest 错误代码。
//		dateCreated	String	必选	主账户的创建时间
//		dateUpdated	String	必选	主账户的最近更新时间
//		friendlyName	String	必选	主账户名称，唯一，由64个英文字母和阿拉伯数字组成，默认为你的电子邮箱地址
//		type	String	必选	主账户类型，取值有0（试用）和1（已注册），默认值为0
//		status	String	必选	主账户状态，取值有0（未激活）、1（激活）、2（暂停）、3（关闭），默认值为0
//		balance	String	必选	主账户余额
//		subBalance	String	必选	副账户余额
	}
	
}
