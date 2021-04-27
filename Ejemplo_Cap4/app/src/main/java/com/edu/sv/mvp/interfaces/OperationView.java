package com.edu.sv.mvp.interfaces;

public interface OperationView {
    void showResult(String result);
    void invalidOperation();

    /*
    En esta interfaz tenemos los metodos showResult e invalidOperation() los cuales nos permitirán
    mostrar el resultado de la operación y mandar un mensaje de error cuando no se cumplan las condiciones
    necesarias para realizar la operación
        */
}
