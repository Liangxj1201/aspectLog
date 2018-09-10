package com.xjliang.aspect.entity;

public class Result<T> {

    private RespHead respHead;
    private T content;

    public RespHead getRespHead() {
        return respHead;
    }

    public void setRespHead(RespHead respHead) {
        this.respHead = respHead;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "Result [respHead=" + respHead + ", content=" + content + "]";
    }
}
