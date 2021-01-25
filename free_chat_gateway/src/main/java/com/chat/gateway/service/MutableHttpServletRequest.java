//package com.chat.gateway.service;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import java.util.*;
//
///**
// * @ProjectName: Parent
// * @Package: com.chat.gateway.service
// * @ClassName: MutableHttpServletRequest
// * @Description: java类作用描述
// * @Author: ldy
// * @CreateDate: 2020/7/17 23:32
// * @UpdateUser: 更新者
// * @UpdateDate: 2020/7/17 23:32
// * @UpdateRemark: 更新说明
// * @Version: 1.0
// */
//public class MutableHttpServletRequest extends HttpServletRequestWrapper {
//    // holds custom header and value mapping
//    private final Map<String, String> customHeaders;
//
//    public MutableHttpServletRequest(HttpServletRequest request){
//        super(request);
//        this.customHeaders = new HashMap<String, String>();
//    }
//
//    public void putHeader(String name, String value){
//        this.customHeaders.put(name, value);
//    }
//
//    public String getHeader(String name) {
//        // check the custom headers first
//        String headerValue = customHeaders.get(name);
//
//        if (headerValue != null){
//            return headerValue;
//        }
//        // else return from into the original wrapped object
//        return ((HttpServletRequest) getRequest()).getHeader(name);
//    }
//
//    public Enumeration<String> getHeaderNames() {
//        // create a set of the custom header names
//        Set<String> set = new HashSet<String>(customHeaders.keySet());
//
//        // now add the headers from the wrapped request object
//        @SuppressWarnings("unchecked")
//        Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();
//        while (e.hasMoreElements()) {
//            // add the names of the request headers into the list
//            String n = e.nextElement();
//            set.add(n);
//        }
//
//        // create an enumeration from the set and return
//        return Collections.enumeration(set);
//    }
//
//
//}
