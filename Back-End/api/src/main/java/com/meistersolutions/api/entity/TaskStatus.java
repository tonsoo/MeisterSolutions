package com.meistersolutions.api.entity;

public enum TaskStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED;

    private static final TaskStatus[] vals = values();

    public TaskStatus next() {
        int nextVal = this.ordinal() + 1;
        if(nextVal >= vals.length){
            return vals[vals.length - 1];
        }

        return vals[nextVal];
    }

    public TaskStatus previous() {
        int prevVal = this.ordinal() - 1;
        if(prevVal <= 0){
            return vals[0];
        }

        return vals[prevVal];
    }
}