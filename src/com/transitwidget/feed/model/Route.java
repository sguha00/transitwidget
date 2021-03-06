package com.transitwidget.feed.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

import com.transitwidget.provider.TransitServiceDataProvider;

public class Route {
	public static final String LOGTAG = Route.class.getName();
	
	public static final String TABLE_NAME = "routes";
	
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/transitwidget.service.route";
    public static final String CONTENT_TYPE_ITEM = "vnd.android.cursor.item/transitwidget.service.route";
    
    public static final Uri CONTENT_URI = Uri.parse("content://" + TransitServiceDataProvider.AUTHORITY + "/" + TABLE_NAME);

	public static final String _ID = BaseColumns._ID;
	public static final String TITLE = "title";
	public static final String TAG = "tag";
	public static final String AGENCY = "agency";
	
	public Route() {}
	
	public Route(Cursor cursor) {
		this.id = cursor.getInt(cursor.getColumnIndex(_ID));
		this.tag = cursor.getString(cursor.getColumnIndex(TAG));
		this.title = cursor.getString(cursor.getColumnIndex(TITLE));
		this.agency = cursor.getString(cursor.getColumnIndex(AGENCY));
	}

	public ContentValues getContentValues() {
		ContentValues values = new ContentValues();
		values.put(TAG, tag);
		values.put(TITLE, title);
		values.put(AGENCY, agency);
		return values;
	}
	
	private int id;
	private String tag;
	private String title;
	private String agency;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@Override
	public String toString() {
		return "ROUTE (tag: " + tag + ", title: " + title + ")";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    /**
     * Creates the underlying database.
     */
    public static void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE " + Route.TABLE_NAME + " ( " 
				   + Route._ID + " INTEGER PRIMARY KEY, "
				   + Route.TAG + " TEXT, "
				   + Route.TITLE + " TEXT, "
				   + Route.AGENCY + " TEXT"
			   + " );";

		Log.w(LOGTAG, "Creating service data route table with sql " + sql);
		db.execSQL(sql);
    }

    /**
     * Upgrade the database tables.
     */
    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Nothing to do here (yet)
    }

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}
}
