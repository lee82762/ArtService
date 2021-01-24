package com.project.restfulproject.Service.MovieService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service

public class MovieListService {


    String key="63c3d4c3e3724ea08877a2ef4d87e222";
    String stdate="20200318";
    String eddate="20200318";
    String cpage="1";
    String rows="10";

    String url="http://kopis.or.kr/openApi/restful/pblprfr?"+
            "service="+key+
            "&stdate="+stdate+
            "&eddate="+eddate+
            "&cpage="+cpage+
            "&rows="+rows;
    int num=2;


    public String movieList() throws IOException,ParseException {
        StringBuffer result=new StringBuffer();
        URL url1= new URL(url);
        System.out.println(url1);

        HttpURLConnection httpURLConnection=(HttpURLConnection) url1.openConnection();
        httpURLConnection.setRequestMethod("GET");
        BufferedReader br= new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String returnLine;
        while((returnLine=br.readLine())!=null){
            result.append(returnLine+"\n");
        }

        httpURLConnection.disconnect();
        String xmlresult=result+"";
        JSONObject jsObject= XML.toJSONObject(xmlresult);

        JSONArray re=jsObject.getJSONObject("dbs").getJSONArray("db");
        // String result3=re.getJSONObject(num).get("mt20id").toString();
        String []resultarr= new String[re.length()];
        String result3=re.getJSONObject(num).get("mt20id").toString();


        //mt20id를 뽑아오는 부분
      /*  for(int i=0; i<re.length(); i++){
            resultarr[i]=re.getJSONObject(i).get("mt20id").toString();
        }
        String result3="";
        for(int i=0; i<re.length(); i++){
            result3+=resultarr[i]+",";
        }
        result3=result3.substring(0,result3.length()-1);*/
        System.out.println(jsObject);






        return result3;
    }






}

