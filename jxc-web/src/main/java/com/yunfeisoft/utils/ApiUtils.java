package com.yunfeisoft.utils;

import com.applet.base.BaseModel;
import com.applet.session.SessionModel;
import com.applet.session.SpringServletHelper;
import com.applet.utils.WebUtils;
import com.yunfeisoft.model.User;

import java.io.File;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Jackie Liu on 2017/4/8.
 */
public class ApiUtils {

    private ApiUtils() {

    }

    public static final String WX_TOKEN_COOKIE_NAME = "wx_token";

    /**
     * 获取登录用户信息
     *
     * @return
     */
    public static User getLoginUser() {
        SessionModel sessionModel = WebUtils.getLoginSessionModel();
        if (sessionModel != null) {
            return (User) sessionModel.getUser();
        }
        return null;
    }

    /**
     * 获取微信用户或者系统用户登录信息
     *
     * @return
     */
    public static BaseModel getLogin() {
        SessionModel sessionModel = WebUtils.getLoginSessionModel();
        if (sessionModel != null) {
            return sessionModel.getUser();
        }
        return null;
    }

    /**
     * 去除重复节点
     *
     * @param list
     */
    public static void removeDuplicate(List<String> list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
    }

    /**
     * 获取临时目录
     *
     * @return
     */
    public static String getTempPath() {
        StringBuffer sb = new StringBuffer();
        sb.append(SpringServletHelper.getRequest().getSession().getServletContext().getRealPath("/"));
        sb.append("/upload/temp/");
        File file = new File(sb.toString());
        //System.out.println("################## file path = " + file.getAbsolutePath());
        if (!file.exists()) {
            file.mkdirs();
        }
        return sb.toString();
    }

    /**
     * 获取项目根目录
     * @return
     */
    public String getRootPath() {
        return SpringServletHelper.getRequest().getSession().getServletContext().getRealPath("/");
    }
}
