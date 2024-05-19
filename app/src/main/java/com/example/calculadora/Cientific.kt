package com.example.calculadora

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.databinding.ActivityCientific2Binding


class Cientific : AppCompatActivity() {
    private lateinit var binding: ActivityCientific2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCientific2Binding.inflate(layoutInflater)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Visor.modoDeExibicaoVisor = binding.modoText


        binding.e.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor)) {
                Visor.tratamentoSeResultadoInvalido()
                Visor.calculoVisor.text = "(${Visor.resultadoVisor.text})e"
            } else {
                Visor.limpaVisor(Visor.resultadoVisor)
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}e"
            }
        }

        binding.raiz.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor)) {
                Visor.tratamentoSeResultadoInvalido()
                Visor.calculoVisor.text = "√(${Visor.resultadoVisor.text}"
            }
            else{
                Visor.limpaVisor(Visor.resultadoVisor)
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}√"
            }
        }

        binding.fatorial.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor)) {
                Visor.tratamentoSeResultadoInvalido()
                Visor.calculoVisor.text = "(${Visor.resultadoVisor.text})!"
            } else {
                Visor.limpaVisor(Visor.resultadoVisor)
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}!"
            }
        }

        binding.potencia.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor)) {
                Visor.tratamentoSeResultadoInvalido()
                Visor.calculoVisor.text = "(${Visor.resultadoVisor.text})^"
            } else {
                Visor.limpaVisor(Visor.resultadoVisor)
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}^"
            }
        }



        binding.normal.setOnClickListener {
            mudaParaNormal()
        }

        binding.ce.setOnClickListener {
            Visor.limpaTodosVisores()
            Visor.limpaHistorico()
        }

        binding.mudarModo.setOnClickListener {
            Visor.modoDeExibicao = !(Visor.modoDeExibicao)
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.mudaModoDeExibicao()


        }

        binding.parenteseAberto.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor)) {
                Visor.calculoVisor.text = "${Visor.resultadoVisor.text}("
            } else {
                Visor.limpaVisor(Visor.resultadoVisor)
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}("
            }
        }
        binding.parenteseFechado.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = "${Visor.calculoVisor.text})"
        }

        binding.sen.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor) == true) {
                Visor.tratamentoSeResultadoInvalido()
                Visor.calculoVisor.text = "sin("
            } else
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}sin("
        }

        binding.cos.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor) == true) {
                Visor.tratamentoSeResultadoInvalido()
                Visor.calculoVisor.text = "cos("
            } else
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}cos("
        }

        binding.tang.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor) == true) {
                Visor.tratamentoSeResultadoInvalido()
                Visor.calculoVisor.text = "tan("
            } else
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}tan("
        }

        binding.percentual.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor)) {
                Visor.tratamentoSeResultadoInvalido()
                Visor.calculoVisor.text = "${Visor.resultadoVisor.text}%*"
            } else {
                Visor.limpaVisor(Visor.resultadoVisor)
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}%*"
            }
        }

        binding.divisao.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor)) {
                Visor.tratamentoSeResultadoInvalido()
                Visor.calculoVisor.text = "${Visor.resultadoVisor.text}/"
            } else {
                Visor.limpaVisor(Visor.resultadoVisor)
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}/"
            }
        }


        binding.um.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = "${Visor.calculoVisor.text}1"
        }
        binding.dois.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = "${Visor.calculoVisor.text}2"
        }
        binding.tres.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = "${Visor.calculoVisor.text}3"
        }
        binding.quatro.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = "${Visor.calculoVisor.text}4"
        }
        binding.cinco.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = "${Visor.calculoVisor.text}5"
        }
        binding.seis.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = "${Visor.calculoVisor.text}6"

        }
        binding.sete.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = "${Visor.calculoVisor.text}7"
        }
        binding.oito.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = "${Visor.calculoVisor.text}8"
        }
        binding.nove.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = "${Visor.calculoVisor.text}9"
        }
        binding.zero.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = "${Visor.calculoVisor.text}0"
        }

        binding.multiplicacao.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor)) {
                Visor.tratamentoSeResultadoInvalido()
                Visor.calculoVisor.text = "${Visor.resultadoVisor.text}*"
            } else {
                Visor.limpaVisor(Visor.resultadoVisor)
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}*"
            }
        }
        binding.subtracao.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor)) {
                Visor.tratamentoSeResultadoInvalido()
                Visor.calculoVisor.text = "${Visor.resultadoVisor.text}-"
            } else {
                Visor.limpaVisor(Visor.resultadoVisor)
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}-"
            }
        }
        binding.soma.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor)) {
                Visor.tratamentoSeResultadoInvalido()
                Visor.calculoVisor.text = "${Visor.resultadoVisor.text}+"
            } else {
                Visor.limpaVisor(Visor.resultadoVisor)
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}+"
            }
        }
        binding.ponto.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = "${Visor.calculoVisor.text}."
        }

        binding.delete.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = Visor.calculoVisor.text.dropLast(1)
        }
        binding.ce.setOnClickListener {
            Visor.limpaTodosVisores()
            Visor.limpaHistorico()
        }
        binding.historicoVisor.setOnClickListener {
            if (Visor.historicoLista.isNotEmpty()) {
                val calculo: String = Visor.historicoLista.last()
                val resultadoValor = Visor.valorIntOuFloat(calculo)
                Visor.historicoLista.removeAt(Visor.historicoLista.size - 1)
                Visor.calculoVisor.text = calculo
                if (Visor.historicoLista.isNotEmpty()) {
                    Visor.resultadoVisor.text = resultadoValor
                    Visor.historicoVisor.text = Visor.historicoLista.last()
                } else {
                    Visor.limpaVisor(Visor.resultadoVisor)
                    Visor.limpaVisor(Visor.historicoVisor)
                    Visor.resultadoVisor.text = resultadoValor

                }

            } else {
                Visor.limpaTodosVisores()
            }
        }

        binding.igual.setOnClickListener {
            val resultadoString = Visor.valorIntOuFloat(Visor.calculoVisor.text.toString())
            Visor.resultadoVisor.text = resultadoString


//            MODIFICAR ESSA FUNÇÃO
            Visor.adicionaNoHistorico(
                Visor.calculoVisor.text.toString(),
                Visor.historicoLista
            )
        }

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }

    override fun onResume() {
        super.onResume()


        binding.resultadoText.text = Visor.resultadoVisor.text.toString()
        binding.historicoVisor.text = Visor.historicoVisor.text.toString()
        binding.calculoVisor.text = Visor.calculoVisor.text.toString()

        Visor.historicoVisor = binding.historicoVisor
        Visor.calculoVisor = binding.calculoVisor
        Visor.resultadoVisor = binding.resultadoText


        Visor.mudaModoDeExibicao()
    }

    fun mudaParaNormal() {
        val normalTela = Intent(this, MainActivity::class.java)
        normalTela.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(normalTela)
    }


}