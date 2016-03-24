package cn.chace.www.springboot.springsession.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author chenx
 * @date 2016/3/24
 */
@RestController
@RequestMapping("session")
public class SessionController {
    @RequestMapping("login")
    public String createSession(HttpSession session) {
        session.setAttribute("username", "chace");
        return "Create session successfully!";
    }

    @RequestMapping("username")
    public String getUsername(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return "Get username from session: " + username;
    }
}
