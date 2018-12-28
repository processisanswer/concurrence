package com.async;

import java.util.concurrent.LinkedBlockingDeque;

public class SaveProcessor implements Runnable, RequestProcessor {

    LinkedBlockingDeque<Request> requests = new LinkedBlockingDeque<>();

    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Request request = requests.take();
                System.out.println("begin save request info:" + request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
