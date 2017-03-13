package cn.chace.www.springboot.resttemplate.web.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.MessageFormat;

/**
 * 控制器类：示例
 *
 * @author chenx
 * @date 2017/3/13
 */
@RestController
public class DemoController {
    @Value("${gocanvas.username}")
    private String username;
    @Value("${gocanvas.password}")
    private String password;

    /**
     * 接口输出图片内容的示例
     *   图片直接读取自网络url
     */
    @RequestMapping(value = "gocanvas/image/{id}", method = RequestMethod.GET)
    public void getGoCanvasImg(@PathVariable String id, HttpServletResponse response) throws IOException {
        String url = "https://www.gocanvas.com/apiv2/images.xml?image_id={0}&username={1}&password={2}";
        URL imgUrl = new URL(MessageFormat.format(url, id, username, password));
        InputStream inputStream = imgUrl.openStream();
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(inputStream, response.getOutputStream());
    }
}
