package com.abctechnologies.procurementmanagementsystem.intercepter;

import com.abctechnologies.procurementmanagementsystem.pojo.Result;
import com.abctechnologies.procurementmanagementsystem.utils.JwtUtils;
import com.alibaba.fastjson2.JSONObject;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //get url of the request
        String url = request.getRequestURL().toString();
        log.info("URL of the request: {}", url);

        //if request url contains login, if yes, it's a login request
        if(url.contains("login")) {
            log.info("Login request allowed");
            return true;
        }
        // Get the token from the request header
        String authHeader = request.getHeader("Authorization");

        // Check if the token exists and is prefixed with "Bearer "
        if (!StringUtils.hasLength(authHeader) || !authHeader.startsWith("Bearer ")) {
            log.info("Token does not exist or is not prefixed with 'Bearer ', back to login");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(JSONObject.toJSONString(Result.error("not_Logged_In")));
            return false;
        }

        // Extract the token
        String jwt = authHeader.substring(7);

        // If the token is invalid or expired, return a "not_Logged_In" error
        try {
            JwtUtils.parseJWT(jwt);
        } catch (ExpiredJwtException e) {
            log.info("JWT expired");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(JSONObject.toJSONString(Result.error("token_expired")));
            return false;
        } catch (JwtException e) {
            log.info("JWT parse failed");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(JSONObject.toJSONString(Result.error("not_Logged_In")));
            return false;
        }

        //If everything is fine, allow the request to proceed
        log.info("token valid, request allowed " + url);
        return true;
    }

@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    System.out.println("postHandle");
}

@Override
public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
System.out.println("afterCompletion");
}
}
