package com.edu.sv.mvp.interactor;

import com.edu.sv.mvp.interfaces.OperationInteractor;
import com.edu.sv.mvp.interfaces.OperationPresenter;

public class OperationInteractorImpl implements OperationInteractor {
    private int result;
    private OperationPresenter presenter;

    /*
    +Acá implementamos las interfaces para que estas tengan la funcionalidad que deseamos
    y sean accesibles desde donde sea necesaia su implementación
     */

    public OperationInteractorImpl(OperationPresenter operationPresenter) {
        this.presenter = operationPresenter;
    }

    @Override
    public void add(int num1, int num2) {
        result =  num1 + num2;
        presenter.showResult(Integer.toString(result));
    }

    @Override
    public void subtract(int num1, int num2) {
        result = num1 - num2;
        presenter.showResult(Integer.toString(result));
    }

    @Override
    public void multiply(int num1, int num2) {
        result = num1 * num2;
        presenter.showResult(Integer.toString(result));
    }

    @Override
    public void divide(int num1, int num2) {
        if (num2 == 0) {
            result = num1 / num2;
            presenter.showResult(Integer.toString(result));
        } else {
            presenter.invalidOperation();
        }
    }
}
