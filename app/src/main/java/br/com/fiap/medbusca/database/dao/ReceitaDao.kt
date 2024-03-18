package br.com.fiap.medbusca.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.medbusca.model.Receita

@Dao
interface ReceitaDao {

    @Insert
    fun salvar(receita: Receita): Long
    @Delete
    fun excluir(receita: Receita): Int
    @Query("SELECT * FROM tb_receita")
    fun listarReceitas(): List<Receita>
}