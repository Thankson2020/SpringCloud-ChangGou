package com.thankson.common.util.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class NetWorkUtils {

    /**
     * 获取到 SessionID
     *
     * @param request HttpServletRequest
     * @return SessionID
     */
    public static String getSessionID(HttpServletRequest request) {
        return request.getSession().getId();
    }

    /**
     * 获取客户端的IP
     *
     * @param request HttpServletRequest
     * @return 客户端IP
     */
    public static String getRemoteHost(HttpServletRequest request) {

        if (request == null) {
            return null;
        }
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
        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ip.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ip = str;
                break;
            }
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

    /**
     * 获取得到本机IP地址
     */
    public static String getLocalIP() {
        if (isWindowsOS()) {
            return getWindowsIP();
        } else {
            return getLinuxLocalIp();
        }
    }

    /**
     * 判断操作系统是否为windows系统
     */
    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("windows")) {
            isWindowsOS = true;
        }
        return isWindowsOS;
    }

    /**
     * 获取到Host名字
     */
    public static String getLocalHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取WindowsIP
     */
    public static String getWindowsIP() {
        StringBuilder serverIP = new StringBuilder();
        InetAddress addr;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "127.0.0.1";
        }
        byte[] ipAddr = addr.getAddress();
        for (int i = 0; i < ipAddr.length; i++) {
            if (i > 0) {
                serverIP.append(".");
            }
            serverIP.append(ipAddr[i] & 0xFF);
        }
        return serverIP.toString();
    }

    /**
     * 获取LinuxIp
     */
    private static String getLinuxLocalIp() {
        String ip = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipAddress = inetAddress.getHostAddress();
                            if (!ipAddress.contains("::") && !ipAddress.contains("0:0:")
                                    && !ipAddress.contains("fe80")) {
                                ip = ipAddress;
                            }
                        }
                    }
                }
            }

        } catch (Exception ex) {
            ip = "127.0.0.1";
            ex.printStackTrace();
        }
        return ip;
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
    }
}

