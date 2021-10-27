public class ExplicitCall extends checksAtWork{
    private static final String NAME_OF_METHOD = "finalize";
    private static final String NAME_OF_SCOPE = "super";

    @Override
    protected void handleVisit(Node node, ParseContext context, ICodeIssuePublisher codeIssuePublisher) throws ParserException {
        if(node instanceof MethodCallExpr){
            MethodCallExpr methodCallExpr = ObjCaster.castNode(MethodCallExpr.class,node);
            if(StringUtils.equals(NAME_OF_METHOD,methodCallExpr.getName()) && !(StringUtils.equals(NAME_OF_SCOPE,methodCallExpr.getScope().toString()))){
                publish(node, context, codeIssuePublisher);
            }
        }
    }

    private void publish(Node node, ParseContext context, ICodeIssuePublisher codeIssuePublisher) {
        codeIssuePublisher.publish(new CodeIssueModel(context.getCu().getCuFile(), node.getRange().begin.line,
                Severity.medium, "Explicit Call", CodeIssueNames.EXPLICIT_CALL));
    }
}
