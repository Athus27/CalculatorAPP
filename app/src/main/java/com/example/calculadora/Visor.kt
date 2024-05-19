package com.example.calculadora

import android.annotation.SuppressLint
import android.widget.TextView
import org.mariuszgromada.math.mxparser.Expression
import org.mariuszgromada.math.mxparser.mXparser

@SuppressLint("StaticFieldLeak")
object Visor {
    lateinit var historicoVisor: TextView
    lateinit var calculoVisor: TextView
    lateinit var resultadoVisor: TextView
    lateinit var modoDeExibicaoVisor: TextView

    val historicoLista = mutableListOf<String>()
    var modoDeExibicao: Boolean = true



    fun estaVazio(visor: TextView): Boolean{
        return (visor.text.isEmpty()|| visor.text.isNullOrBlank())
    }

    fun limpaVisor(visor: TextView){
        visor.text = ""
    }

    fun limpaTodosVisores() {
        limpaVisor(calculoVisor)
        limpaVisor(historicoVisor)
        limpaVisor(resultadoVisor)
    }

    fun limpaHistorico(){
        historicoLista.clear()
    }

    fun valorIntOuFloat(expressao: String): String {
        val num = Expression(expressao.toString()).calculate()
        return if (num.rem(1.0) == 0.0) {
            num.toInt().toString()
        } else if (num.isNaN()) {
            return "Operação Inválida"
        }else
            return num.toString()
    }

    fun adicionaNoHistorico(
        calculo: String,
        historicoLista: MutableList<String>,
    ) {
        historicoLista.add(calculo)
        historicoVisor.text = (historicoLista.last()).toString()
        limpaVisor(calculoVisor)
    }

    fun mudaModoDeExibicao() {
        when (modoDeExibicao) {
            false -> {
                modoDeExibicaoVisor.text = "π"
                mXparser.setRadiansMode()
            }

            true -> {
                modoDeExibicaoVisor.text = "o"
                mXparser.setDegreesMode()
            }


        }
//        limpaVisor(resultadoVisor)
    }

    fun tratamentoSeResultadoInvalido() {
        if (resultadoVisor.text.toString().compareTo("Operação Inválida")==0)
            limpaVisor(resultadoVisor)
    }

}

