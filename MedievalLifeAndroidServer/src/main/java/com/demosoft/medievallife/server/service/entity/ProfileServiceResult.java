package com.demosoft.medievallife.server.service.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by demos_000 on 20.03.2016.
 */
public class ProfileServiceResult<T> {
    private boolean successAction;
    private List<String> errorMgs = new ArrayList<>();
    private T processedObject;

    public boolean isSuccessAction() {
        return successAction;
    }

    public void setSuccessAction(boolean successAction) {
        this.successAction = successAction;
    }

    public List<String> getErrorMgs() {
        return errorMgs;
    }

    public void setErrorMgs(List<String> errorMgs) {
        this.errorMgs = errorMgs;
    }

    public T getProcessedObject() {
        return processedObject;
    }

    public void setProcessedObject(T processedObject) {
        this.processedObject = processedObject;
    }
}
