package info.sergeikolinichenko.cryptorates.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import info.sergeikolinichenko.cryptorates.data.model.CryptoNameDto

/** Created by Sergei Kolinichenko on 02.11.2022 at 17:04 (GMT+3) **/

@Database(entities = [CryptoNameDto::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    companion object {

        private var db: AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    ).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun cryptoInfoDao(): CryptoInfoDao
}