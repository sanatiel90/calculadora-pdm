package com.example.sanatiel.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
//import kotlinx.android.synthetic.main.activity_main.* //BUG

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var operador = ""
        var numero:Int = 0
        var numeroAtual:Int = 0
        var numeroNovo:Int = 0
        var resultado:Boolean = false

       /* findViewById<Button>(R.id.bt9).setOnClickListener { show() }
        bt8.setOnClickListener { Toast.makeText(this,"ocho",Toast.LENGTH_LONG).show() }
         Toast.makeText(this,"nUM 9",Toast.LENGTH_LONG).show()
        */

        val bt1 = findViewById<Button>(R.id.bt1)
        val bt2 = findViewById<Button>(R.id.bt2)
        val bt3 = findViewById<Button>(R.id.bt3)
        val bt4 = findViewById<Button>(R.id.bt4)
        val bt5 = findViewById<Button>(R.id.bt5)
        val bt6 = findViewById<Button>(R.id.bt6)
        val bt7 = findViewById<Button>(R.id.bt7)
        val bt8 = findViewById<Button>(R.id.bt8)
        val bt9 = findViewById<Button>(R.id.bt9)
        val bt0 = findViewById<Button>(R.id.bt0)
        val btSoma = findViewById<Button>(R.id.btSoma)
        val btMult = findViewById<Button>(R.id.btMult)
        val btDiv = findViewById<Button>(R.id.btDiv)
        val btSub = findViewById<Button>(R.id.btSub)
        val btClear = findViewById<Button>(R.id.btClear)
        val btAux = findViewById<Button>(R.id.btAux)
        val edTxt = findViewById<EditText>(R.id.editText)

        bt1.setOnClickListener {
            edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt1)))  //informa o num atual do edit text mais o numero 1
        }

        bt2.setOnClickListener {
            edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt2)))
        }


        bt3.setOnClickListener {
             edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt3)))
        }

        bt4.setOnClickListener {
            edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt4)))
        }

        bt5.setOnClickListener {
               edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt5)))
        }

        bt6.setOnClickListener {
               edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt6)))
        }

        bt7.setOnClickListener {
              edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt7)))
        }

        bt8.setOnClickListener {
               edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt8)))
        }

        bt9.setOnClickListener {
             edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt9)))
        }

        bt0.setOnClickListener {
              edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt0)))
        }

        btSoma.setOnClickListener {
            try {
                if (resultado == false){
                    numeroAtual = calculaOperacao(operador,numeroAtual,Integer.parseInt(edTxt.text.toString()))
                }else{
                    resultado = false;
                }
                operador = "+"
                edTxt.setText("")
            }catch (ex: NumberFormatException){
                Toast.makeText(this,"Operação inválida",Toast.LENGTH_SHORT).show()
                btClear.callOnClick()
            }


        }

        btMult.setOnClickListener {
            try {
                if (resultado == false){
                    numeroAtual = calculaOperacao(operador,numeroAtual,Integer.parseInt(edTxt.text.toString()))
                }else{
                    resultado = false;
                }
                operador = "*"
                edTxt.setText("")
            }catch (ex: NumberFormatException){
                Toast.makeText(this,"Operação inválida",Toast.LENGTH_SHORT).show()
                btClear.callOnClick()
            }


        }

        btSub.setOnClickListener {
            try {
                if (resultado == false){
                    numeroAtual = calculaOperacao(operador,numeroAtual,Integer.parseInt(edTxt.text.toString()))
                }else{
                    resultado = false;
                }
                operador = "-"
                edTxt.setText("")
            }catch (ex: NumberFormatException){
                Toast.makeText(this,"Operação inválida",Toast.LENGTH_SHORT).show()
                btClear.callOnClick()
            }


        }

        btDiv.setOnClickListener {
            try {
                if (resultado == false){
                    numeroAtual = calculaOperacao(operador,numeroAtual,Integer.parseInt(edTxt.text.toString()))
                }else{
                    resultado = false;
                }
                operador = "/"
                edTxt.setText("")
            }catch (ex: NumberFormatException){
                Toast.makeText(this,"Operação inválida",Toast.LENGTH_SHORT).show()
                btClear.callOnClick()
            }


        }

        btAux.setOnClickListener {

           try {
             numeroAtual = calculaOperacao(operador,numeroAtual,Integer.parseInt(edTxt.text.toString()))
             edTxt.setText(numeroAtual.toString())
             resultado = true
           }catch (ex: NumberFormatException){
                Toast.makeText(this,"Operação inválida",Toast.LENGTH_SHORT).show()
                btClear.callOnClick()
           }
            operador = ""

        }

        btClear.setOnClickListener {
            operador = ""
            edTxt.setText("")
            numeroAtual = 0
            resultado = false
        }

    }


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


    }





