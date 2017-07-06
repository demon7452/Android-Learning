package com.lixiong.googletraining.database.common;

import android.provider.BaseColumns;

/**
 * Created by nali on 03/07/2017.
 */

public final class UserContract {

    private UserContract(){
    }

    public static class UserEntry implements BaseColumns{
        public static final String TABLE_NAME = "USER";

        public static final String NAME = "NAME";
        public static final String AGE = "AGE";
        public static final String PHONE = "PHONE";
        public static final String NATIVE_LANGUAGE = "NATIVE_LANGUAGE";
    }
}
