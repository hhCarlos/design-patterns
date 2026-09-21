package io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles;

public record RoleContext(
    LanguageId languageId,
    String name,
    String description
) {
    public RoleContext(LanguageId languageId) {
        this(languageId, null, null);
    }

    public RoleContext resolve(
            String name,
            String description
    ) {
        return new RoleContext(
                languageId,
                name,
                description
        );
    }
}
