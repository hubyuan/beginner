package cn.wfy.nikey;

import java.math.BigInteger;

/**
 * 数据编码项编码
 */
public enum PointCode {

    VOLTAGE(101, "电压"), CURRENT(102, "电流"), POWER(103, "功率"),
    VOLTAGE_A(201, "电压A"), VOLTAGE_B(202, "电压B"), VOLTAGE_C(203, "电压C"),
    PHASE_ANGLE_VOLTAGE_A(204, "A相位角电压"), PHASE_ANGLE_VOLTAGE_B(205, "B相位角电压"),
    PHASE_ANGLE_VOLTAGE_C(206, "C相位角电压"), CURRENT_A(207, "电流A"), CURRENT_B(208, "电流B"),
    CURRENT_C(209, "电流C"), CURRENT_ZERO(210, "零序电流"), TOTAL_ACTIVE_POWER(211, "总有功功率"),
    ACTIVE_POWER_A(212, "A相有功功率"), ACTIVE_POWER_B(213, "B相有功功率"), ACTIVE_POWER_C(214, "C相有功功率"),
    TOTAL_REACTIVE_POWER(215, "总无功功率"), REACTIVE_POWER_A(216, "A相无功功率"), REACTIVE_POWER_B(217, "B相无功功率"),
    REACTIVE_POWER_C(218, "C相无功功率"), TOTAL_POWER_FACTOR(219, "总功率因数"), POWER_FACTOR_A(220, "A相功率因数"),
    POWER_FACTOR_B(221, "B相功率因数"), POWER_FACTOR_C(222, "C相功率因数"), TOTAL_APPARENT_POWER(223, "总视在功率"),
    APPARENT_POWER_A(224, "A相视在功率("), APPARENT_POWER_B(225, "B相视在功率"), APPARENT_POWER_C(226, "C相视在功率"),
    GRID_FREQUENCY(227, "电网频率"), DEMAND(228, "需量"), TOTAL_POSITIVE_ACTIVE_ENERGY(229, "正向有功总电能"),
    TOTAL_POSITIVE_ACTIVE_ENERGY_QUANTITY(100229, "正向有功总电能(统计量)"),
    TOTAL_REVERSE_ACTIVE_ENERGY(230, "反向有功总电能"),
    TOTAL_REVERSE_ACTIVE_ENERGY_QUANTITY(100230, "反向有功总电能(统计量)"),
    TOTAL_POSITIVE_REACTIVE_ENERGY(231, "正向无功总电能(组合无功1)"),
    TOTAL_POSITIVE_REACTIVE_ENERGY_QUANTITY(100231, "正向无功总电能(组合无功1)(统计量)"),
    TOTAL_REVERSE_REACTIVE_ENERGY(232, "反向无功总电能(组合无功2)"), LOAD_RATE(233, "负荷率"),
    TOTAL_REVERSE_REACTIVE_ENERGY_QUANTITY(100232, "反向无功总电能(组合无功2)(统计量)"),
    LOAD_FACTOR(234, "负载率"), VOLTAGE_UNBALANCE(235, "电压不平衡度"),
    VOLTAGE_UNBALANCE_A(236, "电压不平衡度A"), VOLTAGE_UNBALANCE_B(237, "电压不平衡度B"),
    VOLTAGE_UNBALANCE_C(238, "电压不平衡度C"), CURRENT_UNBALANCE(242, "电流不平衡度"), CURRENT_UNBALANCE_A(243, "电流不平衡度A"),
    CURRENT_UNBALANCE_B(244, "电流不平衡度B"), CURRENT_UNBALANCE_C(245, "电流不平衡度C"),
    VOLTAGE_AB(249, "电压AB"), VOLTAGE_BC(250, "电压BC"), VOLTAGE_CA(251, "电压CA"),
    CURRENT_AB(261, "电流AB"), CURRENT_BC(262, "电流BC"), CURRENT_CA(263, "电流CA"),
    TOTAL_POWER_FACTOR_AVG(252, "总功率因数平均值"), LOAD_FACTOR_AVG(253, "负载率平均值"),
    ACTIVE_POWER_AB(264, "AB线有功功率"), ACTIVE_POWER_BC(265, "BC线有功功率"),ACTIVE_POWER_CA(266, "CA线有功功率"),
    REACTIVE_POWER_AB(267, "AB线无功功率"), REACTIVE_POWER_BC(268, "BC线无功功率"), REACTIVE_POWER_CA(269, "CA线无功功率"),
    APPARENT_POWER_AB(270, "AB线视在功率"), APPARENT_POWER_BC(271, "BC线视在功率"), APPARENT_POWER_CA(272, "CA线视在功率"),
    POWER_FACTOR_AB(273, "AB线功率因数"), POWER_FACTOR_BC(274, "BC线功率因数"), POWER_FACTOR_CA(275, "CA线视在功率"),
    TOTAL_POSITIVE_FLOW(401, "总正向流量(累计流量)"),
    TOTAL_POSITIVE_FLOW_QUANTITY(100401, "总正向流量(累计流量)(统计量)"), TOTAL_REVERSE_FLOW(402, "总反向流量"),
    TOTAL_REVERSE_FLOW_QUANTITY(100402, "总反向流量(统计量)"), FLOW_RATE(403, "流速(流量、瞬时流量)"),
    PRESSURE(404, "压力"), DENSITY(405, "密度"), TOTAL_FLOW_HEAT(406, "总热能"),
    TOTAL_COOLING_HEAT(407, "总冷能"), POWER_HEAT	(408, "热功率"),
    POWER_COOLING(409, "冷功率"), TEMPERATURE(501, "温度"), HUMIDITY(502, "湿度"),
    STATE(601, "状态"), COUNT(701, "计数"), COUNT_QUANTITY(100701, "计数(统计量)"),
    ENERGY_CONSUMPTION(100801, "能源消耗量(综合能源)"), USER_CUSTOM_COUNT(1000, "用户自定义(统计相关)"),
    HARMONIC_VOLTAGE_A(10000, "谐波电压A"), HARMONIC_VOLTAGE_B(15000, "谐波电压B"),
    HARMONIC_VOLTAGE_C(20000, "谐波电压C"), HARMONIC_CURRENT_A(25000, "谐波电流A"),
    HARMONIC_CURRENT_B(30000, "谐波电流B"), HARMONIC_CURRENT_C(35000, "谐波电流C"),
    ;

