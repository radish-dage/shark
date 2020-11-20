package com.shark.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shark.annotation.RequestUrlMapping;
import com.shark.common.HttpCode;
import com.shark.utils.HttpUtil;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TrainQueryAction {
//
//	https://kyfw.12306.cn/otn/leftTicketPrice/query?leftTicketDTO.train_date=2020-11-09&leftTicketDTO.from_station=BJP&leftTicketDTO.to_station=SHH&leftTicketDTO.ticket_type=1&randCode=6BRW

    private static String urlStr = "https://kyfw.12306.cn/otn/leftTicket/query";

    private static String trainDate = "leftTicketDTO.train_date=2020-11-19";

    private static String fromStation = "leftTicketDTO.from_station=CSQ";

    private static String toStation = "leftTicketDTO.to_station=MLQ";

    private static String purposeCodes = "purpose_codes=ADULT";

    public static void main(String[] args) {
        new TrainQueryAction().queryTrainInfo("2020-11-19", "CSQ", "MLQ", "ADULT");
    }

    @RequestUrlMapping(url="/query")
    public void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("my DispatcherServlet ok");
        response.getWriter().write("my DispatcherServlet ok");
    }

    /**
     * 查询车次信息
     * @param trainDate 要查询日期的车次
     * @param fromStation 出发站
     * @param toStation 目的站
     * @param purposeCodes 乘车目标
     * @return
     */
    @RequestUrlMapping(url="/queryTrain")
    public String queryTrainInfo(String trainDate, String fromStation,
                                        String toStation, String purposeCodes) {
        StringBuilder url = new StringBuilder("https://kyfw.12306.cn/otn/leftTicket/query?");
        url.append("leftTicketDTO.train_date="+ trainDate);
        url.append("&leftTicketDTO.from_station=" + fromStation);
        url.append("&leftTicketDTO.to_station=" + toStation);
        url.append("&purpose_codes=" + purposeCodes);

        Map<String, String> reqHeader = new HashMap<>();
        reqHeader.put("Cookie", "RAIL_DEVICEID=YES");

        try {

            HttpURLConnection httpURLConnection = HttpUtil.createHttpUrlConn(url.toString(), HttpCode.GET, reqHeader);

            httpURLConnection.disconnect();

            //3.输入流
            BufferedReader bReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String lineString;
            StringBuffer sb = new StringBuffer();
            while( (lineString = bReader.readLine()) != null) {
                sb.append(lineString);
            }

            try{
                JSONObject jb = JSON.parseObject(sb.toString());


                JSONObject data = (JSONObject) jb.get("data");
                JSONObject map = (JSONObject) data.get("map");
                JSONArray resultArray = data.getJSONArray("result");
                for (Object object : resultArray) {
                    String infoString = (String) object;
                    String[] infos = infoString.split("\\|");
                    if(infos.length == 47 && ("y").equalsIgnoreCase(infos[11])) {
                        System.out.println(infos[3]+","+map.getString(infos[6])+"-->"+map.getString(infos[7])+
                                ",发车时间---->到达时间："+infos[8]+"--("+infos[10]+")-->"+infos[9]+
                                ",商务座："+infos[32]+",特等座："+infos[25]+",一等座："+infos[31]+",二等座："+infos[30]+
                                ",高级软卧："+infos[21]+",软卧："+infos[23]+",动卧："+infos[33]+",硬卧："+infos[28]+",软座："+infos[24]+
                                ",硬座："+infos[29]+",无座："+infos[26]+",其它："+infos[22]);
                    }
                }

            } catch (Exception e){
                System.out.println("json解析错误，请检查响应回来的json");
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally{

        }





        return null;
    }

    /*public static String getURLContent() throws Exception {

        String urlPath = urlStr + "?" + trainDate + "&" + fromStation + "&" + toStation + "&" + purposeCodes;
        //System.out.println(urlPath);
        //1.网络url地址
        //Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1", 8888));
        URL url = new URL(urlPath);

        //2.http连接
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        //httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.183 Safari/537.36");
//		httpConnection.setRequestProperty("Cookie", "_uab_collina=160490440053822868080035; "
//				+ "JSESSIONID=EA8A7C4FE04614ACD12A97449483FE13; "
//				+ "RAIL_EXPIRATION=1605207855687; "
//				+ "RAIL_DEVICEID=FVCmlwruARgpoUE56vFn58xLUZY9uoLjT85BFDmysd8QOSBT9bX_C5TbmQZpjKaBZrAfHzxVi7oI8Y3j6JePo0RIZUhgchwrwqKMfGPf8awZGWJya7Ywwt2t1luG2QlZFCTniuDx1trWog1ULhWNZHddVJXLd0re; "
//				+ "_jc_save_wfdc_flag=dc; "
//				+ "_jc_save_fromStation=%u5E7F%u5DDE%2CGZQ; "
//				+ "_jc_save_toStation=%u957F%u6C99%2CCSQ; "
//				+ "BIGipServerpassport=971505930.50215.0000; "
//				+ "route=6f50b51faa11b987e576cdb301e545c4; "
//				+ "BIGipServerotn=2681667850.50210.0000; "
//				+ "_jc_save_toDate=2020-11-11; "
//				+ "_jc_save_fromDate=2020-11-11");

        //RAIL_DEVICEID值随便写
        httpConnection.setRequestProperty("Cookie", "RAIL_DEVICEID=YES");
        httpConnection.setRequestMethod("GET");

        httpConnection.connect();

        if(httpConnection.getResponseCode() == 200) {
            System.out.println("响应状态码200");
            System.out.println(httpConnection.getResponseMessage());

        }



        //3.输入流
        BufferedReader bReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
        String lineString;
        StringBuffer sb = new StringBuffer();
        while( (lineString = bReader.readLine()) != null) {
            sb.append(lineString);
        }

        try{
            JSONObject jb = JSON.parseObject(sb.toString());


            JSONObject data = (JSONObject) jb.get("data");
            JSONObject map = (JSONObject) data.get("map");
            //String resultString = data.getString("result");
            JSONArray resultArray = data.getJSONArray("result");
            for (Object object : resultArray) {
                String infoString = (String) object;
                String[] infos = infoString.split("\\|");
                if(infos.length == 47 && ("y").equalsIgnoreCase(infos[11])) {
                    System.out.println(infos[3]+","+map.getString(infos[6])+"-->"+map.getString(infos[7])+
                            ",发车时间---->到达时间："+infos[8]+"--("+infos[10]+")-->"+infos[9]+
                            ",商务座："+infos[32]+",特等座："+infos[25]+",一等座："+infos[31]+",二等座："+infos[30]+
                            ",高级软卧："+infos[21]+",软卧："+infos[23]+",动卧："+infos[33]+",硬卧："+infos[28]+",软座："+infos[24]+
                            ",硬座："+infos[29]+",无座："+infos[26]+",其它："+infos[22]);
                }
            }

        } catch (Exception e){
            System.out.println("json解析错误，请检查响应回来的json");
            e.printStackTrace();
        } finally {
            bReader.close();
            httpConnection.disconnect();
        }


        return null;
    }*/
}
