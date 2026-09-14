package io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.contextualhelp.handlers;

import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.contextualhelp.HelpContent;
import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.contextualhelp.HelpRequest;

public class ApplicationHelpHandler extends BaseHelpHandler {
    @Override
    public HelpContent handle(HelpRequest request) {
        if (canHandle(request)) {
            return new HelpContent(
                    "Application help",
                    "Application help for: " + request.componentId()
            );
        }

        return handleNext(request);
    }

    private boolean canHandle(HelpRequest request) {
        return request.componentId() != null;
    }
}
