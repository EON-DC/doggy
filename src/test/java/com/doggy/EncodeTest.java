package com.doggy;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

public class EncodeTest {

    String testUrl =
            "http://www.baeldung.com?key1=value+1&key2=value%40%21%242&key3=value%253";

    @Test
    public void givenURL_whenAnalyze_thenCorrect() throws Exception {
        URI uri = new URI(testUrl);

        assertThat(uri.getScheme()).isEqualTo("http");
        assertThat(uri.getHost()).isEqualTo("www.baeldung.com");
        assertThat(uri.getRawQuery()).isEqualTo("key1=value+1&key2=value%40%21%242&key3=value%253");
    }
    private String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }

    @Test
    public void givenRequestParam_whenUTF8Scheme_thenEncode() throws Exception {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("key1", "value 1");
        requestParams.put("key2", "value@!$2");
        requestParams.put("key3", "value%3");

        String encodedURL = requestParams.keySet().stream()
                .map(key -> {
                    try {
                        return key + "=" + encodeValue(requestParams.get(key));
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(joining("&", "http://www.baeldung.com?", ""));

        assertThat(testUrl).isEqualTo(encodedURL);
}}
