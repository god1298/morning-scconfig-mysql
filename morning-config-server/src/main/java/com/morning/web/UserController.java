package com.morning.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * 类UserController.java的实现描述：TODO 类实现描述
 *
 * @author  2018年1月8日 下午2:10:09
 */
@RequestMapping("/user")
@RestController
/** The Constant log. */
@Slf4j
public class UserController extends BaseController {

    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    /**
     * 新增用户.
     *
     * @return the string
     * @throws Exception the exception
     */
    @RequestMapping(value = "find")
    public void findUser() throws Exception {
    }
}
