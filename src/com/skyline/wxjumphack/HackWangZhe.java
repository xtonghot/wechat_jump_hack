package com.skyline.wxjumphack;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * HackWangZhe ������ҫˢ���
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
                    Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1560 965 "); // ��ս
                } else {
                    // TODO ��һ����Ҫ�ȵ������һ������ͣ���ڴ˻��棬��������
                }

                Thread.sleep(3_000);
                printLog("cg ");
                Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1465 905 "); // ����

                Thread.sleep(13_000); // loadʱ���Գ�
                tiaoGuo(); // �������Զ�֮ǰ�Ļ��棩

                Thread.sleep(2_000);
                auto(); // TODO �Զ������ؿ�ʼ��

                // TODO ��ʱ�У���ʱû��
//                Thread.sleep(1_000);
//                tiaoGuo(); // �������Զ�֮��Ļ��棩

                Thread.sleep(11_000); // �ȴ�������֣��������
                tiaoGuo(); // �������Զ�֮��Ļ��棩

                Thread.sleep(63_000); // �ȴ����������������
                tiaoGuo(); // ����

                Thread.sleep(2_000);

                printLog("dianji pinmu ");
                Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1560 965 "); // �������λ�ã�һ�����ڽ�������ý����Ļ��
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
        Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1795 37 "); // �Զ������ؿ�ʼ��
    }

    private static void tiaoGuo() throws IOException {
        printLog("tiaoGuo ");
        Runtime.getRuntime().exec(ADB_PATH + " shell input tap 1795 37 "); // ����
    }

    /**
     * ��ȡ����ʱ����ַ���
     * @return
     */
    private static String getNowStringTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        return df.format(new Date());
    }

    /**
     * ��ӡlog
     * @param var
     */
    private static void printLog(String var) {
        System.out.println(getNowStringTime() + ": " + var);
    }
}
