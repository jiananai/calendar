package com.nineton.calendar;

import com.nineton.calendar.utils.AesUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalendarApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void run(){
		String a="{\"identificationCode\":\"123123\"}";
		String b="29B0CDE147B4E2C2DCCB651955A9C1725F414BEE1E5D7B01B9B8199A6D13627288F45B590538F1324D7453060C1EBAB0025D16F4DCB8A5AC668B809085D1DB5B82661D3E6DDC05FB293355F47042B22540618350361FAA800055FE079350B9684C8B9258B4D4677171CD2D2B5CFD5B1ABE7761BAA9BA2FC7D501128812F013565BFFD3A431C8501274370FD0BE10486EC0FFA115DC83F5421C2F4E1DA00904930FF3105287F995027925B88692D0C8530212125F93C9E0FEEC9C17A5A5667CF1BAC0A9FEF05E7CA085A5A08DD1B4D9743D55362BE352D75BDDA3C4C22ABDAEB1710ADB93C20E09D2E53B21AF4414EAADC9EAFB2C305BCC8E3C96221C998DF674";
		String enString = AesUtils.encrypt(a, "youllikefollower", "likethisverymuch");
		System.out.println("AES:" + enString);
		System.out.println("AES:" + AesUtils.decrypt(b, "youllikefollower", "likethisverymuch"));
	}
}
