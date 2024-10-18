package com.kripto.appmanager.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kripto.appmanager.database.MainDatabase
import com.kripto.appmanager.database.dao.AppwareDao
import com.kripto.appmanager.database.dao.AppwareDataSource
import com.kripto.appmanager.database.dao.AppwareTerminalDao
import com.kripto.appmanager.database.dao.AppwareTerminalDataSource
import com.kripto.appmanager.database.dao.ClientDao
import com.kripto.appmanager.database.dao.ClientDataSource
import com.kripto.appmanager.database.dao.StoreDao
import com.kripto.appmanager.database.dao.StoreDataSource
import com.kripto.appmanager.database.dao.TerminalDao
import com.kripto.appmanager.database.dao.TerminalDataSource
import com.kripto.appmanager.database.dao.TerminalStoreDao
import com.kripto.appmanager.database.dao.TerminalStoreDataSource
import com.kripto.appmanager.repository.AppwareRepositoryImpl
import com.kripto.appmanager.repository.AppwareTerminalRepositoryImpl
import com.kripto.appmanager.repository.ClientRepositoryImpl
import com.kripto.appmanager.repository.StoreRepositoryImpl
import com.kripto.appmanager.repository.TerminalRepositoryImpl
import com.kripto.appmanager.repository.TerminalStoreRepositoryImpl
import com.kripto.appmanager.respository.AppwareRepository
import com.kripto.appmanager.respository.AppwareTerminalRepository
import com.kripto.appmanager.respository.ClientRepository
import com.kripto.appmanager.respository.StoreRepository
import com.kripto.appmanager.respository.TerminalRepository
import com.kripto.appmanager.respository.TerminalStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.SQLException
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): MainDatabase {
        return Room.databaseBuilder(
            appContext,
            MainDatabase::class.java,
            "main_database"
        )
        //.fallbackToDestructiveMigration()
        .addCallback(object :RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                val scope = CoroutineScope(Dispatchers.IO)
                scope.launch {
                    prepopulationData(db)
                }

            }
        })
        .allowMainThreadQueries()
        .build()
    }


    @Singleton
    @Provides
    fun providesClientDao(db: MainDatabase): ClientDao {
        return db.clientDao()
    }

    @Singleton
    @Provides
    fun providesStoreDao(db: MainDatabase): StoreDao {
        return db.storeDao()
    }

    @Singleton
    @Provides
    fun providesTerminalDao(db: MainDatabase): TerminalDao {
        return db.terminalDao()
    }

    @Singleton
    @Provides
    fun providesAppwareDao(db: MainDatabase): AppwareDao {
        return db.appwareDao()
    }

    @Singleton
    @Provides
    fun providesAppwareTerminalDao(db: MainDatabase): AppwareTerminalDao {
        return db.appwareTerminalDao()
    }

    @Singleton
    @Provides
    fun providesTerminalStoreDao(db: MainDatabase): TerminalStoreDao {
        return db.terminalStoreDao()
    }

    @Singleton
    @Provides
    fun provideClientDataSource(dao: ClientDao): ClientDataSource {
        return ClientDataSource(dao)
    }

    @Singleton
    @Provides
    fun provideStoreDataSource(dao: StoreDao): StoreDataSource {
        return StoreDataSource(dao)
    }

    @Singleton
    @Provides
    fun provideTerminalDataSource(dao: TerminalDao): TerminalDataSource {
        return TerminalDataSource(dao)
    }

    @Singleton
    @Provides
    fun provideAppwareDataSource(dao: AppwareDao): AppwareDataSource {
        return AppwareDataSource(dao)
    }

    @Singleton
    @Provides
    fun provideAppwareTerminalDataSource(dao: AppwareTerminalDao): AppwareTerminalDataSource {
        return AppwareTerminalDataSource(dao)
    }
    @Singleton
    @Provides
    fun provideTerminalStoreDataSource(dao: TerminalStoreDao): TerminalStoreDataSource {
        return TerminalStoreDataSource(dao)
    }



    @Singleton
    @Provides
    fun clientRepository(clientDataSource: ClientDataSource): ClientRepository {
        return ClientRepositoryImpl(clientDataSource)
    }

    @Singleton
    @Provides
    fun storeRepository(storeDataSource: StoreDataSource): StoreRepository {
        return StoreRepositoryImpl(storeDataSource)
    }

    @Singleton
    @Provides
    fun terminalRepository(terminalDataSource: TerminalDataSource):TerminalRepository {
        return TerminalRepositoryImpl(terminalDataSource)
    }

    @Singleton
    @Provides
    fun appwareRepository(appwareDataSource: AppwareDataSource): AppwareRepository {
        return AppwareRepositoryImpl(appwareDataSource)
    }

    @Singleton
    @Provides
    fun appwareTerminalRepository(
        appwareTerminalDataSource: AppwareTerminalDataSource
    ): AppwareTerminalRepository {
        return AppwareTerminalRepositoryImpl(appwareTerminalDataSource)
    }

    @Singleton
    @Provides
    fun terminalStoreRepository(
        terminalStoreDataSource: TerminalStoreDataSource
    ): TerminalStoreRepository {
        return TerminalStoreRepositoryImpl(terminalStoreDataSource)
    }








    fun prepopulationData(db: SupportSQLiteDatabase){
        if(db.isOpen){
            db.beginTransaction()
            val query1="""
             INSERT INTO appware ("name","version","versionname","averagedataflow") VALUES ('zeus app',1,'1.0.0',102400),
             ('hera app',1,'1.0.0',92400),
             ('ares app',1,'1.0.0',102400),
             ('hefesto app',1,'1.0.0',82400),
             ('artemisa app',1,'1.0.0',102400),
             ('apolo app',1,'1.0.0',92400),
             ('zeus app',2,'2.0.0',52400),
             ('hera app',2,'2.0.0',202400),
             ('ares app',2,'2.0.0',22400),
             ('hefesto app',2,'2.0.0',72400),
             ('artemisa app',2,'2.0.0',22400),
             ('zeus app',3,'3.0.0',12400),
             ('ares app',3,'3.0.0',52400),
             ('artemisa app',3,'3.0.0',42400);
             """.trimIndent()
            val query2="""
            INSERT INTO terminal ("name","connectivity") VALUES ('T000WG-A001',3),
             ('T000WG-A002',3),
             ('T000WG-A003',3),
             ('T000WG-A004',3),
             ('T0000G-A005',1),
             ('T0000G-A006',1),
             ('T0000G-A007',1),
             ('T0000W-A008',2),
             ('T0000W-A009',2),
             ('T0000G-A010',1);
             """.trimIndent()
            val query3="""INSERT INTO store ("name","employequantity","connectivity","clientid") VALUES ('norte',3,3,1),
             ('este',2,1,1),
             ('oeste',4,2,1),
             ('sur',5,3,1);
             """.trimIndent()
            val query4="""INSERT INTO client ("name","maxemployebystore") VALUES ('javier ',5),
             ('Leonardo',4),
             ('Donatelo',4),
             ('Rafael',4),
             ('miguelangel',4);
             """.trimIndent()
            val query5="""INSERT INTO appware_terminal ("appwareid","terminalid") VALUES (1,1),
             (7,3),
             (9,6),
             (5,8),
             (14,10);
             """.trimIndent()
            val query6="""INSERT INTO terminal_store ("storeid","terminalid") VALUES (1,1),
             (1,10),
             (2,3),
             (3,6),
             (4,8);
             """.trimIndent()

            try {
                db.execSQL(query1)
                db.execSQL(query2)
                db.execSQL(query3)
                db.execSQL(query4)
                db.execSQL(query5)
                db.execSQL(query6)
                db.setTransactionSuccessful()
            }catch  (e:SQLException){
                Log.e("jqg","ex ${e.message}")
            }
            db.endTransaction()
        }

    }
}