    private Integer code;
    private String text;

    public Integer getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    PointCode(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public static PointCode get(String code) {
        if(code == null || "".equals(code)) {
            return null;
        }
        int i = Integer.parseInt(code);
        if (i >= 10000 && i < 15000) {
            HARMONIC_VOLTAGE_A.code = i;
            return HARMONIC_VOLTAGE_A;
        }
        if (i >= 15000 && i < 20000) {
            HARMONIC_VOLTAGE_B.code = i;
            return HARMONIC_VOLTAGE_B;
        }
        if (i >= 20000 && i < 25000) {
            HARMONIC_VOLTAGE_C.code = i;
            return HARMONIC_VOLTAGE_C;
        }
        if (i >= 25000 && i < 30000) {
            HARMONIC_CURRENT_A.code = i;
            return HARMONIC_CURRENT_A;
        }
        if (i >= 30000 && i < 35000) {
            HARMONIC_CURRENT_B.code = i;
            return HARMONIC_CURRENT_B;
        }
        if (i >= 35000 && i < 40000) {
            HARMONIC_CURRENT_C.code = i;
            return HARMONIC_CURRENT_C;
        }
        for(PointCode pointCode: PointCode.values()) {
            if(pointCode.getCode().toString().equals(code) || pointCode.name().equals(code)) {
                return pointCode;
            }
        }
        return null;
    }

    public static PointCode get(Integer code) {
        if(code == null) {
            return null;
        }
        code = code.intValue();
        if (code >= 10000 && code < 15000) {
            HARMONIC_VOLTAGE_A.code = code;
            return HARMONIC_VOLTAGE_A;
        }
        if (code >= 15000 && code < 20000) {
            HARMONIC_VOLTAGE_B.code = code;
            return HARMONIC_VOLTAGE_B;
        }
        if (code >= 20000 && code < 25000) {
            HARMONIC_VOLTAGE_C.code = code;
            return HARMONIC_VOLTAGE_C;
        }
        if (code >= 25000 && code < 30000) {
            HARMONIC_CURRENT_A.code = code;
            return HARMONIC_CURRENT_A;
        }
        if (code >= 30000 && code < 35000) {
            HARMONIC_CURRENT_B.code = code;
            return HARMONIC_CURRENT_B;
        }
        if (code >= 35000 && code < 40000) {
            HARMONIC_CURRENT_C.code = code;
            return HARMONIC_CURRENT_C;
        }
        for(PointCode pointCode: PointCode.values()) {
            if(pointCode.getCode().intValue() == code) {
                return pointCode;
            }
        }
        return null;
    }

    public static final String REALTIME = "realtime_";
    public static final String COUNT_NAME = "count_";
    public static final String STATE_NAME = "state_";
    public static final String STATISTICS = "statistics_";
    public static final String STATISTICS_TIME_SEGMENT = "statistics_time_segments_";
    public static final String STATISTICS_RENTAL_AREA_REPORT = "statistics_rental_area_report_";
    public static final Integer REALTIME_TABLE_COUNT = 512;
    public static final Integer COUNT_TABLE_COUNT = 32;
    public static final Integer STATISTICS_TABLE_COUNT = 32;
    public static final Integer STATE_TABLE_COUNT = 16;

    /**
     * 根据查询的Code和计量点id获取Measurement。该方法只适用于查询瞬时值和原始值使用。查询统计值请自己拼接前缀和哈希码
     * @param pointCode
     * @param measureId
     * @return
     */
    public static String getMeasurement(PointCode pointCode, BigInteger measureId) {
        switch (pointCode) {
            case STATE:
                return STATE_NAME + hashCode(measureId, STATE_TABLE_COUNT);
            case TOTAL_POSITIVE_ACTIVE_ENERGY:
            case TOTAL_REVERSE_ACTIVE_ENERGY:
            case TOTAL_POSITIVE_REACTIVE_ENERGY:
            case TOTAL_REVERSE_REACTIVE_ENERGY:
            case TOTAL_POSITIVE_FLOW:
            case TOTAL_REVERSE_FLOW:
            case COUNT:
                return COUNT_NAME + hashCode(measureId, COUNT_TABLE_COUNT);
            default:
                return REALTIME + hashCode(measureId, REALTIME_TABLE_COUNT);
        }
    }

    public static String hashCode(BigInteger measureId, int tableCount) {
        BigInteger tableCountTemp = new BigInteger(String.valueOf(tableCount - 1));
        BigInteger and = measureId.and(tableCountTemp);
        return String.valueOf(and);
    }

    public static PointCode getCodeByAvgCode(PointCode pointCode) {
        switch (pointCode) {
            case TOTAL_POWER_FACTOR_AVG:
                return TOTAL_POWER_FACTOR;
            case LOAD_FACTOR_AVG:
                return LOAD_FACTOR;
        }
        return null;
    }

    public static boolean isStatisticsCode(PointCode pointCode) {
        switch (pointCode) {
            case LOAD_FACTOR_AVG:
            case TOTAL_POSITIVE_FLOW_QUANTITY:
            case TOTAL_POSITIVE_ACTIVE_ENERGY_QUANTITY:
            case TOTAL_REVERSE_ACTIVE_ENERGY_QUANTITY:
            case TOTAL_POSITIVE_REACTIVE_ENERGY_QUANTITY:
            case TOTAL_POWER_FACTOR_AVG:
            case TOTAL_REVERSE_FLOW_QUANTITY:
            case TOTAL_REVERSE_REACTIVE_ENERGY_QUANTITY:
            case COUNT_QUANTITY:
            case LOAD_RATE:
            case USER_CUSTOM_COUNT:
            case ENERGY_CONSUMPTION:
                return true;
        }
        return false;
    }
}
