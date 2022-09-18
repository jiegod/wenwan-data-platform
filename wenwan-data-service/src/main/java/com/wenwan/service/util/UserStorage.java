package com.wenwan.service.util;

import com.wenwan.common.constant.UserConst;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class UserStorage {

    private static final ThreadLocal<String> LOCAL = new InheritableThreadLocal<>();

    public static void set(String username) {
        if (StringUtils.isNotEmpty(username)) {
            LOCAL.set(username);
            TraceIdStorage.set(UUID.randomUUID().toString());
        }
    }

    public static String get() {
        if (StringUtils.isNotEmpty(LOCAL.get())) {
            return LOCAL.get();
        }
        return UserConst.SYS_USER;
    }

    public static void remove() {
        LOCAL.remove();
        TraceIdStorage.remove();
    }


    public static class TraceIdStorage {

        private static final ThreadLocal<String> LOCAL = new InheritableThreadLocal<>();

        public static void set(String tracId) {
            LOCAL.set(tracId);
        }

        public static String get() {
            if (StringUtils.isNotEmpty(LOCAL.get())) {
                return LOCAL.get();
            }
            return UserConst.SYS_USER_TRAC;
        }

        public static void remove() {
            LOCAL.remove();
        }
    }
}
