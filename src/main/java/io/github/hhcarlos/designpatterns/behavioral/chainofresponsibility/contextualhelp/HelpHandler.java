package io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.contextualhelp;

public interface HelpHandler {
    public HelpHandler setNext(HelpHandler handler);
    public HelpContent handle(HelpRequest request);
}
