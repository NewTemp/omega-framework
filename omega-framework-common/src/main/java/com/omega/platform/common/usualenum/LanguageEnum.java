package com.omega.platform.common.usualenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
*@Description Happy!
*@Author Allen.Lv
*@Date 3/23/2020
*@Time 8:37 PM
*/
@Getter
@AllArgsConstructor
public enum LanguageEnum {
    CN(1, "CN", "中文"),
    EN(2, "EN", "英文"),
    CHT(3, "CHT", "中文繁体"),
    OTHER(-1, "OTHER", "其他"),

    ;

    /**
     * 系统内使用代码
     */
    private final int code;
    /**
     * 国际通用代码
     */
    private final String isoCode;
    /**
     * 语种名称
     */
    private final String name;


    /**
     * 根据枚举状态码获取对应的中文描述信息
     *
     * @param code 枚举状态码
     * @return
     */
    public static String getName(int code) {
        LanguageEnum[] enums = LanguageEnum.values();

        for (LanguageEnum enumTemp : enums) {
            if (enumTemp.getCode() == code) {
                return enumTemp.getName();
            }
        }

        return null;
    }


    /**
     * 根据枚举状态码获取对应的中文描述信息
     *
     * @param isoCode 国际通用代码
     * @return
     */
    public static String getNameByIsoCode(String isoCode) {
        LanguageEnum[] enums = LanguageEnum.values();

        for (LanguageEnum enumTemp : enums) {
            if (enumTemp.getIsoCode().equals(isoCode)) {
                return enumTemp.getName();
            }
        }

        return null;
    }

    /**
     * 根据枚举状态码获取code对应的Enum对象
     *
     * @param code 枚举状态码
     * @return
     */
    public static LanguageEnum getEnum(int code) {
        LanguageEnum[] enums = LanguageEnum.values();

        for (LanguageEnum enumTemp : enums) {
            if (enumTemp.getCode() == code) {
                return enumTemp;
            }
        }

        return null;
    }

    /**
     * 根据枚举状态码获取code对应的Enum对象
     *
     * @param isoCode 国际通用代码
     * @return
     */
    public static LanguageEnum getEnumByIsoCode(String isoCode) {
        LanguageEnum[] enums = LanguageEnum.values();

        for (LanguageEnum enumTemp : enums) {
            if (enumTemp.getIsoCode().equals(isoCode)) {
                return enumTemp;
            }
        }

        return null;
    }
}
