package service.impl;


import service.WeatherInterface;

import javax.jws.WebService;

@WebService
public class WeatherInterfaceImpl implements WeatherInterface {
    @Override
    public String queryWeather(String cityName) {
        System.out.println("获取程序名" + cityName);
        String weather = "暴雨";
        return weather;
    }
}
