package com.andychen1024.common;



import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;

import com.blankj.utilcode.util.LogUtils;


/**
 * 获取设备信息
 */
public class DeviceUtil {

//    private static Logger logger = LoggerFactory.getLogger(DeviceUtil.class);

    /**
     * 获取应用程序的IMEI号，15位数字，例如：866190021582780
     */
    @SuppressLint("HardwareIds")
    public static String getIMEI(Context context) {
        if (context == null) {
            LogUtils.i("getIMEI  context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    /**
     * 获取mac地址，例如：38:bc:1a:c2:4d:d4
     */
    @SuppressLint("HardwareIds")
    public static String getMacAddress(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }   

        return ((WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getMacAddress();
    }

    /**
     * 获取电话状态：
     * tm.CALL_STATE_IDLE=0     无活动
     * tm.CALL_STATE_RINGING=1  响铃
     * tm.CALL_STATE_OFFHOOK=2  摘机
     */
    public static int getCallState(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return -1;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getCallState();
    }

    /**
     * 获取安卓id
     */
    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    public static String getAndroidId(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return android.provider.Settings.Secure.getString(
                context.getContentResolver(),
                android.provider.Settings.Secure.ANDROID_ID);
    }

    /**
     * 获取电话方位
     */
    public static CellLocation getCellLocation(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getCellLocation();
    }

    /**
     * 唯一的设备ID：
     * GSM手机的 IMEI 和 CDMA 手机的 MEID.
     * Return null if device ID is not available.
     */
    @SuppressLint("HardwareIds")
    public static String getDeviceId(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    /**
     * 设备的软件版本号：
     * 例如：the IMEI/SV(software version) for GSM phones.
     * Return null if the software version is not available.
     */
    public static String getDeviceSoftwareVersion(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceSoftwareVersion();
    }

    /**
     * 手机号：
     * GSM 手机的 MSISDN.
     * Return null if it is unavailable.
     */
    @SuppressLint("HardwareIds")
    public static String getLine1Number(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getLine1Number();
    }

    /**
     * 附近的电话的信息:
     * 类型：List<NeighboringCellInfo>
     * 需要权限：android.Manifest.permission#ACCESS_COARSE_UPDATES
     */
//    @TargetApi(Build.VERSION_CODES.CUPCAKE)
//    public static List<NeighboringCellInfo> getNeighboringCellInfo(Context context) {
//        if (context == null) {
//            LogUtils.i("getMacAddress() context为空");
//            return null;
//        }
//
//        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getNeighboringCellInfo();
//    }

    /**
     * 获取ISO标准的国家码，即国际长途区号。
     * 注意：仅当用户已在网络注册后有效。
     * 在CDMA网络中结果也许不可靠。
     */
    public static String getNetworkCountryIso(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getNetworkCountryIso();
    }

    /**
     * MCC+MNC(mobile country code + mobile network code)
     * 注意：仅当用户已在网络注册时有效。
     * 在CDMA网络中结果也许不可靠。
     */
    public static String getNetworkOperator(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getNetworkOperator();
    }

    /**
     * 按照字母次序的current registered operator(当前已注册的用户)的名字
     * 注意：仅当用户已在网络注册时有效。
     * 在CDMA网络中结果也许不可靠。
     */
    public static String getNetworkOperatorName(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getNetworkOperatorName();
    }

    /**
     * 当前使用的网络类型：
     * 例如：
     * NETWORK_TYPE_UNKNOWN  网络类型未知  0
     * NETWORK_TYPE_GPRS     GPRS网络  1
     * NETWORK_TYPE_EDGE     EDGE网络  2
     * NETWORK_TYPE_UMTS     UMTS网络  3
     * NETWORK_TYPE_HSDPA    HSDPA网络  8
     * NETWORK_TYPE_HSUPA    HSUPA网络  9
     * NETWORK_TYPE_HSPA     HSPA网络  10
     * NETWORK_TYPE_CDMA     CDMA网络,IS95A 或 IS95B.  4
     * NETWORK_TYPE_EVDO_0   EVDO网络, revision 0.  5
     * NETWORK_TYPE_EVDO_A   EVDO网络, revision A.  6
     * NETWORK_TYPE_1xRTT    1xRTT网络  7
     */
    public static int getNetworkType(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return -1;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getNetworkType();
    }

    /**
     * 手机类型：
     * 例如：
     * PHONE_TYPE_NONE  无信号
     * PHONE_TYPE_GSM   GSM信号
     * PHONE_TYPE_CDMA  CDMA信号
     */
    public static int getPhoneType(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return -1;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getPhoneType();
    }

    /**
     * Returns the ISO country code equivalent for the SIM provider's country code.
     * 获取ISO国家码，相当于提供SIM卡的国家码。
     */
    public static String getSimCountryIso(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getSimCountryIso();
    }

    /**
     * Returns the MCC+MNC (mobile country code + mobile network code) of the provider of the SIM. 5 or 6 decimal digits.
     * 获取SIM卡提供的移动国家码和移动网络码.5或6位的十进制数字.
     * SIM卡的状态必须是 SIM_STATE_READY(使用getSimState()判断).
     */
    public static String getSimOperator(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getSimOperator();
    }

    /**
     * 服务商名称：
     * 例如：中国移动、联通
     * SIM卡的状态必须是 SIM_STATE_READY(使用getSimState()判断).
     */
    public static String getSimOperatorName(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getSimOperatorName();
    }

    /**
     * SIM卡的序列号：
     * 需要权限：READ_PHONE_STATE
     */
    public static String getSimSerialNumber(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getSimSerialNumber();
    }

    /**
     * SIM的状态信息：
     * SIM_STATE_UNKNOWN          未知状态 0
     * SIM_STATE_ABSENT           没插卡 1
     * SIM_STATE_PIN_REQUIRED     锁定状态，需要用户的PIN码解锁 2
     * SIM_STATE_PUK_REQUIRED     锁定状态，需要用户的PUK码解锁 3
     * SIM_STATE_NETWORK_LOCKED   锁定状态，需要网络的PIN码解锁 4
     * SIM_STATE_READY            就绪状态 5
     */
    public static int getSimState(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return -1;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getSimState();
    }

    /**
     * 国际移动用户识别码（IMSI：International Mobile Subscriber Identification Number）是区别移动用户的标志，储存在SIM卡中，可用于区别移动用户的有效信息。其总长度不超过15位，同样使用0～9的数字。其中MCC是移动用户所属国家代号，占3位数字，中国的MCC规定为460；MNC是移动网号码，由两位或者三位数字组成，中国移动的移动网络编码（MNC）为00；用于识别移动用户所归属的移动通信网；MSIN是移动用户识别码，用以识别某一移动通信网中的移动用户。
     * 唯一的用户ID：
     * 例如：IMSI(国际移动用户识别码) for a GSM phone.
     * 需要权限：READ_PHONE_STATE
     */
    @SuppressLint("HardwareIds")
    public static String getSubscriberId(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getSubscriberId();
    }

    /**
     * 取得和语音邮件相关的标签，即为识别符
     * 需要权限：READ_PHONE_STATE
     */
    public static String getVoiceMailAlphaTag(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getVoiceMailAlphaTag();
    }

    /**
     * 获取语音邮件号码：
     * 需要权限：READ_PHONE_STATE
     */
    public static String getVoiceMailNumber(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return null;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getVoiceMailNumber();
    }

    /**
     * ICC卡是否存在
     */
    @TargetApi(Build.VERSION_CODES.ECLAIR)
    public static boolean hasIccCard(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return false;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).hasIccCard();
    }

    /**
     * 是否漫游:
     * (在GSM用途下)
     */
    public static boolean isNetworkRoaming(Context context) {
        if (context == null) {
            LogUtils.i("getMacAddress() context为空");
            return false;
        }

        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).isNetworkRoaming();
    }

    /**
     * 获取设备的系统版本号
     */
    public static int getDeviceSDK() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 获取设备的型号
     */
    public static String getDeviceName() {
        return Build.MODEL;
    }

}