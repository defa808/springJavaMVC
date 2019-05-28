package com.kpi.testtask2.proxy;

public class ProxyFactory {

    public static Object newInstance(String classEntity) {
        switch(classEntity){
            case "Present": return new PresentServiceProxy();
            default:
                return new PresentServiceProxy();
        }
    }
}
