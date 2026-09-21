package io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles.handlers;

import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles.BaseRoleHandler;
import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles.LanguageId;
import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles.RoleContext;

public class JavaRoleHandler  extends BaseRoleHandler {

    @Override
    protected boolean supports(RoleContext context) {
        return context.languageId() == LanguageId.JAVA;
    }

    @Override
    protected RoleContext resolve(RoleContext context) {
        return context.resolve(
                "Java Developer",
                "Developer specialized in Java"
        );
    }
}
