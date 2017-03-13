package cn.chace.www.springboot.resttemplate.component;

import cn.chace.www.springboot.resttemplate.entity.gocanvas.*;
import cn.chace.www.springboot.resttemplate.entity.gocanvas.referencedata.Columns;
import cn.chace.www.springboot.resttemplate.entity.gocanvas.referencedata.RefData;
import cn.chace.www.springboot.resttemplate.entity.gocanvas.referencedata.Row;
import com.google.common.collect.Lists;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 组件类：处理XML格式的Rest客户端请求
 *
 * @author chenx
 * @date 2017/3/6
 */
@Component
public class XmlRestClient {
    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        XStreamMarshaller marshaller = new XStreamMarshaller();
        marshaller.setAnnotatedClasses(CanvasResult.class, Form.class, Response.class, ResponseGroup.class, Screen.class,
                Section.class, Submission.class, RefData.class, Columns.class, Row.class);
        MarshallingHttpMessageConverter marshallingConverter = new MarshallingHttpMessageConverter(marshaller);

        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(marshallingConverter);

        restTemplate.setMessageConverters(converters);
    }

    public <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType, Map<String, String> urlParams) {
        HttpHeaders httpHeaders = this.buildHeads(headers);
        HttpEntity request = new HttpEntity(httpHeaders);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, responseType, urlParams);

        return responseEntity.getBody();
    }

    public void postForObject(String url, Map<String, String> headers, Object body, Map<String, String> urlParams) {
        HttpHeaders httpHeaders = this.buildHeads(headers);
        HttpEntity request = new HttpEntity(body, httpHeaders);
        ResponseEntity responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, Object.class, urlParams);
        System.out.println(responseEntity.getBody());
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Post request failed:" + responseEntity);
        }
    }

    private HttpHeaders buildHeads(Map<String, String> headersMap) {
        HttpHeaders headers = new HttpHeaders();

        if (headersMap != null) {
            for (String key : headersMap.keySet()) {
                headers.add(StringUtils.trimToEmpty(key), StringUtils.stripToEmpty(MapUtils.getString(headersMap, key)));
            }
        }

        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setAccept(Lists.newArrayList(MediaType.APPLICATION_XML));

        return headers;
    }

}
