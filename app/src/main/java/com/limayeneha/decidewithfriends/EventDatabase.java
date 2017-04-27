package com.limayeneha.decidewithfriends;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by limayeneha on 2/22/17.
 */
@Database(name = EventDatabase.NAME, version = EventDatabase.VERSION)
public class EventDatabase {

    public static final String NAME = "EventDatabase";

    public static final int VERSION = 1;
}
