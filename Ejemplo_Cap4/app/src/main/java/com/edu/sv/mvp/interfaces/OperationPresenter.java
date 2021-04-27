package com.edu.sv.mvp.interfaces;

public interface OperationPresenter {
    void showResult(String result);
    void invalidOperation();
    void add(int num1, int num2);
    void subtract(int num1, int num2);
    void multiply(int num1, int num2);
    void divide(int num1, int num2);

    /*
    * El presentador es nuestro intermediario entre el interactor y la vista, por lo que
    *debe contener las funciones de las otras interfaces, pues mediante el las mandaremos a llamar
    * */

}
