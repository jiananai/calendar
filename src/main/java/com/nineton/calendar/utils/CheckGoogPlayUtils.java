package com.nineton.calendar.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;

import com.nineton.calendar.pojo.Googleplay;
import com.nineton.calendar.pojo.P12;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.SecurityUtils;
import com.google.api.services.androidpublisher.AndroidPublisher;
import com.google.api.services.androidpublisher.AndroidPublisherScopes;
import com.google.api.services.androidpublisher.model.ProductPurchase;


public class CheckGoogPlayUtils {
	private static Logger logger = LoggerFactory.getLogger(CheckGoogPlayUtils.class);

	public static ProductPurchase checkPayOrder(Googleplay googleplay, P12 p12) {

		try {
			FileInputStream is= new FileInputStream(new File("P12/"+p12.getFileName()));
			//InputStream is=CommonController.class.getResourceAsStream("/Google.p12");
			HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
			PrivateKey privateKey = SecurityUtils.loadPrivateKeyFromKeyStore(SecurityUtils.getPkcs12KeyStore(),
					is, "notasecret", "privatekey", "notasecret");
			//System.out.println(privateKey);
			GoogleCredential credential = new GoogleCredential.Builder().setTransport(transport)
					.setJsonFactory(JacksonFactory.getDefaultInstance())
					.setServiceAccountId(p12.getEmail()) // e.g.:																														// 626891557797-frclnjv31rn4ss81ch746g9t6pd3mmej@developer.gserviceaccount.com
					.setServiceAccountScopes(AndroidPublisherScopes.all()).setServiceAccountPrivateKey(privateKey)
					.build();
			//System.out.println(3333);;
			AndroidPublisher publisher = new AndroidPublisher.Builder(transport, JacksonFactory.getDefaultInstance(),
					credential).build();

			AndroidPublisher.Purchases.Products products = publisher.purchases().products();
			//System.out.println("||||");
			// 参数详细说明:
			// https://developers.google.com/android-publisher/api-ref/purchases/products/get
			AndroidPublisher.Purchases.Products.Get product = products.get(googleplay.getPackageName(),
					googleplay.getProductId(), googleplay.getToken());
			// 获取订单信息s
			// 通过consumptionState, purchaseState可以判断订单的状态
			//System.out.println("dsad");
			ProductPurchase purchase = product.execute();		
			logger.info(googleplay.getOrderId()+":查询成功,返回值"+JsonUtils.objectToJson(purchase));
			return purchase;
		} catch (GeneralSecurityException | IOException e) {
			logger.error("支付订单链接失败"+googleplay.getOrderId(),e);
		}
		return null;
	}
}
