public class KsonDeserializer {

    public static boolean DEBUG_STACK = false;

    protected KsonCharInput in;
    protected KsonTypeMapper mapper;
    protected Stack<ParseStep> stack;
    protected boolean supportJSon = true;

    private KsonArgTypesResolver argTypesRessolver;

    static class ParseStep {
        KsonCharInput in;
        int position;
        String action;

        ParseStep(KsonCharInput in, int position, String action) {
            this.in = in;
            this.position = position;
            this.action = action;
        }

        ParseStep(String action, KsonCharInput in) {
            this(in, in.position(),action);
        }

        @Override
        public String toString() {
            return ""+action+" at pos:"+position;
        }
    }


    public KsonDeserializer(KsonCharInput in, KsonTypeMapper mapper) {
        this.in = in;
        this.mapper = mapper;
        if (DEBUG_STACK) {
            stack = new Stack<>();
            if ( in instanceof KsonStringCharInput ) {
                ((KsonStringCharInput) in).stack = stack;
            }
        }
    }

    public boolean isSupportJSon() {
        return supportJSon;
    }

    public KsonDeserializer supportJSon(boolean supportJSon) {
        this.supportJSon = supportJSon;
        return this;
    }

    public void skipWS() {
        int ch = in.readChar();
        while (ch >= 0 && Character.isWhitespace(ch)) {
            ch = in.readChar();
        }
        if (ch == '#') {
            ch = in.readChar();
            while (ch >= 0 && ch != '\n') {
                ch = in.readChar();
            }
            skipWS();
        } else if (ch > 0)
            in.back(1);
    }
