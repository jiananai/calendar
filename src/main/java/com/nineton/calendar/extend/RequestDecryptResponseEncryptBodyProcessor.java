package com.nineton.calendar.extend;


import com.nineton.calendar.utils.AesUtils;
import com.nineton.calendar.utils.JsonUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author sdcuike
 * <p>
 * Created At 2016年10月26日 下午11:59:07
 */
public class RequestDecryptResponseEncryptBodyProcessor {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    public final String decryptRequestBody(HttpInputMessage inputMessage, Charset charset) throws IOException {
        InputStream inputStream = inputMessage.getBody();
        String input = IOUtils.toString(inputStream, charset);
        HttpHeaders httpHeaders = inputMessage.getHeaders();
        return doDecryptRequestBody(input, httpHeaders, charset);
    }

    public final String encryptResponseBody(String input, HttpHeaders httpHeaders, Charset charset) {
        //System.out.println(input);
        return doEncryptResponseBody(input, httpHeaders, charset);
    }

    protected String doDecryptRequestBody(String input, HttpHeaders httpHeaders, Charset charset) {
        //System.out.println(input+"|||");
        String decrypt = AesUtils.decrypt(input, "youllikefollower", "likethisverymuch");
        return decrypt;
    }

    protected String doEncryptResponseBody(String input, HttpHeaders httpHeaders, Charset charset) {
        String encrypt = AesUtils.encrypt(input, "youllikefollower", "likethisverymuch");
        return encrypt;
    }

}
