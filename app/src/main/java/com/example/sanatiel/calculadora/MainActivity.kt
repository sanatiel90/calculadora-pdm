package com.example.sanatiel.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

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
        var strCalculo = ""

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
        val txtCalc = findViewById<TextView>(R.id.txtCalculo)

        bt1.setOnClickListener {
            edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt1)))  //informa o num atual do edit text mais o numero 1
            strCalculo = atualizaTxtCalculo(strCalculo,"",getString(R.string.bt1))
            txtCalc.setText(strCalculo)
        }

        bt2.setOnClickListener {
            edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt2)))
            strCalculo = atualizaTxtCalculo(strCalculo,"",getString(R.string.bt2))
            txtCalc.setText(strCalculo)
        }


        bt3.setOnClickListener {
             edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt3)))
            strCalculo = atualizaTxtCalculo(strCalculo,"",getString(R.string.bt3))
            txtCalc.setText(strCalculo)
        }

        bt4.setOnClickListener {
            edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt4)))
            strCalculo = atualizaTxtCalculo(strCalculo,"",getString(R.string.bt4))
            txtCalc.setText(strCalculo)
        }

        bt5.setOnClickListener {
               edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt5)))
            strCalculo = atualizaTxtCalculo(strCalculo,"",getString(R.string.bt5))
            txtCalc.setText(strCalculo)
        }

        bt6.setOnClickListener {
                edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt6)))
                strCalculo = atualizaTxtCalculo(strCalculo,"",getString(R.string.bt6))
                txtCalc.setText(strCalculo)
        }

        bt7.setOnClickListener {
              edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt7)))
            strCalculo = atualizaTxtCalculo(strCalculo,"",getString(R.string.bt7))
            txtCalc.setText(strCalculo)
        }

        bt8.setOnClickListener {
               edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt8)))
            strCalculo = atualizaTxtCalculo(strCalculo,"",getString(R.string.bt8))
            txtCalc.setText(strCalculo)
        }

        bt9.setOnClickListener {
             edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt9)))
            strCalculo = atualizaTxtCalculo(strCalculo,"",getString(R.string.bt9))
            txtCalc.setText(strCalculo)
        }

        bt0.setOnClickListener {
              edTxt.setText(atribuiNumero(edTxt.text.toString(), getString(R.string.bt0)))
            strCalculo = atualizaTxtCalculo(strCalculo,"",getString(R.string.bt0))
            txtCalc.setText(strCalculo)
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

                strCalculo = atualizaTxtCalculo(strCalculo," ",getString(R.string.btSoma))
                txtCalc.setText(strCalculo)
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

                strCalculo = atualizaTxtCalculo(strCalculo," ",getString(R.string.btMult))
                txtCalc.setText(strCalculo)
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

                strCalculo = atualizaTxtCalculo(strCalculo," ",getString(R.string.btSub))
                txtCalc.setText(strCalculo)
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

                strCalculo = atualizaTxtCalculo(strCalculo," ",getString(R.string.btDiv))
                txtCalc.setText(strCalculo)
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

             strCalculo = atualizaTxtCalculo(strCalculo," ",getString(R.string.btAux))
             txtCalc.setText(strCalculo)
             strCalculo = atualizaTxtCalculo(strCalculo,"",numeroAtual.toString())
             txtCalc.setText(strCalculo)

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
            strCalculo = ""
            txtCalc.setText(strCalculo)
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


    fun atualizaTxtCalculo(valorAtual:String,espaco:String? = "",  valorNovo:String):String{

        if (valorAtual != null) return valorAtual + espaco + valorNovo + espaco else return valorNovo
    }

    }





