package io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.contextualhelp.handlers;

import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.contextualhelp.HelpContent;
import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.contextualhelp.HelpHandler;
import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.contextualhelp.HelpRequest;

import java.util.Objects;

abstract public class BaseHelpHandler implements HelpHandler {
    private HelpHandler nextHandler;

    @Override
    public HelpHandler setNext(HelpHandler handler) {
        this.nextHandler = Objects.requireNonNull(handler);
        return handler;
    }

    protected HelpContent handleNext(HelpRequest request) {
        if (request == null) {
            throw new IllegalStateException(
                    "No help handler could process request."
            );
        }

        return nextHandler.handle(request);
    }
}
