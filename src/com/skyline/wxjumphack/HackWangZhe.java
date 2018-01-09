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
        String scenario;
        for (int i = 0; i < 100; i++) {
            try {
                printLog("============start========== " + i);

                if (i > 0) {
                    printLog("挑战 ");
                    Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1595 990 "); // 挑战

                    Thread.sleep(5_000);
                } else {
                    // TODO 第一次需要先点击【下一步】，停留在此画面，启动程序
                }
                printLog("闯关 ");
                Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1470 915 "); // 闯关

                scenario = "闯关点击后，load时间过长。容错";
                Thread.sleep(12_000); // 闯关点击后，load时间略长，多跳过几次，容错
                tiaoGuo(scenario, 5); // 跳过

                Thread.sleep(1_000);
                auto(); // TODO 自动 ====== 从这里开始大概： 10s 白起出现， 60s 扁鹊出现

                Thread.sleep(1_000);
                tiaoGuo("自动之后的跳过", 1); // 跳过（自动之后的画面） 有时有，有时没有，多点一下跳过无妨

                Thread.sleep(8_000); // 自动点击后，10s 白起出现，12秒左右跳过按钮出现
                scenario = "白起出现的跳过，容错";
                tiaoGuo(scenario, 5); // 跳过

                // 自动开始耗时：1+8+5 = 13s  62-13 = 49s
                Thread.sleep(46_000); // 自动点击后，62左右 boss扁鹊第一次出现，扁鹊两次出现间隔大概5秒
                scenario = "扁鹊两次出现的跳过，容错";
                tiaoGuo(scenario, 10); // 跳过

                Thread.sleep(3_000);
                printLog("点击任意位置 "); // 扁鹊第二次出现跳过后，等5秒，结束界面出现
                Runtime.getRuntime().exec(ADB_PATH + " shell input tap 800 800 "); // 点击任意位置（一个周期结束，获得金币屏幕）

                Thread.sleep(2_000); // 等待再次挑战页面出现

                printLog("============end========== " + i);

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    private static void auto() throws IOException {
        printLog("自动 ");
        Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1800 35 "); // 自动（闯关开始）
    }

    private static void tiaoGuo(String scenario, int times) throws IOException, InterruptedException {
        for (int j = 0; j < times; j++) {
            printLog("跳过 " + scenario + j);
            Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1705 85 "); // 跳过

            // 每两次跳过间隔1秒
            Thread.sleep(1_000);
        }
    }

    /**
     * 获取现在时间的字符串
     * @return
     */
    private static String getNowStringTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
