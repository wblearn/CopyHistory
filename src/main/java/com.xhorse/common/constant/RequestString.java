package com.xhorse.common.constant;

public interface RequestString {

    String[] APP_UPDATE = {"尊敬的用户，APP已更新，请及时下载最新版本",
            "A new version for APP is ready, please update your APP ASAP",
            "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] CHIP_RESULT = {"尊敬的用户，芯片生成数据已更新，请及时下载最新版本",
            "generate transponder data updated and released, pls download latest version",
            "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] RENEW_RESULT = {"尊敬的用户，钥匙解锁数据已更新，请及时下载最新版本",
            "Dear Customer, a new version for renew data is completed, please update your database ASAP!",
            "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] LARK_REMOTE_TITLE = {"云雀遥控数据升级", "MINIKEYTOOL remote update", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] KEYTOOL_REMOTE_TITLE = {"KEYTOOL遥控数据升级", "KEYTOOL remote update", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] KEYTOOL_CHIP_TITLE = {"KEYTOOL芯片生成数据", "KEYTOOL generate transponder", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] LARK_CHIP_TITLE = {"云雀芯片生成数据", "MINIKEYTOOL generate transponder", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] RENEW_TITLE = {"钥匙解锁数据升级", "Renew data update", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] ICUTTER_TITLE = {"海豚数据库升级", "Dolphin database update", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] KEYTOOL_FIRMWARE_TITLE = {"KEYTOOL固件升级公告 ", "KEYTOOL firmware update", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] ICUTTER_FIRMWARE_TITLE = {"海豚固件升级公告 ", "Dolphin firmware update ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] LARK_FIRMWARE_TITLE = {"云雀固件升级公告 ", "MINIKEYTOOL firmware update ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] APP_TITLE = {"APP软件升级", "APP UPDATE", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] APP_BROADCAST_TITLE = {"APP升级", "APP UPDATE", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] APP_BROADCAST_INFO = {"APP已更新至%s，请及时下载最新版本APP", "NEW VERSION %s FOR APP,PLEASE DOWNLOAD ASAP", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] ICUTTER_BROADCAST_TITLE = {"数据库升级", "DATABASE UPDATE", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] ICUTTER_BROADCAST_INFO = {"海豚数据库已更新至%s，请及时下载最新数据", "NEW VERSION %s FOR DOLPHIN DATA,PLEASE DOWNLOAD ASAP", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] REMOTE_BROADCAST_TITLE = {"遥控库更新", "REMOTE UPDATE", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] REMOTE_BROADCAST_INFO = {"遥控库已更新至%s，请及时下载最新数据", "NEW VERSION %s FOR REMOTE IS READY,PLEASE DOWNLOAD ASAP", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] CHIP_BROADCAST_TITLE = {"芯片数据升级", "CHIP DATA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] CHIP_BROADCAST_INFO = {"芯片生成数据已更新至最新版本，请及时下载", "NEW VERSION FOR CHIP DATA IS READY,PLEASE DOWNLOAD ASAP", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] DEVICE_BROADCAST_TITLE = {"固件升级", "FIRMWARE UPDATE", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    String[] DEVICE_BROADCAST_INFO = {"固件版本已更新至%s，请及时下载更新", "NEW VERSION %s FOR FIRMWARE IS READY,PLEASE DOWNLOAD ASAP", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    /*
     * 本机请求验证账号
     */
    String USERNAME = "123456";

    /*
     * PHP服务器请求URL
     */
    String PHP_URL_IP_ORIGINAL = "http://218.17.107.90:6001/api/";
    String PHP_URL_INTERNAL = "http://10.128.25.102:6001/internal-services/";

    //    String PHP_URL_IP_BONUS = "http://218.17.107.90:6005/linktoouter.php/Bonus/";
    String PHP_URL_IP_BONUS = "http://10.128.25.102:6005/linktoouter.php/Bonus/";

    String PHP_URL_CREATE_BONUS_ORDER = PHP_URL_IP_BONUS + "createBonusOrder";
    String PHP_URL_CREATE_BONUS_TOTALBONUS = PHP_URL_IP_BONUS + "getTotalBonus";
    String PHP_URL_CREATE_BONUS_EXCHANGEBLELIST = PHP_URL_IP_BONUS + "getExchangeableList";
    String PHP_URL_CREATE_BONUS_ADDRESSLIST = PHP_URL_IP_BONUS + "getAddressList";
    String PHP_URL_CREATE_BONUS_ADDADDRESS = PHP_URL_IP_BONUS + "addAddress";
    String PHP_URL_CREATE_BONUS_EDITADDRESS = PHP_URL_IP_BONUS + "editAddress";
    String PHP_URL_CREATE_BONUS_DELADDRESS = PHP_URL_IP_BONUS + "delAddress";
    String PHP_URL_CREATE_BONUS_SETDEFAULTADDRESS = PHP_URL_IP_BONUS + "setDefaultAddress";
    String PHP_URL_CREATE_BONUS_GETDEALER = PHP_URL_IP_BONUS + "getDealer";
    String PHP_URL_CREATE_BONUS_DEFAULTADDRESS = PHP_URL_IP_BONUS + "getDefaultAddress";
    String PHP_URL_CREATE_BONUS_GETADDRESSTABLE = PHP_URL_IP_BONUS + "getLocationConf";
    String PHP_URL_CREATE_BONUS_GETORDERLIST = PHP_URL_IP_BONUS + "getorderlist";
    String PHP_URL_CREATE_BONUS_GETPOINTSPRODUCT_LIST = PHP_URL_IP_BONUS + "getProductListTwo";
    String PHP_URL_CREATE_BONUS_CONFIRMORDER = PHP_URL_IP_BONUS + "confirmOrder";
    String PHP_URL_CREATE_BONUS_MBCOMBINESN = PHP_URL_IP_BONUS + "mbCombineSn";

    String PHP_URL_DATATRANSFER = "http://ec2-52-82-11-145.cn-northwest-1.compute.amazonaws.com.cn:7001/api/data-transfer/index";
    String CUTOMER_INFO = "https://api.xhorse.net.cn/release/project/app-xhorse/pold/api/customer/get-customer-info";
    String PHP_URL_GETSMS = PHP_URL_IP_ORIGINAL + "service/sms-generator";
    String PHP_URL_NATIONCODE = PHP_URL_IP_ORIGINAL + "config/nationcode";
    String PHP_URL_VERIFYEMAIL = PHP_URL_IP_ORIGINAL + "service/sms-verification";
    String PHP_URL_UPLOAD_FEEDBACK = PHP_URL_INTERNAL + "product/remote/set-generate-count";
    String PHP_URL_BONUS_REWARD = PHP_URL_INTERNAL + "customer/bonus/reward ";

    //    String PHP_URL_GETREGION = "http://218.17.107.90:6005/linktoouter.php/AppSvr/getProductRegion";
    String PHP_URL_GETREGION = "http://10.128.25.102:6005/linktoouter.php/AppSvr/getProductRegion";

    /*
     * APP静态资源获取IP
     */
    String SERVER_IP = "https://api.xhorse.net.cn/release/project/app-xhorse/old";
    String IP = "https://s3.cn-northwest-1.amazonaws.com.cn/public-cn-northwest-1-1251058331/service/project/app-xhorse-java";
//    String IP_EN = "https://s3-ap-southeast-1.amazonaws.com/public-ap-southeast-1-1251058331/service/project/app-xhorse-java";
//    String SERVER_IP = "http://10.128.25.41:8080/ControlPannelWeb";
//    String SERVER_IP = "http://52.82.23.96:6060/ControlPannelWeb";
//    String IP = "https://s3.cn-northwest-1.amazonaws.com.cn/public-cn-northwest-1-1251058331/service/project/app-xhorse-java/test";
    String IP_EN = "https://s3.ap-southeast-1.amazonaws.com/public-ap-southeast-1-1251058331/service/project/app-xhorse-java/test";

    String VIN_SERVER_IP = "https://ali-vin.showapi.com/vin";
    String APP_CODE = "856a7052ef424530952a401699a53840";
}
