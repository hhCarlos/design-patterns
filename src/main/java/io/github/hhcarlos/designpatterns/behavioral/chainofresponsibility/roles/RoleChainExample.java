package io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles;

import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles.handlers.JavaRoleHandler;
import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles.handlers.PythonRoleHandler;

public final class RoleChainExample {
    static public void run() {
        RoleHandler javaHandler = new JavaRoleHandler();
        RoleHandler pythonHandler = new PythonRoleHandler();

        javaHandler
                .setNext(pythonHandler);

        RoleContext requestRole = new RoleContext(LanguageId.PYTHON);

        RoleContext resolveRole = javaHandler.handle(requestRole);

        System.out.println("Language: " + resolveRole.languageId());
        System.out.println("Name: " + resolveRole.name());
        System.out.println("Description: " + resolveRole.description());
    }
}
