  private void checkingReturnInThen(Node containOfThen,Node node, ParseContext context, ICodeIssuePublisher codeIssuePublisher){
        List<Node> childOfThen = containOfThen.getChildrenNodes();
        for(Node nodes:childOfThen){
            if(nodes instanceof ReturnStmt){
                publishCodeIssue(node, context, codeIssuePublisher);
            }
        }
    }

    private void checkingReturnInElse(Node containOfElse,Node node, ParseContext context, ICodeIssuePublisher codeIssuePublisher){
        List<Node> childOfElse = containOfElse.getChildrenNodes();
        for(Node nodes:childOfElse){
            if(nodes instanceof ReturnStmt){
                publishCodeIssue(node, context, codeIssuePublisher);
            }
        }
    }
