package com.async;

public class Main {
    PrintProcessor printProcessor;
    //初始化
    protected Main(){
        SaveProcessor saveProcessor=new SaveProcessor();
        new Thread(saveProcessor).start();
        printProcessor=new PrintProcessor(saveProcessor);
        printProcessor.start();
    }
    //模拟请求
    private void doTest(Request request){
        printProcessor.processRequest(request);
    }

    public static void main(String[] args) {
        Request request=new Request();
        request.setName("zheng");
        new Main().doTest(request);
    }
}
