package io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.contextualhelp;

public record HelpRequest(
   String componentId,
   String sectionId,
   String pageId
) {}
