package com.mota.demo;

import java.util.HashMap;
import java.util.Set;

import com.mota.sdk.CCPRestSDK;
import com.mota.sdk.CCPRestSDK.BodyType;

public class SDKTestVoiceVerify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, Object> result = null;

		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init("app.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		restAPI.setAccount("8a48b5515427d2760154319dbd2e0d88", "39a0b5ac1b2044278ca0841d81f1e432");// 初始化主帐号和主帐号TOKEN
		restAPI.setAppId("8aaf07086772ac61016773b46d42025b");// 初始化应用ID
		result = restAPI.voiceVerify("验证码内容", "号码","显示的号码","3(播放次数)","状态通知回调地址", "语言类型", "第三方私有数据","wav格式的文件名,欢迎提示音","wav格式的文件名","最大通话时长");

		System.out.println("SDKTestVoiceVerify result=" + result);
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
	}

}
