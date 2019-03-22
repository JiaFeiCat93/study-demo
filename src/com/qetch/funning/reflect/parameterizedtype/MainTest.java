package com.qetch.funning.reflect.parameterizedtype;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainTest {
	
	static Gson gson = new Gson();
	
	public static void main(String[] args) {
		
		/**
		 * 参考资料：https://www.jianshu.com/p/b1ad2f1d3e3e
		 */
		String host = "";
		String reqBody = "";
		HttpPost httpPost = new HttpPost(host + "/api/dataA");
		httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
		// ...
		try {
			StringEntity se = new StringEntity(gson.toJson(reqBody), "utf-8");
			httpPost.setEntity(se);
			DataA resbody = myHttpPost(httpPost, DataA.class);
		} catch (Exception ex) {
			try {
				throw new MyException("调用接口失败, " + ex.getMessage(), MyErrorCode.ES_REQUEST_FAIL);
			} catch (MyException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 甚至, 泛型类的子类也可以参数化传入:
		 */
		List<DataB> resbodyB = myHttpPost(httpPost, new TypeToken<List<DataB>>(){}.getType()); // 这里用到Gson的TypeToken
		
		/**
		 * 子类的参数类型也可以参数化, 使用ParameterizedTypeImp构造其类型即可:
		 */
		Type tClass = P.class;
		Type typeDataCP = new ParameterizedTypeImpl(DataC.class, new Type[]{tClass}, DataC.class); // Class<P> tClass
		DataC<P> resbodyC = myHttpPost(httpPost, typeDataCP);
	}

	/**
	 * GET请求
	 * @param httpGet
	 * @param dataType
	 * @return
	 */
	private static <T> T myHttpGet(HttpGet httpGet, Type dataType) {
		HttpClient httpClient = HttpClients.createDefault();
		try {
			HttpResponse response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(response.getEntity());
				Type parameterizedTypeClass = // 构造响应类型 ResponseDTO<T>
						new ParameterizedTypeImpl(ResponseDTO.class, new Type[] { dataType }, ResponseDTO.class);
				ResponseDTO<T> responseBody = gson.fromJson(result, parameterizedTypeClass); // 使用GSON反序列化响应
				if (responseBody.getCode() != 0) {
					throw new MyException(String.format("[MY.HttpGet]请求失败, url=%s, details=%s", httpGet.getURI(),
							gson.toJson(responseBody.getMessage())), MyErrorCode.ES_REQUEST_FAIL);
				}
				return responseBody.getData();
			}
			throw new MyException("[MY.HttpGet]" + response.getStatusLine().toString(), MyErrorCode.ES_REQUEST_FAIL);
		} catch (Exception ex) {
			try {
				throw new MyException("[MY.HttpGet]" + ex.getMessage(), MyErrorCode.ES_REQUEST_FAIL);
			} catch (MyException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * POST请求
	 * @param httpPost
	 * @param dataType
	 * @return
	 */
	private static <T> T myHttpPost(HttpPost httpPost, Type dataType) {
		HttpClient httpClient = HttpClients.createDefault();
		try {
			HttpResponse response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(response.getEntity());
				Type responseTypeClass = // 构造响应类型 ResponseDTO<T>
						new ParameterizedTypeImpl(ResponseDTO.class, new Type[] { dataType }, ResponseDTO.class);
				ResponseDTO<T> responseBody = gson.fromJson(result, responseTypeClass); // 使用GSON反序列化响应
				if (responseBody.getCode() != 0) {
					throw new MyException(String.format("[MY.HttpPost]请求失败, url=%s, details=%s", httpPost.getURI(),
							gson.toJson(responseBody.getMessage())), MyErrorCode.ES_REQUEST_FAIL);
				}
				return responseBody.getData();
			}
			throw new MyException("[MY.HttpPost]" + response.getStatusLine().toString(), MyErrorCode.ES_REQUEST_FAIL);
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				throw new MyException("[MY.HttpPost]" + ex.getMessage(), MyErrorCode.ES_REQUEST_FAIL);
			} catch (MyException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
