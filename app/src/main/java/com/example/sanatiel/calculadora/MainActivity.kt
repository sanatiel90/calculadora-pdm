package com.example.sanatiel.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.example.sanatiel.calculadora.extensions.onClick
import com.example.sanatiel.calculadora.extensions.toast
import kotlinx.android.synthetic.main.activity_main.*

//import kotlinx.android.synthetic.main.activity_main.* //BUG

class MainActivity : AppCompatActivity() {

    var operador = ""
    var numero:Int = 0
    var numeroAtual:Int = 0
    var numeroNovo:Int = 0
    var resultado:Boolean = false
    var strCalculo = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //usando Extension para evento de click dos botoes, para nao ter q usar findViewById para cada um
        onClick(R.id.bt1) {
            botaoDigito(getString(R.string.bt1))
        }

        onClick(R.id.bt2) {
            botaoDigito(getString(R.string.bt2))
        }

        onClick(R.id.bt3) {
            botaoDigito(getString(R.string.bt3))
        }

        onClick(R.id.bt4) {
            botaoDigito(getString(R.string.bt4))
        }

        onClick(R.id.bt5) {
            botaoDigito(getString(R.string.bt5))
        }

        onClick(R.id.bt6) {
            botaoDigito(getString(R.string.bt6))
        }

        onClick(R.id.bt7) {
            botaoDigito(getString(R.string.bt7))
        }

        onClick(R.id.bt8) {
            botaoDigito(getString(R.string.bt8))
        }

        onClick(R.id.bt9) {
            botaoDigito(getString(R.string.bt9))
        }

        onClick(R.id.bt0) {
            botaoDigito(getString(R.string.bt0))
        }

        onClick(R.id.btSoma) {
            botaoOperacao(getString(R.string.btSoma))
        }

        onClick(R.id.btMult) {
            botaoOperacao(getString(R.string.btMult))
        }

        onClick(R.id.btSub) {
            botaoOperacao(getString(R.string.btSub))
        }

        onClick(R.id.btDiv){
            botaoOperacao(getString(R.string.btDiv))
        }

        onClick(R.id.btAux) {
            botaoAux()
        }

        onClick(R.id.btClear) {
            botaoClear()
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.mnAbout){
            toast("Desenvolvido por Sanatiel Barros")
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //atribui o numero digitado à lista que vai pra operacao e ao txtView de calculo, usando as func atribuiNumero e atualizaTxtCalculo
    fun botaoDigito(digito: String){
        val edTxt = findViewById<EditText>(R.id.editText)
        val txtCalc = findViewById<TextView>(R.id.txtCalculo)
        edTxt.setText(atribuiNumero(edTxt.text.toString(), digito))  //informa o num atual do edit text mais o numero 1
        strCalculo = atualizaTxtCalculo(strCalculo,"",digito)
        txtCalc.setText(strCalculo)
    }

    //faz o calculo da operacao informada
    fun botaoOperacao(operacao: String){
        val edTxt = findViewById<EditText>(R.id.editText)
        val txtCalc = findViewById<TextView>(R.id.txtCalculo)
        try {
            if (resultado == false){
                numeroAtual = calculaOperacao(operador,numeroAtual,Integer.parseInt(edTxt.text.toString()))
            }else{
                resultado = false;
            }
            operador = operacao
            edTxt.setText("")

            strCalculo = atualizaTxtCalculo(strCalculo," ",getString(R.string.btSoma))
            txtCalc.setText(strCalculo)
        }catch (ex: NumberFormatException){
            toast("Operação inválida")
            btClear.callOnClick()
        }
    }

    //botao =
    fun botaoAux(){
        val edTxt = findViewById<EditText>(R.id.editText)
        val txtCalc = findViewById<TextView>(R.id.txtCalculo)
        try {
            numeroAtual = calculaOperacao(operador,numeroAtual,Integer.parseInt(edTxt.text.toString()))
            edTxt.setText(numeroAtual.toString())
            resultado = true

            strCalculo = atualizaTxtCalculo(strCalculo," ",getString(R.string.btAux))
            txtCalc.setText(strCalculo)
            strCalculo = atualizaTxtCalculo(strCalculo,"",numeroAtual.toString())
            txtCalc.setText(strCalculo)

        }catch (ex: NumberFormatException){
            toast("Operação inválida")
            btClear.callOnClick()
        }
        operador = ""
    }

    //botao CE
    fun botaoClear(){
        val edTxt = findViewById<EditText>(R.id.editText)
        val txtCalc = findViewById<TextView>(R.id.txtCalculo)
        operador = ""
        edTxt.setText("")
        numeroAtual = 0
        resultado = false
        strCalculo = ""
        txtCalc.setText(strCalculo)
    }


    //calcula a operacao dos numeros informados com base no sinal fornecido
    fun calculaOperacao(op:String, numAtual:Int, numNovo:Int):Int{
        var result:Int = 0
        when(op){
            "+" -> result = numAtual + numNovo
            "-" -> result = numAtual - numNovo
            "/" -> result = numAtual / numNovo
            "*" -> result = numAtual * numNovo
            "" -> result = numNovo
        }
       return result
    }



    fun atribuiNumero(editAtual:String, num: String):String{
        if (editAtual != null){
            return editAtual + num
        }else{
            return num
        }
    }


    fun atualizaTxtCalculo(valorAtual:String,espaco:String? = "",  valorNovo:String):String{
        if (valorAtual != null) return valorAtual + espaco + valorNovo + espaco else return valorNovo
    }

    }





