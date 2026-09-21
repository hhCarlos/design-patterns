package io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles.handlers;

import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles.BaseRoleHandler;
import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles.LanguageId;
import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles.RoleContext;

public class PythonRoleHandler extends BaseRoleHandler {
    @Override
    protected boolean supports(RoleContext context) {
        return context.languageId() == LanguageId.PYTHON;
    }

    @Override
    protected RoleContext resolve(RoleContext context) {
        return context.resolve(
                "Python Developer",
                "Developer specialized in Python."
        );
    }
}
