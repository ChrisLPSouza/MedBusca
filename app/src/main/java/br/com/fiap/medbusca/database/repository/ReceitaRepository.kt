package br.com.fiap.medbusca.database.repository

import android.content.Context
import br.com.fiap.medbusca.database.dao.ReceitaDb
import br.com.fiap.medbusca.model.Receita
import br.com.fiap.medbusca.model.ReceitaX

class ReceitaRepository(context: Context) {

    private val db = ReceitaDb.getDatabase(context).receitaDao()

    fun salvar(receita: ReceitaX): Long{
        return db.salvar(receita = receita)
    }

    fun excluir(receita: ReceitaX): Int {
        return db.excluir(receita = receita)
    }

    fun listarReceitas(): List<ReceitaX>{
        return db.listarReceitas()
    }

}