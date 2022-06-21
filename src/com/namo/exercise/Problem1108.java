package com.namo.exercise;

import org.junit.Test;

/**
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * <p>
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 示例 2：
 * <p>
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *  
 * <p>
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * <p>
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 示例 2：
 * <p>
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *  
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/defanging-an-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author namo
 * @date 2022/6/21-10:16
 */
public class Problem1108 {
    @Test
    public void Case1108() {
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));
    }


    /**
     * 自己的思路
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        final String addStr = "[.]";
        StringBuilder stringBuilder = new StringBuilder();
        char[] addresses = address.toCharArray();

        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == '.') {
                stringBuilder.append(addStr);
            } else {
                stringBuilder.append(addresses[i]);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 直接replace
     * @param address
     * @return
     */
    public String defangIPaddr2(String address) {
        return address.replace(".","[.]");
    }


    //todo 题解解决方案
}
