package com.androiddesdecero.mvvmyoutube;

public class AlCuadradoUseCase {
    public static String alCuadrado(String data){
        if(data.equals("")){
            return "Campo Vacio";
        }
        return String.valueOf(Double.valueOf(data)*Double.valueOf(data));
    }
}
