package io.github.hhcarlos.designpatterns.behavioral
        .chainofresponsibility.contextualhelp.handlers;

import io.github.hhcarlos.designpatterns.behavioral
        .chainofresponsibility.contextualhelp.HelpContent;
import io.github.hhcarlos.designpatterns.behavioral
        .chainofresponsibility.contextualhelp.HelpRequest;

public final class ApplicationHelpHandler extends BaseHelpHandler {

    @Override
    public HelpContent handle(HelpRequest request) {
        return new HelpContent(
                "Application help",
                "General help for using the application."
        );
    }
}
