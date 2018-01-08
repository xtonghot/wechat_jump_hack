package com.skyline.wxjumphack;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * HackWangZhe 王者荣耀刷金币
 *
 * @author Tong Xuefang
 * @date 2018/1/8 15:13
 */
public class HackWangZhe {

    static final String ADB_PATH = "E:\\work\\Users\\Administrator\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb";

    public static void main(String... strings) {

        for (int i = 0; i < 100; i++) {
            try {
                printLog("============start========== " + i);

                if (i > 0) {
                    printLog("tz ");
                    Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1560 965 "); // 挑战
                } else {
                    // TODO 第一次需要先点击【下一步】，停留在此画面，启动程序
                }

                Thread.sleep(3_000);
                printLog("cg ");
                Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1465 905 "); // 闯关

                Thread.sleep(13_000); // load时间略长
                tiaoGuo(); // 跳过（自动之前的画面）

                Thread.sleep(2_000);
                auto(); // TODO 自动（闯关开始）

                // TODO 有时有，有时没有
//                Thread.sleep(1_000);
//                tiaoGuo(); // 跳过（自动之后的画面）

                Thread.sleep(11_000); // 等待白起出现，点击跳过
                tiaoGuo(); // 跳过（自动之后的画面）

                Thread.sleep(63_000); // 等待整个闯关任务完成
                tiaoGuo(); // 跳过

                Thread.sleep(2_000);

                printLog("dianji pinmu ");
                Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1560 965 "); // 点击任意位置（一个周期结束，获得金币屏幕）
                Thread.sleep(5_000);

                printLog("============end========== " + i);

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    private static void auto() throws IOException {
        printLog("auto ");
        Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1795 37 "); // 自动（闯关开始）
    }

    private static void tiaoGuo() throws IOException {
        printLog("tiaoGuo ");
        Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1795 37 "); // 跳过
    }

    /**
     * 获取现在时间的字符串
     * @return
     */
    private static String getNowStringTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        return df.format(new Date());
    }

    /**
     * 打印log
     * @param var
     */
    private static void printLog(String var) {
        System.out.println(getNowStringTime() + ": " + var);
    }
}
