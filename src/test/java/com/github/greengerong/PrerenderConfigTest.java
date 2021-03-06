package com.github.greengerong;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PrerenderConfigTest {
    @Test(expected = NumberFormatException.class)
    public void should_throw_exception_if_invalid_timeout_value_specified() throws Exception {
        //given
        Map<String, String> configuration = new HashMap<String, String>();
        configuration.put("socketTimeout", "not_an_int");
        PrerenderConfig config = new PrerenderConfig(configuration);
        //when
        config.getHttpClient();
    }

    @Test
    public void should_pass_if_correct_timeout_value_specified() throws Exception {
        //given
        Map<String, String> configuration = new HashMap<String, String>();
        configuration.put("socketTimeout", "1000");
        PrerenderConfig config = new PrerenderConfig(configuration);
        //when
        config.getHttpClient();
    }
}
