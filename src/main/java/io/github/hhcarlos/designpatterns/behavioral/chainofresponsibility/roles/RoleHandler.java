package io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles;

public interface RoleHandler {
    RoleContext handle(RoleContext context);
    RoleHandler setNext(RoleHandler handler);
}
