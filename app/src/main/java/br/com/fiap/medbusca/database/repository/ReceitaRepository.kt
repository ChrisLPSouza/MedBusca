package br.com.fiap.medbusca.database.repository

import android.content.Context
import br.com.fiap.medbusca.database.dao.ReceitaDb
import br.com.fiap.medbusca.model.Receita

class ReceitaRepository(context: Context) {

    var db = ReceitaDb.getDatabase(context).receitaDao()

    fun salvar(receita: Receita): Long{
        return db.salvar(receita = receita)
    }

    fun excluir(receita: Receita): Int {
        return db.excluir(receita = receita)
    }

    fun listarReceitas(): List<Receita>{
        return db.listarReceitas()
    }

}