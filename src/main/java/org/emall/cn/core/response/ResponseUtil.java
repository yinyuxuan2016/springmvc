package org.emall.cn.core.response;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/28
 */
public class ResponseUtil {
    private static Logger logger = Logger.getLogger(ResponseUtil.class);
    public ResponseUtil() {

    }

    /**
     * ajax响应json
     * @param response
     * @param msg
     * @Param responseType 响应类型：json/html/script
     */
    public static void responseJson(HttpServletResponse response,String msg,String responseType){
        PrintWriter out=null;
        try{
            response.setCharacterEncoding("utf-8");
            if("html".equals(responseType)){
                response.setContentType("text/html;charset=UTF-8");
            }else if("script".equals(responseType)){
                response.setContentType("text/javascript;charset=UTF-8");
            }else{
                //默认是json格式的类型
                response.setContentType("application/json;charset=UTF-8");
            }
            out.print(msg);
            out.flush();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }finally {
            if(out!=null){
                out.close();
            }
        }
    }
}
