package com.artlinux.demo.Util;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private int Code;
    private String Msg;
    private Object Data;

    public static Result succ(int code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result succ(String msg) {
        return publicMethod(200, msg, null);
    }

    public static Result succ(String msg, Object data) {
        return publicMethod(200, msg, data);
    }

    public static Result succ(int code, String msg, Object data) {
        return publicMethod(code, msg, data);
    }

    public static Result fail(String msg) {
        return publicMethod(400, msg, null);
    }

    public static Result fail(int code, String msg, Object data) {
        return publicMethod(code, msg, data);
    }

    public static Result fail(int code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    private static Result publicMethod(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

}