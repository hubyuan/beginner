package cn.wfy.nikey;

import java.util.*;

public class Consts
{
	//设备分类分项
	final static public String Equipment = "Equipment"; //设备分类
	final static public String Transformer = "Transformer"; //变压器分类
	//final static public String TransformerCapacity = "TransformerCapacity"; //变压器容量
	
	//进线分类分项
	final static public String MainInLine = "MainInLine"; //总进线
	final static public String HPMainInLine = "HPMainInLine"; //全厂总进线
	
	//变压器厂区分类
	final static public String HPTransformerClass = "HPTransformerClass"; //变压器厂区分类
	
	//厂区虚拟点关联电、水、蒸汽、产量、产值
	final static public String TotalEnergyUsage = "TOTAL_POSITIVE_ACTIVE_ENERGY"; //总用电量
	final static public String TotalWaterUsage = "TOTAL_POSITIVE_FLOW"; //总用水量
	final static public String TotalSteamUsage = "TOTAL_POSITIVE_FLOW"; //总用蒸汽量
	final static public String TotalProduct = "TotalProduct"; //总产量
	final static public String TDP = "TDP"; //总产值
	
	//折标系数
	final static public double PowerEnergyFoldingCoefficient = 0.1229 / 1000; //电力  吨标准煤 
	final static public double WaterFoldingCoefficient = 0.0857 / 1000; //软水 kgce/t
	final static public double SteamFoldingCoefficient = 0.0341 * 2.792; //蒸汽 吨标准煤
	
	//时间类型
	final static public int CUSTOM_DATE = 0; //自定义范围
	final static public int DAY = 1; //日
	final static public int MONTH = 2; //月
	final static public int YEAR = 3; //年
	final static public int FIVE_YEAR = 4; //5年

	//计量点参数
	final static public String TransformerDeclareCapacity = "DeclareCapacity"; //变压器容量
	final static public String HarmonicOrder = "HarmonicOrder"; //谐波次数
	final static public String DeviceRun = "1"; //投运
	
	//干式配电变压器能效限定值（电工钢带）,(额定容量 kVA,空载损耗 kW)
	public static Map<Integer, Double> transformerLoss = new LinkedHashMap<>();
	
	static
	{
		transformerLoss.put(30, 150/1000D);
		transformerLoss.put(50, 215/1000D);
		transformerLoss.put(80, 295/1000D);
		transformerLoss.put(100, 320/1000D);
		transformerLoss.put(125, 375/1000D);
		transformerLoss.put(160, 430/1000D);
		transformerLoss.put(200, 495/1000D);
		transformerLoss.put(250, 575/1000D);
		transformerLoss.put(315, 705/1000D);
		transformerLoss.put(400, 785/1000D);
		transformerLoss.put(500, 930/1000D);
		transformerLoss.put(630, 1070/1000D);
		transformerLoss.put(800, 1215/1000D);
		transformerLoss.put(1000, 1415/1000D);
		transformerLoss.put(1250, 1670/1000D);
		transformerLoss.put(1600, 1960/1000D);
		transformerLoss.put(2000, 2440/1000D);
		transformerLoss.put(2500, 2880/1000D);
	}

	//前端定义时间类型
	final static public int preday = 0; //日
	final static public int premonth = 2; //月
	final static public int preyear = 5; //年

	//电流三相不平衡标准值
	final static public Double CurrentUnbalanceStandardValue = 10d;
	//电压三相不平衡标准值
	final static public Double VoltageUnbalanceStandardValue = 2d;
	//电压短时三相不平衡标准值
	final static public Double VoltageUnbalanceStandardNowValue = 4d;

	//频率偏差（+-Hz）
	final static public Double frequencyRate = 0.2d;

	//频率（Hz）
	final static public Double frequency = 50d;

	//（1）35kV及以上供电电压正、负偏差的绝对值之和不超过额定电压的10%。若供电电压上下偏差同号（均为正或负）时，按较大的偏差绝对值作为衡量依据。
	//（2）10kV及以下供电电压允许偏差为额定电压的±7%。
	//（3）0.22kV单相供电电压允许偏差为+7%、-10%。
	//35kV电压偏差允许值
	final static public Double thirtyFiveVoltageDeviation = 0.1d;
	//10kV电压偏差允许值
	final static public Double tenVoltageDeviation = 0.07d;
	//220v电压偏差正允许值
	final static public Double twenVoltageDeviationP = 0.07d;
	//220v电压偏差负允许值
	final static public Double twenVoltageDeviationN = 0.1d;
	
	final static public int productConsumptionTrend = 1; //产量单耗趋势
	final static public int tdpConsumptionTrend = 2; //产值单耗趋势
	final static public int energyUsageTrend = 3; //能耗趋势

	//查询类型 用量1 表码2
	final static public Integer dosage = 1;
	final static public Integer tabelCode = 2;

	//能源类型 电 水 蒸汽 柴油
	final static public Integer electricType = 1;
	final static public Integer waterType = 2;
	final static public Integer steamType = 3;
	final static public Integer gasType = 4;
	final static public Integer dieselType = 5;

	//类型 （1 瞬时量，2电能 ，3 非电能，4 谐波 ，5 温度 ，6 湿度，7 计数，8 计数统计量 ，9 状态）

	final static public Integer allType1 = 1;
	final static public Integer allType2 = 2;
	final static public Integer allType3 = 3;
	final static public Integer allType4 = 4;
	final static public Integer allType5 = 5;
	final static public Integer allType6 = 6;
	final static public Integer allType7 = 7;
	final static public Integer allType8 = 8;
	final static public Integer allType9 = 9;

	//是否变压器
	final static public String IsTransformer = "IsTransformer";

	//是否总进线
	final static public String IsMainInLine = "IsMainInLine";

	//一分钟秒数
	final static public Long secondOfMinute = 60l;

	//一小时秒数
	final static public Long secondOfHour = 60 * 60l;

	//一天秒数
	final static public Long secondOfDay = 24 * 60 * 60l;

	//一月秒数
	final static public Long secondOfMonth = 30 * 24 * 60 * 60l;


	final static public Double phaseVolatagelow = 220d;

	final static public Double lineVolatagehigh = 10000d;

	//峰平谷尖
	final static public List<String> PPVS= new ArrayList<>(Arrays.asList("peak","plain","valley","sharp"));
	//峰
	final static public String peak = "peak";
	//平
	final static public String plain = "plain";
	//谷
	final static public String valley = "valley";
	//尖
	final static public String sharp = "sharp";

	//成本计价模型-峰平谷尖
	final static public Integer COST_PPVS = 1;
	//成本计价模型-商业
	final static public Integer COST_COMMERCIAL = 2;
	//成本计价模型-階梯
	final static public Integer COST_LADDER = 3;


	//水流量number
	final static public Integer water_pointnumber = 0;
	//蒸汽流量number
	final static public Integer steam_pointnumber = 1;
	//天然气流量number
	final static public Integer gas_pointnumber = 2;
	//柴油流量number
	final static public Integer diesel_pointnumber = 3;
	//压缩空气流量number
	final static public Integer aircompress_pointnumber = 4;

	final static public List<String> expressName = new ArrayList<>(Arrays.asList("ENERGY_CONSUMPTION", "TOTAL_POSITIVE_ACTIVE_ENERGY_QUANTITY", "TOTAL_POSITIVE_FLOW_QUANTITY", "TOTAL_POSITIVE_FLOW_QUANTITY"));
	final static public List<String> viewName = new ArrayList<>(Arrays.asList("integrate", "power", "water", "gas"));//前端


}
