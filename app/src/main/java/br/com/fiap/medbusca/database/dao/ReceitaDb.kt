package br.com.fiap.medbusca.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.medbusca.model.Receita

@Database(
    entities = [Receita::class],
    version = 1
)
abstract class ReceitaDb: RoomDatabase() {

    abstract fun receitaDao(): ReceitaDao

    companion object {

        private lateinit var instance: ReceitaDb

        fun getDatabase(context: Context): ReceitaDb{
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder( context, ReceitaDb::class.java, "receita_db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}