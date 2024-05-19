package com.example.calculadora

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        Visor.historicoVisor = binding.historico
        Visor.calculoVisor = binding.calculo
        Visor.resultadoVisor = binding.resultado1


        binding.cientifica.setOnClickListener {
            mudaParaCientifica()

        }


        binding.percentual.setOnClickListener {

            if (Visor.estaVazio(Visor.calculoVisor)) {
                Visor.tratamentoSeResultadoInvalido()
                    Visor.calculoVisor.text = "${Visor.resultadoVisor.text}%*"
            } else {
                Visor.limpaVisor(Visor.resultadoVisor)
                Visor.calculoVisor.text = "${Visor.resultadoVisor.text}%*"
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
        binding.parenteseAberto.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor)) {
                Visor.tratamentoSeResultadoInvalido()
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
        binding.divisao.setOnClickListener {
            if (Visor.estaVazio(Visor.calculoVisor)) {
                Visor.tratamentoSeResultadoInvalido()
                Visor.calculoVisor.text = "${Visor.resultadoVisor.text}/"
            } else {
                Visor.limpaVisor(Visor.resultadoVisor)
                Visor.calculoVisor.text = "${Visor.calculoVisor.text}/"
            }
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

        binding.excluir.setOnClickListener {
            Visor.limpaVisor(Visor.resultadoVisor)
            Visor.calculoVisor.text = Visor.calculoVisor.text.dropLast(1)
        }
        binding.ce.setOnClickListener {
            Visor.limpaTodosVisores()
            Visor.limpaHistorico()
        }
        binding.historico.setOnClickListener {
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
            val valorExpressao = Expression(Visor.calculoVisor.text.toString()).calculate()
            val resultadoString = Visor.valorIntOuFloat (Visor.calculoVisor.text.toString())

            if (valorExpressao.isNaN()){
                Visor.resultadoVisor.text = "0"
            }
            binding.resultado1.text = resultadoString

            Visor.adicionaNoHistorico(
                Visor.calculoVisor.text.toString(),
                Visor.historicoLista
            )
        }
    }

    override fun onResume() {
        super.onResume()

        binding.historico.text = Visor.historicoVisor.text
        binding.calculo.text = Visor.calculoVisor.text
        binding.resultado1.text = Visor.resultadoVisor.text
        Visor.historicoVisor = binding.historico
        Visor.calculoVisor = binding.calculo
        Visor.resultadoVisor = binding.resultado1
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

    }

    fun mudaParaCientifica() {
        val cientificaTela = Intent(this, Cientific::class.java)
        startActivity(cientificaTela)
    }

}

