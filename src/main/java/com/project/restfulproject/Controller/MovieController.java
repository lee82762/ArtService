package com.project.restfulproject.Controller;

import com.project.restfulproject.Service.MovieService.MovieListService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private static MovieListService movieListService;
    String key="63c3d4c3e3724ea08877a2ef4d87e222";


    @RequestMapping(value = "/movieLocationList",method = {RequestMethod.GET})
    public String movielocationList() throws IOException, ParseException {
        StringBuffer result=new StringBuffer();
        String cpage="1";
        String rows="5";
        String shprfnmfct="예술의전당";
        String url="http://kopis.or.kr/openApi/restful/prfplc?"+
                "service="+key+
                "&cpage="+cpage+
                "&rows="+rows+
                "&shprfnmfct="+shprfnmfct;

        URL url1= new URL(url);
        System.out.println(url);

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
        System.out.println(jsObject);
        String resultList=jsObject.toString();
        JSONArray re=jsObject.getJSONObject("dbs").getJSONArray("db");
        String result3=re.getJSONObject(1).get("mt10id").toString();

        return resultList;
    }

    }

