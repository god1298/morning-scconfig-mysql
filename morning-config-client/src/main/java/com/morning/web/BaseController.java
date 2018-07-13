/**
 * *****BaseController.java
 * Copyright
 * <p>
 * Copyright
 **/
/**
 *Copyright
 *
 **/
package com.morning.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class BaseController.
 *
 * @describe: <pre>
 * </pre>
 */

/** The Constant log. */
@Slf4j
public abstract class BaseController {

//    /**
//     * Rtn page data.
//     *
//     * @param pageHolder the page holder
//     * @return the map
//     */
//    protected Map<String, Object> rtnPageData(PageHolder<?> pageHolder) {
//        Map<String, Object> rtnMap = new HashMap<String, Object>();
//        rtnMap.put("rowCount", pageHolder.getRowCount());
//        rtnMap.put("list", pageHolder.getList());
//        rtnMap.put("isFirstPage", pageHolder.isFirstPage());
//        rtnMap.put("isLastPage", pageHolder.isLastPage());
//        rtnMap.put("pageSize", pageHolder.getPageSize());
//        rtnMap.put("pageIndex", pageHolder.getPageIndex());
//        rtnMap.put("respExtMap", pageHolder.getRespExtMap());
//        return rtnMap;
//    }

    /**
     * 获取IP地址.
     *
     * @param request the request
     * @return the ip addr
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /** The Constant COOKIE_UID. */
    public static final String COOKIE_UID = "userId";

    /**
     * Inits the binder.
     *
     * @param binder the binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
