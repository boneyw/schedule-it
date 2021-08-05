import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.annotation.Nullable;

import static org.xmlpull.v1.XmlPullParser.TEXT;

public class Event_db extends SQLiteOpenHelper {

    public static final String EVENT_TABLE = "EVENT_TABLE";
    public static final String EMAIL = "EMAIL";
    public static final String REPEAT ="REPEAT";
    public static final String EVENT_DATE ="EVENT_DATE";
    public static final String EVENT_TIME ="EVENT_TIME";
    public static final String EVENT_ID = "ID";
    public static final String EVENT_NOTES ="EVENT_NOTES";




    public Event_db (@Nullable Context context){
        super (context, "Event.db",  null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTableStatement = "CREATE TABLE " + EVENT_TABLE + " (" + EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EVENT_DATE + " TEXT, "
                + EVENT_TIME+ " TEXT," + EMAIL + " TEXT, " + REPEAT + " BOOL, " + EVENT_NOTES + "NOTES) ";

        db.execSQL(CreateTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
