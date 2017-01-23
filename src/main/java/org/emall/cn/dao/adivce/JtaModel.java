package org.emall.cn.dao.adivce;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/5
 */
    public class JtaModel {
        private long startTime;
        private Method method;

        public JtaModel() {
        }

        public JtaModel(long startTime) {
            this.startTime = startTime;
        }

        public JtaModel(long startTime, Method method) {
            this.startTime = startTime;
            this.method = method;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public Method getMethod() {
            return this.method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }
    }
