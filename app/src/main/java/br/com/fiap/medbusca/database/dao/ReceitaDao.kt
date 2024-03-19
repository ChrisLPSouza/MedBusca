package br.com.fiap.medbusca.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.medbusca.model.Receita
import br.com.fiap.medbusca.model.ReceitaX

@Dao
interface ReceitaDao {

    @Insert
    fun salvar(receita: ReceitaX): Long
    @Delete
    fun excluir(receita: ReceitaX): Int
    @Query("SELECT * FROM tb_receitax")
    fun listarReceitas(): List<ReceitaX>
}