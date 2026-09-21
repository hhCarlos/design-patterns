package io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles;

import java.util.Objects;

public abstract class BaseRoleHandler implements RoleHandler {

    private RoleHandler nextHandler;

    @Override
    public final RoleHandler setNext(RoleHandler handler) {
        this.nextHandler = Objects.requireNonNull(handler);

        return handler;
    }

    @Override
    public final RoleContext handle(
            RoleContext context
    ) {
        Objects.requireNonNull(
                context,
                "Role context cannot be null."
        );

        if (supports(context)) {
            return resolve(context);
        }

        if (nextHandler == null) {
            throw new IllegalStateException(
                    "No handler supports: "
                        + context.languageId()
            );
        }

        return nextHandler.handle(context);
    }

    protected abstract boolean supports(RoleContext context);

    protected abstract RoleContext resolve(RoleContext context);
}
