package bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class bdAgenda extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="bdAgenda.cdb";

    private String idql ="create table if not exists contatos " +
            "( id interer primary key autoincrement,"+
            "nome varchar(40), "+
            "email varchar(100),"+
            "celular varchar(14),"+
            "pass varchar(255));";


    public bdAgenda(Context contexto){
        super(contexto,DATABASE_NAME,null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase cbd){
        cbd.execSQL(idql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase cbd,int oldversion, int newversion ){

    }
}


