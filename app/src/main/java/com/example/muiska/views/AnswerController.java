package com.example.muiska.views;

public class AnswerController {

    private CharSequence enunciado;
    private int respuesta;

    public AnswerController(CharSequence enunciado,int respuesta){
        this.enunciado = enunciado;
        this.respuesta = respuesta;
    }
    public CharSequence getEnunciado(){
        return  this.enunciado;
    }
    public int getRespuesta(){
        return this.respuesta;
    }

    public void setRespuesta(int respuesta){
        this.respuesta = respuesta;
    }

    public void setEnunciado(CharSequence enunciado){
        this.enunciado = enunciado;
    }
}
