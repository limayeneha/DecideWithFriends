package com.limayeneha.decidewithfriends;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import static android.R.attr.priority;

/**
 * Created by limayeneha on 2/8/17.
 */
@Table(database = EventDatabase.class)
public class Event extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    public int id;

    @Column
    public String name;

    @Column
    public String venue;

    @Column
    public String date;

    @Column
    public String time;

    public Event() {

    }

    public Event(String name, String venue, String date, String time) {
        this.name = name;
        this.venue = venue;
        this.date = date;
        this.time = time;
    }

//    public Event(int id, int status) {
//        this.id = id;
//        this.status = status;
//    }
}
