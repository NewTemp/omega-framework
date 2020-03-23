package com.omega.platform.common.utils;

import com.github.houbb.opencc4j.util.ZhConverterUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Tyan框架中文文案转换工具类(主要用于将简体中文转换成繁体中文)
 *
 * @Author: TommyYang
 * @Date: Created in 2019/9/12 15:14
 */
@Slf4j
public class TyanZhConvertUtil {
    /**
     * 将字符串转换成简体中文
     *
     * @param original
     * @return
     */
    public static String convertToSimple(String original) {
        return ZhConverterUtil.convertToSimple(original);
    }

    /**
     * 将字符串转换成繁体中文
     *
     * @param original
     * @return
     */
    public static String convertToTraditional(String original) {
        return ZhConverterUtil.convertToTraditional(original);
    }

    public static void main(String[] args) {
        log.debug("convertToSimple:{}", convertToSimple("我們都是中國人，我高兴、我自豪、我荣耀、我奋斗！"));
        log.debug("convertToTraditional:{}", convertToTraditional("我們都是中國人，我高興、我自豪、我榮耀、我奋斗！"));

        log.debug("复杂文案 convertToSimple:{}", convertToSimple("鑫 森 淼 焱 垚 犇 骉 羴 猋 麤 鱻 贔 掱 劦 晶 磊 毳 畾"));
        log.debug("复杂文案 convertToTraditional:{}", convertToTraditional("鑫 森 淼 焱 垚 犇 骉 羴 猋 麤 鱻 贔 掱 劦 晶 磊 毳 畾"));

        log.debug("复杂文案 convertToTraditional:{}", convertToTraditional("华为、苹果、湖南、长沙"));
        log.debug("复杂文案 convertToTraditional:{}", convertToTraditional("系统开小差,请稍后重试"));
    }
}
