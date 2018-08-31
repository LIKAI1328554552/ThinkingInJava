package com.likai.chapter09;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by likai on 2018/08/28.
 */
public class Controller {
    private List<Event> eventList = new ArrayList<Event>() ;

    public void addEvent(Event event) {
        this.eventList.add(event) ;
    }

    public void run() {
        while (this.eventList.size() > 0) {
            for (Event event : new ArrayList<Event>(eventList)) {
                if(event.ready()) {
                    System.out.println(event);
                    //执行event
                    event.action();
                    //在列表中移除event
                    eventList.remove(event) ;
                }
            }
        }
    }

}
