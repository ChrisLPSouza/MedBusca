package br.com.fiap.medbusca.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_receitax")
data class ReceitaX (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var name : String = "",
    var medicine : String = "",
    var date : String = "",
    var dosage : String = "",
    @ColumnInfo(name="is_continous_use") var continuosUse : Boolean = false

)
