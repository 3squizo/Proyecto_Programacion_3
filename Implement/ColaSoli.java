package Implement;


public class ColaSoli extends VectorSoli {
    protected int fi;
    protected int fr;

    public ColaSoli() {
        super();
        fi = 0;
        fr = 0;
    }

    public ColaSoli(int MAX) {
        super(MAX);
        fi = 0;
        fr = 0;
    }

    public int getFi() {
        return fi;
    }

    public void setFi(int fi) {
        this.fi = fi;
    }

    public int getFr() {
        return fr;
    }

    public void setFr(int fr) {
        this.fr = fr;
    }
}
