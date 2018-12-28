package com.async;

import java.util.concurrent.LinkedBlockingDeque;

public class PrintProcessor extends Thread implements  RequestProcessor {
    //阻塞队列
    LinkedBlockingDeque<Request> requests=
            new LinkedBlockingDeque<>();
    private final RequestProcessor nextProcessor;

    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    //处理请求
    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }
    //重写run()
    @Override
    public void run(){
        while(true){
            try {
                Request request=requests.take();
                System.out.println("print data:"+request.getName());
                nextProcessor.processRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
